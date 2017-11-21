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
}