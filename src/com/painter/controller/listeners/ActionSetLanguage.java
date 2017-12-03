<<<<<<< HEAD
package com.painter.controller.listeners;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ResourceBundle;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.view.PFrame;
import com.painter.view.PMenu;

public class ActionSetLanguage implements ActionListener 
{
	Data data;
	PFrame frame;
	
	public ActionSetLanguage(Data data, PFrame frame)
	{
		this.data = data;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		for (InterfaceBundle language : LanguageFactory.bundles)
		{
			if (str.equals(language.getName()))
			{
				language.setStatus(true); 
				System.out.println(language.getName() + " status = " + language.getStatus());
			}
			else
			{
				language.setStatus(false);
				System.out.println(language.getName() + " status = " + language.getStatus());
			}
		}
		data.bundle = LanguageFactory.activeLanguage();	
		frame.refreshFrame();
	}
=======
package com.painter.controller.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import com.painter.model.Data;
import com.painter.model.lang.InterfaceBundle;
import com.painter.model.lang.LanguageFactory;
import com.painter.view.PFrame;

public class ActionSetLanguage implements ActionListener 
{
	Data data;
	PFrame frame;
	
	public ActionSetLanguage(Data data, PFrame frame)
	{
		this.data = data;
		this.frame = frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String str = e.getActionCommand();

		for (InterfaceBundle language : LanguageFactory.bundles)
		{
			if (str.equals(language.getName()))
			{
				language.setStatus(true);
				System.out.println(language.getName() + " status = " + language.getStatus());
			}
			else
			{
				language.setStatus(false);
				System.out.println(language.getName() + " status = " + language.getStatus());
			}
		}
		createNewFrame();	
	}
	
	private void createNewFrame()
	{
		String confirmTitle = data.bundle.getString("confirm_title");
		String confirmMessage = data.bundle.getString("actionSessionClosed");
		int confirmResult = JOptionPane.showConfirmDialog(null, confirmMessage, confirmTitle, JOptionPane.OK_CANCEL_OPTION);
		if (confirmResult == JOptionPane.OK_OPTION) 
		{
			// сначала сохранение!
			System.out.println("отработало сохранение");
			frame.dispose();
			new PFrame();
		}
		else if (confirmResult == JOptionPane.CANCEL_OPTION) 
		{
			String warningTitle = data.bundle.getString("warning_title");
			String warningMessage = data.bundle.getString("areYouSureForSession");
			int warningResult = JOptionPane.showConfirmDialog(null, warningMessage, warningTitle, JOptionPane.YES_NO_OPTION);
			if (warningResult == JOptionPane.YES_OPTION) 
			{
				frame.dispose();
				new PFrame();
			} 
		} 
	}
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}