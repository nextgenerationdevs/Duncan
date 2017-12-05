package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import com.painter.controller.PCommand;
import com.painter.controller.PPanel;
import com.painter.model.Data;
import com.painter.model.Resizable;
import com.painter.view.PFrame;
import com.painter.view.PTabbedPane;
import com.painter.view.PToolBar;

public class ActionUndoRedo implements ActionListener
{
	private PFrame frame;
	private PPanel panel;
	private Resizable res;
	PCommand cmd;
	Data data;

	UndoManager undoManager = new UndoManager();
	private boolean canUndo = false;
	private boolean canRedo = false;

	public ActionUndoRedo(PCommand cmd, Data data)
	{
		this.cmd = cmd;
		this.data = data;
	}

	public void setPPanel(PPanel panel)
	{
		this.panel = panel;
		this.undoManager = panel.getManager();
	}

	public void setUndoManager(UndoManager undoManager)
	{
		this.undoManager = undoManager;
	}

	public void setFrame(PFrame frame)
	{
		this.frame = frame;
	}
	
	public boolean isCanUndo()
	{
		return canUndo;
	}

	public boolean isCanRedo()
	{
		return canRedo;
	}

	public void setCanUndo(boolean canUndo)
	{
		this.canUndo = canUndo;
		panel.setCanUndo(canUndo);
		frame.toolBar.buttonUndo.setEnabled(panel.isCanUndo());
		frame.menuBar.editMenu.actionUndo.setEnabled(panel.isCanUndo());
	}

	public void setCanRedo(boolean canRedo)
	{
		this.canRedo = canRedo;
		panel.setCanRedo(canRedo);
		frame.toolBar.buttonRedo.setEnabled(panel.isCanRedo());
		frame.menuBar.editMenu.actionRedo.setEnabled(panel.isCanRedo());
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String action = ae.getActionCommand();
		switch (action)
		{
			case "actionUndo":
				undo();
				break;
			case "actionRedo":
				redo();
				break;
		}
	}

	private void undo()
	{
		undoManager.undo();
		setCanUndo(undoManager.canUndo());
		setCanRedo(undoManager.canRedo());
	}

	private void redo()
	{
		undoManager.redo();
		setCanUndo(undoManager.canUndo());
		setCanRedo(undoManager.canRedo());
	}

	public Resizable getRes()
	{
		return res;
	}

	public void setRes(Resizable res)
	{
		this.res = res;
	}
}
