<<<<<<< HEAD
package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.modal.AboutDialog;
import com.painter.view.modal.ColorDialog;

public class ActionColorChooser implements ActionListener 
{
	Data data;
	
	public ActionColorChooser(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		new ColorDialog(data);
	}
=======
package com.painter.controller.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JDialog;

import com.painter.model.Data;

public class ActionColorChooser implements ActionListener 
{
	Data data;
	
	public ActionColorChooser(Data data)
	{
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		Color newColor = JColorChooser.showDialog(null, "Choosing default color...", new Color(data.getColor()));
		if(newColor != null)
		{
			data.setColor(newColor.getRGB());
		}
	}
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}