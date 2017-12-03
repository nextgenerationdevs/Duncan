<<<<<<< HEAD
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
=======
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
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
