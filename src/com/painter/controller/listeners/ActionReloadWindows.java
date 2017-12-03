package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.view.menus.WindowMenu;

public class ActionReloadWindows implements ActionListener
{
	WindowMenu wMenu;
	
	public void setVMenu(WindowMenu wMenu)
	{
		this.wMenu = wMenu;
	}

	@Override
	public void actionPerformed(ActionEvent ae)
	{
		if (ae.getActionCommand().equals("updateWindowMenu"))
		{
			wMenu.setWindows();
		}
	}

}
