package com.painter.model.lang.dictionaries;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

import com.painter.model.lang.InterfaceBundle;

public class Dictionary_EN extends ListResourceBundle implements InterfaceBundle
{
	private boolean status;
	public static final String resourceBundle = "com.painter.model.lang.dictionaries.Dictionary_EN";
	private static final String name = "English";
	
	private static final Object[][] content = 
	{
	//MenuBar, Menu_File:
	{"actionFile", "File"}, {"actionNew", "New"}, {"actionOpen", "Open"}, {"actionOpenFromCloud", "Open from Cloud"}, {"actionLoad", "Load"},
	{"actionSave", "Save"}, {"actionSaveToCloud", "Save to Cloud"}, {"actionReload", "Reload"}, {"actionClose", "Close"}, {"actionExit", "Exit"},
	//MenuBar, Menu_Edit:		
	{"actionEdit", "Edit"}, {"actionUndo", "Undo"}, {"actionRedo", "Redo"}, {"actionType", "Type"}, {"actionColor", "Color"}, {"actionThickness", "Thickness"},
	//MenuBar, Menu_Window:
	{"actionWindow", "Window"}, {"actionNextTab", "Next Tab"}, {"actionPrevTab", "Prev Tab"}, {"actionTab", "Tab"},
	//MenuBar, Menu_Options:		
	{"actionOptions", "Options"}, {"actionPlugins", "Plugins"}, {"actionSkins", "Skins"}, {"actionCloud", "Cloud"}, {"actionLanguage", "Language"},
	{"actionAddLanguage", "Add language"},
	//MenuBar, Menu_Help:		
	{"actionHelp", "Help"}, {"actionHotKeys", "Hot Keys"}, {"actionAbout", "About"}
	};
	
	@Override
	protected Object[][] getContents()
	{
		return content;
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

	@Override
	public ResourceBundle returnBundle()
	{
		Locale.setDefault(Locale.ENGLISH);
		return ResourceBundle.getBundle(resourceBundle);
	}
}