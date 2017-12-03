package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
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
import javax.swing.filechooser.FileNameExtensionFilter;

public class CreateNewFileDialog extends JDialog
{
	private final static int widthOfCreateNewFileDialog = 500;
	private final static int heightOfCreateNewFileDialog = 400;
	
	private final static String defaultLocation = "C:/Profram Files/Painter/projects";
	public static String fileName = "";
	public static int status_WINDOW = 1;
	
	JLabel labelFileName;
	JTextField fieldFileName;
	
	Checkbox checkDefaultLocation;
	
	JLabel labelLocation;
	JTextField fieldLocation;
	JButton btnBrowse;
	
	JButton btnOk;
	JButton btnCancel;

	public CreateNewFileDialog() 
	{
		setTitle("CREATING NEW TAB...");
		
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfCreateNewFileDialog) / 2, 
			 	 	 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfCreateNewFileDialog) / 2);
		setSize(widthOfCreateNewFileDialog, heightOfCreateNewFileDialog);
		
		JPanel panelForm = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5, 5, 5, 2);
		
		labelFileName = new JLabel("File Name: ");
		panelForm.add(labelFileName, c);
		
		c.gridx = 1;
		c.gridwidth = 2;
		c.insets = new Insets(5, 0, 5, 0);
		fieldFileName = new JTextField("Untitled", 27);
		panelForm.add(fieldFileName, c);
		
		c.gridy ++;

		c.gridx = 0;
		c.gridwidth = 3;
		c.insets = new Insets(5, 5, 5, 0);
		checkDefaultLocation = new Checkbox("Use default location", true);
		checkDefaultLocation.addItemListener(new ItemListener() 
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
		panelForm.add(checkDefaultLocation, c);
		c.gridy ++;
		
		c.gridwidth = 1;
		c.insets = new Insets(5, 5, 5, 2);
		labelLocation = new JLabel("Location: ");
		labelLocation.setEnabled(false);
		panelForm.add(labelLocation, c);
		
		c.gridx = 1;
		c.insets = new Insets(5, 0, 5, 10);
		fieldLocation = new JTextField(defaultLocation, 20);
		fieldLocation.setEnabled(false);
		panelForm.add(fieldLocation, c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(5, 0, 5, 5);
		btnBrowse = new JButton("Browse");
		btnBrowse.setEnabled(false);
		btnBrowse.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JFileChooser chooser = new JFileChooser();
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				int returnValue = chooser.showDialog(null, "Browse");
				if (returnValue == JFileChooser.APPROVE_OPTION) 
				{
					fieldLocation.setText(chooser.getSelectedFile().toString());
				}
			}
		});
		panelForm.add(btnBrowse, c);
		c.gridy ++;
		
		c.gridx = 1;
		c.insets = new Insets(5, 0, 5, 10);
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
		c.insets = new Insets(5, 0, 5, 5);
		c.anchor = GridBagConstraints.CENTER;
		btnCancel = new JButton("Cancel");
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