package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import com.painter.controller.PPanel;
import com.painter.model.Data;

public class PHotKeysPanel extends JPanel
{
	Data data = null;
	JTabbedPane jtp = new JTabbedPane();
	
	public PHotKeysPanel(Data data)
	{
		this.data = data;
		
		
		PPanel pp = new PPanel(data);
		int width = 400;
		int height = 600;
		int x = pp.getWidth() / 2 - width / 2;
		int y = pp.getHeight() / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		
		
		JPanel installedPanel = new JPanel();
		installedPanel.setLayout(new GridLayout(2, 3, 10, 10));	
		
		JPanel searchPanel = new JPanel();
		searchPanel.setLayout(new GridLayout(2, 3, 10, 10));
		
		JLabel figureLabel1 = new JLabel("Rectangle");
		
		JPanel rectangle = new JPanel();
		rectangle.setSize(100, 100);
		rectangle.setBorder(new EtchedBorder());
		rectangle.setBackground(Color.WHITE);
		
		JButton buttonUninstall1 = new JButton("Uninstall");
		
		installedPanel.add(figureLabel1, BorderLayout.WEST);
		installedPanel.add(rectangle, BorderLayout.CENTER);
		installedPanel.add(buttonUninstall1, BorderLayout.CENTER);
		
		JLabel figureLabel2 = new JLabel("Rectangle with Text");
		
		JPanel rectangleText = new JPanel();
		rectangleText.setSize(100, 100);
		rectangleText.setBorder(new EtchedBorder());
		rectangleText.setBackground(Color.WHITE);
		
		JButton buttonUninstall2 = new JButton("Uninstall");
		
		installedPanel.add(figureLabel2, BorderLayout.WEST);
		installedPanel.add(rectangleText, BorderLayout.CENTER);
		installedPanel.add(buttonUninstall2, BorderLayout.CENTER);
		
		JScrollPane scrollPaneInstalled = new JScrollPane( installedPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		JScrollPane scrollPaneSearch = new JScrollPane( searchPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		jtp.addTab("Installed", scrollPaneInstalled);
		jtp.addTab("Search", scrollPaneSearch);
		add(jtp, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3, 10, 0));
		String[] arrayStr = {"OK", "Apply", "Cancel"};
		for (int i = 0; i < arrayStr.length; i++)
		{
			JButton button = new JButton(arrayStr[i]);
			switch (arrayStr[i]) 
			{
				case "Cancel": button.addActionListener(new CloseModalWindow()); 
							   button.setEnabled(true);
							   break;
			}
			controlPanel.add(button);
		}
		add(controlPanel, BorderLayout.SOUTH);
		setVisible(true);
	}
	
	class CloseModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			
		}
	}
}