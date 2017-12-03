package com.painter.view;

import java.awt.Component;
import java.awt.event.ActionEvent;

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
	public PToolBar toolBar;

	public PTabbedPane(PCommand cmd, PFrame frame, PToolBar toolBar) 
	{
		this.cmd = cmd;
		this.frame = frame;
		this.toolBar = toolBar;
		cmd.actionTabbedPane.setTPane(this);

		addChangeListener(new ChangeListener()
		{

			@Override
			public void stateChanged(ChangeEvent e)
			{
				PPanel panel = getCurrentPanel();
				if (panel != null)
				{
					panel.subscribeListener();
					if (cmd.getData().names.size() > 0)
					{
						cmd.getData().selectedIndex = getSelectedIndex();
						cmd.actionUpdateStatusBar.actionPerformed(new ActionEvent(this, 0, "updateFile"));
					}
				}
			}
		});
	}

	public void addNewTab(String name)
	{
		PPanel pPanel = new PPanel(cmd);
		JScrollPane scrollPane = new JScrollPane(pPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		addTab(name, scrollPane);
		cmd.getData().names.add(name);						//		!!!�������� !!! ��������!!!
		cmd.getData().selectedIndex = cmd.getData().names.size() - 1;
		setSelectedIndex(cmd.getData().selectedIndex);
		if (cmd.getData().names.size() > 1)
		{
			toolBar.buttonNextTab.setEnabled(true);
			toolBar.buttonPrevTab.setEnabled(true);
		}
		cmd.actionUpdateStatusBar.actionPerformed(new ActionEvent(this, 0, "updateFile"));
	}

	public void nextTab()
	{
		int index = getSelectedIndex();

		if (index >= cmd.getData().names.size() - 1)
			return;
		setSelectedIndex(++index);
	}

	public void prevTab()
	{
		int index = getSelectedIndex();

		if (index <= 0)
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
		if (getSelectedIndex() < 0)
		{
			return;
		}
		if (getSelectedIndex() < 2)
		{
			toolBar.buttonNextTab.setEnabled(false);
			toolBar.buttonPrevTab.setEnabled(false);
		}
		cmd.getData().names.remove(getSelectedIndex());
		removeTabAt(getSelectedIndex());
		if (cmd.getData().names.size() == 0)
		{
			cmd.actionUpdateStatusBar.actionPerformed(new ActionEvent(this, 0, "setToZeroStatusBar"));
		}
	}	
}