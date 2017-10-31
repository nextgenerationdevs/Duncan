package com.painter.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import com.painter.controller.PCommand;
import com.painter.controller.PPanel;

public class PTabbedPane extends JTabbedPane
{
	PCommand cmd;
	List<String> names;
	
	public PTabbedPane(PCommand cmd) 
	{
		this.cmd = cmd;
		cmd.actionNewFile.setTPane(this);
		cmd.actionOpenFile.setTPane(this);
		cmd.actionCloseFile.setTPane(this);
		cmd.actionOpenFileFromCloud.setTPane(this);
		cmd.mousePaint.setData(cmd.getData());
		names = new ArrayList<>();
	}
	
	public void addTab(String name)
	{
		PPanel pPanel = new PPanel(cmd.getData());		
		pPanel.addMouseListener(cmd.mousePaint);		
		pPanel.addMouseMotionListener(cmd.mousePaint);
		JScrollPane scrollPane = new JScrollPane(pPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addTab(name, scrollPane);
		names.add(name);
	}
	
	public PPanel returnCurrentTab()
	{
		return (PPanel)((JScrollPane) getSelectedComponent()).getComponent(0);
	}
	
	public String returnCurrentFileName()
	{
		return names.get(getSelectedIndex());
	}
	
	public void closeTab()
	{
		names.remove(getSelectedIndex());
		removeTabAt(getSelectedIndex());
	}
}
