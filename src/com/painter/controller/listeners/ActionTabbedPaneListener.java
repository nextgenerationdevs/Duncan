package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.painter.controller.EmptyDialog;
import com.painter.controller.PCommand;
import com.painter.controller.formats.ImportExportImpl;
import com.painter.controller.formats.SaveOpenLoad_JSON;
import com.painter.model.Data;
import com.painter.view.PTabbedPane;
import com.painter.view.modal.CreateNewFileDialog;

public class ActionTabbedPaneListener implements ActionListener
{
	PTabbedPane tPane;
	PCommand cmd;
	Data data;
	int nameCounter;
	
	public ActionTabbedPaneListener(PCommand cmd, Data data)
	{
		this.cmd = cmd;
		this.data = data;
	}
	
	public void setTPane(PTabbedPane tPane)
	{
		this.tPane = tPane;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String action = ae.getActionCommand();
		switch(action)
		{
			case "actionNew":
				createTab();
				break;
			case "actionOpen":
				openTab();
				break;
			case "actionOpenFromCloud":
				openFromCloudTab();
				break;
			case "actionLoad":
				loadTab();
				break;
			case "actionReload":
				reloadTab();
				break;
			case "actionClose":
				closeTab();
				break;
			case "actionNextTab":
				selectNextTab();
				break;
			case "actionPrevTab":
				selectPreviousTab();
				break;				
		default:
			if (action.length() > 0)
				selectTab(action);
			break;
		}
	}

	private void selectTab(String action)
	{
		tPane.selectTab(action);		
	}

	private void selectPreviousTab()
	{
		tPane.prevTab();		
	}

	private void selectNextTab()
	{
		tPane.nextTab();
	}

	private void closeTab()
	{
		String str = cmd.getData().names.get(tPane.getSelectedIndex());
		if(str.compareTo("Untitled" + ""+nameCounter) == 0)
		{
			nameCounter--;
		}
		tPane.closeTab();
		addWindow();
	}

	private void reloadTab()
	{
		// TODO Auto-generated method stub		
	}

	private void loadTab()
	{
		JFileChooser dialog = new JFileChooser();
		dialog.setFileFilter(new FileNameExtensionFilter("*.json", "json"));
		int result = dialog.showOpenDialog(null);
		
		if (result == JFileChooser.APPROVE_OPTION) 
		{
			new SaveOpenLoad_JSON().open(dialog.getSelectedFile().getPath());
//			pp.repaint();												//	¿√¿, Ÿ¿««««!!
		}
		addWindow();
	}

	private void openFromCloudTab()
	{
		new EmptyDialog(getClass().toString());
		tPane.addNewTab("Untitled");
		addWindow();
	}

	private void openTab()
	{
		JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter[] filters = new ImportExportImpl().getFilters();			
		for (FileNameExtensionFilter filter : filters)
		{
			fc.addChoosableFileFilter(filter);
		}	
		fc.setFileFilter(filters[0]);
		int result = fc.showOpenDialog(null);
//		if (result == JFileChooser.APPROVE_OPTION) 
//		{
//			PPanel pp = null;
//			if (!tPane.isEmpty())
//				pp = panelList.get(tPane.getSelectedIndex());
//			else
//			{
//				panelList.add(new PPanel(cmd, data, statusBar));
//				tPane.addTab("New Tab", panelList.get(0));
//				pp = panelList.get(0);
//			}
//			pp.setBackground(Color.WHITE);
//			new ImportExportImpl().getFormat(fc.getFileFilter().getDescription(), pp).load(fc.getSelectedFile().getPath());
//			pp.repaint();
//		}
		addWindow();
	}

	private void createTab()
	{
		CreateNewFileDialog createNewFileDialog = new CreateNewFileDialog();
		String fileName = createNewFileDialog.returnFileName();
		
		if (createNewFileDialog.status_WINDOW == 0)
		{
			if (fileName.equals("Untitled"))
			{
				tPane.addNewTab(fileName + ++nameCounter);
			}
			else
			{
				for (int i = 0; i < cmd.getData().names.size(); i++)
				{
					if ((cmd.getData().names.get(i)).equals(fileName))
					{
						String title = data.bundle.getString("warning_title");
						String message = data.bundle.getString("nameOfTabbedPaneExist");
						JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE); return;
					}
				}
				tPane.addNewTab(fileName); 
			}
			addWindow();			
		}			
	}
	
	private void addWindow()
	{
		cmd.actionReloadWindows.actionPerformed(new ActionEvent(this, 0, "updateWindowMenu"));		
	}
}