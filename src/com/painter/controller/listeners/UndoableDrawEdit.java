package com.painter.controller.listeners;

import java.util.List;

import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.painter.controller.PPanel;
import com.painter.model.plugins.InterfaceFigure;

class UndoableDrawEdit extends AbstractUndoableEdit {
	
	PPanel pPanel;

	List<InterfaceFigure> figures, savedFigures;

	public UndoableDrawEdit(PPanel pPanel) {
		this.pPanel = pPanel;
		figures = pPanel.getFigures();
	}

	public String getPresentationName() {
		return "Figures";
	}

	public void redo() throws CannotRedoException {
		super.redo();
		if (savedFigures == null) {
			throw new CannotRedoException();
		} else {
			pPanel.setFigures(savedFigures);
			savedFigures = null;
		}
	}

	public void undo() throws CannotUndoException {
		super.undo();
		savedFigures = pPanel.getFigures();
		pPanel.setFigures(figures);
	}
}
