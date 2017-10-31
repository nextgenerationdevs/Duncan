package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.PFrame;
import com.painter.view.modal.SkinsDialog;

public class ActionSkins implements ActionListener 
{
	Data data;
	PFrame frame;
	public ActionSkins(Data data, PFrame frame)
	{
		this.data = data;
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new SkinsDialog(data, frame);
	}
}
