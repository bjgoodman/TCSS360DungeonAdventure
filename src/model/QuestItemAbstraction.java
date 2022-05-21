/* QuestItemAbstraction.java */

package model;

/**
 * Abstraction quest item within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class QuestItemAbstraction extends QuestItem {

	/** description for abstraction pillar */
	private String MY_DESCRIPTION = "Obtaining this jewel can boost a character's attack."
			+ "attack power.";

	/**
	 * Solidifies the name of the quest item
	 * 
	 * @param theItemName the name of the item
	 */
	public QuestItemAbstraction(String theItemName) {
		super(theItemName);
	}


	/**
	 * item will activate to boost the character's attack performance
	 * 
	 * @param theUser the character that the user selected for the game
	 */
	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		float ATTACK = 1;
		int ATTACK_MODIFIER = 2;
		float PERCENT = 80;
		theUser.setMyAttackDamageMax(theUser.getMyAttackDamageMax() * ATTACK_MODIFIER);
		System.out.println(theUser.getMyCharacterName() + "'s attack was raised by " +
				((ATTACK_MODIFIER - ATTACK) * PERCENT) + " %!");
	}

}
