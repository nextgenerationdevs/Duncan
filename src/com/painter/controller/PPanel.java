package com.painter.controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

import com.painter.model.Data;
import com.painter.view.PStatusBar;

public class PPanel extends JPanel implements MouseMotionListener
{
	Data data;
	
	public PPanel (Data data)
	{
		this.data = data;
		setSize(1000, 800);
		setBackground(Color.GRAY);
	}
	
	@Override
	public void mouseMoved(MouseEvent e) 
	{
		PStatusBar.setStatus("X: " + e.getX() + "  " + "Y: " + e.getY(), "file:");
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
			
	}
}
