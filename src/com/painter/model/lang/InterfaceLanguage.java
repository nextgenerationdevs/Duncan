package com.painter.model.lang;

import java.util.Map;

public interface InterfaceLanguage
{
	public Map<String, String> getDictionary();
	public void setDictionary(Map<String, String> map);
	
	public boolean getStatus();
	public void setStatus(boolean status);
	public String getName();
}
