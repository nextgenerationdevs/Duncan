package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

import com.painter.controller.PCommand;
import com.painter.controller.PPanel;
import com.painter.model.Data;
import com.painter.model.Images;

public class PFrame extends JFrame
{

	public PFrame()
	{
		Data data = new Data();
		PCommand cmd = new PCommand(data);
		
		setTitle("Duncan");		
		setIconImage(Images.getIcon());
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setSize(1366, 768);
		setLocation( Toolkit.getDefaultToolkit().getScreenSize().width / 2 - 1366 / 2, 
					 Toolkit.getDefaultToolkit().getScreenSize().height / 2 - 768 / 2);
	
		add(new PPanel(data), BorderLayout.CENTER);
		
		setJMenuBar(new PMenu(data, cmd));
		
		add(new PToolBar(cmd), BorderLayout.NORTH);
		
		add(new PStatusBar(), BorderLayout.SOUTH);
		
		setVisible(true);
	}
}