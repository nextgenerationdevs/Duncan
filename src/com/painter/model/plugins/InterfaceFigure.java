package com.painter.model.plugins;

import javax.swing.JPanel;

public interface InterfaceFigure
{
	/**
	 * @return ������ � ����� ���������
	 */
	public JPanel getPluginFigure();
	/**
	 * @return ������ � ����������� ������� ����� ��������
	 */
	public JPanel getPluginProperties();
	
//	�� ������, ��� ���� ����� ������ ������ ����.
	public void drawShape(int type, int startX, int startY, int endX, int endY, int thickness, int color);
	/**
	 * ����������� ������ �� ����� ����� ������� �������
	 * @param newX	����� x-����������
	 * @param newY	����� y-����������
	 */
	public void move(int newX, int newY);
	/**
	 * ��������� ������� ������
	 * @param startX ��������� x-����������
	 * @param startY ��������� y-����������
	 * @param endX �������� x-����������
	 * @param endY �������� y-����������
	 */
	public void resize(int startX, int startY, int endX, int endY);
	/**
	 * @param type	��� ������
	 * @param color ���� �����
	 * @param thickness ������� �����
	 */
	public void setMainProperties(int type, int color, int thickness);
	/**
	 * @return ������� ������� ������
	 */
	public boolean isSelected(); 
}
