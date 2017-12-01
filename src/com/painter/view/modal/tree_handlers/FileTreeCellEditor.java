package com.painter.view.modal.tree_handlers;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.CellEditor;
import javax.swing.JTree;
import javax.swing.event.CellEditorListener;
import javax.swing.tree.TreeCellEditor;

public class FileTreeCellEditor implements TreeCellEditor
{
	FileEditor fileEditor;
	CellEditor currentEditor;
	String val;

	public FileTreeCellEditor()
	{
		FileEditor fe = new FileEditor();
		fileEditor = fe;
	}

	public Component getTreeCellEditorComponent(JTree tree, Object value, boolean isSelected, boolean expanded,
			boolean leaf, int row)
	{
		currentEditor = fileEditor;
		fileEditor.setText(value.toString());
		return (Component) currentEditor;
	}

	public Object getCellEditorValue()
	{
		return currentEditor.getCellEditorValue();
	}

	public boolean isCellEditable(EventObject eo)
	{
		if ((eo == null) || ((eo instanceof MouseEvent) && (((MouseEvent) eo).getClickCount() == 3)))
		{
			return true;
		}
		return false;
	}

	public boolean shouldSelectCell(EventObject event)
	{
		return currentEditor.shouldSelectCell(event);
	}

	public boolean stopCellEditing()
	{
		return currentEditor.stopCellEditing();
	}

	public void cancelCellEditing()
	{
		currentEditor.cancelCellEditing();
	}

	public void addCellEditorListener(CellEditorListener l)
	{
		fileEditor.addCellEditorListener(l);
	}

	public void removeCellEditorListener(CellEditorListener l)
	{
		fileEditor.removeCellEditorListener(l);
	}
}