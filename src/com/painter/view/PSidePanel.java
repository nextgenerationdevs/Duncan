package com.painter.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.painter.controller.PCommand;

public class PSidePanel extends JPanel
{
	PCommand cmd;
	
	public PSidePanel(PCommand cmd)
	{
		this.cmd = cmd;

		JLabel nameLabel = new JLabel("Figures");
		nameLabel.setFont(new Font("Arial", Font.BOLD, 14));
		nameLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		PFigures figuresPanel = new PFigures(cmd);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(Box.createRigidArea(new Dimension(180, 0)));
		add(nameLabel);
		add(figuresPanel);
		
		setVisible(true);
	}
}
