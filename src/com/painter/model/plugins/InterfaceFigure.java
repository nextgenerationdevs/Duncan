package com.painter.model.plugins;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.painter.model.Type;

public interface InterfaceFigure
{
	public InterfaceFigure getInstance(InterfaceFigure figure);
	/**
	 * @return ������ � ����� ���������
	 */
	public JPanel getPluginFigure();
	/**
	 * @return ������ � ����������� ������� ����� ��������
	 */
	public JPanel getPluginProperties();
	
//	�� ������, ��� ���� ����� ������ ������ ����.
//	public void drawShape(Graphics2D graphics);
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
	public void setMainProperties(Type type, int color, int thickness);
	/**
	 * @return type, color, thickness ������
	 */
	public int[] getMainProperties();
	/**
	 * @param x x-���������� 
	 * @param y y-����������
	 */
	public void setCoordinates(int x, int y);
	/**
	 * @return ������� ������� ������
	 */
	public boolean isSelected();
}
