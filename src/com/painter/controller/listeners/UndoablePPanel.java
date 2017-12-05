package com.painter.controller.listeners;

import java.util.ArrayList;
import java.util.List;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import com.painter.controller.PPanel;
import com.painter.model.Resizable;
import com.painter.model.plugins.InterfaceFigure;

public class UndoablePPanel extends AbstractUndoableEdit
{
	PPanel pPanel;
	List<Resizable> figures, savedFigures;

	public UndoablePPanel(PPanel pPanel)
	{
		this.pPanel = pPanel;
		figures = new ArrayList<Resizable>(pPanel.getFigures());
	}

	public void redo() throws CannotRedoException
	{
		super.redo();
		if (savedFigures == null)
		{
			throw new CannotRedoException();
		}
		else
		{
			pPanel.setFigures(savedFigures);
			savedFigures = null;
		}
	}

	public void undo() throws CannotUndoException
	{
		super.undo();
		savedFigures = new ArrayList<Resizable>(pPanel.getFigures());
		pPanel.setFigures(figures);
	}
}
