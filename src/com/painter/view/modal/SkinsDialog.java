package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import com.painter.controller.PPanel;
import com.painter.controller.skins.SkinsFactory;
import com.painter.model.Data;
import com.painter.view.PFrame;
import com.painter.view.modal.PluginsDialog.ApplyModalWindow;
import com.painter.view.modal.PluginsDialog.CloseModalWindow;
import com.painter.view.modal.PluginsDialog.SaveChangesOfModalWindow;

@SuppressWarnings("serial")
public class SkinsDialog extends JDialog
{
	Data data;
	SkinsFactory factory = new SkinsFactory();
	
	
	public SkinsDialog(Data data, PFrame frame)
	{
		this.data = data;
		setTitle("Skins Management");
		
		JPanel pp = new JPanel();
		int width = 300;
		int height = 500;
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 2;
		int y =  pp.getToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		setModal(true);
		setResizable(false);
		  
		JPanel chngePanel = new JPanel();
		
		String[] arraySkin = {"Luna", "Aero", "Aluminium", "Nimbus", "Graphite", "Metal", 
				"Bernstein", "Fast", "HiFi", "McWin", "Mint", "Noire", "Smart", 
				"Texture", "Autumn", "MistAqua", "BlackSteel", "Magma", "ChallengerDeep", 
				"EmeraldDusk", "MistSilver", "GraphiteGlass"};
		
		chngePanel.setLayout(new GridLayout(arraySkin.length, 1, 10, 0));
		
		for (int i = 0; i < arraySkin.length; i++)
		{
			JButton button = new JButton(arraySkin[i]);
			button.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					factory.skinsActionPerformed(evt, frame, button.getText());
				}
			});
			chngePanel.add(button, BorderLayout.CENTER);
		}
			
		JScrollPane scrollPaneSkin = new JScrollPane(chngePanel);		
		add(scrollPaneSkin, BorderLayout.CENTER);
		
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3, 10, 0));
		String[] arrayStr = {"OK", "Cancel"};
		for (int i = 0; i < arrayStr.length; i++)
		{
			JButton button = new JButton(arrayStr[i]);
			switch (arrayStr[i]) 
			{
				case "OK": 	   button.addActionListener(new SaveChangesOfModalWindow()); 
							   button.setEnabled(true);
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
	
	class CloseModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dispose();
		}
	}
}
