package com.painter.controller;

import java.awt.Color;
//import java.awt.event.MouseEvent;
//import java.awt.event.MouseMotionListener;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.painter.model.Data;
import com.painter.model.FiguresList;
import com.painter.model.plugins.InterfaceFigure;
import com.painter.model.plugins.PluginsList;

public class PPanel extends JPanel	// implements MouseMotionListener
{
	Data data;
	
	public PPanel (Data data)
	{
		this.data = data;
//		setSize(1000, 800);
		setBackground(Color.WHITE);
	}
	
	@Override
	public void paint(Graphics arg0)
	{
		for (JPanel figure : FiguresList.getFigures())
		{
			add(figure);
		}
		super.paint(arg0);
	}
//	
//	@Override
//	public void mouseMoved(MouseEvent e) 
//	{
//		PStatusBar.setStatus("X: " + e.getX() + "  " + "Y: " + e.getY(), "file:");
//	}
//
//	@Override
//	public void mouseDragged(MouseEvent e)
//	{
//			
//	}
}
