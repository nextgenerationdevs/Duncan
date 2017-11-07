package com.painter.controller.plugins.list.def;

import java.awt.Color;
import javax.swing.JPanel;

import com.painter.model.Type;
import com.painter.model.plugins.InterfaceFigure;

public class DefaultPlugin implements InterfaceFigure
{
	private Type type;
	private int color;
	private int thickness;
	private boolean status;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private FigurePanel thisFigure;
	private JPanel thisProperties;
	
	public DefaultPlugin(int x, int y)
	{
		this.x = x;
		this.y = y;
		init();
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	void init()
	{
		type = Type.rectangle;
		color = 0;
		thickness = 1;
		width = 160;
		height = 90;
		
		thisFigure = new FigurePanel(0, 0, width + thickness, height + thickness, color, thickness, type);
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
	public void setMainProperties(Type type, int color, int thickness)
	{
		this.type = type;
		this.color = color;
		this.thickness = thickness;
		thisFigure =  new FigurePanel(0, 0, width + thickness, height + thickness, color, thickness, type);
	}

	@Override
	public int[] getMainProperties() 
	{
		int[] ret = {color, thickness};
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

	@Override
	public InterfaceFigure getInstance(InterfaceFigure figure)
	{
		return new DefaultPlugin(((DefaultPlugin)figure).getX(), ((DefaultPlugin)figure).getY());		
	}

}
