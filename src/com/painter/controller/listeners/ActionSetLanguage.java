package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.view.PMenu;

public class ActionSetLanguage implements ActionListener 
{
	Data data;
	PMenu menuBar;
	
	public ActionSetLanguage(Data data, PMenu menuBar)
	{
		this.data = data;
		this.menuBar = menuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		for (InterfaceBundle language : LanguageFactory.bundles)
		{
			if (str.equals(language.getName()))
			{
				language.setStatus(true); 
			}
			else
			{
				language.setStatus(false);
			}	
		}
		data.bundle = LanguageFactory.activeLanguage();
		//menuBar.refreshMenu();
	}
}