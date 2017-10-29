package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;

import com.painter.controller.PPanel;
import com.painter.model.Data;

public class PluginsDialog extends JDialog
{
	Data data = null;
	JTabbedPane jtp = new JTabbedPane();
	
	public PluginsDialog(Data data)
	{
		this.data = data;
		setTitle("Plugins Management");
		
		PPanel pp = new PPanel(data);
		int width = 400;
		int height = 600;
		int x = pp.getLocation().x + pp.getWidth() / 2 - width / 2;
		int y =  pp.getLocation().y + pp.getHeight() / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		setModal(true);
		
		JPanel installedPanel = new JPanel();
		//getContentPane().add(installedPanel);
		JPanel searchPanel = new JPanel();
		//searchPanel.setLayout(new GridLayout(2, 3, 10, 10));
		//installedPanel.setLayout(new GridLayout(2, 3, 10, 100));	
		//installedPanel.setLayout(new FlowLayout());
		//installedPanel.setLayout(new BoxLayout(firstPanel, BoxLayout.PAGE_AXIS));	
		
		JLabel figureLabel1 = new JLabel("Rectangle: ");
		
		JPanel rectangle = new JPanel();
		rectangle.setSize(100, 100);
		rectangle.setBorder(new EtchedBorder());
		rectangle.setBackground(Color.WHITE);
		
		JButton buttonUninstall1 = new JButton("Uninstall");
		
		JCheckBox checkBox1 = new JCheckBox();
		
		JLabel figureLabel2 = new JLabel("Rectangle with text: ");
		
		JPanel rectangleText = new JPanel();
		rectangleText.setSize(100, 100);
		rectangleText.setBorder(new EtchedBorder());
		rectangleText.setBackground(Color.WHITE);
		
		JButton buttonUninstall2 = new JButton("Uninstall");
		
		JCheckBox checkBox2 = new JCheckBox();
			
		JPanel panelForm = new JPanel(new GridBagLayout());
		installedPanel.add(panelForm);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = 2;
		c.insets = new Insets(20, 0, 20, 20);
		
		panelForm.add(figureLabel1, c);
	
		c.gridx = 1;
		c.gridy = 0;
		//c.gridwidth = 2;
		//c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.VERTICAL;
		
		panelForm.add(rectangle, c);
		
		c.gridx = 2;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;

		panelForm.add(checkBox1, c);
		
		c.gridx = 2;
		c.gridy = 1;
		
		panelForm.add(buttonUninstall1, c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.LINE_START;
		c.gridheight = 2;
		
		panelForm.add(figureLabel2, c);
		
		c.gridx = 1;
		c.gridy = 2;
		//c.gridwidth = 2;
		//c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.VERTICAL;
		
		panelForm.add(rectangleText, c);
		
		c.gridx = 2;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		c.gridwidth = 1;
		c.gridheight = 1;

		panelForm.add(checkBox2, c);
		
		c.gridx = 2;
		c.gridy = 3;
		
		panelForm.add(buttonUninstall2, c);
		
		JScrollPane scrollPaneInstalled = new JScrollPane( installedPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		JScrollPane scrollPaneSearch = new JScrollPane( searchPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		jtp.addTab("Installed", scrollPaneInstalled);
		jtp.addTab("Search", scrollPaneSearch);
		add(jtp);
		
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