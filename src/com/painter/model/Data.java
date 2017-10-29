package com.painter.model;

import com.painter.model.lang.DefaultDictionary;
import com.painter.model.lang.InterfaceLanguage;

public class Data
{
	public static InterfaceLanguage dictionary = new DefaultDictionary();

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
