package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionExit implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		System.exit(0);
	}
}