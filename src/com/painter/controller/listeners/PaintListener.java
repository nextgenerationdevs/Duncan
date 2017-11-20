package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URLClassLoader;

import com.painter.controller.PCommand;
import com.painter.controller.PPanel;
import com.painter.model.Data;
import com.painter.model.Type;
import com.painter.model.plugins.InterfaceFigure;

/**
 * @author Dmitry Chmul
 *
 */
public class PaintListener extends MouseAdapter
{
	private Data data;
	private PCommand cmd;
	private PPanel panel;

	private int startX;
	private int startY;
	private int endX;
	private int endY;

	public PaintListener(PCommand cmd, Data data)
	{
		this.cmd = cmd;
		this.data = data;
	}

	public void setPPanel(PPanel panel)
	{
		this.panel = panel;
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
		data.setStatusX(e.getX());
		data.setStatusY(e.getY());
		cmd.actionUpdateStatusBar.actionPerformed(new ActionEvent(this, 0, "updateXY"));
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
//		data.statusX = e.getX();
//		data.statusY = e.getY();
//		InterfaceFigure figure = data.selectedFigure.getInstance(data.selectedFigure);
//		figure.setMainProperties(data.type, data.color, data.thickness);
//		figure.move(e.getX(), e.getY());
//		panel.figures.add(figure);
//		panel.initialize();
	}

	private void notifyContextMenu(MouseEvent e)
	{
		//		TODO ¬ызов контекстного меню
	}
}
