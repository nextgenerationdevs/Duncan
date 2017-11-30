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
	private static final String surname = "����������";
	
	private static final Object[][] content = 
	{
	//Dialogs, Titles:
	{"titleAddLanguageDialog", "������ ����"}, 
	//Dialogs, ControllButtons:
	{"controllButtonOk", "��"}, {"controllButtonApply", "�����������"}, {"controllButtonCancel", "³������"},
	{"controllButtonAdd", "������"}, {"controllButtonRemove", "��������"},
	//JOptionPane, Buttons:
	{"actionOptionPaneCancel", "³������"}, {"actionOptionPaneOk", "��"}, {"actionOptionPaneNo", "ͳ"}, {"actionOptionPaneYes", "���"},
	//PFrame, SetTitle:
	{"actionFrameTitle", "����������"},
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
	{"actionHelp", "��������"}, {"actionHotKeys", "������ ������"}, {"actionAbout", "� �������"},
	//Warning messages		
	{"warning_title", "��������������� �����������"},
	{"nameOfTabbedPaneExist", "������� � ����� ��'�� ��� ����!\n���� ����� ������� ������� � ����� ��'��!"},
	{"areYouSureForSession", "�� �������� ������� ���� ��� ��������� �� ��������!\n�������� OK, ���� �� ������� � �����!"},
	//Repaint frame message		
	{"confirm_title", "��������������� �����������"},
	{"actionSessionClosed", "�������� ����� ���� ��������!\n�������� OK, ���� ������ �������� �����!"}
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