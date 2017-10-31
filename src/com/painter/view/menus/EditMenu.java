package com.painter.view.menus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class EditMenu extends JMenu
{
	private Data data;
	private PCommand cmd;

	public EditMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}

	public JMenu createEditMenu()
	{
		JMenu edit = new JMenu("actionEdit");
		edit.setText(data.dictionary.getDictionary().get(edit.getActionCommand()));

		String[] arrayStr = {"actionUndo", "actionRedo", "actionType", "actionColor", "actionThickness"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(arrayStr[i]);
			item.setText(data.dictionary.getDictionary().get(item.getActionCommand()));
			edit.add(item);
			switch (arrayStr[i]) 
			{
			case "actionUndo": item.setIcon(new ImageIcon("resources/img/menubar/arrow-undo-icon.png"));
							   item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
							   /*item.addActionListener(cmd.actionPlugins);*/ break;
			case "actionRedo": item.setIcon(new ImageIcon("resources/img/menubar/arrow-redo-icon.png"));
							   item.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
							   /*item.addActionListener(cmd.actionPlugins);*/ break;
			case "actionType": item.setIcon(new ImageIcon("resources/img/menubar/typeOfFigure-icon.png"));
							   item.setEnabled(false);
							   /*item.addActionListener(cmd.actionSkins);*/ break;
			case "actionColor": item.setIcon(new ImageIcon("resources/img/menubar/colorChooser-icon.png"));
								item.addActionListener(cmd.actionColorChooser); break;
			case "actionThickness": item.setIcon(new ImageIcon("resources/img/menubar/thickness-icon.png"));
									item.addActionListener(cmd.actionThickness); break;
			}
			if (i == 1) 
			{
				edit.addSeparator();
			}
		}	
		return edit;
	}
}