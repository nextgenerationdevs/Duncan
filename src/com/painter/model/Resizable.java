package com.painter.model;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import javax.swing.undo.UndoableEditSupport;

import com.painter.controller.PCommand;
import com.painter.controller.listeners.UndoableResizable;
import com.painter.model.plugins.InterfaceFigure;

public class Resizable extends JComponent
{
	InterfaceFigure figure;
	
	PCommand cmd;
	
	UndoableEditSupport undoableEditSupport = new UndoableEditSupport(this);
	
	UndoManager manager = new UndoManager();
	
	public Resizable(InterfaceFigure figure, PCommand cmd)
	{
		this(figure, new ResizableBorder(8), cmd);
	}
	
	public Resizable(InterfaceFigure figure, ResizableBorder border, PCommand cmd)
	{
		this.figure = figure;
		this.cmd = cmd;
		setLayout(new BorderLayout());
		add(figure.getPluginFigure());
		addMouseListener(resizeListener);
		addMouseMotionListener(resizeListener);
		setBorder(border);
	}
	
	public void addUndoableEditListener()
	{
		undoableEditSupport.addUndoableEditListener(manager);
	}

	public void removeUndoableEditListener()
	{
		undoableEditSupport.removeUndoableEditListener(manager);
	}
	
	private void resize(int startX, int startY, int width, int height)
	{
		if (getParent() != null) {
			
			undoableEditSupport.postEdit(new UndoableResizable(Resizable.this));
			
			
			
			figure.resize(startX + 10, startY + 10, width - 24, height - 24);			
			revalidate();
			repaint();
		}
	}

	public InterfaceFigure getFigure()
	{
		return figure;
	}

	public void setFigure(InterfaceFigure figure)
	{
		this.figure = figure;
	}

	MouseInputAdapter resizeListener = new MouseInputAdapter()
	{		
		@Override
		public void mousePressed(MouseEvent e)
		{
			super.mousePressed(e);
			ResizableBorder border = (ResizableBorder) getBorder();
			cursor = border.getCursor(e);
			startPos = e.getPoint();
			requestFocus();
			repaint();
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
			super.mouseReleased(e);
			startPos = null;
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
			super.mouseExited(e);
			setCursor(Cursor.getDefaultCursor());
		}
		
		private int cursor;
		private Point startPos = null;
		
		@Override
		public void mouseDragged(MouseEvent e)
		{
			super.mouseDragged(e);
			if (startPos != null) {

				int x = getX();
				int y = getY();
				int width = getWidth();
				int height = getHeight();

				int dx = e.getX() - startPos.x;
				int dy = e.getY() - startPos.y;

				switch (cursor) {
					case Cursor.N_RESIZE_CURSOR:
						if (!(height - dy < 50)) {
							setBounds(x, y + dy, width, height - dy);
							resize(x, y + dy, width, height - dy);
						}
						break;

					case Cursor.S_RESIZE_CURSOR:
						if (!(height + dy < 50)) {
							setBounds(x, y, width, height + dy);
							startPos = e.getPoint();
							resize(x, y, width, height + dy);
						}
						break;

					case Cursor.W_RESIZE_CURSOR:
						if (!(width - dx < 50)) {
							setBounds(x + dx, y, width - dx, height);
							resize(x + dx, y, width - dx, height);
						}
						break;

					case Cursor.E_RESIZE_CURSOR:
						if (!(width + dx < 50)) {
							setBounds(x, y, width + dx, height);
							startPos = e.getPoint();
							resize(x, y, width + dx, height);
						}
						break;

					case Cursor.NW_RESIZE_CURSOR:
						if (!(width - dx < 50) && !(height - dy < 50)) {
							setBounds(x + dx, y + dy, width - dx, height - dy);
							resize(x + dx, y + dy, width - dx, height - dy);
						}
						break;

					case Cursor.NE_RESIZE_CURSOR:
						if (!(width + dx < 50) && !(height - dy < 50)) {
							setBounds(x, y + dy, width + dx, height - dy);
							startPos = new Point(e.getX(), startPos.y);
							resize(x, y + dy, width + dx, height - dy);
						}
						break;

					case Cursor.SW_RESIZE_CURSOR:
						if (!(width - dx < 50) && !(height + dy < 50)) {
							setBounds(x + dx, y, width - dx, height + dy);
							startPos = new Point(startPos.x, e.getY());
							resize(x + dx, y, width - dx, height + dy);
						}
						break;

					case Cursor.SE_RESIZE_CURSOR:
						if (!(width + dx < 50) && !(height + dy < 50)) {
							setBounds(x, y, width + dx, height + dy);
							startPos = e.getPoint();
							resize(x, y, width + dx, height + dy);
						}
						break;

					case Cursor.MOVE_CURSOR:
						Rectangle bounds = getBounds();
						bounds.translate(dx, dy);
						setBounds(bounds);
						resize(bounds.x, bounds.y, bounds.width, bounds.height);
				}

				setCursor(Cursor.getPredefinedCursor(cursor));
			}
		}

		@Override
		public void mouseMoved(MouseEvent e)
		{
			if (hasFocus())
			{
				ResizableBorder border = (ResizableBorder) getBorder();
				setCursor(Cursor.getPredefinedCursor(border.getCursor(e)));
			}
			super.mouseMoved(e);
		}
	};
}
