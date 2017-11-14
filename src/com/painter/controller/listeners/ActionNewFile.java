package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.view.PTabbedPane;

public class ActionNewFile implements ActionListener 
{
	PTabbedPane tPane;
	
	public void setTPane(PTabbedPane tPane)
	{
		this.tPane = tPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		tPane.addNewTab("Untitled");
	}
}