package com.painter.model.lang.dictionaries;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

import com.painter.model.lang.InterfaceBundle;

public class Dictionary_UKR extends ListResourceBundle implements InterfaceBundle
{
	private boolean status;
	private static final String resourceBundle = "com.painter.model.lang.dictionaries.Dictionary_UKR";
	private static final String name = "���������";
	
	private static final Object[][] content = 
	{
	//MenuBar, Menu_File:
	{"actionFile", "����"}, {"actionNew", "�����"}, {"actionOpen", "³������"}, {"actionOpenFromCloud", "³������ � �����"}, {"actionLoad", "���������"},
	{"actionSave", "��������"}, {"actionSaveToCloud", "�������� � �����"}, {"actionReload", "�����������"}, {"actionClose", "�������"}, {"actionExit", "�����"},
	//MenuBar, Menu_Edit:		
	{"actionEdit", "������"}, {"actionUndo", "����������� �����"}, {"actionRedo", "����������� ������"}, {"actionType", "���"}, {"actionColor", "����"}, {"actionThickness", "�������"},
	//MenuBar, Menu_Window:
	{"actionWindow", "³���"}, {"actionNextTab", "�������� ����"}, {"actionPrevTab", "��������� ����"}, {"actionTab", "����"},
	//MenuBar, Menu_Options:		
	{"actionOptions", "�����"}, {"actionPlugins", "������"}, {"actionSkins", "����"}, {"actionCloud", "�����"}, {"actionLanguage", "����"},
	{"actionAddLanguage", "������ ����"},
	//MenuBar, Menu_Help:		
	{"actionHelp", "��������"}, {"actionHotKeys", "������ ������"}, {"actionAbout", "� �������"}
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
		return ResourceBundle.getBundle(resourceBundle);
	}
}