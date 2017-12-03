package com.painter.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PStatusBar extends JPanel
{
	private static final JLabel statusCoord = new JLabel();
	private static final JLabel statusFile = new JLabel();
	
	public PStatusBar(String str1, String str2) 
	{
		setLayout(new BorderLayout());
		setBorder(new EtchedBorder());
		statusCoord.setText(str1);
		statusFile.setText(str2);
		add(statusCoord, BorderLayout.WEST);
		add(statusFile, BorderLayout.EAST);
		
	}

	public static void setStatus(String coordinates) 
	{
		statusCoord.setText(coordinates);	
	}

	public static void setFile(String file)
	{
		statusFile.setText(file);
	}
}