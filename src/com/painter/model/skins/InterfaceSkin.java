package com.painter.model.skins;
import java.awt.Color;
import java.awt.Font;

public interface InterfaceSkin
{
	/**
	 * @return ���� ����������������� ����������
	 */
	public Color getMainColor();
	
	/**
	 * @return ���� ����
	 */
	public Color getBackgroundColor();
	/**
	 * @return ���� ��������� ���������
	 */
	public Color getSelectColor();
	/**
	 * @return ���� ������
	 */
	public Color getFontColor();
	
	/**
	 * @return ����������� �����
	 */
	public Font getMainFont();
	/**
	 * @return ����� ���������� ��������
	 */
	public Font getSelectFont();
	/**
	 * @return ���������� �����
	 */
	public Font getSecondaryFont();	
}
