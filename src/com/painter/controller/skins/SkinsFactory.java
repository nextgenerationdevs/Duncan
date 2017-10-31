package com.painter.controller.skins;

import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.jtattoo.plaf.luna.LunaLookAndFeel;
import com.painter.view.PFrame;

public class SkinsFactory {

	public void skinsActionPerformed(ActionEvent evt, PFrame frame, String key) {
		try {

			UIManager.setLookAndFeel((LookAndFeel) setSkins(key));
			SwingUtilities.updateComponentTreeUI(frame);
		} catch (/*ClassNotFoundException | InstantiationException | IllegalAccessException
				|*/ UnsupportedLookAndFeelException ex) {
			Logger.getLogger(SkinsFactory.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public Object setSkins(String key) {
		Object s = null;
		switch (key) {
		case "Luna":
			 s = new LunaLookAndFeel();
//			s = "com.jtattoo.plaf.luna.LunaLookAndFeel";
			break;
		case "Aero":
			s = "com.jtattoo.plaf.aero.AeroLookAndFeel";
			break;
		case "Aluminium":
			// s = new AluminiumLookAndFeel();
			s = "com.jtattoo.plaf.aluminium.AluminiumLookAndFeel";
			break;
		case "Nimbus":
			s = "javax.swing.plaf.nimbus.NimbusLookAndFeel";
			break;
		case "Graphite":
			s = "com.jtattoo.plaf.graphite.GraphiteLookAndFeel";
			break;
		case "Metal":
			s = "javax.swing.plaf.metal.MetalLookAndFeel";
			break;
		case "Bernstein":
			s = "com.jtattoo.plaf.bernstein.BernsteinLookAndFeel";
			break;
		case "Fast":
			s = "com.jtattoo.plaf.fast.FastLookAndFeel";
			break;
		case "HiFi":
			s = "com.jtattoo.plaf.hifi.HiFiLookAndFeel";
			break;
		case "McWin":
			s = "com.jtattoo.plaf.mcwin.McWinLookAndFeel";
			break;
		case "Mint":
			s = "com.jtattoo.plaf.mint.MintLookAndFeel";
			break;
		case "Noire":
			s = "com.jtattoo.plaf.noire.NoireLookAndFeel";
			break;
		case "Smart":
			s = "com.jtattoo.plaf.smart.SmartLookAndFeel";
			break;
		case "Texture":
			s = "com.jtattoo.plaf.texture.TextureLookAndFeel";
			break;
		case "BlackStar":
			s = "de.javasoft.plaf.synthetica.SyntheticaBlackStarLookAndFeel";
			break;
		case "BlackMoon":
			s = "de.javasoft.plaf.synthetica.SyntheticaBlackMoonLookAndFeel";
			break;
		case "BlueIce":
			s = "de.javasoft.plaf.synthetica.SyntheticaBlueIceLookAndFeel";
			break;
		case "Autumn":
			s = "org.jvnet.substance.skin.SubstanceAutumnLookAndFeel";
			break;
		case "MistAqua":
			s = "org.jvnet.substance.skin.SubstanceMistAquaLookAndFeel";
			break;
		case "Classy":
			s = "de.javasoft.plaf.synthetica.SyntheticaClassyLookAndFeel";
			break;
		case "BlackSteel":
			s = "org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel";
			break;
		case "Magma":
			s = "org.jvnet.substance.skin.SubstanceMagmaLookAndFeel";
			break;
		case "ChallengerDeep":
			s = "org.jvnet.substance.skin.SubstanceChallengerDeepLookAndFeel";
			break;
		case "EmeraldDusk":
			s = "org.jvnet.substance.skin.SubstanceEmeraldDuskLookAndFeel";
			break;
		case "MistSilver":
			s = "org.jvnet.substance.skin.SubstanceMistSilverLookAndFeel";
			break;
		case "GraphiteGlass":
			s = "org.jvnet.substance.skin.SubstanceRavenGraphiteGlassLookAndFeel";
			break;

		default:
			break;
		}
		return s;
	}
}

