package com.painter.controller.listeners;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.view.PFrame;
import com.painter.view.PMenu;

public class ActionSetLanguage implements ActionListener 
{
	Data data;
	PFrame frame;
	
	public ActionSetLanguage(Data data, PFrame frame)
	{
		this.data = data;
		this.frame = frame;
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
				System.out.println(language.getName() + " status = " + language.getStatus());
			}
			else
			{
				language.setStatus(false);
				System.out.println(language.getName() + " status = " + language.getStatus());
			}
		}
		data.bundle = LanguageFactory.activeLanguage();	
		frame.refreshFrame();
	}
}