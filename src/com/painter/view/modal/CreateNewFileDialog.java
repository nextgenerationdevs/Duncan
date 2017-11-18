package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.painter.model.Data;

public class CreateNewFileDialog extends JDialog implements ActionListener
{
	JLabel labelLocation;
	JTextField fieldLocation;
	JButton btnBrowse;
	JTextField txtPath;
	
	public CreateNewFileDialog() 
	{
		setTitle("CREATING NEW TAB...");
		
		JPanel pp = new JPanel();
		int width = 500;
		int height = 400;	
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 4;
		int y = pp.getToolkit().getScreenSize().height / 2 - height;
		setLocation(x, y);
		setSize(width, height);
		
		JPanel panelForm = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(10, 10, 10, 10);
		
		JLabel labelFileName = new JLabel("File Name: ");
		panelForm.add(labelFileName, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		JTextField fieldFileName = new JTextField("Untitled", 15);
		panelForm.add(fieldFileName, c);
		
		c.gridy ++;

		c.gridx = 0;
		c.gridwidth = 3;
		Checkbox defaultLocation = new Checkbox("Use default location", true);
		defaultLocation.addItemListener(new ItemListener() 
		{
			public void itemStateChanged(ItemEvent e) 
			{
				if (e.getStateChange() == ItemEvent.SELECTED)
				{
					labelLocation.setEnabled(false);
					fieldLocation.setEnabled(false);
					btnBrowse.setEnabled(false);
				}
				else 
				{
					labelLocation.setEnabled(true);
					fieldLocation.setEnabled(true);
					btnBrowse.setEnabled(true);
				}
			}
		});
		panelForm.add(defaultLocation, c);
		c.gridy ++;
		
		c.gridwidth = 1;
		labelLocation = new JLabel("Location: ");
		labelLocation.setEnabled(false);
		panelForm.add(labelLocation, c);
		
		c.gridx = 1;
		fieldLocation = new JTextField("C:/Profram Files/Painter/projects", 20);
		fieldLocation.setEnabled(false);
		panelForm.add(fieldLocation, c);
		
		c.gridx = 2;
		btnBrowse = new JButton("Browse");
		btnBrowse.setEnabled(false);
		btnBrowse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser fileChooser = new JFileChooser();

				// For Directory
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				// For File
				//fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

				fileChooser.setAcceptAllFileFilterUsed(false);

				int rVal = fileChooser.showOpenDialog(null);
				if (rVal == JFileChooser.APPROVE_OPTION) 
				{
					txtPath.setText(fileChooser.getSelectedFile().toString());
				}
			}
		});
		panelForm.add(btnBrowse, c);
		c.gridy ++;
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		JButton btn_ok = new JButton("OK");
		btn_ok.addActionListener(new ActionCreateNewFile());
		panelForm.add(btn_ok, c);
		
		c.gridx = 2;
		JButton btn_cancel = new JButton("Cancel");
		btn_cancel.addActionListener(this);
		panelForm.add(btn_cancel, c);
		
		add(panelForm, BorderLayout.CENTER);
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
	
	class ActionCreateNewFile implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			// TODO Auto-generated method stub
			
		}
	}
}