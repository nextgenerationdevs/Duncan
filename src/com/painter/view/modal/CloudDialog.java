<<<<<<< HEAD
package com.painter.view.modal;

import javax.swing.JDialog;

public class CloudDialog extends JDialog
{

}
=======
package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.painter.controller.users.ListOfUsers;
import com.painter.controller.users.UserCloud;
import com.painter.model.Data;
import com.painter.view.modal.PluginsDialog.ApplyModalWindow;
import com.painter.view.modal.PluginsDialog.CloseModalWindow;
import com.painter.view.modal.PluginsDialog.SaveChangesOfModalWindow;

public class CloudDialog extends JDialog
{
	private final static int widthOfPluginsDialog = 350;
	private final static int heightOfPluginsDialog = 250;
	
	Data data;
	JPanel cloudPanelDialog;
	
	JTextField fieldCloudUrl;
	JComboBox cloudVault;
	JTextField fieldLoginOrEmail;
	JPasswordField fieldPassword;
	Checkbox checkboxUser;
	
	JButton btnOk;
	JButton btnCancel;
	
	public CloudDialog(Data data)
	{
		this.data = data;
		
		setTitle("Cloud Options");

		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfPluginsDialog) / 2, 
					 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfPluginsDialog) / 2);
		setSize(widthOfPluginsDialog, heightOfPluginsDialog);
		
		initializeCloudDialog();
		setTextToAllFields();
		
		setModal(true);
		setResizable(true);
		setVisible(true);
	}
	
	private void initializeCloudDialog()
	{
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 2, 10, 0));		
		btnOk = new JButton("OK");
		btnOk.setEnabled(false);
		btnOk.addActionListener(new SaveChangesOfModalWindow());
		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new CloseModalWindow()); 			
		controlPanel.add(btnOk);
		controlPanel.add(btnCancel);
		add(controlPanel, BorderLayout.SOUTH);
		
		cloudPanelDialog = new JPanel();
		cloudPanelDialog.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(3, 2, 3, 2);	
		JLabel labelCloudUrl = new JLabel("Cloud URL: ");
		cloudPanelDialog.add(labelCloudUrl, c);
		
		c.gridx = 1;
		fieldCloudUrl = new JTextField(15);
		fieldCloudUrl.getDocument().addDocumentListener(new FieldChangeListener());
		cloudPanelDialog.add(fieldCloudUrl, c);
		
		c.gridy++;
		c.gridx = 0;
		c.insets = new Insets(3, 2, 3, 2);		
		JLabel labelCloudVault = new JLabel("Cloud Vault: ");
		cloudPanelDialog.add(labelCloudVault, c);
		
		c.gridx = 1;	
		String[] cloudList = { "", "Microsoft Azure", "Amazon", "GitHub", "Etc..." };
		cloudVault = new JComboBox(cloudList);
		cloudVault.setSelectedIndex(0);
//		((JTextField)cloudVault.getEditor().getEditorComponent()).getDocument().addDocumentListener(new FieldChangeListener());	
		cloudVault.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				cloudVault = (JComboBox)e.getSource();
				cloudVault.setSelectedItem(cloudVault.getSelectedItem().toString());
				
//				String cloudItem = (String)cloudVault.getSelectedItem();
//				if (!cloudItem.equals(""))
//				{
//					btnOk.setEnabled(true);
//				}
//				else
//				{
//					btnOk.setEnabled(false);
//				}	
			}
		});
		cloudPanelDialog.add(cloudVault, c);
		
		c.gridy++;
		c.gridx = 0;
		JLabel labelLoginOrEmail = new JLabel("Login or Email: ");
		cloudPanelDialog.add(labelLoginOrEmail, c);
		
		c.gridx = 1;
		fieldLoginOrEmail = new JTextField(10);
		fieldLoginOrEmail.getDocument().addDocumentListener(new FieldChangeListener());
		cloudPanelDialog.add(fieldLoginOrEmail, c);
		
		c.gridy++;
		c.gridx = 0;		
		JLabel labelPassword = new JLabel("Password: ");
		cloudPanelDialog.add(labelPassword, c);
		
		c.gridx = 1;
		fieldPassword = new JPasswordField(10);
		fieldPassword.getDocument().addDocumentListener(new FieldChangeListener());
		cloudPanelDialog.add(fieldPassword, c);
		
		c.gridy++;
		c.gridx = 0;
		c.insets = new Insets(3, 2, 0, 2);
		checkboxUser = new Checkbox("Remember User", false);
		cloudPanelDialog.add(checkboxUser, c);
		
		add(cloudPanelDialog);
	}
	
	private void setTextToAllFields()
	{
		if (ListOfUsers.getI().size() != 0)
		{
			fieldCloudUrl.setText(ListOfUsers.getI().get(0).getCloudUrl());
			cloudVault.setSelectedItem(ListOfUsers.getI().get(0).getCloudItem());
			fieldLoginOrEmail.setText(ListOfUsers.getI().get(0).getLoginOrEmail());
			fieldPassword.setText(ListOfUsers.getI().get(0).getPassword());
		}
	}
	
	class FieldChangeListener implements DocumentListener 
	{
		@Override
		public void removeUpdate(DocumentEvent e)
		{
			setEnabledButton(fieldCloudUrl.getText(), /*cloudVault.getSelectedItem().toString(),*/ fieldLoginOrEmail.getText(), fieldPassword.getText());			
		}
		
		@Override
		public void insertUpdate(DocumentEvent e)
		{
			setEnabledButton(fieldCloudUrl.getText(), /*cloudVault.getSelectedItem().toString(),*/ fieldLoginOrEmail.getText(), fieldPassword.getText());	
		}
		
		@Override
		public void changedUpdate(DocumentEvent e)
		{
			setEnabledButton(fieldCloudUrl.getText(), /*cloudVault.getSelectedItem().toString(),*/ fieldLoginOrEmail.getText(), fieldPassword.getText());	
		}
		
		public void setEnabledButton(String fieldCloudUrl, /*String cloudItem,*/ String fieldLoginOrEmail, String fieldPassword)
		{
			String cloudItem = (String)cloudVault.getSelectedItem();
			if (!fieldCloudUrl.equals("") & !cloudItem.equals("") & !fieldLoginOrEmail.equals("") & !fieldPassword.equals(""))
			{
				btnOk.setEnabled(true);
			}
			else
			{
				btnOk.setEnabled(false);
			}
		}
	}
	
	class SaveChangesOfModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if (checkboxUser.getState() == true)
			{
				ListOfUsers.getI().add(new UserCloud(fieldCloudUrl.getText(), cloudVault.getSelectedItem().toString(), fieldLoginOrEmail.getText(), fieldPassword.getText()));
				dispose();
			}
			else
			{
				dispose();
			}
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
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
