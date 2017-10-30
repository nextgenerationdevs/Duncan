package com.painter.view.modal.plugins_model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PluginsImpl
{
	List<Plugins> listOfPlugins = new ArrayList<>();

	public PluginsImpl()
	{
		JPanel rectangle = new JPanel();
		rectangle.setBorder(new EtchedBorder(10, Color.BLACK, null));
		rectangle.setSize(50, 50);
		rectangle.setBackground(Color.WHITE);
		
		JPanel rectangleText = new JPanel();
		rectangleText.setBorder(new EtchedBorder(10, Color.BLACK, null));
		rectangleText.setSize(50, 50);
		rectangleText.setBackground(Color.WHITE);
		JLabel labelText = new JLabel("Text");
		rectangleText.setLayout(new BorderLayout());
		rectangleText.add(labelText, BorderLayout.CENTER);
		
		listOfPlugins.add(new Plugins(true, "Rectangle", rectangle));
		listOfPlugins.add(new Plugins(true, "Rectangle with text", rectangleText));
		//listOfPlugins.add(new Plugins(false, "Rectangle with picture", new JPanel()));
		//listOfPlugins.add(new Plugins(false, "Rectangle with video", new JPanel()));
	}

	public ArrayList<Plugins> read() 
	{
		return (ArrayList<Plugins>) listOfPlugins;
	}
}