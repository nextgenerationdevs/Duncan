package com.painter.model;

import com.painter.model.lang.InterfaceLanguage;
import com.painter.model.lang.LanguageFactory;

public class Data
{
	public static InterfaceLanguage dictionary = LanguageFactory.activeLanguage();

	public int statusX = 0;
	public int statusY = 0;
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
	
	
}
