package com.painter.model.plugins;

import javax.swing.JPanel;

public interface InterfaceFigure
{
	/**
	 * @return ѕанель с новым контентом
	 */
	public JPanel getPluginFigure();
	/**
	 * @return ѕанель с управлением свойств новго контента
	 */
	public JPanel getPluginProperties();
	
//	Ќе уверен, что этот метод вообще должен быть.
	public void drawShape(int type, int startX, int startY, int endX, int endY, int thickness, int color);
	/**
	 * ѕеремещение фигуры на новое место рабочей области
	 * @param newX	нова€ x-координата
	 * @param newY	нова€ y-координата
	 */
	public void move(int newX, int newY);
	/**
	 * »зменение размера фигуры
	 * @param startX начальна€ x-координата
	 * @param startY начальна€ y-координата
	 * @param endX конечна€ x-координата
	 * @param endY конечна€ y-координата
	 */
	public void resize(int startX, int startY, int endX, int endY);
	/**
	 * @param type	тип фигуры
	 * @param color цвет линии
	 * @param thickness толщина линии
	 */
	public void setMainProperties(int type, int color, int thickness);
	/**
	 * @return выбрана текуща€ фигура
	 */
	public boolean isSelected(); 
}
