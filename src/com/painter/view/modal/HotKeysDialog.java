package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import com.painter.controller.PPanel;
import com.painter.model.Data;
import com.painter.view.PFrame;
import com.painter.view.modal.hot_keys_model.HotKeysImpl;
import com.painter.view.modal.hot_keys_model.HotKeysTableModel;

public class HotKeysDialog extends JDialog implements ActionListener
{	
	public HotKeysDialog()
	{
		setTitle("Hot keys");
		
		HotKeysImpl hotKeysImpl = new HotKeysImpl();
		JTable mainTable = new JTable(new HotKeysTableModel(hotKeysImpl));   
        mainTable.setRowHeight(20);
		
		JPanel pp = new JPanel();
		int width = mainTable.getColumnModel().getColumnCount() * 175;
		int height = mainTable.getRowCount() * 20;
		int x = pp.getToolkit().getScreenSize().width / 2 - width / 2;
		int y = pp.getToolkit().getScreenSize().height / 2 - height / 2;
		setLocation(x, y);
		setSize(width, height);
		setModal(true);
		setResizable(false);
        
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        mainTable.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        
        Box contents = new Box(BoxLayout.Y_AXIS);
        contents.add(new JScrollPane(mainTable));
        getContentPane().add(contents);
        
		JButton button = new JButton("Cancel");
		button.addActionListener(this); 
		add(button, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();	
	}		
}