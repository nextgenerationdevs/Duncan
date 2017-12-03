package com.painter.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

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
	private JMenu window;
	private ConcurrentMap<String, JMenuItem> windows;

	public WindowMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
		cmd.actionReloadWindows.setVMenu(this);
		window = new JMenu(data.bundle.getString("actionWindow"));
		windows = new ConcurrentHashMap<>();
	}

	public JMenu createWindowMenu()
	{
		String[] arrayStr = {"actionNextTab", "actionPrevTab"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(data.bundle.getString(arrayStr[i]));
			item.setActionCommand(arrayStr[i]);
			switch (arrayStr[i]) 
			{
				case "actionNextTab": item.setIcon(new ImageIcon("resources/img/menubar/nextTab-icon.png"));
				item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, ActionEvent.CTRL_MASK));
				item.addActionListener(cmd.actionTabbedPane); break;
				case "actionPrevTab": item.setIcon(new ImageIcon("resources/img/menubar/prevTab-icon.png"));
				item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_TAB, ActionEvent.SHIFT_MASK));
				item.addActionListener(cmd.actionTabbedPane); break;
			}
			window.add(item);
			if (i == 1) 
			{
				window.addSeparator();
			}
		}		
		return window;
	}

	public void setWindows()
	{
		Set<String> keys = windows.keySet();
		for (String key: keys)
		{
			window.remove(windows.remove(key));
		}			

		for (String name: data.names)
		{
			JMenuItem item = new JMenuItem(name);
			windows.put(item.getText(), item);
			window.add(item);
		}
		window.invalidate();
		window.repaint();
	}
}