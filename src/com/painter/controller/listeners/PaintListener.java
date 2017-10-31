package com.painter.controller.listeners;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.painter.model.Data;
import com.painter.model.FiguresList;
import com.painter.model.plugins.InterfaceFigure;
import com.painter.model.plugins.PluginsList;

/**
 * @author Dmitry Chmul
 *
 */
public class PaintListener extends MouseAdapter
{
	private Data data;

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public void setData(Data data)
	{
		this.data = data;
	}

	//	ƒобавление новой фигуры в рабочую область с установленными параметрами
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

	//	‘ормирование параметров дл€ рисовани€ фигуры
	@Override
	public void mouseDragged(MouseEvent e)
	{
		int button = e.getButton();
		switch(button)
		{
		case MouseEvent.BUTTON1:
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


	//	ƒобавление новой фигуры в рабочую область с установленными параметрами
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

		InterfaceFigure figure = PluginsList.getPlugins().get(data.selectedIndex);
		figure.setMainProperties(data.type, data.color, data.thickness);
		figure.setCoordinates(startX, startY);			//		»ли все же стандартные размеры, а настроим потом?
		JPanel newPanel = figure.getPluginFigure();
		FiguresList.addFigure(newPanel);
	}

	private void notifyContextMenu(MouseEvent e)
	{
		//		TODO ¬ызов контекстного меню
	}
}
