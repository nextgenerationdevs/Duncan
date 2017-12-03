<<<<<<< HEAD
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.painter.model.lang.LanguageFactory;
import com.painter.view.PFrame;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{

					UIManager.setLookAndFeel(info.getClassName());

					break;
				}
			}

		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		LanguageFactory.updateLanguages();
		new PFrame();
	}
=======
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.painter.model.lang.LanguageFactory;
import com.painter.view.PFrame;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}

		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
		LanguageFactory.updateLanguages();
		new PFrame();
	}
>>>>>>> branch 'master' of https://github.com/nextgenerationdevs/Duncan.git
}