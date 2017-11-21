package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableCellRenderer;

import static javax.swing.GroupLayout.Alignment.*; 
import com.painter.controller.PPanel;
import com.painter.model.Data;
import com.painter.view.modal.hot_keys_model.HotKeysImpl;
import com.painter.view.modal.hot_keys_model.HotKeysTableModel;

public class PluginsDialog extends JDialog
{
	private final static int widthOfPluginsDialog = 350;
	private final static int heightOfPluginsDialog = 400;
	
	Data data;
	JTabbedPane jtp = new JTabbedPane();
	
	JPanel installedPanel;
	JPanel searchPanel;
	
	public PluginsDialog(Data data)
	{
		this.data = data;
		
		setTitle("Plugins Management");

		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfPluginsDialog) / 2, 
					 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfPluginsDialog) / 2);
		setSize(widthOfPluginsDialog, heightOfPluginsDialog);
		
		initializeInstalledPanel();
		initializeSearchPanel();
				
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
		
		add(jtp);
		add(controlPanel, BorderLayout.SOUTH);
		
		setModal(true);
		setResizable(true);
		setVisible(true);
	}

	private void initializeInstalledPanel()
	{
		installedPanel = new JPanel();
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		JPanel panelForm1 = new JPanel(gridBagLayout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 0, 20);		
		JLabel labelDefaultFigures = new JLabel("Default Figures: ");
		panelForm1.add(labelDefaultFigures, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		JPanel panelDefault = new JPanel();
		panelDefault.setBorder(new EtchedBorder(10, Color.BLACK, null));
		panelDefault.setBackground(Color.WHITE);
		JButton button1 = new JButton();
		ImageIcon iconDefault = new ImageIcon("resources/img/other/default-icon.png");
		button1.setIcon(iconDefault);
		panelDefault.add(button1, BorderLayout.CENTER);
		panelForm1.add(panelDefault, c);
		
		c.gridx = 2;
		c.ipadx = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(0, 0, 0, 0);	
		JButton btnUninstall1 = new JButton("Uninstall");
		btnUninstall1.setEnabled(false);
		panelForm1.add(btnUninstall1, c);
		
		c.gridx = 0;
		c.gridy++;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(20, 0, 0, 20);
		JLabel labelFigureText = new JLabel("Figures with Text: ");
		panelForm1.add(labelFigureText, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		JPanel panelText = new JPanel();
		panelText.setBorder(new EtchedBorder(10, Color.BLACK, null));
		panelText.setBackground(Color.WHITE);
		JButton button2 = new JButton();
		ImageIcon iconText = new ImageIcon("resources/img/other/text-icon.png");
		button2.setIcon(iconText);
		panelText.add(button2, BorderLayout.CENTER);
		panelForm1.add(panelText, c);
		
		c.gridx = 2;
		c.anchor = GridBagConstraints.LINE_END;
		c.insets = new Insets(20, 0, 0, 0);
		JButton btnUninstall2 = new JButton("Uninstall");
		panelForm1.add(btnUninstall2, c);
			
		installedPanel.add(panelForm1);
		
		JScrollPane scrollPaneInstalled = new JScrollPane(installedPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		jtp.addTab("Installed", scrollPaneInstalled);
	}

	private void initializeSearchPanel()
	{
		searchPanel = new JPanel();
		searchPanel.setLayout(new GridBagLayout());
		GridBagConstraints main = new GridBagConstraints();
		main.gridx = 0;
		main.gridy = 0;
		main.anchor = GridBagConstraints.FIRST_LINE_START;
		main.insets = new Insets(10, 5, 10, 5);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		JPanel panelForm3 = new JPanel(gridBagLayout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(0, 0, 0, 5);		
		JLabel labelPathUrl = new JLabel("Path/URL: ");
		panelForm3.add(labelPathUrl, c);
		
		c.gridx = 1;
		JTextField fieldPathUrl = new JTextField("http://mycompany.com/painter/plugins", 15);
		panelForm3.add(fieldPathUrl, c);
		
		c.gridx = 2;
		c.insets = new Insets(0, 0, 0, 0);
		JButton button1 = new JButton();
        ImageIcon iconPathUrl = new ImageIcon("resources/img/other/folder-icon.png");
        button1.setIcon(iconPathUrl);
		panelForm3.add(button1, c);
		
		c.gridy++;
		c.gridx = 0;
		c.insets = new Insets(5, 0, 0, 5);
		JLabel labelSearch = new JLabel("Search: ");
		panelForm3.add(labelSearch, c);
		
		c.gridx = 1;
		JTextField fieldSearch = new JTextField("Picture", 15);
		panelForm3.add(fieldSearch, c);
		
		c.gridx = 2;
		c.insets = new Insets(5, 0, 0, 0);
		JButton button2 = new JButton();
        ImageIcon iconSearch = new ImageIcon("resources/img/other/search-icon.png");
        button2.setIcon(iconSearch);
		panelForm3.add(button2, c);
		
		GridBagLayout gridBagLayout2 = new GridBagLayout();
		JPanel panelForm4 = new JPanel(gridBagLayout2);
		
		GridBagConstraints c2 = new GridBagConstraints();
		c2.gridx = 0;
		c2.gridy = 0;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(0, 0, 0, 20);	
		JLabel labelFigurePicture = new JLabel("Figures with Picture: ");
		panelForm4.add(labelFigurePicture, c2);
		
		c2.gridx = 1;
		c2.anchor = GridBagConstraints.CENTER;
		JPanel panelPicture = new JPanel();
		panelPicture.setBorder(new EtchedBorder(10, Color.BLACK, null));
		panelPicture.setBackground(Color.WHITE);
		JButton button3 = new JButton();
		ImageIcon iconPicture = new ImageIcon("resources/img/other/picture-icon.png");
		button3.setIcon(iconPicture);
		panelPicture.add(button3, BorderLayout.CENTER);
		panelForm4.add(panelPicture, c2);
		
		c2.gridx = 2;
		c2.anchor = GridBagConstraints.LINE_END;
		c2.insets = new Insets(0, 0, 0, 0);
		JButton buttonInstall1 = new JButton("Install");	
		buttonInstall1.setToolTipText("This is Plugin which adds type of figures with pictures inside...");
		panelForm4.add(buttonInstall1, c2);
		
		c2.gridx = 0;
		c2.gridy++;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(20, 0, 0, 20);
		JLabel labelFigureVideo = new JLabel("Figures with Video: ");
		panelForm4.add(labelFigureVideo, c2);
		
		c2.gridx = 1;
		c2.anchor = GridBagConstraints.CENTER;
		JPanel panelVideo = new JPanel();
		panelVideo.setBorder(new EtchedBorder(10, Color.BLACK, null));
		panelVideo.setBackground(Color.WHITE);
		JButton button4 = new JButton();
		ImageIcon iconVideo = new ImageIcon("resources/img/other/video-icon.png");
		button4.setIcon(iconVideo);
		panelVideo.add(button4, BorderLayout.CENTER);
		panelForm4.add(panelVideo, c2);
		
		c2.gridx = 2;
		c2.anchor = GridBagConstraints.LINE_END;
		c2.insets = new Insets(20, 0, 0, 0);
		JButton buttonInstall2 = new JButton("Install");	
		buttonInstall2.setToolTipText("This is Plugin which adds type of figures with video inside...");
		panelForm4.add(buttonInstall2, c2);
		
		c2.gridx = 0;
		c2.gridy++;
		c2.anchor = GridBagConstraints.LINE_START;
		c2.insets = new Insets(20, 0, 0, 20);
		JLabel labelFigureText = new JLabel("Figures with Text: ");
		panelForm4.add(labelFigureText, c2);
		
		c2.gridx = 1;
		c2.anchor = GridBagConstraints.CENTER;
		JPanel panelText = new JPanel();
		panelText.setBorder(new EtchedBorder(10, Color.BLACK, null));
		panelText.setBackground(Color.WHITE);
		JButton button5 = new JButton();
		ImageIcon iconText = new ImageIcon("resources/img/other/text-icon.png");
		button5.setIcon(iconText);
		panelText.add(button5, BorderLayout.CENTER);
		panelForm4.add(panelText, c2);
		
		c2.gridx = 2;
		c2.anchor = GridBagConstraints.LINE_END;
		c2.insets = new Insets(20, 0, 0, 0);
		JButton buttonInstall3 = new JButton("Install");	
		buttonInstall3.setToolTipText("This is Plugin which adds type of figures with text inside...");
		panelForm4.add(buttonInstall3, c2);

		searchPanel.add(panelForm3, main);
		main.gridy++;
		searchPanel.add(panelForm4, main);
		
		JScrollPane scrollPaneSearch = new JScrollPane(searchPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);	
		jtp.addTab("Search", scrollPaneSearch);
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