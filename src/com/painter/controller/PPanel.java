package com.painter.controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import com.painter.model.Resizable;
import com.painter.model.plugins.InterfaceFigure;

public class PPanel extends JPanel
{
	PCommand cmd;
	
	public List<Resizable> figures = Collections.synchronizedList(new ArrayList<>());

	public PPanel (PCommand cmd)
	{
		setLayout(null);
		this.cmd = cmd;
		addMouseMotionListener(cmd.mousePaint);
		addMouseListener(cmd.mousePaint);
		subscribeListener();
		setBackground(Color.WHITE);
	}
	
	public void addFigure()
	{
		Resizable resFigure = figures.get(figures.size() - 1);
		add(resFigure);		
		resFigure.revalidate();
		resFigure.requestFocus();
		resFigure.repaint();
	}

	public void update()
	{	
		revalidate();
		repaint();
	}

	public void subscribeListener()
	{
		cmd.dropTargetListener.setPPanel(this);

		cmd.mousePaint.setPPanel(this);
	}
}