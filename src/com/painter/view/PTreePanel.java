<<<<<<< HEAD
package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.painter.controller.PCommand;
import com.painter.controller.plugins.list.def.DefaultPlugin;
import com.painter.model.plugins.InterfaceFigure;
import com.painter.model.plugins.PluginsList;

public class PTreePanel extends JPanel
{
	PCommand cmd;
	
	private JTree tree;
   // private JLabel selectedLabel;
	
	public PTreePanel(PCommand cmd)
	{
		this.cmd = cmd;
		
		JLabel nameLabel = new JLabel("Windows");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));	
		add(Box.createRigidArea(new Dimension(180, 0)));	

		 //create the root node
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        //create the child nodes
        DefaultMutableTreeNode vegetableNode = new DefaultMutableTreeNode("Vegetables");
        vegetableNode.add(new DefaultMutableTreeNode("Capsicum"));
        vegetableNode.add(new DefaultMutableTreeNode("Carrot"));
        vegetableNode.add(new DefaultMutableTreeNode("Tomato"));
        vegetableNode.add(new DefaultMutableTreeNode("Potato"));
         
        DefaultMutableTreeNode fruitNode = new DefaultMutableTreeNode("Fruits");
        fruitNode.add(new DefaultMutableTreeNode("Banana"));
        fruitNode.add(new DefaultMutableTreeNode("Mango"));
        fruitNode.add(new DefaultMutableTreeNode("Apple"));
        fruitNode.add(new DefaultMutableTreeNode("Grapes"));
        fruitNode.add(new DefaultMutableTreeNode("Orange"));
        //add the child nodes to the root node
        root.add(vegetableNode);
        root.add(fruitNode);
         
        //create the tree by passing in the root node
        tree = new JTree(root);
        JScrollPane scrollPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		add(nameLabel);
		add(scrollPane);
		setVisible(true);
		
        //ImageIcon imageIcon = new ImageIcon(PTreePanel.class.getResource("/leaf.jpg"));
        //DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();       
        //renderer.setLeafIcon(imageIcon);
         
        //tree.setCellRenderer(renderer);
        tree.setShowsRootHandles(true);
        tree.setRootVisible(true);

//        selectedLabel = new JLabel();
//        add(selectedLabel, BorderLayout.SOUTH);
//        tree.getSelectionModel().addTreeSelectionListener(new TreeSelectionListener() 
//        {
//            @Override
//            public void valueChanged(TreeSelectionEvent e) {
//                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
//                selectedLabel.setText(selectedNode.getUserObject().toString());
//            }
//        });
	}
=======
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
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}