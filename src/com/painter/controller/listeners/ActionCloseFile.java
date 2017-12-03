package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.controller.EmptyDialog;
import com.painter.view.PTabbedPane;

public class ActionCloseFile implements ActionListener 
{
	PTabbedPane tPane;
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		tPane.closeTab();
	}

	public void setTPane(PTabbedPane tPane) 
	{
		this.tPane = tPane;		
	}
}