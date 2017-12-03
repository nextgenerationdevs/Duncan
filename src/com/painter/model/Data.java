package com.painter.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.painter.model.lang.LanguageFactory;
import com.painter.model.plugins.InterfaceFigure;
import com.painter.model.plugins.PluginsList;

public class Data
{
	public ResourceBundle bundle = LanguageFactory.activeLanguage();
	
	public int statusX = 0;
	public int statusY = 0;
	
	public InterfaceFigure selectedFigure = PluginsList.getPlugins().get(0);
	
	//Default Properties
	public Type type = Type.oval;
	public int color = 0xFF9900;
	public int thickness = 10;

	//Selected Plugin
	public int selectedIndex = 0;

	//Tabs
	public List<String> names = new ArrayList<String>();
	
	public int getStatusX()
	{
		return statusX;
	}
	public void setStatusX(int statusX)
	{
		this.statusX = statusX;
	}
	public int getStatusY()
	{
		return statusY;
	}
	public void setStatusY(int statusY)
	{
		this.statusY = statusY;
	}	
	public int getThickness()
	{
		return thickness;
	}
	public void setThickness(int thickness)
	{
		this.thickness = thickness;
	}
	public int getColor()
	{
		return color;
	}
	public void setColor(int color)
	{
		this.color = color;
	}
}