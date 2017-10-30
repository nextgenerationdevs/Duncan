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

	//	���������� ����� ������ � ������� ������� � �������������� �����������
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

	//	������������ ���������� ��� ��������� ������
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
	
	
//	���������� ����� ������ � ������� ������� � �������������� �����������
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
		//	TODO ����� �������� ������� �� PluginsList, ����������� ������ � ��������� �� ���������, ���������� ������, ���������� ������� �������.
	}
	
	private void notifyContextMenu(MouseEvent e)
	{
//		TODO ����� ������������ ����
	}
}
