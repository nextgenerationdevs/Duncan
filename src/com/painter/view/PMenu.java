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
	private FileMenu 	fileMenu;
	private EditMenu 	editMenu;
	private WindowMenu 	windowMenu;
	private OptionsMenu optionsMenu;
	private HelpMenu 	helpMenu;

	public PMenu(Data data, PCommand cmd)
	{
		fileMenu 	= new FileMenu(data, cmd);
		editMenu 	= new EditMenu(data, cmd);
		windowMenu 	= new WindowMenu(data, cmd);
		optionsMenu = new OptionsMenu(data, cmd);
		helpMenu 	= new HelpMenu(data, cmd);

		createMenu();
	}

	private void createMenu()
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
	
	public void refreshMenu()
	{
		
	}
}