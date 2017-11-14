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
		
		add(new PToolBar(cmd), BorderLayout.NORTH);		
		
		statusBar = new PStatusBar("Welcome");
		add(statusBar, BorderLayout.SOUTH);
		
		tpane = new PTabbedPane(cmd);
		add(tpane, BorderLayout.CENTER);
		
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