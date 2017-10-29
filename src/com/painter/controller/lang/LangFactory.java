package com.painter.controller.lang;

import java.util.Map;

import com.painter.model.Data;

public class LangFactory
{
	public void setLanguage()
	{
		Map<String, String> tmpDict = null;
		// Вычитать из файла Map в tmpDict
		Data.dictionary.setDictionary(tmpDict);
	}
}
