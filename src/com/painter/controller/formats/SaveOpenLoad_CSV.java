package com.painter.controller.formats;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.painter.controller.shape.impl.Line;
import com.painter.controller.shape.impl.Oval;
import com.painter.controller.shape.impl.Rectangle;
import com.painter.controller.shape.impl.RoundRect;
import com.painter.model.shape.InterfaceShape;

public class SaveOpenLoad_CSV implements InterfaceImportExport
{
	ArrayList<FigurePanel> al = new ArrayList<FigurePanel>();
	
	public SaveOpenLoad_CSV(ArrayList<FigurePanel> al)
	{
		this.al = al;
	}
	
	@Override
	public void load(String path)
	{
		String str = "";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(path));
			while (br.ready())
			{
				str += br.readLine();
				str += "\r\n";
			}
			br.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		int cnt = 0;
		StringTokenizer strTk = new StringTokenizer(str, "\t\n\r");
		String[] strParsed = new String[strTk.countTokens()];
		while (strTk.hasMoreTokens())
		{
			strParsed[cnt++] = strTk.nextToken();
		}
		
		for (int i = 1; i < strParsed.length; i++)
		{
			StringTokenizer tokenStr = new StringTokenizer(strParsed[i], ", \t");
			String[] tmpStr = new String[7];
			int j = 0;
			while (tokenStr.hasMoreTokens())
			{
				tmpStr[j++] = tokenStr.nextToken();
			}
			int shapeType = Integer.parseInt(tmpStr[0]);
			FigurePanel figure = null;
//			switch(shapeType)
//			{
//			case 0:
//				figure = new Line(
//						Integer.parseInt(tmpStr[1]),
//						Integer.parseInt(tmpStr[2]),
//						Integer.parseInt(tmpStr[3]),
//						Integer.parseInt(tmpStr[4]),
//						Integer.parseInt(tmpStr[5]),
//						Integer.parseInt(tmpStr[6]));
//				break;
//			case 1:
//				figure = new Rectangle(
//						Integer.parseInt(tmpStr[1]),
//						Integer.parseInt(tmpStr[2]),
//						Integer.parseInt(tmpStr[3]),
//						Integer.parseInt(tmpStr[4]),
//						Integer.parseInt(tmpStr[5]),
//						Integer.parseInt(tmpStr[6]));
//				break;
//			case 2:
//				figure = new Oval(
//						Integer.parseInt(tmpStr[1]),
//						Integer.parseInt(tmpStr[2]),
//						Integer.parseInt(tmpStr[3]),
//						Integer.parseInt(tmpStr[4]),
//						Integer.parseInt(tmpStr[5]),
//						Integer.parseInt(tmpStr[6]));
//				break;
//			case 3:
//				figure = new RectOval(
//						Integer.parseInt(tmpStr[1]),
//						Integer.parseInt(tmpStr[2]),
//						Integer.parseInt(tmpStr[3]),
//						Integer.parseInt(tmpStr[4]),
//						Integer.parseInt(tmpStr[5]),
//						Integer.parseInt(tmpStr[6]));
//				break;
//			case 4:
//				figure = new Line(
//						Integer.parseInt(tmpStr[1]),
//						Integer.parseInt(tmpStr[2]),
//						Integer.parseInt(tmpStr[3]),
//						Integer.parseInt(tmpStr[4]),
//						Integer.parseInt(tmpStr[5]),
//						Integer.parseInt(tmpStr[6]));
//				break;
//			}			
			al.add(figure);
			figure = null;
		}
	}

	@Override
	public void save(String path)
	{
		String str = "shape, x1, y1, x2, y2, color, width\r\n";
		for (int i = 0; i < al.size(); i++)
		{
			FigurePanel figure = al.get(i);
			str += figure.shape + ", " + figure.x1 + ", "+ figure.y1 + ", " + figure.x2 + ", " + figure.y2 + ", " + figure.color + ", " + figure.width + "\r\n";
		}
		try
		{
			if (path.equals(""))
				path = "untitled.csv";
			else if (!path.contains(".csv"))
				path += ".csv";
			BufferedWriter bw = new BufferedWriter(new FileWriter(path));
			bw.write(str);
			bw.close();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void open(String path) {
		// TODO Auto-generated method stub
		
	}
}