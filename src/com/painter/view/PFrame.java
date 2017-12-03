<<<<<<< HEAD
package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import com.painter.controller.PCommand;
import com.painter.model.Data;
import com.painter.model.Images;

public class PFrame extends JFrame
{
	public PTabbedPane tpane;
	public PStatusBar statusBar;
	public PSidePanel sidePanel;
	public PToolBar toolBar;

	PCommand cmd;
	Data data;
	public PMenu menuBar;

	public PFrame()
	{
		data = new Data();
		cmd = new PCommand(data, this);

		setTitle("Duncan");		
		setIconImage(Images.getIcon());		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(1366, 768);
		//		setLocationRelativeTo(null);
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - 1366) / 2, 
					 (Toolkit.getDefaultToolkit().getScreenSize().height - 768) / 2);

		//		getContentPane().setBackground(Color.GRAY);
		menuBar = new PMenu(data, cmd);			
		setJMenuBar(menuBar);

		toolBar = new PToolBar(cmd);
		add(toolBar, BorderLayout.NORTH);		

		statusBar = new PStatusBar("Coordinates", "Path to file");
		add(statusBar, BorderLayout.SOUTH);

		sidePanel = new PSidePanel(cmd);
		add(sidePanel);

		tpane = new PTabbedPane(cmd, this, toolBar);
		add(tpane, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();	
		leftPanel.setLayout(new GridLayout(2,1));
		add(leftPanel, BorderLayout.WEST);
		
		PTreePanel treePanel = new PTreePanel(cmd);
		//getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		leftPanel.add(treePanel);
		
		PSidePanel sidePanel = new PSidePanel(cmd);
		leftPanel.add(sidePanel);
		
		setResizable(true);
		setMinimumSize(new Dimension(1366, 768));

		setVisible(true);
	}

	public void refreshFrame()
	{
		System.out.println("перерисовка фрейма");
		dispose();
//		invalidate();
//		repaint();
		new PFrame().setVisible(true);
	}
=======
package com.painter.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.util.Enumeration;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.painter.controller.PCommand;
import com.painter.controller.listeners.ActionSaveFile;
import com.painter.model.Data;
import com.painter.model.Images;

public class PFrame extends JFrame
{
	public PTabbedPane tpane;
	public PStatusBar statusBar;
	public PSidePanel sidePanel;
	public PToolBar toolBar;

	public PCommand cmd;
	public Data data;
	public PMenu menuBar;
	
	public PFrame()
	{
		data = new Data();
		cmd = new PCommand(data, this);

		setTitle(data.bundle.getString("actionFrameTitle"));
		
		setIconImage(Images.getIcon());		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		setSize(1366, 768);
		//		setLocationRelativeTo(null);
		setLocation( (Toolkit.getDefaultToolkit().getScreenSize().width - 1366) / 2, 
					 (Toolkit.getDefaultToolkit().getScreenSize().height - 768) / 2);

		//		getContentPane().setBackground(Color.GRAY);
		menuBar = new PMenu(data, cmd);			
		setJMenuBar(menuBar);

		toolBar = new PToolBar(cmd);
		add(toolBar, BorderLayout.NORTH);		

		statusBar = new PStatusBar("Coordinates", "Path to file");
		add(statusBar, BorderLayout.SOUTH);

		sidePanel = new PSidePanel(cmd);
		add(sidePanel);

		tpane = new PTabbedPane(cmd, this, toolBar);
		add(tpane, BorderLayout.CENTER);

		JPanel leftPanel = new JPanel();	
		leftPanel.setLayout(new GridLayout(2,1));
		add(leftPanel, BorderLayout.WEST);
		
		PTreePanel treePanel = new PTreePanel(cmd);
		leftPanel.add(treePanel);
		
		PSidePanel sidePanel = new PSidePanel(cmd);
		leftPanel.add(sidePanel);
		
		setResizable(false);
		setMinimumSize(new Dimension(1366, 768));
		
		setVisible(true);
	}

	public void repaintMLJComponents() 
	{
		System.out.println("перерисовка фрейма");
		Vector<JComponent> validate = recursiveFindMLJComponents(this);
		for (Enumeration<JComponent> e = validate.elements(); e.hasMoreElements();) 
		{
			JComponent jcomp = (JComponent)e.nextElement();
			System.out.println(jcomp.getRootPane().getName());
			jcomp.revalidate();
		}
		
		for (Component component: this.getComponents())
		{
			System.out.println(component.getName());
			component.revalidate();
		}
	}

	private Vector<JComponent> recursiveFindMLJComponents(Container root) 
	{
		//java.awt.Container.getComponents() doesn't return null!
		Component[] tmp = root.getComponents();
		
		Vector<JComponent> v = new Vector<JComponent>();
		for (int i = 0; i < tmp.length; i++) 
		{		
			if (tmp[i] instanceof JComponent) 
			{
				JComponent jcomp = (JComponent)tmp[i];
				if (jcomp.getComponentCount() == 0) 
				{
					v.add(jcomp);
				}
				else 
				{
					v.addAll(recursiveFindMLJComponents(jcomp));
				}
			}
			else if (tmp[i] instanceof Container) 
			{
				v.addAll(recursiveFindMLJComponents((Container)tmp[i]));
			}
		}
		return v;
	}
	
	
	
		
//		JOptionPane.showMessageDialog
//		btnConfirm2.addActionListener(new ActionListener() {
//	        public void actionPerformed(ActionEvent e) {
//	            JOptionPane.showConfirmDialog(JOptionPaneTest.this,
//	                                          "Вы не отказываетесь?",
//	                                          TITLE_confirm,
//	                                          JOptionPane.YES_NO_OPTION,
//	                                          JOptionPane.WARNING_MESSAGE);
//	    }});
		
//		setVisible(false);
//		for(Component component: getComponents())
//		{
//			//this.removeAll();
//			menuBar.revalidate();
//			menuBar.repaint();
//			this.revalidate();
//			this.repaint();
//		}
//		setVisible(true);
//		dispose();
//		invalidate();
//		repaint();
//		new PFrame();
//	}
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}