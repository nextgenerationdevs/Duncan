package com.painter.view.modal.tree_handlers;

import java.io.File;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;

import com.painter.view.PTreePanel;

public class MyTreeModelListener implements TreeModelListener
{
	String filePath = "";

	@Override
	public void treeNodesChanged(TreeModelEvent e)
	{
		// File f = new File(filePath + "\\" +
		// e.getChildren()[0].toString());
		File f = new File(filePath + "\\" + PTreePanel.bufName);
		f.renameTo(new File(filePath + "\\" + e.getChildren()[0].toString()));
		PTreePanel.m_model.reload();
		PTreePanel.m_tree.updateUI();
	}

	@Override
	public void treeStructureChanged(TreeModelEvent e)
	{
		// [MyComputer, C:\]
		filePath = "";
		for (int i = 0; i < e.getPath().length; i++)
		{
			if (i != 0)
			{
				if (i != 1)
				{
					filePath += "\\" + e.getPath()[i].toString();
				}
				else
				{
					filePath += e.getPath()[i].toString();
				}
			}
		}
	}
	
	@Override
	public void treeNodesInserted(TreeModelEvent e) {}

	@Override
	public void treeNodesRemoved(TreeModelEvent e) {}
}