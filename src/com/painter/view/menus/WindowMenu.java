package com.painter.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class WindowMenu extends JMenu
{
	private Data data;
	private PCommand cmd;

	public WindowMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}
	
	public JMenu createWindowMenu()
	{
		JMenu window = new JMenu("actionWindow");	
		window.setText(data.dictionary.getDictionary().get(window.getActionCommand()));

		String[] arrayStr = {"actionNextTab", "actionPrevTab", "actionTab"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			window.add(item);
			switch (arrayStr[i]) 
			{
				case "actionNextTab": item.setIcon(new ImageIcon("resources/img/menubar/nextTab-icon.png"));
								   	  item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, ActionEvent.CTRL_MASK));
								   	  /*item.addActionListener(cmd.?);*/ break;
				case "actionPrevTab": item.setIcon(new ImageIcon("resources/img/menubar/prevTab-icon.png"));
				   					  item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, ActionEvent.SHIFT_MASK));
				   					  /*item.addActionListener(cmd.?);*/ break;
				case "actionTab": /*item.addActionListener(cmd.?);*/ break;
			}
			if (i == 1) 
			{
				window.addSeparator();
			}
		}		
		return window;
	}
}