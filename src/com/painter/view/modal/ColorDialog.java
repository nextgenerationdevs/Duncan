package com.painter.view.modal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.painter.model.Data;

public class ColorDialog extends JDialog
{
	JColorChooser colorChooser = new JColorChooser();
	Data data;
		
	public ColorDialog(Data data)
	{		
		this.data = data;

		Color color = colorChooser.showDialog(null, "Choosing default color...", Color.red);
		data.setColor(color.getRGB());
		//add(colorChooser);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		//setModal(true);
		setResizable(false);
		setVisible(true);
	}
}