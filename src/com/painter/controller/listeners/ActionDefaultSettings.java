package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.controller.EmptyDialog;

public class ActionDefaultSettings implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new EmptyDialog(getClass().toString());
	}
}
