package com.painter.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PStatusBar extends JPanel
{
	private static final JLabel statusCoord = new JLabel();
	private static final JLabel statusFile = new JLabel();
	
	public PStatusBar(String str) 
	{
		setLayout(new BorderLayout());
		setBorder(new EtchedBorder());
		statusCoord.setText(str);
		add(statusCoord, BorderLayout.WEST);
		add(statusFile, BorderLayout.EAST);
		
	}

	public static void setStatus(String coordinates, String file) 
	{
		statusCoord.setText(coordinates);
		statusFile.setText(file);
	}
}