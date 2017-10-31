package com.painter.controller.listeners;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JPanel;

import com.painter.model.Data;
import com.painter.model.plugins.InterfaceFigure;
import com.painter.model.plugins.PluginsList;

/**
 * @author Dmitry Chmul
 *
 */
public class PaintListener extends MouseAdapter
{
	private Data data;
	private List<JPanel> figures;
	
	private int startX;
	private int startY;
	private int endX;
	private int endY;
	
	private Graphics graphics;

	public void setData(Data data)
	{
		this.data = data;
	}
	
	public void setFigures(List<JPanel> figures)
	{
		this.figures = figures;
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
		figure.setCoordinates(e.getX(), e.getY());			//		»ли все же стандартные размеры, а настроим потом?
		figures.add(figure.getPluginFigure());							//	потом - synchronyzed
	}

	private void notifyContextMenu(MouseEvent e)
	{
		//		TODO ¬ызов контекстного меню
	}
}
