package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.PHotKeysPanel;

public class ActionHotKeys implements ActionListener 
{
	Data data;
	
	public ActionHotKeys(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new PHotKeysPanel(data);
	}
}
