package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.DefaultSettingsDialog;

public class ActionDefaultSettings implements ActionListener 
{
	Data data;
	
	public ActionDefaultSettings(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new DefaultSettingsDialog(data);
	}
}