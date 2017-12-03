package com.painter.view;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.painter.controller.PCommand;
import com.painter.controller.plugins.list.def.DefaultPlugin;
import com.painter.model.plugins.InterfaceFigure;
import com.painter.model.plugins.PluginsList;

public class PFigures extends JPanel
{
	PCommand cmd;
	
	public PFigures(PCommand cmd)
	{
		this.cmd = cmd;
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		JScrollPane scrollPane = new JScrollPane(new DefaultPlugin(0, 0).getPluginFigure(), JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	
		scrollPane.getViewport().setLayout(null);
		scrollPane.getViewport().setBackground(Color.WHITE);
		for (InterfaceFigure figure : PluginsList.getPlugins())
		{
			figure.setMainProperties(cmd.getData().type, cmd.getData().color, cmd.getData().thickness);
			JPanel panel = figure.getPluginFigure();		
			figure.setDragSource(panel);
			scrollPane.getViewport().add(panel);
		}
		scrollPane.add(new JPanel());
		
		
		
		add(scrollPane);
		
		setVisible(true);
	}
	
	public void redrawPanel()
	{
		revalidate();
		repaint();
	}
}
