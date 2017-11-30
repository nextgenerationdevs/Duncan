package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.model.lang.dictionaries.Dictionary_EN;
import com.painter.model.lang.dictionaries.Dictionary_RU;
import com.painter.model.lang.dictionaries.Dictionary_UKR;
import com.painter.view.PFrame;
import com.painter.view.modal.CloudDialog.FieldChangeListener;
import com.painter.view.modal.CloudDialog.SaveChangesOfModalWindow;

public class AddLanguageDialog extends JDialog
{
	private final static int widthOfPluginsDialog = 350;
	private final static int heightOfPluginsDialog = 200;
	
	Dictionary_RU bundleRu;
	Dictionary_UKR bundleUkr;
	
	Data data;
	PFrame frame;
	JPanel languageDialog;
	
	JLabel chooseLanguage;
	JComboBox<String> languageBox;
	
	JLabel addLanguage;
	JButton btnAdd;
	
	JLabel removeLanguage;
	JButton btnRemove;
	
	JButton btnOk;
	JButton btnApply;
	JButton btnCancel;
	
	String checkCommand = "";
	
	public AddLanguageDialog(Data data, PFrame frame) 
	{
		this.data = data;
		this.frame = frame;
		
		setTitle(data.bundle.getString("titleAddLanguageDialog"));
		
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfPluginsDialog) / 2, 
				 	 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfPluginsDialog) / 2);
		setSize(widthOfPluginsDialog, heightOfPluginsDialog);
		
		initializeLanguageDialog();

		setResizable(false);
		setModal(true);
		setVisible(true);
	}

	private void initializeLanguageDialog()
	{
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3, 10, 0));		
		btnOk = new JButton(data.bundle.getString("controllButtonOk"));
		btnOk.setEnabled(false);
		btnOk.addActionListener(new SaveChangesOfModalWindow());
		btnApply = new JButton(data.bundle.getString("controllButtonApply"));
		btnApply.setEnabled(false);
		btnApply.addActionListener(new ApplyChangesOfModalWindow()); 
		btnCancel = new JButton(data.bundle.getString("controllButtonCancel"));
		btnCancel.addActionListener(new CloseModalWindow()); 			
		controlPanel.add(btnOk);
		controlPanel.add(btnApply);
		controlPanel.add(btnCancel);
		add(controlPanel, BorderLayout.SOUTH);
		
		languageDialog = new JPanel();
		languageDialog.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(3, 2, 3, 2);
		chooseLanguage = new JLabel("Choose the Language: ");
		languageDialog.add(chooseLanguage, c);
		
		c.gridx = 1;
		Locale[] languageList = Locale.getAvailableLocales();
		languageBox = new JComboBox<String>();					
		for (Locale locale : languageList)
		{
			languageBox.addItem(locale.getDisplayLanguage());
		}

		languageBox.setSelectedIndex(0);
		languageBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				languageBox = (JComboBox<String>)e.getSource();
				languageBox.setSelectedItem(languageBox.getSelectedItem().toString());
	
				String language = (String)languageBox.getSelectedItem();
				if (!language.equals(""))
				{
					btnAdd.setEnabled(true);
					btnRemove.setEnabled(true);
				}
				else
				{
					btnAdd.setEnabled(false);
					btnRemove.setEnabled(false);
				}			
			}
		});	
		
		languageDialog.add(languageBox, c);
		
		c.gridx = 0;
		c.gridy++;		
		addLanguage = new JLabel("Add choosing language: ");
		languageDialog.add(addLanguage, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		btnAdd = new JButton(data.bundle.getString("controllButtonAdd"));
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener()
		{					
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String language = languageBox.getSelectedItem().toString();
				if (language.equals("английский"))
				{
					JOptionPane.showMessageDialog(null, "Это default язык: не удалить и не добавить!", "Вот так вот...", JOptionPane.ERROR_MESSAGE);
					languageBox.setSelectedIndex(0);
					return;
				}
				else if (language.equals("русский") || language.equals("украинский"))
				{
					for (InterfaceBundle bundle : LanguageFactory.bundles)
					{
						if (bundle.getSurname().toLowerCase().equals(language))
						{
							JOptionPane.showMessageDialog(null, "Сорян такой язык уже добавлен!", "Вот так вот...", JOptionPane.ERROR_MESSAGE);
							languageBox.setSelectedIndex(0);
							return;
						}
					}			
					checkCommand = e.getActionCommand();
					btnApply.setEnabled(true);
					languageBox.setEnabled(false);
					btnRemove.setEnabled(false);				
				}
				else
				{
					//String title = data.bundle.getString("warning_title");
					//String message = data.bundle.getString("nameOfTabbedPaneExist");
					JOptionPane.showMessageDialog(null, "Сорян такого языка в бандлах нет!", "Вот так вот...", JOptionPane.ERROR_MESSAGE); 
					return;
				}
			}
		});
		languageDialog.add(btnAdd, c);
		
		c.gridx = 0;
		c.gridy++;		
		removeLanguage = new JLabel("Remove choosing language: ");
		languageDialog.add(removeLanguage, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		btnRemove = new JButton(data.bundle.getString("controllButtonRemove"));
		btnRemove.setEnabled(false);
		btnRemove.addActionListener(new ActionListener()
		{			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String language = (String)languageBox.getSelectedItem();
				if (language.equals("английский"))
				{
					JOptionPane.showMessageDialog(null, "Это default язык: не удалить и не добавить!", "Вот так вот...", JOptionPane.ERROR_MESSAGE);
					languageBox.setSelectedIndex(0);
					return;
				}
				else if (language.equals("русский") || language.equals("украинский"))
				{
					for (InterfaceBundle bundle : LanguageFactory.bundles)
					{				
						if(bundle.getSurname().toLowerCase().equals(language))
						{
							System.out.println("зашёл в отработку");
							checkCommand = e.getActionCommand();
							languageBox.setEnabled(false);
							btnAdd.setEnabled(false);
							btnApply.setEnabled(true);
						}
					}			
				}
				else
				{
					System.out.println("зашёл в сорян");
					JOptionPane.showMessageDialog(null, "Сорян такой язык удалить невозможно!", "Вот так вот...", JOptionPane.ERROR_MESSAGE); 
					return;
				}
			}	
		});
		languageDialog.add(btnRemove, c);
		
		add(languageDialog);
	}

	class SaveChangesOfModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			String language = (String)languageBox.getSelectedItem();
			if (checkCommand.equals("Add"))
			{
				switch (language)
				{
					case "русский": bundleRu = new Dictionary_RU();
					LanguageFactory.addToBundles(bundleRu); 
					frame.menuBar.optionsMenu.setNameOfDictionaryItem();
					break;
					case "украинский": bundleUkr = new Dictionary_UKR();
					LanguageFactory.addToBundles(bundleUkr); 
					frame.menuBar.optionsMenu.setNameOfDictionaryItem();
					break;
				}
			}
			else if (checkCommand.equals("Remove"))
			{
				switch (language)
				{
					case "русский": LanguageFactory.removeFromBundles(bundleRu); 
					frame.menuBar.optionsMenu.setNameOfDictionaryItem();
					break;
					case "украинский": LanguageFactory.removeFromBundles(bundleUkr);
					frame.menuBar.optionsMenu.setNameOfDictionaryItem();
					break;
				}
			}			
			btnOk.setEnabled(false);
			btnApply.setEnabled(false);
			languageBox.setEnabled(true);
			languageBox.setSelectedIndex(0);
		}
	}
	
	class ApplyChangesOfModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			btnOk.setEnabled(true);
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