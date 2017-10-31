package com.painter.model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class FigurePanel extends JPanel
{
	int x;
	int y;
	int width;
	int height;
	int color;
	int thickness;
	int type;
	
	public FigurePanel(int x, int y, int width, int height, int color, int thickness, int type)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.color = color;
		this.thickness = thickness;
		this.type = type;
	}
	
	@Override
	public void paint(Graphics g)
	{
		drawShape(g);
		super.paint(g);
	}
	
	public void drawShape(Graphics g)
	{
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(thickness));
		g2d.setColor(new Color(color));
		switch(type)
		{
		case 0:
			g2d.drawRect(x, y, width, height);
			break;
		case 1:
			g2d.drawOval(x, y, width, height);
			break;
		case 2:
			g2d.drawRoundRect(x, y, width, height, (int)(width * 0.05), (int)(height * 0.05));
			break;
		case 3:
			g2d.drawLine(x, y, width, height);
			break;
		default:
			break;
		}
	}
}
