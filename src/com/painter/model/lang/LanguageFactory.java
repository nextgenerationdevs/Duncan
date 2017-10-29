package com.painter.model.lang;

import java.util.ArrayList;
import java.util.List;

public class LanguageFactory 
{
	public static List<InterfaceLanguage> languages = new ArrayList<>();
	
	public static InterfaceLanguage activeLanguage()
	{
		for (InterfaceLanguage language : languages)
		{
			if (language.getStatus() == true)
			{
				return language;
			}
		}
		InterfaceLanguage dictionary = new DefaultDictionary();
		dictionary.setStatus(true);
		return dictionary;
	}
	
	public static void updateLanguages()
	{
		
	}
}