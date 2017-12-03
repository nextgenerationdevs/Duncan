package com.painter.model.lang.dictionaries;

import java.util.ListResourceBundle;
import java.util.ResourceBundle;

import com.painter.model.lang.InterfaceBundle;

public class Dictionary_EN extends ListResourceBundle implements InterfaceBundle
{
	private boolean status;
	public static final String resourceBundle = "com.painter.model.lang.dictionaries.Dictionary_EN";
	private static final String name = "English";
	private static final String surname = "английский";
	
	private static final Object[][] content = 
	{
	//Dialogs, Titles:
	{"titleAddLanguageDialog", "ADD LANGUAGE"}, 
	//Dialogs, ControllButtons:
	{"controllButtonOk", "OK"}, {"controllButtonApply", "Apply"}, {"controllButtonCancel", "Cancel"},
	{"controllButtonAdd", "Add"}, {"controllButtonRemove", "Remove"},
	//JOptionPane, Buttons:
	{"actionOptionPaneCancel", "Cancel"}, {"actionOptionPaneOk", "OK"}, {"actionOptionPaneNo", "NO"}, {"actionOptionPaneYes", "YES"},
	//PFrame, SetTitle:
	{"actionFrameTitle", "Duncan"},
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
	{"actionHelp", "Help"}, {"actionHotKeys", "Hot Keys"}, {"actionAbout", "About"},
	//Warning messages		
	{"warning_title", "Warning Message"},
	{"nameOfTabbedPaneExist", "A tab with this name already exists!\nPlease change the tab name!"},
	{"areYouSureForSession", "You will lost your session without save!\nPressed OK, if you sure about it!"},
	//Repaint frame message		
	{"confirm_title", "Warning Message"},
	{"actionSessionClosed", "Current session will be closed!\nPressed OK if you want to save your session!"}
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
	public String getSurname()
	{
		return surname;
	}

	@Override
	public ResourceBundle returnBundle()
	{
		return ResourceBundle.getBundle(resourceBundle);
	}
}