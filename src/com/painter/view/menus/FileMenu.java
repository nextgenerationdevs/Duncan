package com.painter.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class FileMenu extends JMenu
{
	private Data data;
	private PCommand cmd;
	
	public FileMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}
	
	public JMenu createFileMenu()
	{
		JMenu file = new JMenu(data.bundle.getString("actionFile"));	

		String[] arrayStr = {"actionNew", "actionOpen", "actionOpenFromCloud", "actionLoad", "actionSave", "actionSaveToCloud", 
				"actionReload", "actionClose", "actionExit"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(data.bundle.getString(arrayStr[i]));
			item.setActionCommand(arrayStr[i]);
			switch (arrayStr[i]) 
			{
				case "actionNew": item.setIcon(new ImageIcon("resources/img/menubar/newFile-icon.png"));
								  item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
								  item.addActionListener(cmd.actionTabbedPane); break;
				case "actionOpen": item.setIcon(new ImageIcon("resources/img/menubar/openFile-icon.png"));
				   				   item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
				   				   item.addActionListener(cmd.actionTabbedPane); break;
				case "actionOpenFromCloud": item.setIcon(new ImageIcon("resources/img/menubar/openFileFromCloud-icon.png"));
											item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.ALT_MASK | ActionEvent.SHIFT_MASK));
											/*item.addActionListener(cmd.?);*/ break;
				case "actionLoad": item.setIcon(new ImageIcon("resources/img/menubar/loadFile-icon.png"));
								   item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
								   item.addActionListener(cmd.actionTabbedPane); break;
				case "actionSave": item.setIcon(new ImageIcon("resources/img/menubar/saveFile-icon.png"));
								   item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
								   item.addActionListener(cmd.actionSaveFile); break;
				case "actionSaveToCloud": item.setIcon(new ImageIcon("resources/img/menubar/saveFileToCloud-icon.png"));
										  item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK | ActionEvent.SHIFT_MASK));
										  /*item.addActionListener(cmd.?);*/ break;
				case "actionReload": item.setIcon(new ImageIcon("resources/img/menubar/reloadFile-icon.png"));
									 item.setAccelerator(KeyStroke.getKeyStroke("F5"));
				   					 /*item.addActionListener(cmd.?);*/ break;
				case "actionClose": item.setIcon(new ImageIcon("resources/img/menubar/closeFile-icon.png"));
									item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, ActionEvent.CTRL_MASK));
									item.addActionListener(cmd.actionTabbedPane); break;
				case "actionExit": item.setIcon(new ImageIcon("resources/img/menubar/exitProgram-icon.png"));
								   item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
								   item.addActionListener(cmd.actionExit); break;
			}
			file.add(item);
			if (i == 0 || i == 3 || i == 7) 
			{
				file.addSeparator();
			}
		}	
		return file;
	}
}