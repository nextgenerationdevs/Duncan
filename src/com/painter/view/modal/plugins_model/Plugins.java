package com.painter.view.modal.plugins_model;

import javax.swing.JPanel;

public class Plugins 
{
	private boolean status;
	private String name;
	private JPanel panel;
	
	public Plugins() {}
	
	public Plugins(boolean status, String name, JPanel panel)
	{
		this.status = status;
		this.name = name;
		this.panel = panel;
	}

	public boolean isStatus() 
	{
		return status;
	}

	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public Object getPanel() 
	{
		return panel;
	}

	public void setPanel(JPanel panel) 
	{
		this.panel = panel;
	}
}