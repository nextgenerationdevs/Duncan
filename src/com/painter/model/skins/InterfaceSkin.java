package com.painter.model.skins;
import java.awt.Color;
import java.awt.Font;

public interface InterfaceSkin
{
	/**
	 * @return цвет пользовательского интерфейса
	 */
	public Color getMainColor();
	
	/**
	 * @return цвет фона
	 */
	public Color getBackgroundColor();
	/**
	 * @return цвет выбранных элементов
	 */
	public Color getSelectColor();
	/**
	 * @return цвет шрифта
	 */
	public Color getFontColor();
	
	/**
	 * @return стандартный шрифт
	 */
	public Font getMainFont();
	/**
	 * @return шрифт выбранного элемента
	 */
	public Font getSelectFont();
	/**
	 * @return неосновной шрифт
	 */
	public Font getSecondaryFont();	
}
