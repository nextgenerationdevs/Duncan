package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.view.PMenu;
import com.painter.view.modal.AddLanguageDialog;

public class ActionAddLanguage implements ActionListener 
{
	Data data;
	PMenu menuBar;
	
	public ActionAddLanguage(Data data, PMenu menuBar)
	{
		this.data = data;
		this.menuBar = menuBar;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new AddLanguageDialog();
	}
}