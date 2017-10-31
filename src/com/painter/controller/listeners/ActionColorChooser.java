package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.AboutDialog;
import com.painter.view.modal.ColorDialog;

public class ActionColorChooser implements ActionListener 
{
	Data data;
	
	public ActionColorChooser(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new ColorDialog(data);
	}
}