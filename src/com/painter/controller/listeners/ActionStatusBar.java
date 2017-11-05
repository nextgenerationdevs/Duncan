package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.PStatusBar;

public class ActionStatusBar implements ActionListener
{
	PStatusBar statusBar;
	Data data;
	
	public ActionStatusBar(PStatusBar statusBar, Data data)
	{
		this.data = data;
		this.statusBar = statusBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getActionCommand().equals("actionEventChangeCoords"))
		{
			String coordinates = "x: " + data.getStatusX() + "\t" + "y: " + data.getStatusY();
			String file = "file: ...";
			statusBar.setStatus(coordinates, file);
		}	
	}	
}