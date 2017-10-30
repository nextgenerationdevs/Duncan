package com.painter.view.menus;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class HelpMenu extends JMenu
{
	private Data data;
	private PCommand cmd;

	public HelpMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}
	
	public JMenu createHelpMenu()
	{
		JMenu help = new JMenu("actionHelp");	
		help.setText(data.dictionary.getDictionary().get(help.getActionCommand()));

		String[] arrayStr = {"actionHotKeys", "actionAbout"};
		for (int i = 0; i < arrayStr.length; i++)
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			switch (arrayStr[i]) 
			{
				case "actionHotKeys": item.setIcon(new ImageIcon("resources/img/menubar/hotKeys-icon.png"));
									  item.addActionListener(cmd.actionHotKeys); break;
				case "actionAbout": item.setIcon(new ImageIcon("resources/img/menubar/about-icon.png"));
									item.addActionListener(cmd.actionAbout); break;
			}
			help.add(item);
		}		
		return help;
	}
}