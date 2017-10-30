package com.painter.view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import com.painter.controller.PCommand;
import com.painter.model.Data;
import com.painter.view.menus.EditMenu;
import com.painter.view.menus.FileMenu;
import com.painter.view.menus.HelpMenu;
import com.painter.view.menus.OptionsMenu;
import com.painter.view.menus.WindowMenu;

public class PMenu extends JMenuBar
{
	private Data data;
	private PCommand cmd = new PCommand(data);
	
	private FileMenu 	fileMenu 	= new FileMenu(data, cmd);
	private EditMenu 	editMenu 	= new EditMenu(data, cmd);
	private WindowMenu 	windowMenu 	= new WindowMenu(data, cmd);
	private OptionsMenu optionsMenu = new OptionsMenu(data, cmd);
	private HelpMenu 	helpMenu 	= new HelpMenu(data, cmd);
	
	public PMenu()
	{
		Object[] obj = {
					   	fileMenu.createFileMenu(), 
					   	editMenu.createEditMenu(), 
					   	windowMenu.createWindowMenu(), 
					   	optionsMenu.createOptionsMenu(), 
					   	helpMenu.createHelpMenu()
					   };
		for (int i = 0; i < obj.length; i++) 
		{
			add((JMenu) obj[i]);
		}
	}

	private void refreshMenu()
	{

	}
}