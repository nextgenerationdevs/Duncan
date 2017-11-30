package com.painter.controller.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JDialog;

import com.painter.model.Data;

public class ActionColorChooser extends JDialog implements ActionListener 
{
	Data data;
	
	public ActionColorChooser(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Color newColor = JColorChooser.showDialog(this, "Choosing default color...", new Color(data.getColor()));
		if(newColor != null)
		{
			data.setColor(newColor.getRGB());
		}
	}
}