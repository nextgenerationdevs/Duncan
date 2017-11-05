package com.painter.model.lang;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.painter.model.lang.dictionaries.Dictionary_EN;
import com.painter.model.lang.dictionaries.Dictionary_RU;

public class LanguageFactory 
{
	public static List<InterfaceBundle> bundles = new ArrayList<>();
	
	public static ResourceBundle activeLanguage()
	{
		for (InterfaceBundle language : bundles)
		{
			if (language.getStatus() == true)
			{
				return language.returnBundle();
			}
		}
		return new Dictionary_EN().returnBundle();
	}
	
	public static void updateLanguages()
	{
		addToBundles(new Dictionary_EN());
		addToBundles(new Dictionary_RU());
	}
	
	public static void addToBundles(InterfaceBundle bundle)
	{
		bundles.add(bundle);
	}
}