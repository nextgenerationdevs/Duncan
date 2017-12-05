package com.painter.controller.listeners;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.painter.model.Resizable;
import com.painter.model.plugins.InterfaceFigure;

public class UndoableResizable extends AbstractUndoableEdit
{

	InterfaceFigure resFigure, savedResFigure;

	Resizable resizable;

	public UndoableResizable(Resizable resizable)
	{
		this.resizable = resizable;
		resFigure = resizable.getFigure();
	}

	public void redo() throws CannotRedoException
	{
		super.redo();
		if (savedResFigure == null)
		{
			throw new CannotRedoException();
		}
		else
		{
			resizable.setFigure(savedResFigure);
			savedResFigure = null;
		}
	}

	public void undo() throws CannotUndoException
	{
		super.undo();
		savedResFigure = resizable.getFigure();
		resizable.setFigure(resFigure);
	}

}
