package com.painter.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class PToolBar extends JToolBar
{
	private PCommand cmd;

	public PToolBar(PCommand cmd)
	{
		this.cmd = cmd;
		
		String[] arrayStr = {"newFile", "openFile", "saveFile", "openFileFromCloud", "saveFileToCloud", "closeFile", "aboutApp", 
							 "defaultSettings", "actionUndo", "actionRedo", "prevTab", "nextTab"};
		for (int i = 0; i < arrayStr.length; i++)
		{
			JButton button = new JButton(new ImageIcon("resources/img/toolbar/" + arrayStr[i] + "-icon.png"));
			switch (arrayStr[i]) 
			{
				case "newFile": button.addActionListener(cmd.actionNewFile); break;
				case "openFile": button.addActionListener(cmd.actionOpenFile); break;
				case "saveFile": button.addActionListener(cmd.actionSaveFile); break;
				case "openFileFromCloud": button.addActionListener(cmd.actionOpenFileFromCloud); break;
				case "saveFileToCloud": button.addActionListener(cmd.actionSaveFileToCloud); break;
				case "closeFile": button.addActionListener(cmd.actionCloseFile); break;
				case "aboutApp": button.addActionListener(cmd.actionAbout); break;
				case "defaultSettings": button.addActionListener(cmd.actionDefaultSettings); break;
				case "actionUndo": button.setEnabled(false);
					/*button.addActionListener(cmd.?);*/ break;
				case "actionRedo": button.setEnabled(false);
					/*button.addActionListener(cmd.?);*/ break;
				case "prevTab": button.setEnabled(false);
					/*button.addActionListener(cmd.?);*/ break;
				case "nextTab": button.setEnabled(false);
					/*button.addActionListener(cmd.?);*/ break;
			}
			add(button);
			if (i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 || i == 11) 
			{
				addSeparator();
			}	
		}
	}
}