package com.painter.model.plugins;

import java.util.ArrayList;
import java.util.List;

import com.painter.controller.plugins.list.def.DefaultPlugin;

public class PluginsList 
{
	private static List<InterfaceFigure> plugins ;
	
	public static List<InterfaceFigure> getPlugins()
	{
		if (plugins == null)
		{
			plugins = new ArrayList<>();
			plugins.add(new DefaultPlugin(0, 0));
		}
		return plugins;
	}
}
