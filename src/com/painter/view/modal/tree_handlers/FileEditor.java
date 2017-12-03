package com.painter.view.modal.tree_handlers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;
import java.util.Vector;

import javax.swing.CellEditor;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;

import com.painter.view.PTreePanel;

@SuppressWarnings("serial")
public class FileEditor extends JTextField implements CellEditor
{
	String value = "";
	Vector<CellEditorListener> listeners = new Vector<CellEditorListener>();

	public FileEditor()
	{
		this("", 5);
	}

	public FileEditor(String s, int w)
	{
		super(s, w);
		addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ae)
			{
				if (stopCellEditing())
				{
					fireEditingStopped();
				}
			}
		});
	}

	public void cancelCellEditing()
	{
		setText("");
	}

	public boolean stopCellEditing()
	{
		String tmp = getText();
		String buf = PTreePanel.m_display.getText();
		PTreePanel.bufName = buf.substring(buf.lastIndexOf("\\") + 1);
		value = tmp;
		return true;
	}

	public Object getCellEditorValue()
	{
		return value;
	}

	public boolean isCellEditable(EventObject eo)
	{
		if ((eo == null) || ((eo instanceof MouseEvent) && (((MouseEvent) eo).getClickCount() == 3)))
		{
			return true;
		}
		return false;
	}

	public boolean shouldSelectCell(EventObject eo)
	{
		return true;
	}

	public void addCellEditorListener(CellEditorListener cel)
	{
		listeners.addElement(cel);
	}

	public void removeCellEditorListener(CellEditorListener cel)
	{
		listeners.removeElement(cel);
	}

	protected void fireEditingStopped()
	{
		if (listeners.size() > 0)
		{
			ChangeEvent ce = new ChangeEvent(this);
			for (int i = listeners.size() - 1; i >= 0; i--)
			{
				((CellEditorListener) listeners.elementAt(i)).editingStopped(ce);
			}
		}
	}
}