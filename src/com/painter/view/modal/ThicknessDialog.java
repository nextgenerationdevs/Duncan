package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.painter.model.Data;

public class ThicknessDialog extends JDialog implements ActionListener
{	
	Data data;
	JSlider slider;
	JLabel labelThicknessValue;
	JTextField fieldThicknessValue;
	
	private final static int widthOfThicknessDialog = 450;
	private final static int heightOfThicknessDialog = 150;
	
	public ThicknessDialog(Data data)
	{
		this.data = data;
		
		setTitle("Choosing default thickness...");
		
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfThicknessDialog) / 2, 
				 	 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfThicknessDialog) / 2);
		setSize(widthOfThicknessDialog, heightOfThicknessDialog);
		
		slider = new JSlider(0, 100, data.getThickness());
		
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		slider.addChangeListener(new ChangeListener() 
		{	
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				JSlider theSlider = (JSlider) e.getSource();
				
				int thicknessValue = theSlider.getValue();
				fieldThicknessValue.setText(""+thicknessValue);
				data.setThickness(thicknessValue);	
			}
		});
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		JPanel panelValue = new JPanel(gridBagLayout);
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5, 0, 5, 0);	
		labelThicknessValue = new JLabel("Thickness = ");
		panelValue.add(labelThicknessValue, c);
		
		c.gridx = 1;
		c.insets = new Insets(5, 0, 5, 15);	
		fieldThicknessValue = new JTextField(2);	
		fieldThicknessValue.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		fieldThicknessValue.setText(""+data.getThickness());
		panelValue.add(fieldThicknessValue, c);
		
		c.gridx = 2;
		c.insets = new Insets(5, 0, 5, 0);	
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(this);
		panelValue.add(btnOk, c);
	
		add(slider, BorderLayout.NORTH);
		add(panelValue);	
		
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