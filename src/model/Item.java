/* Item.java */

package model;

/**
 * Characters receive items within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public abstract class Item {

	/* the name of the item */
	private String myItemName;

	/** the slot number/position of the item */
	private int myItemSlot;

	/** the target for the item */
	private boolean myTargetable;

	/**
	 * Constructor for the class - solidifying the name of the item 
	 * 
	 * @param myItemName the name of the accessory
	 */
	public Item(final String myItemName) {
		setMyItemName(myItemName);
	}

	/**
	 * item will activate for the character to use 
	 * 
	 * @param theUser the character that the user selected for the game
	 */
	public abstract void itemEffectActivate(DungeonCharacter theUser);

	/**
	 * Retrieves the item
	 */
	public String getMyItemName() {
		return myItemName;
	}

	/**
	 * Solidifies the name of the item
	 * 
	 * @param theAccessoryName the name of the item
	 */
	public void setMyItemName(final String theItemName) {
		myItemName = theItemName;
	}

	/**
	 * Retrieves the item slot
	 */
	public int getMyItemSlsot() {
		return myItemSlot;
	}

	/**
	 * Solidifies the slot of the item
	 * 
	 * @param theAccessorySlot the slot of the accessory
	 */
	public void setMyItemSlot(final int theItemSlot) {
		myItemSlot = theItemSlot;
	}

	/**
	 * Retrieves the item's target
	 */
	public boolean isTargetable() {
		return myTargetable;
	}

	/**
	 * Solidifies the target of the item
	 * 
	 * @param theTargetable the target of the item
	 */
	public void setMyTargetable(final boolean theTargetable) {
		myTargetable = theTargetable;
	}

}
