package com.painter.controller;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class EmptyDialog extends JDialog implements ActionListener
{
	public EmptyDialog(String name)
	{
		setTitle("Modal window for " + name);
		JButton button = new JButton("OK");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
		add(new JLabel("You must do it!!!"), BorderLayout.CENTER);
		int width = 600;
		int height = 300;	
		setSize(width, height);
		setModal(true);
		int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - width / 2;
		int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		pack();
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();
	}
}