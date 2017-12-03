package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.painter.controller.PCommand;
import com.painter.view.modal.tree_handlers.DirExpansionListener;
import com.painter.view.modal.tree_handlers.DirSelectionListener;
import com.painter.view.modal.tree_handlers.FileNode;
import com.painter.view.modal.tree_handlers.FileTreeCellEditor;
import com.painter.view.modal.tree_handlers.IconCellRenderer;
import com.painter.view.modal.tree_handlers.IconData;
import com.painter.view.modal.tree_handlers.MyTreeModelListener;

@SuppressWarnings("serial")
public class PTreePanel extends JPanel
{
	PCommand cmd;

	public static JTree m_tree;
	public static DefaultTreeModel m_model;
	public static JTextField m_display;
	public static String bufName;
	public static DefaultMutableTreeNode nodeToUpdate;

	public PTreePanel(PCommand cmd)
	{
		this.cmd = cmd;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(180, 0)));
		
		JLabel nameLabel = new JLabel("Windows");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		add(nameLabel);
		
		DefaultMutableTreeNode top = new DefaultMutableTreeNode(new IconData(null, null, "MyComputer"));
		DefaultMutableTreeNode node;
		File[] roots = File.listRoots();
		for (int k = 0; k < roots.length; k++)
		{
			node = new DefaultMutableTreeNode(new IconData(null, null, new FileNode(roots[k])));
			top.add(node);
			node.add(new DefaultMutableTreeNode(new Boolean(true)));
		}
		m_model = new DefaultTreeModel(top);
		m_model.addTreeModelListener(new MyTreeModelListener());

		m_tree = new JTree(m_model);
		m_tree.putClientProperty("JTree.lineStyle", "Angled");

		m_tree.setCellRenderer(new IconCellRenderer());
		m_tree.setCellEditor(new FileTreeCellEditor());
		
		m_tree.addTreeExpansionListener(new DirExpansionListener(this));
		m_tree.addTreeSelectionListener(new DirSelectionListener(this));
		
		m_tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
		
		m_tree.setShowsRootHandles(true);
		m_tree.setRootVisible(true);
		m_tree.setEditable(true);

		JScrollPane scrollPane = new JScrollPane(m_tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);	
		add(scrollPane);
		
		m_display = new JTextField();
		m_display.setEditable(false);
		add(m_display, BorderLayout.NORTH);
		
		setVisible(true);
		
		//// this.add(panel);
		//
		// WindowListener wndCloser = new WindowAdapter() {
		// public void windowClosing(WindowEvent e) {
		// System.exit(0);
		// }
		// };
		// addWindowListener(wndCloser);
	}

	public DefaultMutableTreeNode getTreeNode(TreePath path)
	{
		return (DefaultMutableTreeNode) (path.getLastPathComponent());
	}

	public FileNode getFileNode(DefaultMutableTreeNode node)
	{
		if (node == null) 
			return null;
		Object obj = node.getUserObject();
		if (obj instanceof IconData) 
		{
			obj = ((IconData) obj).getObject();
		}		
		if (obj instanceof FileNode) 
		{
			return (FileNode) obj;
		}		
		else 
		{
			return null;
		}			
	}

	public JPanel getBrowser()
	{
		return this;
	}
}