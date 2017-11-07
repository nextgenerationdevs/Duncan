package com.painter.controller.plugins.list.def;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.painter.model.Type;

public class FigurePanel extends JPanel
{
	int x;
	int y;
	int width;
	int height;
	int color;
	int thickness;
	Type type;
	
	public FigurePanel(int x, int y, int width, int height, int color, int thickness, Type type)
	{
		this.x = x + thickness / 2;
		this.y = y + thickness / 2;
		this.width = width - thickness;
		this.height = height - thickness;
		this.color = color;
		this.thickness = thickness;
		this.type = type;
		
		setBackground(new Color(0, true));
		setBounds(x, y, width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g)
	{
		drawShape(g);
		super.paintComponent(g);
	}
	
	public void drawShape(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(new Color(color));
		switch(type)
		{
		case rectangle:
			g2d.drawRect(x, y, width, height);
			break;
		case oval:
			g2d.drawOval(x, y, width, height);
			break;
		case roundRect:
			g2d.drawRoundRect(x, y, width, height, (int)(width * 0.05), (int)(height * 0.05));
			break;
		case line:
			g2d.drawLine(x, y, width, height);
			break;
		default:
			break;
		}
	}
}
