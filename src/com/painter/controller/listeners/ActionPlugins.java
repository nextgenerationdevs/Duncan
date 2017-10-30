package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.PluginsDialog;

public class ActionPlugins implements ActionListener 
{
	Data data;
	public ActionPlugins(Data data)
	{
		this.data = data;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new PluginsDialog(data);
	}
}
