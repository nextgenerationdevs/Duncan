package com.painter.controller.plugins.list;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Stroke;

import javax.swing.JPanel;
import com.painter.model.plugins.InterfaceFigure;

public class DefaultPlugin implements InterfaceFigure
{
	private int type;
	private int color;
	private int thickness;
	private boolean status;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private JPanel thisFigure;
	private JPanel thisProperties;
	
	public DefaultPlugin(int x, int y)
	{
		type = 0;
		color = 0;
		thickness = 1;
		this.x = x;
		this.y = y;
		width = 200;
		height = 150;
		
		thisFigure = new JPanel();
		thisFigure.setBackground(new Color(Color.TRANSLUCENT));
		thisFigure.setBounds(x, y, width, height);
	}

	@Override
	public JPanel getPluginFigure() 
	{
		return thisFigure;
	}

	@Override
	public JPanel getPluginProperties() 
	{
		return null;
	}

	@Override
	public void drawShape(Graphics2D graphics)
	{
		Graphics2D graphics2d = (Graphics2D)graphics;
		graphics.setStroke(new BasicStroke(thickness));
		graphics.setColor(new Color(color));
		switch(type)
		{
		case 0:
			graphics.drawRect(x, y, width, height);
			break;
		case 1:
			graphics.drawOval(x, y, width, height);
			break;
		case 2:
			graphics.drawRoundRect(x, y, width, height, (int)(width * 0.05), (int)(height * 0.05));
			break;
		case 3:
			graphics.drawLine(x, y, width, height);
			break;
		default:
			break;
		}
	}
	
	@Override
	public void move(int newX, int newY) 
	{
		thisFigure.setLocation(newX, newY);
	}

	@Override
	public void resize(int startX, int startY, int endX, int endY) 
	{
		int leftCornerX = (startX < endX) ? startX : endX;
		int leftCornerY = (startY < endY) ? startY : endY;
		int rightCornerX = (startX > endX) ? startX : endX;
		int rightCornerY = (startY > endY) ? startY : endY;
		
		x = leftCornerX;
		y = leftCornerY;
		width = rightCornerX - leftCornerX;
		height = rightCornerY - leftCornerY;
		
		thisFigure.setLocation(x, y);
		thisFigure.setSize(width, height);
	}

	@Override
	public void setMainProperties(int type, int color, int thickness)
	{
		this.type = type;
		this.color = color;
		this.thickness = thickness;
	}

	@Override
	public int[] getMainProperties() 
	{
		int[] ret = {type, color, thickness};
		return ret;
	}

	@Override
	public boolean isSelected()
	{
		return status;
	}

	@Override
	public void setCoordinates(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}

}
