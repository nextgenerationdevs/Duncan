package com.painter.controller;

import com.painter.controller.listeners.ActionAbout;
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
import com.painter.controller.listeners.ActionSaveFile;
import com.painter.controller.listeners.ActionSaveFileToCloud;
import com.painter.controller.listeners.ActionThickness;
import com.painter.controller.listeners.PaintListener;
import com.painter.model.Data;
import com.painter.view.PFrame;

public class PCommand
{
	Data data;
	PFrame frame;
	
	public PCommand(Data data)
	{
		this.data = data;
	}

	public Data getData()
	{
		return data;
	}

	public ActionNewFile			actionNewFile			= new ActionNewFile();
	public ActionOpenFile			actionOpenFile			= new ActionOpenFile();
	public ActionSaveFile			actionSaveFile			= new ActionSaveFile();
	public ActionLoadFile			actionLoadFile			= new ActionLoadFile();
	public ActionOpenFileFromCloud	actionOpenFileFromCloud	= new ActionOpenFileFromCloud();
	public ActionSaveFileToCloud	actionSaveFileToCloud	= new ActionSaveFileToCloud();
	public ActionCloseFile			actionCloseFile			= new ActionCloseFile();
	
	public ActionColorChooser		actionColorChooser		= new ActionColorChooser(data);
	public ActionThickness			actionThickness			= new ActionThickness(data);
	public ActionDefaultSettings	actionDefaultSettings	= new ActionDefaultSettings();
	public ActionPlugins			actionPlugins			= new ActionPlugins(data);
	public ActionAbout				actionAbout				= new ActionAbout();
	public ActionHotKeys			actionHotKeys			= new ActionHotKeys();
	public ActionExit				actionExit				= new ActionExit();
	public PaintListener			mousePaint				= new PaintListener();
}