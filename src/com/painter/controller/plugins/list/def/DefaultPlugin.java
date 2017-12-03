package com.painter.controller.plugins.list.def;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragSource;
import java.io.IOException;

import javax.swing.JPanel;

import com.painter.model.Type;
import com.painter.model.plugins.InterfaceFigure;

public class DefaultPlugin implements InterfaceFigure
{
	private Type type;
	private int color;
	private int thickness;
	private boolean status;
	
	private int x;
	private int y;
	private int width;
	private int height;
	
	private FigurePanel thisFigure;
	private JPanel thisProperties;
	private DataFlavor df = new DataFlavor(DefaultPlugin.class, "DefaultPlugin");
	private DataFlavor[] supportedFlavors = {df};
	
	public DefaultPlugin(int x, int y)
	{
		this.x = x;
		this.y = y;
		init();
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	void init()
	{
		type = Type.rectangle;
		color = 0;
		thickness = 1;
		width = 160;
		height = 90;
		
		thisFigure = new FigurePanel(0, 0, width + thickness, height + thickness, color, thickness, type);
	}

	@Override
	public JPanel getPluginFigure() 
	{
		return thisFigure;
	}

	@Override
	public JPanel getPluginProperties() 
	{
		return null;
	}
	
	@Override
	public void move(int newX, int newY) 
	{
		thisFigure.setLocation(newX, newY);
	}

	@Override
	public void resize(int startX, int startY, int width, int height) 
	{		
		x = startX;
		y = startY;
		this.width = width;
		this.height = height;
		
		thisFigure.width = width;
		thisFigure.height = height;
		
		thisFigure.revalidate();
		thisFigure.repaint();
	}

	@Override
	public void setMainProperties(Type type, int color, int thickness)
	{
		this.type = type;
		this.color = color;
		this.thickness = thickness;
		thisFigure =  new FigurePanel(0, 0, width + thickness, height + thickness, color, thickness, type);
	}

	@Override
	public int[] getMainProperties() 
	{
		int[] ret = {color, thickness};
		return ret;
	}

	@Override
	public boolean isSelected()
	{
		return status;
	}

	@Override
	public void setCoordinates(int x, int y)
	{
		this.x = x;
		this.y = y;		
	}

	@Override
	public InterfaceFigure getInstance(InterfaceFigure figure)
	{
		return new DefaultPlugin(((DefaultPlugin)figure).getX(), ((DefaultPlugin)figure).getY());		
	}

	@Override
	public void dragGestureRecognized(DragGestureEvent dge)
	{
		Cursor cursor = null;
		JPanel panel = (JPanel) dge.getComponent();
		if (dge.getDragAction() == DnDConstants.ACTION_COPY)
		{
			cursor = DragSource.DefaultCopyDrop;
		}
		dge.startDrag(cursor, new DefaultPlugin(dge.getDragOrigin().x, dge.getDragOrigin().y));
		
	}

	@Override
	public Object getTransferData(DataFlavor df) throws UnsupportedFlavorException, IOException
	{
		if (df.equals(this.df))
			return new DefaultPlugin(x, y);
		else
			throw new UnsupportedFlavorException(df);
	}

	@Override
	public DataFlavor[] getTransferDataFlavors()
	{
		return supportedFlavors;
	}

	@Override
	public boolean isDataFlavorSupported(DataFlavor df)
	{
		return true;
	}

	@Override
	public void setDragSource(JPanel panel)
	{
		new DragSource().createDefaultDragGestureRecognizer(panel, DnDConstants.ACTION_COPY, this);
	}

}
