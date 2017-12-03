package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import com.painter.controller.PCommand;
import com.painter.model.Data;
import com.painter.model.Images;

public class PFrame extends JFrame
{
	public PTabbedPane tpane;
	public PStatusBar statusBar;
	public PSidePanel sidePanel;
	public PToolBar toolBar;

	PCommand cmd;
	Data data;
	public PMenu menuBar;

	public PFrame()
	{
		data = new Data();
		cmd = new PCommand(data, this);

		setTitle("Duncan");		
		setIconImage(Images.getIcon());		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(1366, 768);
		//		setLocationRelativeTo(null);
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - 1366) / 2, 
					 (Toolkit.getDefaultToolkit().getScreenSize().height - 768) / 2);

		//		getContentPane().setBackground(Color.GRAY);
		menuBar = new PMenu(data, cmd);			
		setJMenuBar(menuBar);

		toolBar = new PToolBar(cmd);
		add(toolBar, BorderLayout.NORTH);		

		statusBar = new PStatusBar("Coordinates", "Path to file");
		add(statusBar, BorderLayout.SOUTH);

		sidePanel = new PSidePanel(cmd);
		add(sidePanel);

		tpane = new PTabbedPane(cmd, this, toolBar);
		add(tpane, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();	
		leftPanel.setLayout(new GridLayout(2,1));
		add(leftPanel, BorderLayout.WEST);
		
		PTreePanel treePanel = new PTreePanel(cmd);
		//getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		leftPanel.add(treePanel);
		
		PSidePanel sidePanel = new PSidePanel(cmd);
		leftPanel.add(sidePanel);
		
		setResizable(true);
		setMinimumSize(new Dimension(1366, 768));

		setVisible(true);
	}

	public void refreshFrame()
	{
		System.out.println("ןונונטסמגךא פנוילא");
		dispose();
//		invalidate();
//		repaint();
		new PFrame().setVisible(true);
	}
}