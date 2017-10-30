package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.HotKeysDialog;

public class ActionHotKeys implements ActionListener 
{
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new HotKeysDialog();
	}
}
