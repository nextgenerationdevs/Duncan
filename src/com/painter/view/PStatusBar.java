package com.painter.view;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PStatusBar extends JPanel
{
	private static final JLabel statusCoord = new JLabel("X:	 " + "Y:		");
	private static final JLabel statusFile = new JLabel("file:");
	
	public PStatusBar() 
	{
		setLayout(new BorderLayout());
		setBorder(new EtchedBorder());
		add(statusCoord, BorderLayout.WEST);
		add(statusFile, BorderLayout.EAST);
	}

	public static void setStatus(String coordinates, String file) 
	{
		statusCoord.setText(coordinates);
		statusFile.setText(file);
	}
}