package com.painter.view;

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

import com.painter.controller.PCommand;

public class PSidePanel extends JPanel
{
	PCommand cmd;
	
	public PSidePanel(PCommand cmd)
	{
		this.cmd = cmd;
		
		PFigures figuresPanel = new PFigures(cmd);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JPanel());
		add(Box.createRigidArea(new Dimension(180, 0)));
		add(figuresPanel);
		
		setVisible(true);
	}
}
