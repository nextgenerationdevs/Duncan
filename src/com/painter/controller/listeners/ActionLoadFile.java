package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.painter.controller.EmptyDialog;
import com.painter.controller.PPanel;
import com.painter.controller.formats.SaveOpenLoad_JSON;
import com.painter.view.PTabbedPane;

public class ActionLoadFile implements ActionListener 
{
	PTabbedPane tPane;
	PPanel pp = null;
	
	public void setTPane(PTabbedPane tPane)
	{
		this.tPane = tPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JFileChooser dialog = new JFileChooser();
		dialog.setFileFilter(new FileNameExtensionFilter("*.json", "json"));
		int result = dialog.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			new SaveOpenLoad_JSON().open(dialog.getSelectedFile().getPath());
			pp.repaint();
		}
	}
}