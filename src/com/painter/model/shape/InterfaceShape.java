package com.painter.model.shape;

public interface InterfaceShape
{
	//	�� ������, ��� ���� ����� ������ ������ ����.
	public void drawShape(int type, int startX, int startY, int endX, int endY, int thickness, int color);
	public void move(int newX, int newY);
	public void resize(int startX, int startY, int endX, int endY);
}
