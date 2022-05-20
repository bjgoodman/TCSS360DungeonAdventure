package model;

public class ItemPotion extends Item {
	private static final float FIFTY_PERCENT = (float) 0.5;

	/**
	 * Constructor for the class - solidifying the name of the item 
	 * 
	 * @param myItemName the name of the item
	 */
	public ItemPotion(String myItemName) {
		super(myItemName);
		setMyTargetable(false);
	}

	/**
	 * item will activate for the character to use 
	 * 
	 * @param theUser the character that the user selected for the game
	 */
	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		int potionVal = potionValue(theUser);
		theUser.setMyCurrentHitPoints(theUser.getMyCurrentHitPoints() + potionVal);
		System.out.println(theUser.getMyCharacterName() + " restored " + potionVal +
				" HP. " + theUser.getMyCharacterName() + "'s HP is now " +
				theUser.getMyCurrentHitPoints() + ".");
	}

	/**
	 * Dictates max value of the item to be used for the character
	 * 
	 * @param theUser the character that the user selected for the game
	 */
	private int potionValue(DungeonCharacter theUser) {
		return (int) Math.round(FIFTY_PERCENT * 
				(Math.floor(theUser.getMyHitPointsMax() - theUser.getMyCurrentHitPoints()))); 
	}
}
