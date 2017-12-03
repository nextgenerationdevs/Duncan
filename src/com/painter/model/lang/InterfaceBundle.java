package com.painter.model.lang;

import java.util.ResourceBundle;

public interface InterfaceBundle
{
	public ResourceBundle returnBundle();
	public boolean getStatus();
	public void setStatus(boolean status);
	public String getName();
}