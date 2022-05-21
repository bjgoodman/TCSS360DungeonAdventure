/* QuestItemInheritance.java */

package model;

/**
 * Inheritance quest item within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class QuestItemInheritance extends QuestItem {

	/** description for inheritance pillar */
	private String MY_DESCRIPTION =  "Obtaining this jewel can boost a character's speed.";


	/**
	 * Solidifies the name of the quest item
	 * 
	 * @param theItemName the name of the item
	 */
	public QuestItemInheritance(String theItemName) {
		super(theItemName);
	}

	/**
	 * item will activate to boost the character's speed
	 * 
	 * @param theUser the character that the user selected for the game
	 */
	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		float SPEED = 4;
		float SPEED_MODIFIER = (float) 1.5;
		float PERCENT = 75;
		theUser.setMyAttackSpeed(theUser.getMyDefense() * SPEED_MODIFIER);
		System.out.println(theUser.getMyCharacterName() + "'s speed was raised by " +
				((SPEED_MODIFIER - SPEED) * PERCENT) + " %!");
	}

}
