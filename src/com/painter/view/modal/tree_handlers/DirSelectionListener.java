package com.painter.view.modal.tree_handlers;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.painter.view.PTreePanel;

public class DirSelectionListener implements TreeSelectionListener
{
	PTreePanel treePanel;
	
	public DirSelectionListener(PTreePanel treePanel)
	{
		this.treePanel = treePanel;
	}
	
	public void valueChanged(TreeSelectionEvent event)
	{
		DefaultMutableTreeNode node = treePanel.getTreeNode(event.getPath());
		FileNode fnode = treePanel.getFileNode(node);
		if (fnode != null) 
		{
			PTreePanel.m_display.setText(fnode.getFile().getAbsolutePath());
		}
		else 
		{
			PTreePanel.m_display.setText("");
		}
	}
}