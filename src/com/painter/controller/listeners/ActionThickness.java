package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.ThicknessDialog;

public class ActionThickness implements ActionListener 
{
	Data data;
	
	public ActionThickness(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new ThicknessDialog(data);
	}
}