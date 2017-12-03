package com.painter.model;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Images
{
	private static final ImageIcon icon = new ImageIcon("./resources/img/ico.png");

	public static Image getIcon()
	{
		return icon.getImage();
	}
	
}
