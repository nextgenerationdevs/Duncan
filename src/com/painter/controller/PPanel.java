package com.painter.controller;

import java.awt.Color;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEditSupport;

import com.painter.controller.listeners.UndoablePPanel;
import com.painter.model.Resizable;
import com.painter.model.plugins.InterfaceFigure;

public class PPanel extends JPanel
{
	PCommand cmd;
	DropTargetListener dropTargetListener;

	UndoableEditSupport undoableEditSupport = new UndoableEditSupport(this);
	
	UndoManager manager = new UndoManager();
	private boolean canUndo = false;
	private boolean canRedo = false;

	public List<Resizable> figures = Collections.synchronizedList(new ArrayList<>());

	public PPanel(PCommand cmd)
	{
		setLayout(null);
		this.cmd = cmd;
		addMouseMotionListener(cmd.mousePaint);
		addMouseListener(cmd.mousePaint);
		subscribeListener();
		dropTargetListener = new DropTargetListener();
		setBackground(Color.WHITE);
		
	}

	public void addUndoableEditListener()
	{
		undoableEditSupport.addUndoableEditListener(manager);
	}

	public void removeUndoableEditListener()
	{
		undoableEditSupport.removeUndoableEditListener(manager);
	}

	public UndoManager getManager()
	{
		return manager;
	}

	public void update()
	{
		removeAll();
		
		for(Resizable resFigure: figures) 
		{
			resFigure.addUndoableEditListener();
			add(resFigure);
			resFigure.revalidate();
			resFigure.repaint();
		}
		
		revalidate();
		repaint();
	}

	public void subscribeListener()
	{
		cmd.mousePaint.setPPanel(this);
		cmd.actionUndoRedo.setPPanel(this);
	}

	public List<Resizable> getFigures()
	{
		return figures;
	}

	public void setFigures(List<Resizable> figures)
	{
		this.figures = figures;
		update();
	}

	public boolean isCanUndo()
	{
		return canUndo;
	}

	public void setCanUndo(boolean canUndo)
	{
		this.canUndo = canUndo;
	}

	public boolean isCanRedo()
	{
		return canRedo;
	}

	public void setCanRedo(boolean canRedo)
	{
		this.canRedo = canRedo;
	}

	public class DropTargetListener extends DropTargetAdapter
	{
		DropTarget target;

		public DropTargetListener()
		{
			target = new DropTarget(PPanel.this, DnDConstants.ACTION_COPY, this);
		}

		@Override
		public void drop(DropTargetDropEvent dtde)
		{
			try
			{
				Transferable tr = dtde.getTransferable();
				InterfaceFigure figure = (InterfaceFigure) tr.getTransferData(tr.getTransferDataFlavors()[0]);

				if (dtde.isDataFlavorSupported(tr.getTransferDataFlavors()[0]))
				{
					dtde.acceptDrop(DnDConstants.ACTION_COPY);
					figure.setMainProperties(cmd.getData().type, cmd.getData().color, cmd.getData().thickness);
					figure.move(dtde.getLocation().x, dtde.getLocation().y);
					JPanel pan = figure.getPluginFigure();
					
					undoableEditSupport.postEdit(new UndoablePPanel(PPanel.this));
					
					Resizable res = new Resizable(figure, cmd);
					res.setBounds(dtde.getLocation().x + 8, dtde.getLocation().y + 8, pan.getWidth() + 16,
							pan.getHeight() + 16);
					figures.add(res);
					
					cmd.actionUndoRedo.setCanUndo(true);
					
					update();
					dtde.dropComplete(true);
					
				}
				dtde.rejectDrop();
			}
			catch (UnsupportedFlavorException | IOException e)
			{
				e.printStackTrace();
			}
		}

	}
}