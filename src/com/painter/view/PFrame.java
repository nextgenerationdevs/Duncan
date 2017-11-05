package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.painter.controller.PCommand;
import com.painter.model.Data;
import com.painter.model.Images;
import com.painter.model.lang.LanguageFactory;

public class PFrame extends JFrame
{
	public PTabbedPane tpane;
	public PStatusBar statusBar;
	public PMenu menuBar;

	public PFrame()
	{
		LanguageFactory.updateLanguages();
		Data data = new Data();
		PCommand cmd = new PCommand(data, this, menuBar);
		
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
}