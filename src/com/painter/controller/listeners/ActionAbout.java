package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.view.modal.AboutDialog;

public class ActionAbout implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new AboutDialog();
	}
}
