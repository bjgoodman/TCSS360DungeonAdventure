package model;

/**
 * Encapsulation quest item within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class QuestItemEncapsulation extends QuestItem {

	/** description for encapsulation pillar */
	private String MY_DESCRIPTION =  "Obtaining this jewel can boost a character's defense.";

	public QuestItemEncapsulation(String theItemName) {
		super(theItemName);
	}

	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		float DEFENSE = 1;
		float DEFENSE_MODIFIER = (float) 1.2;
		float PERCENT = 100;
		theUser.setMyDefense(theUser.getMyDefense() * DEFENSE_MODIFIER);
		System.out.println(theUser.getMyCharacterName() + "'s defense was raised by " +
				((DEFENSE_MODIFIER - DEFENSE) * PERCENT) + " %!");
	}

}
