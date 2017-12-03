package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.painter.controller.PCommand;
import com.painter.model.Data;
import com.painter.view.PTabbedPane;

public class ActionUndoRedo implements ActionListener
{
	PTabbedPane tPane;
	PCommand cmd;
	Data data;
	
	public ActionUndoRedo(PCommand cmd, Data data)
	{
		this.cmd = cmd;
		this.data = data;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae)
	{
		String action = ae.getActionCommand();
		switch(action)
		{
			case "actionUndo":
				undo();
				break;
			case "actionRedo":
				redo();
				break;
//			case "actionOpenFromCloud":
//				openFromCloudTab();
//				break;
		}
	}

	private void undo()
	{
		// TODO Auto-generated method stub
		
	}
	
	private void redo()
	{
		// TODO Auto-generated method stub
		
	}
	
}
