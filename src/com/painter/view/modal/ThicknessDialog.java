package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.painter.model.Data;

public class ThicknessDialog extends JDialog implements ActionListener
{	
	Data data;
	JSlider slider = new JSlider();
	
	private final static int widthOfThicknessDialog = 300;
	private final static int heightOfThicknessDialog = 100;
	
	public ThicknessDialog(Data data)
	{
		this.data = data;
		
		setTitle("Choosing default thickness...");
		
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfThicknessDialog) / 2, 
				 	 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfThicknessDialog) / 2);
		setSize(widthOfThicknessDialog, heightOfThicknessDialog);	
		
		slider.setMinimum(1);
		slider.setMaximum(100);
		
		slider.addChangeListener(new ChangeListener() 
		{	
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				JSlider theSlider = (JSlider) e.getSource();
				data.setThickness(theSlider.getValue());	
			}
		});
		
		add(slider, BorderLayout.NORTH);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		add(btnOk, BorderLayout.SOUTH);
		
		pack();
		setModal(true);
		setResizable(false);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		dispose();
	}
}