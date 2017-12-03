package com.painter.model;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class ResizableBorder implements Border
{
	private int dist = 8;

	int locations[] =
		{
				SwingConstants.NORTH, SwingConstants.SOUTH, SwingConstants.WEST, SwingConstants.EAST,
				SwingConstants.NORTH_WEST, SwingConstants.NORTH_EAST, SwingConstants.SOUTH_WEST, SwingConstants.SOUTH_EAST
		};
	
	int cursors[] = 
		{
				Cursor.N_RESIZE_CURSOR, Cursor.S_RESIZE_CURSOR, Cursor.W_RESIZE_CURSOR, Cursor.E_RESIZE_CURSOR,
				Cursor.NW_RESIZE_CURSOR, Cursor.NE_RESIZE_CURSOR, Cursor.SW_RESIZE_CURSOR, Cursor.SE_RESIZE_CURSOR
		};
	
	public ResizableBorder(int dist)
	{
		this.dist = dist;
	}

	@Override
	public void paintBorder(Component c, Graphics g, int x, int y, int width, int height)
	{
		if (c.hasFocus())
		{
			g.setColor(Color.BLACK);
			g.drawRect(x + dist / 2, y + dist / 2, width - dist, height - dist);
			for (int i = 0; i < locations.length; i++)
			{				
				Rectangle rect = getRectangle(x, y, width, height, locations[i]);
				g.setColor(Color.WHITE);
				g.fillRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
				g.setColor(Color.BLACK);
				g.drawRect(rect.x, rect.y, rect.width - 1, rect.height - 1);
			}
		}
	}

	@Override
	public Insets getBorderInsets(Component c)
	{
		return new Insets(dist, dist, dist, dist);
	}

	@Override
	public boolean isBorderOpaque()
	{
		return false;
	}
	
	private Rectangle getRectangle(int x, int y, int width, int height, int location)
	{
		Rectangle rect = null;
		
		switch(location)
		{
		case SwingConstants.NORTH:
			rect = new Rectangle(x + width / 2 - dist / 2, y, dist, dist);
			break;
		case SwingConstants.SOUTH:
			rect = new Rectangle(x + width / 2 - dist / 2, y + height - dist, dist, dist);
			break;
		case SwingConstants.WEST:
			rect = new Rectangle(x, y + height / 2 - dist / 2, dist, dist);
			break;
		case SwingConstants.EAST:
			rect = new Rectangle(x + width - dist, y + height / 2 - dist / 2, dist, dist);
			break;
		case SwingConstants.NORTH_WEST:
			rect = new Rectangle(x, y, dist, dist);
			break;
		case SwingConstants.NORTH_EAST:
			rect = new Rectangle(x + width - dist, y, dist, dist);
			break;
		case SwingConstants.SOUTH_WEST:
			rect = new Rectangle(x, y + height - dist, dist, dist);
			break;
		case SwingConstants.SOUTH_EAST:
			rect = new Rectangle(x + width - dist, y + height - dist, dist, dist);
			break;
		}
		return rect;
	}

	public int getCursor(MouseEvent me)
	{
		Component c = me.getComponent();
		int width = c.getWidth();
		int height = c.getHeight();
		for (int i = 0; i < locations.length; i++)
		{
			Rectangle rect = getRectangle(0, 0, width, height, locations[i]);
			if (rect.contains(me.getPoint()))
			{
				return cursors[i];
			}
		}
		return Cursor.MOVE_CURSOR;
	}
}
