package com.painter.controller;

import java.awt.event.ActionListener;

import com.painter.controller.listeners.ActionAbout;
import com.painter.controller.listeners.ActionAddLanguage;
import com.painter.controller.listeners.ActionCloud;
import com.painter.controller.listeners.ActionColorChooser;
import com.painter.controller.listeners.ActionDefaultSettings;
import com.painter.controller.listeners.ActionExit;
import com.painter.controller.listeners.ActionHotKeys;
import com.painter.controller.listeners.ActionOpenFileFromCloud;
import com.painter.controller.listeners.ActionPlugins;
import com.painter.controller.listeners.ActionReloadWindows;
import com.painter.controller.listeners.ActionSaveFile;
import com.painter.controller.listeners.ActionSaveFileToCloud;
import com.painter.controller.listeners.ActionSetLanguage;
import com.painter.controller.listeners.ActionSkins;
import com.painter.controller.listeners.ActionTabbedPaneListener;
import com.painter.controller.listeners.ActionThickness;
import com.painter.controller.listeners.ActionUndoRedo;
import com.painter.controller.listeners.ActionUpdateStatusBar;
import com.painter.controller.listeners.DropTargetListener;
import com.painter.controller.listeners.PaintListener;
import com.painter.model.Data;
import com.painter.view.PFrame;

public class PCommand
{
	Data data;
	PFrame frame;
	
	public ActionSaveFile			actionSaveFile;
	public ActionOpenFileFromCloud	actionOpenFileFromCloud;
	public ActionSaveFileToCloud	actionSaveFileToCloud;
	public ActionTabbedPaneListener	actionTabbedPane;
	public ActionReloadWindows		actionReloadWindows;
	
	public ActionColorChooser		actionColorChooser;
	public ActionThickness			actionThickness;
	public ActionDefaultSettings	actionDefaultSettings;
	public ActionPlugins			actionPlugins;
	public ActionSkins			    actionSkins;
	public ActionCloud			    actionCloud;
	public ActionAbout				actionAbout;
	public ActionHotKeys			actionHotKeys;
	public ActionExit				actionExit;
	public PaintListener			mousePaint;
	public DropTargetListener		dropTargetListener;
	
	public ActionAddLanguage 		actionAddLanguage;
	public ActionSetLanguage		actionSetLanguage;
	
	public ActionUpdateStatusBar	actionUpdateStatusBar;

	public ActionUndoRedo 			actionUndoRedo;
	
	public PCommand(Data data, PFrame frame)
	{
		this.data = data;
		this.frame = frame;
		
		actionSaveFile			= new ActionSaveFile();
		actionOpenFileFromCloud	= new ActionOpenFileFromCloud();
		actionSaveFileToCloud	= new ActionSaveFileToCloud();
		actionTabbedPane		= new ActionTabbedPaneListener(this, data);
		actionReloadWindows		= new ActionReloadWindows();
		
		actionColorChooser		= new ActionColorChooser(data);
		actionThickness			= new ActionThickness(data);
		actionDefaultSettings	= new ActionDefaultSettings(data);
		actionPlugins			= new ActionPlugins(data);
		actionSkins				= new ActionSkins(data, frame);
		actionCloud				= new ActionCloud(data);
		actionAbout				= new ActionAbout();
		actionHotKeys			= new ActionHotKeys();
		actionExit				= new ActionExit();
		mousePaint				= new PaintListener(this, data);
		dropTargetListener		= new DropTargetListener(this);
		
		actionAddLanguage		= new ActionAddLanguage(data, frame);
		actionSetLanguage		= new ActionSetLanguage(data, frame);
		
		actionUpdateStatusBar   = new ActionUpdateStatusBar(frame, data);
		
		actionUndoRedo 			= new ActionUndoRedo(null, null);
	}

	public Data getData()
	{
		return data;
	}	
}