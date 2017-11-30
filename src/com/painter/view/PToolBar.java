package com.painter.view;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

import com.painter.controller.PCommand;

public class PToolBar extends JToolBar
{
	private PCommand cmd;
	
	public JButton buttonPrevTab;
	public JButton buttonNextTab;
	
	public JButton buttonUndo;
	public JButton buttonRedo;
	
	public PToolBar(PCommand cmd)
	{
		this.cmd = cmd;
		
		String[] arrayStr = {"newFile", "openFile", "saveFile", "openFileFromCloud", "saveFileToCloud", "closeFile", "aboutApp", 
							 "defaultSettings"/*, "actionUndo", "actionRedo", "prevTab", "nextTab"*/};
		
		String[] arrayAct = {"actionNew", "actionOpen", "actionSave", "actionOpenFromCloud", "actionSaveToCloud", "actionClose"};
		
		for (int i = 0; i < arrayStr.length; i++)
		{
			JButton button = new JButton(new ImageIcon("resources/img/toolbar/" + arrayStr[i] + "-icon.png"));
			
			if (i < arrayAct.length)
				button.setActionCommand(arrayAct[i]);					//	ÊÎÑÒÛËÜ!!!
			
			switch (arrayStr[i]) 
			{
				case "newFile": button.addActionListener(cmd.actionTabbedPane/*cmd.actionNewFileStart*/); break;
				case "openFile": button.addActionListener(/*cmd.actionOpenFile*/cmd.actionTabbedPane); break;
				case "saveFile": button.addActionListener(cmd.actionSaveFile); break;
				case "openFileFromCloud": button.addActionListener(/*cmd.actionOpenFileFromCloud*/cmd.actionTabbedPane); break;
				case "saveFileToCloud": button.addActionListener(cmd.actionSaveFileToCloud); break;
				case "closeFile": button.addActionListener(/*cmd.actionCloseFile*/cmd.actionTabbedPane); break;
				case "aboutApp": button.addActionListener(cmd.actionAbout); break;
				case "defaultSettings": button.addActionListener(cmd.actionDefaultSettings); break;
				
//				case "actionUndo": button.setEnabled(false);
//					/*button.addActionListener(cmd.?);*/ break;
//				case "actionRedo": button.setEnabled(false);
//					/*button.addActionListener(cmd.?);*/ break;
//				case "prevTab": button.setActionCommand("actionPrevTab");
//					button.setEnabled(false);
//					button.addActionListener(cmd.actionTabbedPane); break;
//				case "nextTab": button.setActionCommand("actionNextTab");
//					button.setEnabled(false);
//					button.addActionListener(cmd.actionTabbedPane); break;
			}
			add(button);
			if (i == 0 || i == 2 || i == 4 || i == 6 || i == 7 || i == 9 /*|| i == 11*/) 
			{
				addSeparator();
			}	
		}
		
		buttonPrevTab = new JButton(new ImageIcon("resources/img/toolbar/" + "prevTab" + "-icon.png"));
		buttonPrevTab.setActionCommand("actionPrevTab");
		buttonPrevTab.setEnabled(false);
		buttonPrevTab.addActionListener(cmd.actionTabbedPane); 
		
		buttonNextTab = new JButton(new ImageIcon("resources/img/toolbar/" + "nextTab" + "-icon.png"));
		buttonNextTab.setActionCommand("actionNextTab");
		buttonNextTab.setEnabled(false);
		buttonNextTab.addActionListener(cmd.actionTabbedPane); 
		
		buttonUndo = new JButton(new ImageIcon("resources/img/toolbar/" + "actionUndo" + "-icon.png"));
		buttonPrevTab.setActionCommand("actionUndo");
		buttonPrevTab.setEnabled(false);
//		buttonPrevTab.addActionListener(cmd.actionUndoRedo);
		
		buttonRedo = new JButton(new ImageIcon("resources/img/toolbar/" + "actionRedo" + "-icon.png"));
		buttonPrevTab.setActionCommand("actionRedo");
		buttonPrevTab.setEnabled(false);
//		buttonPrevTab.addActionListener(cmd.actionUndoRedo);
		
		add(buttonUndo);
		add(buttonRedo);
		
		add(buttonPrevTab);
		add(buttonNextTab);
	}
}