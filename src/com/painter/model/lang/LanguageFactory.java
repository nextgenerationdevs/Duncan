<<<<<<< HEAD
package com.painter.model.lang;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.painter.model.lang.dictionaries.Dictionary_EN;
import com.painter.model.lang.dictionaries.Dictionary_RU;
import com.painter.model.lang.dictionaries.Dictionary_UKR;

public class LanguageFactory 
{
	public static List<InterfaceBundle> bundles = new ArrayList<InterfaceBundle>();
	
	public static ResourceBundle activeLanguage()
	{
		for (InterfaceBundle language : bundles)
		{
			if (language.getStatus() == true)
			{	
				System.out.println("Активный язык = " + language.getName());
				return language.returnBundle();
			}	
		}
		System.out.println("Default язык выбран");
		return new Dictionary_EN().returnBundle();
	}
	
	public static void updateLanguages()
	{
		addToBundles(new Dictionary_EN());
		addToBundles(new Dictionary_RU());
		addToBundles(new Dictionary_UKR());

		for (InterfaceBundle language : bundles)
		{
			System.out.println(language.getName() + " status = " + language.getStatus());
		}
	}
	
	public static void addToBundles(InterfaceBundle bundle)
	{
		bundles.add(bundle);
	}
=======
package com.painter.model.lang;

import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;

import com.painter.model.lang.dictionaries.Dictionary_EN;

public class LanguageFactory 
{
	public static Set<InterfaceBundle> bundles = new LinkedHashSet<InterfaceBundle>();
	
	public static ResourceBundle activeLanguage()
	{
		for (InterfaceBundle bundle : bundles)
		{
			if (bundle.getStatus() == true)
			{	
				return bundle.returnBundle();
			}	
		}
		return new Dictionary_EN().returnBundle();
	}
	
	public static void updateLanguages()
	{
		addToBundles(new Dictionary_EN());
	}
	
	public static void addToBundles(InterfaceBundle bundle)
	{
		bundles.add(bundle);
	}
	
	public static void removeFromBundles(InterfaceBundle bundle)
	{	
		bundles.remove(bundle);
	}
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}