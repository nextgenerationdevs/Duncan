package com.painter.controller.lang;

import java.util.Map;

import com.painter.model.Data;

public class LangFactory
{
	public void setLanguage()
	{
		Map<String, String> tmpDict = null;
		// �������� �� ����� Map � tmpDict
		Data.dictionary.setDictionary(tmpDict);
	}
}
