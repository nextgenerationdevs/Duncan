package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class AboutDialog extends JDialog implements ActionListener
{
	public AboutDialog() 
	{
		JButton button = new JButton("OK");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
		add(new JLabel("Version 1.0.0"), BorderLayout.NORTH);
		int width = 300;
		int height = 100;	
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
