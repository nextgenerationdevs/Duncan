package com.painter.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class OptionsMenu extends JMenu
{
	private Data data;
	private PCommand cmd;

	public OptionsMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}
	
	public JMenu createOptionsMenu()
	{
		JMenu options = new JMenu("actionOptions");
		options.setText(data.dictionary.getDictionary().get(options.getActionCommand()));

		String[] arrayStr = {"actionPlugins", "actionSkins", "actionCloud", };
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));		
			switch (arrayStr[i]) 
			{
				case "actionPlugins": item.setIcon(new ImageIcon("resources/img/menubar/plugins-icon.png"));
				   					  item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
				   					  item.addActionListener(cmd.actionPlugins); break;
				case "actionSkins": item.setIcon(new ImageIcon("resources/img/menubar/skins-icon.png"));
									item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
									/*item.addActionListener(cmd.actionPlugins);*/ break;
				case "actionCloud": item.setIcon(new ImageIcon("resources/img/menubar/cloud-icon.png"));
									item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK | ActionEvent.SHIFT_MASK));
									/*item.addActionListener(cmd.actionPlugins);*/ break;
			}
			options.add(item);
		}
		
		JMenu language = new JMenu("actionLanguage");
		language.setText(data.dictionary.getDictionary().get(language.getActionCommand()));
		
		JMenuItem english = new JMenuItem("English");				//	’ардкод, посмотреть, как безболезненно выт€нуть из DefaultDictionary
		
		JMenuItem addLanguage = new JMenuItem("actionAddLanguage");
		addLanguage.setText(data.dictionary.getDictionary().get(addLanguage.getActionCommand()));
//		for (InterfaceLanguage lang : LanguageFactory.languages)
//		{
//			language.add(new JMenuItem(lang.getName()));
//		}
		language.add(english);
		language.addSeparator();
		language.add(addLanguage);
		options.add(language);

		return options;
	}
}
