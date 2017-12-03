package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.CloudDialog;
import com.painter.view.modal.PluginsDialog;

public class ActionCloud implements ActionListener 
{
	Data data;
	
	public ActionCloud(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new CloudDialog(data);
	}
}