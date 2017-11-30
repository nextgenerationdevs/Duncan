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
}