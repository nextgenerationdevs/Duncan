<<<<<<< HEAD
package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.painter.controller.EmptyDialog;
import com.painter.controller.PCommand;
import com.painter.controller.formats.ImportExportImpl;
import com.painter.controller.formats.SaveOpenLoad_JSON;
import com.painter.model.Data;
import com.painter.view.PStatusBar;
import com.painter.view.PTabbedPane;

public class ActionUpdateStatusBar implements ActionListener
{
	PStatusBar statusBar;
	Data data;
	
	public ActionUpdateStatusBar(PStatusBar statusBar, Data data)
	{
		this.statusBar = statusBar;
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		if (str.equals("updateXY")) 
		{
			statusBar.setStatus("X: " + data.getStatusX() + " " + "Y: " + data.getStatusY());
		}
		else if (str.equals("updateFile")) 
		{
			statusBar.setFile("path: " + data.names.get(data.selectedIndex) + ".json");
		}
		else if (str.equals("setToZeroStatusBar")) 
		{
			statusBar.setStatus("Coordinates");
			statusBar.setFile("Path to file");
		}
	}
=======
package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.PFrame;

public class ActionUpdateStatusBar implements ActionListener
{
	PFrame frame;
	Data data;
	
	public ActionUpdateStatusBar(PFrame frame, Data data)
	{
		this.frame = frame;
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String str = e.getActionCommand();
		if (str.equals("updateXY")) 
		{
			frame.statusBar.setStatus("X: " + data.getStatusX() + " " + "Y: " + data.getStatusY());
		}
		else if (str.equals("updateFile")) 
		{
			frame.statusBar.setFile("path: " + data.names.get(data.selectedIndex) + ".json");
		}
		else if (str.equals("setToZeroStatusBar")) 
		{
			frame.statusBar.setStatus("Coordinates");
			frame.statusBar.setFile("Path to file");
		}
	}
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}