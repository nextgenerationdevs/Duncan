package com.painter.controller.listeners;

import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetAdapter;
import java.awt.dnd.DropTargetDropEvent;
import java.io.IOException;

import com.painter.controller.PCommand;
import com.painter.controller.PPanel;
import com.painter.model.plugins.InterfaceFigure;

public class DropTargetListener extends DropTargetAdapter
{
	PPanel panel;
	PCommand cmd;
	DropTarget target;
	
	public DropTargetListener(PCommand cmd)
	{
		this.cmd = cmd;
		target = new DropTarget(panel, DnDConstants.ACTION_COPY, this);
	}
	
	public void setPPanel(PPanel panel)
	{
		this.panel = panel;
		target = new DropTarget(panel, DnDConstants.ACTION_COPY, this);
	}
	
	@Override
	public void drop(DropTargetDropEvent dtde)
	{		
		try
		{
			Transferable tr = dtde.getTransferable();
			InterfaceFigure figure = (InterfaceFigure) tr.getTransferData(tr.getTransferDataFlavors()[0]);
			
			if (dtde.isDataFlavorSupported(tr.getTransferDataFlavors()[0]))
			{
				dtde.acceptDrop(DnDConstants.ACTION_COPY);
				figure.setMainProperties(cmd.getData().type, cmd.getData().color, cmd.getData().thickness);	
				figure.move(dtde.getLocation().x, dtde.getLocation().y);				
				panel.figures.add(figure);
				panel.initialize();
				dtde.dropComplete(true);
			}
			dtde.rejectDrop();
		} catch (UnsupportedFlavorException | IOException e)
		{
			e.printStackTrace();
		}
	}

}
