package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.controller.EmptyDialog;
import com.painter.view.PTabbedPane;

public class ActionOpenFileFromCloud implements ActionListener 
{
	PTabbedPane tPane;
	
	public void setTPane(PTabbedPane tPane)
	{
		this.tPane = tPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new EmptyDialog(getClass().toString());
		tPane.addNewTab("Untittled");
	}
}
