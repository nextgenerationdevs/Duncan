package com.painter.view.modal.hot_keys_model;

public class HotKeys 
{
	private String action;
	private String key;
	
	public HotKeys() {}
	
	public HotKeys(String action, String key)
	{
		this.action = action;
		this.key = key;
	}
	
	public String getAction() 
	{
		return action;
	}
	
	public void setAction(String action) 
	{
		this.action = action;
	}
	
	public String getKey() 
	{
		return key;
	}
	
	public void setKey(String key) 
	{
		this.key = key;
	}	
}