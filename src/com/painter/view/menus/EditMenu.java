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
	
	public JMenuItem actionUndo;
	public JMenuItem actionRedo;

	public EditMenu(Data data, PCommand cmd)
	{
		this.data = data;
		this.cmd = cmd;
	}

	public JMenu createEditMenu()
	{
		JMenu edit = new JMenu(data.bundle.getString("actionEdit"));
		
		actionUndo = new JMenuItem(data.bundle.getString("actionUndo"));
		actionUndo.setIcon(new ImageIcon("resources/img/menubar/undo-icon.png"));
		actionUndo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		actionUndo.setActionCommand("actionUndo");
		actionUndo.setEnabled(false);
		actionUndo.addActionListener(cmd.actionUndoRedo);
		
		actionRedo = new JMenuItem(data.bundle.getString("actionRedo"));
		actionRedo.setIcon(new ImageIcon("resources/img/menubar/redo-icon.png"));
		actionRedo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		actionRedo.setActionCommand("actionRedo");
		actionRedo.setEnabled(false);
		actionRedo.addActionListener(cmd.actionUndoRedo);
		
		edit.add(actionUndo);
		edit.add(actionRedo);
		edit.addSeparator();

		String[] arrayStr = {"actionType", "actionColor", "actionThickness"};
		for (int i = 0; i < arrayStr.length; i++) 
		{
			JMenuItem item = new JMenuItem(data.bundle.getString(arrayStr[i]));
			switch (arrayStr[i])
			{
				case "actionType": 		item.setIcon(new ImageIcon("resources/img/menubar/typeOfFigure-icon.png"));
								   		item.setEnabled(false);
								   		/*item.addActionListener(cmd.actionSkins);*/ break;
								   		
				case "actionColor": 	item.setIcon(new ImageIcon("resources/img/menubar/colorChooser-icon.png"));
										item.addActionListener(cmd.actionColorChooser); break;
										
				case "actionThickness": item.setIcon(new ImageIcon("resources/img/menubar/thickness-icon.png"));
										item.addActionListener(cmd.actionThickness); break;
			}
			edit.add(item);
			if (i == 1) 
			{
				edit.addSeparator();
			}
		}
		return edit;
	}
}