package com.painter.controller;

import java.awt.event.ActionListener;

import com.painter.controller.listeners.ActionAbout;
import com.painter.controller.listeners.ActionAddLanguage;
import com.painter.controller.listeners.ActionCloseFile;
import com.painter.controller.listeners.ActionColorChooser;
import com.painter.controller.listeners.ActionDefaultSettings;
import com.painter.controller.listeners.ActionExit;
import com.painter.controller.listeners.ActionHotKeys;
import com.painter.controller.listeners.ActionLoadFile;
import com.painter.controller.listeners.ActionNewFile;
import com.painter.controller.listeners.ActionOpenFile;
import com.painter.controller.listeners.ActionOpenFileFromCloud;
import com.painter.controller.listeners.ActionPlugins;
import com.painter.controller.listeners.ActionReloadWindows;
import com.painter.controller.listeners.ActionSaveFile;
import com.painter.controller.listeners.ActionSaveFileToCloud;
import com.painter.controller.listeners.ActionSetLanguage;
import com.painter.controller.listeners.ActionSkins;
import com.painter.controller.listeners.ActionTabbedPaneListener;
import com.painter.controller.listeners.ActionThickness;
import com.painter.controller.listeners.ActionUpdateStatusBar;
import com.painter.controller.listeners.PaintListener;
import com.painter.model.Data;
import com.painter.view.PFrame;
import com.painter.view.PMenu;

public class PCommand
{
	Data data;
	
//	public ActionNewFile			actionNewFile;
//	public ActionOpenFile			actionOpenFile;
	public ActionSaveFile			actionSaveFile;
//	public ActionLoadFile			actionLoadFile;
//	public ActionOpenFileFromCloud	actionOpenFileFromCloud;
	public ActionSaveFileToCloud	actionSaveFileToCloud;
//	public ActionCloseFile			actionCloseFile;
	public ActionTabbedPaneListener	actionTabbedPane;
	public ActionReloadWindows		actionReloadWindows;
	
	public ActionColorChooser		actionColorChooser;
	public ActionThickness			actionThickness;
	public ActionDefaultSettings	actionDefaultSettings;
	public ActionPlugins			actionPlugins;
	public ActionSkins			    actionSkins;
	public ActionAbout				actionAbout;
	public ActionHotKeys			actionHotKeys;
	public ActionExit				actionExit;
	public PaintListener			mousePaint;
	
	public ActionAddLanguage 		actionAddLanguage;
	public ActionSetLanguage		actionSetLanguage;
	
	public ActionUpdateStatusBar	actionUpdateStatusBar;
	
	public PCommand(Data data, PFrame frame)
	{
		this.data = data;
		
//		actionNewFile			= new ActionNewFile();
//		actionOpenFile			= new ActionOpenFile();
		actionSaveFile			= new ActionSaveFile();
//		actionLoadFile			= new ActionLoadFile();
//		actionOpenFileFromCloud	= new ActionOpenFileFromCloud();
//		actionSaveFileToCloud	= new ActionSaveFileToCloud();
//		actionCloseFile			= new ActionCloseFile();
		actionTabbedPane		= new ActionTabbedPaneListener(this);
		actionReloadWindows		= new ActionReloadWindows();
		
		actionColorChooser		= new ActionColorChooser(data);
		actionThickness			= new ActionThickness(data);
		actionDefaultSettings	= new ActionDefaultSettings();
		actionPlugins			= new ActionPlugins(data);
		actionSkins				= new ActionSkins(data, frame);
		actionAbout				= new ActionAbout();
		actionHotKeys			= new ActionHotKeys();
		actionExit				= new ActionExit();
		mousePaint				= new PaintListener(this, data);	
		
		actionAddLanguage		= new ActionAddLanguage(data);
		actionSetLanguage		= new ActionSetLanguage(data, frame);
		
		actionUpdateStatusBar   = new ActionUpdateStatusBar(frame.statusBar, data);
	}

	public Data getData()
	{
		return data;
	}	
}