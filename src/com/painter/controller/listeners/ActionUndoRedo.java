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
import com.painter.view.PTabbedPane;
import com.painter.view.PToolBar;

public class ActionUndoRedo implements ActionListener
{
	private PToolBar toolBar;
	private PPanel panel;
	private Resizable res;
	PCommand cmd;
	Data data;

	UndoManager undoManager = new UndoManager();

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

	public void setToolBar(PToolBar toolBar)
	{
		this.toolBar = toolBar;
	}

	public void setCanUndo(boolean canUndo)
	{
		panel.setCanUndo(canUndo);
		toolBar.buttonUndo.setEnabled(panel.isCanUndo());
	}

	public void setCanRedo(boolean canRedo)
	{
		panel.setCanRedo(canRedo);
		toolBar.buttonRedo.setEnabled(panel.isCanRedo());
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
