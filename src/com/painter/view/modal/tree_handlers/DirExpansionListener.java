package com.painter.view.modal.tree_handlers;

import javax.swing.SwingUtilities;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.tree.DefaultMutableTreeNode;

import com.painter.view.PTreePanel;

public class DirExpansionListener implements TreeExpansionListener
{
	PTreePanel treePanel;
	
	public DirExpansionListener(PTreePanel treePanel)
	{
		this.treePanel = treePanel;
	}
	
	public void treeExpanded(TreeExpansionEvent event)
	{
		final DefaultMutableTreeNode node = treePanel.getTreeNode(event.getPath());
		final FileNode fnode = treePanel.getFileNode(node);
		PTreePanel.nodeToUpdate = node;

		Thread runner = new Thread()
		{
			public void run()
			{
				if (fnode != null && fnode.expand(node))
				{
					Runnable runnable = new Runnable()
					{
						public void run()
						{
							PTreePanel.m_model.reload(node);
						}
					};
					SwingUtilities.invokeLater(runnable);
				}
			}
		};
		runner.start();
	}

	public void treeCollapsed(TreeExpansionEvent event){}
}