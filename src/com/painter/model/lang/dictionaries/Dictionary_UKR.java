package com.painter.model.lang.dictionaries;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

import com.painter.model.lang.InterfaceBundle;

public class Dictionary_UKR extends ListResourceBundle implements InterfaceBundle
{
	private boolean status;
	private static final String resourceBundle = "com.painter.model.lang.dictionaries.Dictionary_UKR";
	private static final String name = "Українська";
	private static final String surname = "украинский";
	
	private static final Object[][] content = 
	{
	//Dialogs, Titles:
	{"titleAddLanguageDialog", "ДОДАТИ МОВУ"}, 
	//Dialogs, ControllButtons:
	{"controllButtonOk", "ОК"}, {"controllButtonApply", "Застосувати"}, {"controllButtonCancel", "Відмінити"},
	{"controllButtonAdd", "Додати"}, {"controllButtonRemove", "Видалити"},
	//JOptionPane, Buttons:
	{"actionOptionPaneCancel", "Відмінити"}, {"actionOptionPaneOk", "ОК"}, {"actionOptionPaneNo", "Ні"}, {"actionOptionPaneYes", "Так"},
	//PFrame, SetTitle:
	{"actionFrameTitle", "Дунканидло"},
	//MenuBar, Menu_File:
	{"actionFile", "Файл"}, {"actionNew", "Новий"}, {"actionOpen", "Відкрити"}, {"actionOpenFromCloud", "Відкрити з хмари"}, {"actionLoad", "Загрузити"},
	{"actionSave", "Зберегти"}, {"actionSaveToCloud", "Зберегти у хмару"}, {"actionReload", "Перегрузити"}, {"actionClose", "Закрити"}, {"actionExit", "Вийти"},
	//MenuBar, Menu_Edit:		
	{"actionEdit", "Правка"}, {"actionUndo", "Повернутися назад"}, {"actionRedo", "Повернутися вперед"}, {"actionType", "Тип"}, {"actionColor", "Колір"}, {"actionThickness", "Товщина"},
	//MenuBar, Menu_Window:
	{"actionWindow", "Вікно"}, {"actionNextTab", "Наступна таба"}, {"actionPrevTab", "Попередня таба"}, {"actionTab", "Таба"},
	//MenuBar, Menu_Options:		
	{"actionOptions", "Опції"}, {"actionPlugins", "Плагіни"}, {"actionSkins", "Скіни"}, {"actionCloud", "Хмара"}, {"actionLanguage", "Мова"},
	{"actionAddLanguage", "Додати мову"},
	//MenuBar, Menu_Help:		
	{"actionHelp", "Допомога"}, {"actionHotKeys", "Горячі клавіши"}, {"actionAbout", "О програмі"},
	//Warning messages		
	{"warning_title", "Попереджувальне Повідомлення"},
	{"nameOfTabbedPaneExist", "Вкладка з таким ім'ям вже існує!\nБудь ласка створіть вкладку з іншим ім'ям!"},
	{"areYouSureForSession", "Ви втратите поточну сесію без можливості її зберегти!\nНатисніть OK, якщо ви впевнені в цьому!"},
	//Repaint frame message		
	{"confirm_title", "Попереджувальне Повідомлення"},
	{"actionSessionClosed", "Поточний сеанс буде закритий!\nНатисніть OK, якщо хочете зберегти сеанс!"}
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