package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class AboutDialog extends JDialog implements ActionListener
{
	public AboutDialog() 
	{
		setTitle("AUTHORS");
		
		JPanel pp = new JPanel();
		int width = 400;
		int height = 100;	
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 4;
		int y = pp.getToolkit().getScreenSize().height / 2 - height;
		setLocation(x, y);
		setSize(width, height);
		
		JPanel panelForm = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 10, 10, 10);
		
		String[] arrayStr = {"Copyright by:", "Zima Maksim", "Chmul Dmitriy", "Kosyak Maksim", "Medvedev Dmitriy"}; 
		for (int i = 0; i < arrayStr.length; i++)
		{
			JLabel label = new JLabel(arrayStr[i]);
			switch (arrayStr[i]) 
			{
				case "Copyright by:" :		label.setFont(new Font("Arial", Font.BOLD, 16)); 	break;
				case "Zima Maksim" : 		label.setFont(new Font("Arial", Font.ITALIC, 14)); 	break;
				case "Chmul Dmitriy" : 		label.setFont(new Font("Arial", Font.ITALIC, 14)); 	break;
				case "Kosyak Maksim" : 		label.setFont(new Font("Arial", Font.ITALIC, 14)); 	break;
				case "Medvedev Dmitriy" : 	label.setFont(new Font("Arial", Font.ITALIC, 14)); 	break;
			}		
			panelForm.add(label, c);
			c.gridy ++;
		}
		
		JButton button = new JButton("OK");
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);
		
		add(panelForm);
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