package com.painter.controller;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import com.painter.model.plugins.InterfaceFigure;

public class PPanel extends JPanel implements MouseMotionListener
{
	PCommand cmd;
	public List<InterfaceFigure> figures = Collections.synchronizedList(new ArrayList<>());
	
	public PPanel (PCommand cmd)
	{
		setLayout(null);
		this.cmd = cmd;
		subscribeListener();
		setBackground(Color.WHITE);
	}
	
	public void initialize()
	{
//		for (Component comp : getComponents())
//		{
//			remove(comp);
//		}
//		
//		for (InterfaceFigure figure : figures)
//		{
//			add(figure.getPluginFigure());
//		}
		add(figures.get(figures.size() - 1).getPluginFigure());
		revalidate();
		repaint();
	}
	
	public void subscribeListener()
	{
		cmd.dropTargetListener.setPPanel(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		cmd.getData().setStatusX(e.getX());
		cmd.getData().setStatusY(e.getY());
		
		cmd.actionUpdateStatusBar.actionPerformed(new ActionEvent(this, 0, "updateXY"));
	}
}