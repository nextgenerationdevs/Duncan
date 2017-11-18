package com.painter.view.modal;

import java.awt.Color;

import javax.swing.JColorChooser;
import javax.swing.JDialog;

import com.painter.model.Data;

public class ColorDialog extends JDialog
{
	JColorChooser colorChooser = new JColorChooser();
	Data data = null;
		
	public ColorDialog(Data data)
	{		
		this.data = data;
			
		Color color = colorChooser.showDialog(null, "Color", Color.BLUE);
//		data.color = color.getRGB();
		add(colorChooser);
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);	
		
		setModal(true);
		setResizable(false);
	}
}
