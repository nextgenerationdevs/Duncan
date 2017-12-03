package com.painter.model.lang.dictionaries;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.painter.model.lang.InterfaceBundle;

public class Dictionary_RU extends ListResourceBundle implements InterfaceBundle
{
	private boolean status;
	public static final String resourceBundle = "com.painter.model.lang.dictionaries.Dictionary_RU";
	private static final String name = "Русский";
	
	private static final Object[][] contents = 
	{
	//MenuBar, Menu_File:
	{"actionFile", "Файл"}, {"actionNew", "Новый"}, {"actionOpen", "Открыть"}, {"actionOpenFromCloud", "Открыть из облака"}, {"actionLoad", "Загрузить"},
	{"actionSave", "Сохранить"}, {"actionSaveToCloud", "Сохранить в облако"}, {"actionReload", "Перезагрузить"}, {"actionClose", "Закрыть"}, {"actionExit", "Выход"},
	//MenuBar, Menu_Edit:		
	{"actionEdit", "Правка"}, {"actionUndo", "Отменить"}, {"actionRedo", "Вернуть"}, {"actionType", "Тип"}, {"actionColor", "Цвет"}, {"actionThickness", "Толщина"},
	//MenuBar, Menu_Window:
	{"actionWindow", "Окно"}, {"actionNextTab", "Следующая вкладка"}, {"actionPrevTab", "Предыдущая вкладка"}, {"actionTab", "Вкладка"},
	//MenuBar, Menu_Options:		
	{"actionOptions", "Опции"}, {"actionPlugins", "Плагины"}, {"actionSkins", "Скины"}, {"actionCloud", "Облако"}, {"actionLanguage", "Язык"},
	{"actionAddLanguage", "Добавить язык"},
	//MenuBar, Menu_Help:		
	{"actionHelp", "Помощь"}, {"actionHotKeys", "Горячие клавиши"}, {"actionAbout", "О программе"}
	};

	@Override
	protected Object[][] getContents()
	{
		return contents;
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