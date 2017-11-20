package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Checkbox;
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

public class CreateNewFileDialog extends JDialog
{
	public static String fileName = "";
	public static int status_WINDOW = 1;
	
	JLabel labelFileName;
	JTextField fieldFileName;
	
	Checkbox defaultLocation;
	
	JLabel labelLocation;
	JTextField fieldLocation;
	JButton btnBrowse;
	
	JButton btnOk;
	JButton btnCancel;

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
		
		labelFileName = new JLabel("File Name: ");
		panelForm.add(labelFileName, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		fieldFileName = new JTextField("Untitled", 15);
		panelForm.add(fieldFileName, c);
		
		c.gridy ++;

		c.gridx = 0;
		c.gridwidth = 3;
		defaultLocation = new Checkbox("Use default location", true);
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
					fieldFileName.setText(fileChooser.getSelectedFile().toString());
				}
			}
		});
		panelForm.add(btnBrowse, c);
		c.gridy ++;
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.LINE_END;
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setStatusWindow(0);
				fileName = fieldFileName.getText();
				dispose();
			}
		});
		panelForm.add(btnOk, c);
		
		c.gridx = 2;
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				setStatusWindow(1);
				dispose();
			}
		});
		panelForm.add(btnCancel, c);
		
		add(panelForm, BorderLayout.CENTER);
		pack();
		
		setResizable(false);
		setModal(true);
		setVisible(true);
	}
	
	public static int returnStatusWindow()
	{
		return status_WINDOW;
	}
	
	public static void setStatusWindow(int value)
	{
		status_WINDOW = value;
	}
	
	public static String returnFileName()
	{
		return fileName;
	}
}