package com.painter.view.modal.hot_keys_model;

import java.util.ArrayList;
import java.util.List;

public class HotKeysImpl
{
	List<HotKeys> listOfHotKeys = new ArrayList<>();

	public HotKeysImpl()
	{
		listOfHotKeys.add(new HotKeys("Creat new file", "Ctrl + O"));
		listOfHotKeys.add(new HotKeys("Open local file", "Ctrl + P"));
		listOfHotKeys.add(new HotKeys("Open file from cloud", "Ctrl + Shift + P"));
		listOfHotKeys.add(new HotKeys("Load local file", "Ctrl + L"));
		listOfHotKeys.add(new HotKeys("Save file", "Ctrl + S"));
		listOfHotKeys.add(new HotKeys("Save file to cloud", "Ctrl + Shift + S"));
		listOfHotKeys.add(new HotKeys("Reload file", "F5"));
		listOfHotKeys.add(new HotKeys("Close file", "Ctrl + W"));
		listOfHotKeys.add(new HotKeys("Exit program", "Alt + F4"));
		listOfHotKeys.add(new HotKeys("Undo", "Ctrl + Z"));
		listOfHotKeys.add(new HotKeys("Redo", "Ctrl + Y"));
		listOfHotKeys.add(new HotKeys("Go to next tab", "Ctrl + Tab"));
		listOfHotKeys.add(new HotKeys("Go previous tab", "Shift + Tab"));
		listOfHotKeys.add(new HotKeys("Management plugins", "Ctrl + Shift + P"));
		listOfHotKeys.add(new HotKeys("Management skins", "Alt + S"));
		listOfHotKeys.add(new HotKeys("Cloud settings", "Ctrl + Shift + C"));
		listOfHotKeys.add(new HotKeys("Show properties", "Alt + Enter"));
		listOfHotKeys.add(new HotKeys("Move figure to the left", "Left Arrow"));
		listOfHotKeys.add(new HotKeys("Move figure to the right", "Right Arrow"));
		listOfHotKeys.add(new HotKeys("Move figure to the up", "Up Arrow"));
		listOfHotKeys.add(new HotKeys("Move figure to the down", "Down Arrow"));
		listOfHotKeys.add(new HotKeys("Change size of figure", "Shift + Arrows"));
	}

	public ArrayList<HotKeys> read() 
	{
		return (ArrayList<HotKeys>) listOfHotKeys;
	}
}