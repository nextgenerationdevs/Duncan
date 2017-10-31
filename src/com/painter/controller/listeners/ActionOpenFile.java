package com.painter.controller.listeners;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.painter.controller.EmptyDialog;
import com.painter.controller.PCommand;
import com.painter.controller.PPanel;
import com.painter.controller.formats.ImportExportImpl;
import com.painter.controller.formats.SaveOpenLoad_JSON;
import com.painter.view.PTabbedPane;

public class ActionOpenFile implements ActionListener 
{
	PTabbedPane tPane;
	
	public void setTPane(PTabbedPane tPane)
	{
		this.tPane = tPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter[] filters = new ImportExportImpl().getFilters();			
		for (FileNameExtensionFilter filter : filters)
			fc.addChoosableFileFilter(filter);
		fc.setFileFilter(filters[0]);
		
		int result = fc.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			PPanel pp = null;
//			if (!tPane.isEmpty())
//				pp = panelList.get(tPane.getSelectedIndex());
//			else
//			{
//				panelList.add(new PPanel(cmd, data, statusBar));
//				tPane.addTab("New Tab", panelList.get(0));
//				pp = panelList.get(0);
//			}
			pp.setBackground(Color.WHITE);
			new ImportExportImpl().getFormat(fc.getFileFilter().getDescription(), pp).load(fc.getSelectedFile().getPath());
			pp.repaint();
		}
	}		
}