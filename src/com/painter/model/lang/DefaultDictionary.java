package com.painter.model.lang;

import java.util.HashMap;
import java.util.Map;

public class DefaultDictionary implements InterfaceLanguage
{
	private static Map<String, String> dictionary;
	private boolean status;
	private static final String name = "English";
	
	@Override
	public Map<String, String> getDictionary()
	{
		if (dictionary == null)
			setDictionary();
		return dictionary;
	}
	
	private void setDictionary()
	{
		dictionary = new HashMap<String, String>();
		
		dictionary.put("actionFile", "File");
		dictionary.put("actionNew", "New");
		dictionary.put("actionOpen", "Open");
		dictionary.put("actionOpenFromCloud", "Open from Cloud");
		dictionary.put("actionLoad", "Load");
		dictionary.put("actionSave", "New");
		dictionary.put("actionSaveToCloud", "Save to Cloud");
		dictionary.put("actionReload", "Reload");
		dictionary.put("actionClose", "Close");
		dictionary.put("actionExit", "Exit");
		
		dictionary.put("actionEdit", "Edit");
		dictionary.put("actionUndo", "Undo");
		dictionary.put("actionRedo", "Redo");
		dictionary.put("actionType", "Type");
		dictionary.put("actionColor", "Color");
		dictionary.put("actionThickness", "Thickness");
		
		dictionary.put("actionWindow", "Window");
		dictionary.put("actionNextTab", "Next Tab");
		dictionary.put("actionPrevTab", "Prev Tab");
		dictionary.put("actionTab", "Tab");
			
		dictionary.put("actionOptions", "Options");
		dictionary.put("actionPlugins", "Plugins");
		dictionary.put("actionSkins", "Skins");
		dictionary.put("actionCloud", "Cloud");
		dictionary.put("actionLanguage", "Language");
		dictionary.put("actionAddLanguage", "Add language");
			
		dictionary.put("actionHelp", "Help");
		dictionary.put("actionHotKeys", "Hot Keys");
		dictionary.put("actionAbout", "About");
	}

	@Override
	public void setDictionary(Map<String, String> map)
	{
		dictionary = null;
		dictionary = map;
	}

	@Override
	public boolean getStatus() 
	{
		return status;
	}

	@Override
	public void setStatus(boolean status) 
	{
		this.status = status;
	}

	@Override
	public String getName() 
	{
		return name;
	}
}