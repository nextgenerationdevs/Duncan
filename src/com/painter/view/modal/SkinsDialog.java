package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import com.painter.controller.PPanel;
import com.painter.controller.skins.SkinsFactory;
import com.painter.model.Data;
import com.painter.view.PFrame;

@SuppressWarnings("serial")
public class SkinsDialog extends JDialog
{
	Data data;
	SkinsFactory factory = new SkinsFactory();
	
	
	public SkinsDialog(Data data, PFrame frame)
	{
		this.data = data;
		setTitle("Skins Management");
		
		PPanel pp = new PPanel(data);
		int width = 300;
		int height = 500;
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 2;
		int y =  pp.getToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		setModal(true);
		setResizable(false);
		
		JPanel chngePanel = new JPanel();
		chngePanel.setLayout(new GridLayout(1, 3, 10, 0));
		chngePanel.setBackground(Color.BLACK);
		
		add(chngePanel, BorderLayout.NORTH);
		
		JButton jButton2 = new JButton("Luna");
		chngePanel.add(jButton2);
		jButton2.addActionListener(new java.awt.event.ActionListener()
		{
			public void actionPerformed(java.awt.event.ActionEvent evt)
			{
				factory.skinsActionPerformed(evt, frame, jButton2.getText());
			}
		});
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3, 10, 0));
		String[] arrayStr = {"OK", "Apply", "Cancel"};
		for (int i = 0; i < arrayStr.length; i++)
		{
			JButton button = new JButton(arrayStr[i]);
			switch (arrayStr[i]) 
			{
				case "OK": 	   button.addActionListener(new SaveChangesOfModalWindow()); 
							   button.setEnabled(true);
						   	   break;
				case "Apply":  button.addActionListener(new ApplyModalWindow()); 
							   button.setEnabled(false);
							   break;
				case "Cancel": button.addActionListener(new CloseModalWindow()); 
							   button.setEnabled(true);
							   break;
			}
			controlPanel.add(button);
		}
		add(controlPanel, BorderLayout.SOUTH);
		setVisible(true);
	}

	class SaveChangesOfModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dispose();
		}
	}
	
	class ApplyModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			setEnabled(false);
		}
	}
	
	class CloseModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dispose();
		}
	}
}
