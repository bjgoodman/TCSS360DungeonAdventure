/* DungeonAdventureMain.java */

package application;

import controller.DungeonAdventureGUI;
import java.awt.EventQueue;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * A dungeon adventure game. Choose a Hero, fight Enemies, find the Pillars of OO.
 * 
 * @author Chris Nichol
 * @version Spring 2022
 */
public final class DungeonAdventureMain {
	
	/**
	 * Private constructor. Prevents instantiation.
	 * 
	 * @throws IllegalStateException when the constructor is called
	 */
	private DungeonAdventureMain() {
		throw new IllegalStateException();
	}
	
	/**
	 * Main method. Starts the game.
	 * 
	 * @param theArgs ignored
	 */
	public static void main(final String[] theArgs) {
		try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        } catch (final UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (final IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (final InstantiationException ex) {
            ex.printStackTrace();
        } catch (final ClassNotFoundException ex) {
            ex.printStackTrace();
        }
		
		EventQueue.invokeLater(DungeonAdventureGUI::generateGUI);
	}
}