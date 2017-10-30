package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
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
import com.painter.view.modal.plugins_model.PluginsImpl;
import com.painter.view.modal.plugins_model.PluginsTableModel;

public class PluginsDialog extends JDialog
{
	Data data;
	JTabbedPane jtp = new JTabbedPane();
	
	public PluginsDialog(Data data)
	{
		this.data = data;
		setTitle("Plugins Management");
		
		PPanel pp = new PPanel(data);
		int width = 400;
		int height = 400;
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 2;
		int y =  pp.getToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		setModal(true);
		setResizable(false);
		
//		PluginsImpl pluginsImpl = new PluginsImpl();
//		JTable installedPanel = new JTable(new PluginsTableModel(pluginsImpl));
//		installedPanel.setRowHeight(120);
		
		JPanel installedPanel = new JPanel();
		JPanel searchPanel = new JPanel();
		
		installedPanel.setLayout(new BoxLayout(installedPanel, BoxLayout.Y_AXIS));
		getContentPane().add(installedPanel);
		
		JLabel figureLabel1 = new JLabel("Rectangle: ");
		
		JPanel rectangle = new JPanel();
		rectangle.setBorder(new EtchedBorder(10, Color.BLACK, null));
		rectangle.setBackground(Color.WHITE);
		
		JButton buttonUninstall1 = new JButton("Uninstall");
		
		JCheckBox checkBox1 = new JCheckBox("Installed", true);
		
		JLabel figureLabel2 = new JLabel("Rectangle with text: ");
		
		JPanel rectangleText = new JPanel();
		rectangleText.setBorder(new EtchedBorder(10, Color.BLACK, null));
		rectangleText.setBackground(Color.WHITE);
		JLabel labelText = new JLabel("Text");	
		rectangleText.add(labelText, BorderLayout.CENTER);
		
		JButton buttonUninstall2 = new JButton("Uninstall");
		
		JCheckBox checkBox2 = new JCheckBox("Installed", true);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		JPanel panelForm1 = new JPanel(gridBagLayout);
		
		GridBagConstraints c = new GridBagConstraints();
		c.weightx = 1.0;
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.CENTER;
		c.gridheight = 2;
		c.insets = new Insets(5, 5, 5, 0);
		
		panelForm1.add(figureLabel1, c);
	
		c.gridx = 1;
		c.gridy = 0;
		c.ipadx = 80;
		c.ipady = 80;
		
		panelForm1.add(rectangle, c);
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		c.ipadx = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(5, 5, 0, 5);

		panelForm1.add(checkBox1, c);
		
		c.gridx = 2;
		c.gridy = 1;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(0, 5, 5, 5);
		
		panelForm1.add(buttonUninstall1, c);
			
		JPanel panelForm2 = new JPanel(gridBagLayout);
		
		c.weightx = 0.2;
		c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		c.gridheight = 2;
		c.insets = new Insets(5, 5, 5, 0);
		
		panelForm2.add(figureLabel2, c);
		
		c.weightx = 1;
		c.gridx = 1;
		c.gridy = 2;
		c.ipadx = 60;
		c.ipady = 60;
		
		panelForm2.add(rectangleText, c);

		c.gridx = 2;
		c.gridy = 2;
		c.ipadx = 0;
		c.ipady = 0;
		c.anchor = GridBagConstraints.PAGE_END;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.insets = new Insets(5, 5, 0, 5);

		panelForm2.add(checkBox2, c);
		
		c.gridx = 2;
		c.gridy = 3;
		c.anchor = GridBagConstraints.PAGE_END;
		c.insets = new Insets(0, 5, 5, 5);
		
		panelForm2.add(buttonUninstall2, c);
		
		JPanel lineSeparator = new JPanel();
		lineSeparator.setBackground(Color.GRAY);
		
		installedPanel.add(panelForm1);
		installedPanel.add(lineSeparator);
		installedPanel.add(panelForm2);
		
		JScrollPane scrollPaneInstalled = new JScrollPane(installedPanel,
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED,  
				   ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);		
		JScrollPane scrollPaneSearch = new JScrollPane(searchPanel,
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