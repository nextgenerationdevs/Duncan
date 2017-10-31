package com.painter.model;

import com.painter.model.lang.InterfaceLanguage;
import com.painter.model.lang.LanguageFactory;
import com.painter.model.plugins.InterfaceFigure;

public class Data
{
	public static InterfaceLanguage dictionary = LanguageFactory.activeLanguage();

	public int statusX = 0;
	public int statusY = 0;
	
	InterfaceFigure selectedFigure;
	
	public int getStatusX()
	{
		return statusX;
	}
	public void setStatusX(int statusX)
	{
		this.statusX = statusX;
	}
	public int getStutusY()
	{
		return statusY;
	}
	public void setStutusY(int statusY)
	{
		this.statusY = statusY;
	}
	
	// Default Properties
	public int type;
	public int color;
	public int thickness = 1;
	
	//	Selected Plugin
	public int selectedIndex = 0;
}
