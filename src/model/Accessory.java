/* Accessory.java */

package model;

/**
 * Characters receive equipment/accessory within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public abstract class Accessory {

	/** Name of the accessory */
	private String myAccessoryName;

	/** The slot number/position of the accessory */
	private int myAccessorySlot;

	/**
	 * Constructor for the class - solidifying the name of the accessory 
	 * 
	 * @param theAccessoryName the name of the accessory
	 */
	public Accessory(final String theAccessoryName) {
		setMyAccessoryName(myAccessoryName);
	}

	/**
	 * Dictates if the accessory will activate for the character to use 
	 * 
	 * @param theUser the character that the user selected for the game
	 */
	public abstract void accessoryEffectActivate(DungeonCharacter theUser);

	/**
	 * Retrieves the accessory
	 */
	public String getMyAccessoryName() {
		return myAccessoryName;
	}

	/**
	 * Solidifies the name of the accessory
	 * 
	 * @param theAccessoryName the name of the accessory
	 */
	public void setMyAccessoryName(final String theAccessoryName) {
		myAccessoryName = theAccessoryName;
	}

	/**
	 * Retrieves the accessory slot
	 */
	public int getMyAccessorySlot() {
		return myAccessorySlot;
	}

	/**
	 * Solidifies the slot of the accessory
	 * 
	 * @param theAccessorySlot the slot of the accessory
	 */
	public void setMyAccessorySlot(final int theAccessorySlot) {
		myAccessorySlot = theAccessorySlot;
	}
}
