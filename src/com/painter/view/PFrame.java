package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

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
		setLocation( Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 1366 / 2, 
					 Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 768 / 2);

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
		
		PSidePanel sidePanel = new PSidePanel(cmd);
		add(sidePanel, BorderLayout.WEST);
		
		setResizable(true);
		setMinimumSize(new Dimension(1366, 768));
		
		setVisible(true);
	}
	
	public void refreshFrame()
	{
		System.out.println("ןונונטסמגךא פנוילא");
		this.setVisible(false);
		this.revalidate();
		this.repaint();
		new PFrame().setVisible(true);
	}
}