package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.view.PFrame;
import com.painter.view.PMenu;
import com.painter.view.menus.OptionsMenu;
import com.painter.view.modal.AddLanguageDialog;

public class ActionAddLanguage implements ActionListener 
{
	Data data;
	PFrame frame;

	public ActionAddLanguage(Data data, PFrame frame)
	{
		this.data = data;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new AddLanguageDialog(data, frame);
	}
}