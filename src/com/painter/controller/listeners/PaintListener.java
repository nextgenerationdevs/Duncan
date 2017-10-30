package com.painter.controller.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.painter.controller.PCommand;
import com.painter.model.Data;

public class PaintListener extends MouseAdapter
{
	private Data data;
	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public PaintListener(PCommand cmd)
	{
		data = cmd.getData();
	}

	//	Добавление новой фигуры в рабочую область с установленными параметрами
	@Override
	public void mouseClicked(MouseEvent e)
	{
		int button = e.getButton();
		switch(button)
		{
		case MouseEvent.BUTTON1:
			addFigure(e);
			break;
		case MouseEvent.BUTTON2:
			notifyContextMenu(e);
			break;
		default:
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) 
	{
		// TODO Auto-generated method stub
		int button = e.getButton();
		switch(button)
		{
		case MouseEvent.BUTTON1:
			startX = e.getX();
			startY = e.getY();	
			break;
		case MouseEvent.BUTTON2:
			break;
		default:
			break;
		}
	}

	//	Формирование параметров для рисования фигуры
	@Override
	public void mouseDragged(MouseEvent e)
	{
		int button = e.getButton();
		switch(button)
		{
		case MouseEvent.BUTTON1:
			endX = e.getX();
			endY = e.getY();
			addFigure(e);
			break;
		case MouseEvent.BUTTON2:
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		data.statusX = e.getX();
		data.statusY = e.getY();
	}
	
	
//	Добавление новой фигуры в рабочую область с установленными параметрами
	@Override
	public void mouseReleased(MouseEvent e)
	{
		int button = e.getButton();
		switch(button)
		{
		case MouseEvent.BUTTON1:
			addFigure(e);
			break;
		case MouseEvent.BUTTON2:
			notifyContextMenu(e);
			break;
		default:
			break;	
		}
	}
	
	private void addFigure(MouseEvent e)
	{
		data.statusX = e.getX();
		data.statusY = e.getY();
		//	TODO выбор текущего плагина из PluginsList, конструктор фигуры с размерами по умолчанию, обновление фигуры, обновление рабочей области.
	}
	
	private void notifyContextMenu(MouseEvent e)
	{
//		TODO Вызов контекстного меню
	}
}
