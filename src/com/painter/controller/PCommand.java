package com.painter.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.model.Data;
import com.painter.view.PHotKeysPanel;
import com.painter.view.modal.AboutDialog;
import com.painter.view.modal.NewDialog;
import com.painter.view.modal.PluginsDialog;

public class PCommand
{
	Data data;
	public PCommand(Data data)
	{
		this.data = data;
	}

	public ActionNewFile actionNewFile = new ActionNewFile();
	public ActionOpenFile actionOpenFile = new ActionOpenFile();
	public ActionSaveFile actionSaveFile = new ActionSaveFile();
	public ActionOpenFileFromCloud actionOpenFileFromCloud = new ActionOpenFileFromCloud();
	public ActionSaveFileToCloud actionSaveFileToCloud = new ActionSaveFileToCloud();
	public ActionCloseFile actionCloseFile = new ActionCloseFile();
	public ActionDefaultSettings actionDefaultSettings = new ActionDefaultSettings();

	public ActionPlugins actionPlugins = new ActionPlugins();

	public ActionAbout actionAbout = new ActionAbout();
	public ActionHotKeys actionHotKeys = new ActionHotKeys();

	public ActionExit actionExit = new ActionExit();

	// �������
	class ActionNewFile implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().getName());
		}
	}

	// �������
	class ActionOpenFile implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().toString());
		}
	}

	// �������
	class ActionSaveFile implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().toString());
		}
	}

	// �������
	class ActionOpenFileFromCloud implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().toString());
		}
	}

	// �������
	class ActionSaveFileToCloud implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().toString());
		}
	}

	// �������
	class ActionCloseFile implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().toString());
		}
	}

	// �������
	class ActionDefaultSettings implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new EmptyDialog(getClass().toString());
		}
	}


	class ActionPlugins implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new PluginsDialog(data);
		}
	}

	class ActionAbout implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new AboutDialog();
		}
	}

	// �������
	class ActionHotKeys implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			new PHotKeysPanel(data);
		}
	}

	class ActionExit implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			System.exit(0);
		}
	}
}