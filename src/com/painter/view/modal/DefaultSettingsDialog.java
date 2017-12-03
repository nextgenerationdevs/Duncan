package com.painter.view.modal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.painter.model.Data;

public class DefaultSettingsDialog extends JDialog
{
	Data data;
	
	private final static int widthOfCreateNewFileDialog = 250;
	private final static int heightOfCreateNewFileDialog = 350;
	
	JPanel DefaultSettingsDialog;
	
	JLabel labelDefaultType;
	JComboBox typesBox;
	
	JLabel labelDefaultColor;
	JPanel colorPanel;
	JButton btnColorChooser;
	Color newColor;
		
	JLabel labelDefaultThickness;
	JTextField fieldDefaultThickness;
	JSlider slider;
	int thicknessValue;
	
	JButton btnOk;
	JButton btnApply;
	JButton btnCancel;
	
	public DefaultSettingsDialog(Data data) 
	{
		this.data = data;

		setTitle("DEFAULT SETTINGS");
		
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - widthOfCreateNewFileDialog) / 2, 
			 	 	 (Toolkit.getDefaultToolkit().getScreenSize().height - heightOfCreateNewFileDialog) / 2);
		setSize(widthOfCreateNewFileDialog, heightOfCreateNewFileDialog);
		
		initializeDefaultSettingsDialog();
		
		setModal(true);
		setResizable(false);
		setVisible(true);
	}

	private void initializeDefaultSettingsDialog()
	{
		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new GridLayout(1, 3, 10, 0));
		
		btnOk = new JButton(data.bundle.getString("controllButtonOk"));
		btnOk.setEnabled(false);
		btnOk.addActionListener(new SaveChangesOfModalWindow());
		controlPanel.add(btnOk);
		
		btnApply = new JButton(data.bundle.getString("controllButtonApply"));
		btnApply.setEnabled(false);
		btnApply.addActionListener(new ApplyChangesOfModalWindow()); 			
		controlPanel.add(btnApply);
		
		btnCancel = new JButton(data.bundle.getString("controllButtonCancel"));
		btnCancel.addActionListener(new CloseModalWindow()); 			
		controlPanel.add(btnCancel);
		add(controlPanel, BorderLayout.SOUTH);
		
		DefaultSettingsDialog = new JPanel();
		DefaultSettingsDialog.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(10, 5, 0, 5);
		labelDefaultType = new JLabel("Default Type: ");
		DefaultSettingsDialog.add(labelDefaultType, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(10, 0, 0, 5);
		String[] figuresList = { "Oval", "Rectangle", "Line", "RoundRect" };
		typesBox = new JComboBox(figuresList);
		typesBox.setSelectedIndex(0);
		typesBox.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				typesBox = (JComboBox)e.getSource();
				typesBox.setSelectedItem(typesBox.getSelectedItem().toString());		
			}
		});
		DefaultSettingsDialog.add(typesBox, c);
		
		c.gridx = 0;
		c.gridy++;
		c.gridheight = 2;
		c.insets = new Insets(30, 5, 0, 5);
		c.anchor = GridBagConstraints.LINE_START;
		labelDefaultColor = new JLabel("Default Color: ");
		DefaultSettingsDialog.add(labelDefaultColor, c);
		
		c.gridheight = 1;
		c.gridx = 1;
		c.ipadx = 30;
		c.ipady = 30;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(30, 5, 0, 0);
		colorPanel = new JPanel();
		colorPanel.setBorder(new EtchedBorder(10, Color.BLACK, null));
		colorPanel.setBackground(getDefaultColor());
		DefaultSettingsDialog.add(colorPanel, c);
		
		c.ipadx = 0;
		c.ipady = 0;
		c.gridx = 1;
		c.gridy++;
		c.insets = new Insets(2, 5, 0, 0);
		btnColorChooser = new JButton("Color");
		btnColorChooser.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				newColor = JColorChooser.showDialog(null, "Choosing default color...", new Color(data.getColor()));
				if(newColor != null)
				{
					colorPanel.setBackground(getDefaultColor());
				}
				if(newColor != new Color(data.getColor()))
				{
					btnApply.setEnabled(true);
				}
			}
		});
		DefaultSettingsDialog.add(btnColorChooser, c);
		
		c.anchor = GridBagConstraints.LINE_START;
		c.gridwidth = 1;
		c.gridx = 0;
		c.gridy++;
		c.insets = new Insets(30, 5, 0, 10);
		labelDefaultThickness = new JLabel("Default Thickness: ");
		DefaultSettingsDialog.add(labelDefaultThickness, c);
		
		c.gridx = 1;
		c.anchor = GridBagConstraints.CENTER;
		c.insets = new Insets(30, 5, 0, 0);
		fieldDefaultThickness = new JTextField(5);
		fieldDefaultThickness.setHorizontalAlignment((int) CENTER_ALIGNMENT);
		fieldDefaultThickness.setText(""+data.getThickness());
		DefaultSettingsDialog.add(fieldDefaultThickness, c);
		
		c.gridx = 0;
		c.gridy++;
		c.gridwidth = 2;
		c.insets = new Insets(5, 5, 5, 5);
		c.anchor = GridBagConstraints.LINE_START;
		c.insets = new Insets(5, 5, 10, 5);
		slider = new JSlider(0, 100, data.getThickness());	
		slider.setMajorTickSpacing(20);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);	
		slider.addChangeListener(new ChangeListener() 
		{	
			@Override
			public void stateChanged(ChangeEvent e) 
			{
				thicknessValue = ((JSlider)e.getSource()).getValue();
				if(thicknessValue != data.getThickness())
				{
					btnApply.setEnabled(true);
				}
				fieldDefaultThickness.setText(""+thicknessValue);
			}
		});
		DefaultSettingsDialog.add(slider, c);
		
		add(DefaultSettingsDialog, BorderLayout.CENTER);
	}
	
	private Color getDefaultColor()
	{
		Color ret;
		if (newColor == null)
		{
			ret = new Color(data.getColor());
		}
		else
		{
			ret = newColor;
		}	
		return ret;
	}
	
	class SaveChangesOfModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			if(thicknessValue > data.getThickness() || thicknessValue < data.getThickness())
			{
				data.setThickness(thicknessValue);
			}
			if(newColor != new Color(data.getColor()) & newColor != null)
			{
				data.setColor(newColor.getRGB());
				data.setThickness(thicknessValue);
			}		
			dispose();
		}
	}
	
	class ApplyChangesOfModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			btnOk.setEnabled(true);
		}
	}
	
	class CloseModalWindow implements ActionListener 
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{
			dispose();
		}
	}
}