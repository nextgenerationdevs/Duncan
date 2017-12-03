package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.painter.controller.EmptyDialog;
import com.painter.controller.PPanel;
import com.painter.controller.formats.ImportExportImpl;
import com.painter.controller.formats.SaveOpenLoad_JSON;
import com.painter.view.PTabbedPane;

public class ActionSaveFile implements ActionListener 
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
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter[] filters = new ImportExportImpl().getFilters();
		for (FileNameExtensionFilter filter : filters)
			fc.addChoosableFileFilter(filter);
		fc.setFileFilter(filters[0]);

		int result = fc.showSaveDialog(null);

		//if (result == JFileChooser.APPROVE_OPTION) 
		//{
		//	PPanel pp = panelList.get(tPane.getSelectedIndex());
		//	new ImportExportImpl().getFormat(fc.getFileFilter().getDescription(), pp).save(fc.getSelectedFile().getPath());				
		//}
	}	
}