package com.painter.view;

import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class PMenu extends JMenuBar
{
	private Data data;
	private PCommand cmd;

	public PMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
		Object[] obj = {createFileMenu(), createEditMenu(), createWindowMenu(), createOptionsMenu(), createHelpMenu()};
		for (int i = 0; i < obj.length; i++) 
		{
			add((JMenu) obj[i]);
		}
	}

	private JMenu createFileMenu()
	{
		JMenu file = new JMenu("actionFile");	
		file.setText(data.dictionary.getDictionary().get(file.getActionCommand()));

		String[] arrayStr = {"actionNew", "actionOpen", "actionOpenFromCloud", "actionLoad", "actionSave", "actionSaveToCloud", 
				"actionReload", "actionClose", "actionExit"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			file.add(item);
			if (i == 0 || i == 3 || i == 7) 
			{
				file.addSeparator();
			}
		}	
		return file;
	}

	private JMenu createEditMenu()
	{
		JMenu edit = new JMenu("actionEdit");
		edit.setText(data.dictionary.getDictionary().get(edit.getActionCommand()));

		String[] arrayStr = {"actionUndo", "actionRedo", "actionType", "actionColor", "actionThickness"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			edit.add(item);
			if (i == 1) 
			{
				edit.addSeparator();
			}
		}	
		return edit;
	}

	private JMenu createWindowMenu()
	{
		JMenu window = new JMenu("actionWindow");	
		window.setText(data.dictionary.getDictionary().get(window.getActionCommand()));

		String[] arrayStr = {"actionNextTab", "actionPrevTab", "actionTab"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			window.add(item);
			if (i == 1) 
			{
				window.addSeparator();
			}
		}		
		return window;
	}

	private JMenu createOptionsMenu()
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
				case "actionPlugins": item.addActionListener(cmd.actionPlugins); break;
//				case "actionSkins": item.addActionListener(cmd.actionSkins); break;
//				case "actionCloud": item.addActionListener(cmd.actionCloud); break;
			}
			options.add(item);
		}
		
		JMenu language = new JMenu("actionLanguage");
		language.setText(data.dictionary.getDictionary().get(language.getActionCommand()));

		JMenuItem english = new JMenuItem("actionEnglish");
		JMenuItem russian = new JMenuItem("actionRussian");
		JMenuItem ukrainian = new JMenuItem("actionUkrainian");
		JMenuItem addLanguage = new JMenuItem("actionAddLanguage");
		english.setText(data.dictionary.getDictionary().get(english.getActionCommand()));
		russian.setText(data.dictionary.getDictionary().get(russian.getActionCommand()));
		ukrainian.setText(data.dictionary.getDictionary().get(ukrainian.getActionCommand()));
		addLanguage.setText(data.dictionary.getDictionary().get(addLanguage.getActionCommand()));

		language.add(english);
		language.add(russian);
		language.add(ukrainian);
		language.addSeparator();
		language.add(addLanguage);
		options.add(language);

		return options;
	}
	/**
	 * actionPerformed(ActionEvent e)
	 * if (e.getActionCommand().equals("actionEnglish")
	 * 
	 * */
	private JMenu createHelpMenu()
	{
		JMenu help = new JMenu("actionHelp");	
		help.setText(data.dictionary.getDictionary().get(help.getActionCommand()));

		String[] arrayStr = {"actionHotKeys", "actionAbout"};
		for (int i = 0; i < arrayStr.length; i++)
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			switch (arrayStr[i]) 
			{
				case "actionHotKeys": item.addActionListener(cmd.actionHotKeys); break;
				case "actionAbout": item.addActionListener(cmd.actionAbout); break;
			}
			help.add(item);
		}		
		return help;
	}

	public void refreshMenu()
	{

	}
}