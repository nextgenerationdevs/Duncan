package com.painter.controller.skins;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import org.jvnet.substance.skin.SubstanceAutumnLookAndFeel;
import org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel;
import org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel;
import org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel;
import org.jvnet.substance.skin.SubstanceMagmaLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel;
import org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel;
import org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.graphite.GraphiteLookAndFeel;
import com.jtattoo.plaf.hifi.HiFiLookAndFeel;
import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.jtattoo.plaf.mcwin.McWinLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.noire.NoireLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.jtattoo.plaf.texture.TextureLookAndFeel;
import com.painter.model.skins.InterfaceSkin;
import com.painter.view.PFrame;

import de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel;
import de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel;

public class SkinsFactory implements InterfaceSkin
{

	public void skinsActionPerformed(ActionEvent evt, PFrame frame, String key)
	{
		try
		{

			UIManager.setLookAndFeel((LookAndFeel) setSkins(key));
			SwingUtilities.updateComponentTreeUI(frame);
		}
		catch (UnsupportedLookAndFeelException ex)
		{
			Logger.getLogger(SkinsFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Object setSkins(String key)
	{
		Object s = null;
		try
		{
			switch (key)
			{
				case "Luna":
					s = new LunaLookAndFeel();
					break;
				case "Aero":
					s = new AeroLookAndFeel();
					break;
				case "Aluminium":
					s = new AluminiumLookAndFeel();
					break;
				case "Nimbus":
					s = new NimbusLookAndFeel();
					break;
				case "Graphite":
					s = new GraphiteLookAndFeel();
					break;
				case "Metal":
					s = new MetalLookAndFeel();
					break;
				case "Bernstein":
					s = new BernsteinLookAndFeel();
					break;
				case "Fast":
					s = new FastLookAndFeel();
					break;
				case "HiFi":
					s = new HiFiLookAndFeel();
					break;
				case "McWin":
					s = new McWinLookAndFeel();
					break;
				case "Mint":
					s = new MintLookAndFeel();
					break;
				case "Noire":
					s = new NoireLookAndFeel();
					break;
				case "Smart":
					s = new SmartLookAndFeel();
					break;
				case "Texture":
					s = new TextureLookAndFeel();
					break;
				case "BlackStar":
					s = new SyntheticaBlackStarLookAndFeel();
					break;
				case "BlackMoon":
					s = new SyntheticaBlackMoonLookAndFeel();
					break;
				case "BlueIce":
					s = new SyntheticaBlueIceLookAndFeel();
					break;
				case "Autumn":
					s = new SubstanceAutumnLookAndFeel();
					break;
				case "MistAqua":
					s = new SubstanceMistAquaLookAndFeel();
					break;
				case "Classy":
					s = new SyntheticaClassyLookAndFeel();
					break;
				case "BlackSteel":
					s = new SubstanceBusinessBlackSteelLookAndFeel();
					break;
				case "Magma":
					s = new SubstanceMagmaLookAndFeel();
					break;
				case "ChallengerDeep":
					s = new SubstanceChallengerDeepLookAndFeel();
					break;
				case "EmeraldDusk":
					s = new SubstanceEmeraldDuskLookAndFeel();
					break;
				case "MistSilver":
					s = new SubstanceMistSilverLookAndFeel();
					break;
				case "GraphiteGlass":
					s = new SubstanceRavenGraphiteGlassLookAndFeel();
					break;

				default:
					break;
			}
		}
		catch (ParseException ex)
		{
			Logger.getLogger(SkinsFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
		return s;
	}

	@Override
	public void updateLookAndFeel(String var1)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateTheme(String var1)
	{
		// TODO Auto-generated method stub
		
	}
}
