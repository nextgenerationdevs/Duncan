package com.painter.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class FiguresList 
{
	private static List<JPanel> figures;

	public static List<JPanel> getFigures()
	{
		if (figures == null)
			figures = Collections.synchronizedList(new ArrayList<>());
		return figures;
	}
	
	public static void addFigure(JPanel figure)
	{
		
	}
}
