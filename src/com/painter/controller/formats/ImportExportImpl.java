package com.painter.controller.formats;

import javax.swing.filechooser.FileNameExtensionFilter;

import com.painter.controller.PPanel;

public class ImportExportImpl 
{
	public FileNameExtensionFilter[] getFilters()
	{
		FileNameExtensionFilter[] filters = 
			{
					new FileNameExtensionFilter("XML Files (*.xml)", "xml"),
					new FileNameExtensionFilter("JSON Files (*.json)", "json"),
					new FileNameExtensionFilter("CSV Files (*.csv)", "csv"),
					new FileNameExtensionFilter("YAML Files (*.yml)", "yml")						
			};
		return filters;		
	}
	
	public InterfaceImportExport getFormat(String filterDescription, PPanel pp) 
	{
		InterfaceImportExport format = null;
		switch (filterDescription)
		{
//			case "XML Files (*.xml)":
//				format = new SaveOpenLoad_XML(FiguresList);	break;
//			case "JSON Files (*.json)":
//				format = new SaveOpenLoad_JSON(pp.figures);	break;
//			case "CSV Files (*.csv)":
//				format = new SaveOpenLoad_CSV(pp.figures);	break;
//			case "YAML Files (*.yml)":
//				format = new SaveOpenLoad_YAML(pp.figures);	break;
		}
		return format;
	}
}