package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.painter.model.Data;

public class AddLanguageDialog extends JDialog implements ActionListener
{
	Data data;
	
	public AddLanguageDialog(Data data) 
	{
		this.data = data;
		
		setTitle("ADD LANGUAGE");
		
		JPanel pp = new JPanel();
		int width = 400;
		int height = 100;	
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 4;
		int y = pp.getToolkit().getScreenSize().height / 2 - height;
		setLocation(x, y);
		setSize(width, height);
		
		JPanel mainPanel = new JPanel();

		
		
		
		
		
		
		
		
		
		add(mainPanel);
		pack();
		
		setResizable(false);
		setModal(true);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();
	}
}