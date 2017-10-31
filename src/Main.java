import javax.swing.UnsupportedLookAndFeelException;

import com.painter.view.PFrame;

public class Main
{
	public static void main(String[] args)
	{
		try
		{
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
			{
				if ("Nimbus".equals(info.getName()))
				{

					javax.swing.UIManager.setLookAndFeel(info.getClassName());

					break;
				}
			}

		}
		catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException ex)
		{
			java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		new PFrame();
	}
}