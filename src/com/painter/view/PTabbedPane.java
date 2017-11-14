package com.painter.view;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.painter.controller.PCommand;
import com.painter.controller.PPanel;

public class PTabbedPane extends JTabbedPane
{
	public PCommand cmd;
	public PFrame frame;

	public PTabbedPane(PCommand cmd, PFrame frame) 
	{
		this.cmd = cmd;
		this.frame = frame;
		cmd.actionTabbedPane.setTPane(this);
//		cmd.actionNewFile.setTPane(this);
//		cmd.actionOpenFile.setTPane(this);
//		cmd.actionCloseFile.setTPane(this);
//		cmd.actionOpenFileFromCloud.setTPane(this);

		addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e)
			{
				PPanel panel = getCurrentPanel();
				if (panel != null)
					panel.subscribeListener();
			}
		});
	}

	public void addNewTab(String name)
	{
		PPanel pPanel = new PPanel(cmd);
		JScrollPane scrollPane = new JScrollPane(pPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addTab(name, scrollPane);
		cmd.getData().names.add(name);						//		!!!Õ¿œ–ﬂÃ”ﬁ !!! »«Ã≈Õ»“‹!!!
		cmd.getData().selectedIndex = cmd.getData().names.size() - 1;
		setSelectedIndex(cmd.getData().selectedIndex);
		cmd.actionUpdateStatusBar.actionPerformed(new ActionEvent(this, 0, "newFile"));
	}

	public void nextTab()
	{
		int index = getSelectedIndex();

		if (index == cmd.getData().names.size() - 1)
			return;
		setSelectedIndex(++index);
	}

	public void prevTab()
	{
		int index = getSelectedIndex();

		if (index == 0)
			return;
		setSelectedIndex(--index);
	}
	
	public void selectTab(String name)
	{
		for (int i = 0; i < cmd.getData().names.size(); i++)
			if (cmd.getData().names.get(i).equals(name))
			{
				setSelectedIndex(i);
				break;
			}
	}

	public PPanel getCurrentPanel()
	{
		Component c = getSelectedComponent();
		if (c == null)
			return null;
		JScrollPane sp = (JScrollPane)c;
		return (PPanel)sp.getViewport().getView();
	}

	public String returnCurrentFileName()
	{
		return cmd.getData().names.get(getSelectedIndex());
	}

	public void closeTab()
	{
		cmd.getData().names.remove(getSelectedIndex());
		removeTabAt(getSelectedIndex());
	}	
}