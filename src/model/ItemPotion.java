package model;

public class ItemPotion extends Item {
	private static final float FIFTY_PERCENT = (float) 0.5;

	public ItemPotion(String myItemName) {
		super(myItemName);
		setMyReusable(false);
		setMyTargetable(false);
	}

	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		int potionVal = potionValue(theUser);
		theUser.setMyCurrentHitPoints(theUser.getMyCurrentHitPoints() + potionVal);
		System.out.println(theUser.getMyCharacterName() + " restored " + potionVal + " HP. " 
				+ theUser.getMyCharacterName() + "'s HP is now " + theUser.getMyCurrentHitPoints() + ".");
	}

	private int potionValue(DungeonCharacter theUser) {
		return (int) Math.round(FIFTY_PERCENT * 
				(Math.floor(theUser.getMyHitPointsMax() - theUser.getMyCurrentHitPoints()))); 
	}
}
