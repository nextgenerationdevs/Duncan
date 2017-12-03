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

import com.painter.model.Resizable;
import com.painter.model.plugins.InterfaceFigure;

public class PPanel extends JPanel
{
	PCommand cmd;
	DropTargetListener dropTargetListener;
	
	public List<Resizable> figures = Collections.synchronizedList(new ArrayList<>());

	public PPanel (PCommand cmd)
	{
		setLayout(null);
		this.cmd = cmd;
		addMouseMotionListener(cmd.mousePaint);
		addMouseListener(cmd.mousePaint);
		subscribeListener();
		dropTargetListener		= new DropTargetListener();
		setBackground(Color.WHITE);
	}
	
	public void addFigure()
	{
		Resizable resFigure = figures.get(figures.size() - 1);
		add(resFigure);		
		resFigure.revalidate();
		resFigure.requestFocus();
		resFigure.repaint();
	}

	public void update()
	{	
		revalidate();
		repaint();
	}

	public void subscribeListener()
	{
		cmd.mousePaint.setPPanel(this);
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
					Resizable res = new Resizable(figure, pan);
					res.setBounds(dtde.getLocation().x + 8, dtde.getLocation().y + 8, pan.getWidth() + 16, pan.getHeight() + 16);
					figures.add(res);
					addFigure();
					dtde.dropComplete(true);
				}
				dtde.rejectDrop();
			} catch (UnsupportedFlavorException | IOException e)
			{
				e.printStackTrace();
			}
		}

	}
}