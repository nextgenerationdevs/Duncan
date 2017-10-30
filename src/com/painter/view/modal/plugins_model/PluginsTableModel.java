package com.painter.view.modal.plugins_model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

public class PluginsTableModel extends AbstractTableModel
{
	PluginsImpl pluginsImpl = new PluginsImpl();
	public List<Plugins> listOfPlugins = new ArrayList<>();
	
	public PluginsTableModel(PluginsImpl pluginsImpl)
	{
		this.pluginsImpl = pluginsImpl;
		listOfPlugins = pluginsImpl.read();
	}
    	
    @Override
    public int getRowCount() 
    {
        return listOfPlugins.size();
    }
    
    @Override
    public int getColumnCount() 
    {
        return 4;
    }
    
    @Override
	public String getColumnName(int column) 
	{
		String[] name = {"Status", "Name", "Plugin", "Action"};
		return name[column];
	}
    
    @Override
	public Object getValueAt(int row, int col)
	{
		Plugins plugins = listOfPlugins.get(row);
		Object ret = null;	
		switch (col)
		{
			case 0: if (plugins.isStatus() == true) 	
						ret = new JCheckBox("", true);
					else
						ret = new JCheckBox("", false);
					break;
			case 1: ret = plugins.getName(); break;
			case 2: ret = plugins.getPanel(); break;
			case 3: if (plugins.isStatus() == true) 
						ret = new JButton("Uninstall");
					else
						ret = new JButton("Install");
					break;
		}	
		return ret;
	}
    
    @Override
	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{
		return true;
	}
}