package com.painter.controller.listeners;

import java.awt.Component;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.undo.UndoManager;

public abstract class UndoRedoAction extends AbstractAction {
	UndoManager undoManager = new UndoManager();

	String errorMessage = "Cannot undo";

	String errorTitle = "Undo Problem";

	protected UndoRedoAction(UndoManager manager, String name) {
		super(name);
		undoManager = manager;
	}

	public void setErrorMessage(String newValue) {
		errorMessage = newValue;
	}

	public void setErrorTitle(String newValue) {
		errorTitle = newValue;
	}

	protected void showMessage(Object source) {
		if (source instanceof Component) {
			JOptionPane.showMessageDialog((Component) source, errorMessage, errorTitle,
					JOptionPane.WARNING_MESSAGE);
		} else {
			System.err.println(errorMessage);
		}
	}
}
