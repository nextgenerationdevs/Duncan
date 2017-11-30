package com.painter.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu.Separator;
import javax.swing.KeyStroke;

import com.painter.controller.PCommand;
import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;

public class OptionsMenu extends JMenu
{
	private Data data;
	private PCommand cmd;

	JMenu options;
	JMenu language;

	public OptionsMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}

	public JMenu createOptionsMenu()
	{
		options = new JMenu(data.bundle.getString("actionOptions"));

		String[] arrayStr = {"actionPlugins", "actionSkins", "actionCloud", };
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(data.bundle.getString(arrayStr[i]));	
			switch (arrayStr[i]) 
			{
				case "actionPlugins": item.setIcon(new ImageIcon("resources/img/menubar/plugins-icon.png"));
				item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
				item.addActionListener(cmd.actionPlugins); break;
				case "actionSkins": item.setIcon(new ImageIcon("resources/img/menubar/skins-icon.png"));
				item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
				item.addActionListener(cmd.actionSkins); break;
				case "actionCloud": item.setIcon(new ImageIcon("resources/img/menubar/cloud-icon.png"));
				item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
				item.addActionListener(cmd.actionCloud); break;
			}
			options.add(item);
		}	
		language = new JMenu(data.bundle.getString("actionLanguage"));

		setNameOfDictionaryItem();
		
		return options;
	}

	public void setNameOfDictionaryItem()
	{	
		language.removeAll();
		
		for (InterfaceBundle lang : LanguageFactory.bundles)
		{
			JMenuItem item = new JMenuItem(lang.getName());
			item.addActionListener(cmd.actionSetLanguage);
			language.add(item);
		}	

		JMenuItem addLanguage = new JMenuItem(data.bundle.getString("actionAddLanguage"));
		addLanguage.addActionListener(cmd.actionAddLanguage);

		language.addSeparator();
		language.add(addLanguage);		

		options.add(language);
		
		language.invalidate();
		language.repaint();	
	}
}