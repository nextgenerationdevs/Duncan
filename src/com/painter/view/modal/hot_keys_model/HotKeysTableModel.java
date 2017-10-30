package com.painter.view.modal.hot_keys_model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class HotKeysTableModel extends AbstractTableModel
{
	HotKeysImpl hotKeysImpl = new HotKeysImpl();
	public List<HotKeys> listOfHotKeys = new ArrayList<>();
	
	public HotKeysTableModel(HotKeysImpl hotKeysImpl)
	{
		this.hotKeysImpl = hotKeysImpl;
		listOfHotKeys = hotKeysImpl.read();
	}
    	
    @Override
    public int getRowCount() 
    {
        return listOfHotKeys.size();
    }
    
    @Override
    public int getColumnCount() 
    {
        return 2;
    }
    
    @Override
	public String getColumnName(int column) 
	{
		String[] name = {"Action","Hot_Key"};
		return name[column];
	}
    
    @Override
	public Object getValueAt(int row, int col)
	{
		HotKeys hotKeys = listOfHotKeys.get(row);
		Object ret = null;	
		switch (col)
		{
			case 0: ret = hotKeys.getAction(); break;
			case 1: ret = hotKeys.getKey(); break;
		}	
		return ret;
	}
    
    @Override
	public boolean isCellEditable(int rowIndex, int columnIndex) 
	{
		return true;
	}
}