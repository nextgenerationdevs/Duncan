package com.painter.controller.formats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

//import com.painter.controller.shape.impl.Line;
//import com.painter.controller.shape.impl.Oval;
//import com.painter.controller.shape.impl.Rectangle;
//import com.painter.controller.shape.impl.RoundRect;
//import com.painter.model.shape.InterfaceShape;

public class SaveOpenLoad_XML implements InterfaceImportExport
{
//	ArrayList<InterfaceShape> al = null;
//	
//	public SaveOpenLoad_JSON(){}
//	
//	public SaveOpenLoad_JSON(ArrayList<InterfaceShape> al)
//	{
//		this.al = al;
//	}

	@Override
	public void open(String path)
	{
//		al.clear();
		String str = "";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			str = br.readLine();
			br.close();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
		StringTokenizer strTk = new StringTokenizer(str, "{[:, \"]}");
		String[] strParsed = new String[strTk.countTokens()];
		int count = 0;
		while (strTk.hasMoreTokens())
		{
			strParsed[count++] = strTk.nextToken();
		}
//		InterfaceShape figure = null;
//		for (int i = 0; i < strParsed.length; i++)
//		{
//			if (strParsed[i].equals("shape"))
//			{
//				int	shapeType = Integer.parseInt(strParsed[i + 1]);
//				int	parsedType	= (strParsed[i + 10].equals("clr"))? Integer.parseInt(strParsed[i + 11]) : 0;
//				int	parsedX1 = (strParsed[i + 2].equals("x1")) ? Integer.parseInt(strParsed[i + 3]) : 0;
//				int	parsedY1 = (strParsed[i + 4].equals("y1"))? Integer.parseInt(strParsed[i + 5]) : 0;
//				int parsedX2 = (strParsed[i + 6].equals("x2"))? Integer.parseInt(strParsed[i + 7]) : 0;
//				int parsedY2 = (strParsed[i + 8].equals("y2"))? Integer.parseInt(strParsed[i + 9]) : 0;
//				int	parsedColor	= (strParsed[i + 10].equals("clr"))? Integer.parseInt(strParsed[i + 11]) : 0;
//				int	parsedWidth	= (strParsed[i + 12].equals("width"))? Integer.parseInt(strParsed[i + 13]) : 0;
//				switch (shapeType)
//				{
//					case 0: figure = new Line(); break;
//					case 1: figure = new Oval(); break;
//					case 2: figure = new Rectangle(); break;
//					case 3: figure = new RoundRect(); break;
//				}
//				al.add(figure);
//				figure = null;
//			}
//		}
	}

	@Override
	public void save(String path)
	{
		String str = "[";
//		for (InterfaceShape figure : al)
//		{
//			str += "{\"shape:\"" + figure.shape + "\"x1\"" + figure.x1 + "\"y1\"" + figure.y1 + "\"x2\"" + figure.x2 +
//				   "\"y2\"" + figure.y2 + "\"clr\"" + figure.clr + "\"width\"" + figure.width + "}";
//			if (figure != al.get(al.size() - 1))
//			{
//				str += ", ";
//			}
//		}
//		str += "]";
//		try
//		{
//			if (path.equals(""))
//			{
//				path = "untitled.json";
//			}
//			BufferedWriter br = new BufferedWriter(new FileWriter(path));
//			br.write(str);
//			br.flush();
//			br.close();
//		}
//		catch (IOException e)
//		{
//			e.printStackTrace();
//		}
	}

	@Override
	public void load(String path) 
	{
		
	}
}