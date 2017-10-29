package com.painter.model.shape;

import java.awt.Graphics2D;

public interface InterfaceShape
{
	public void drawShape(Graphics2D graphics2d, int startX, int startY, int endX, int endY, int thickness, int color);
	public void move(int newX, int newY);
	public void resize(int startX, int startY, int endX, int endY);
}
