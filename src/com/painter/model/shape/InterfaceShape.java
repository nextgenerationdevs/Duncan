package com.painter.model.shape;

public interface InterfaceShape
{
	//	Ќе уверен, что этот метод вообще должен быть.
	public void drawShape(int type, int startX, int startY, int endX, int endY, int thickness, int color);
	public void move(int newX, int newY);
	public void resize(int startX, int startY, int endX, int endY);
}
