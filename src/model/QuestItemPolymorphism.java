package model;

/**
 * Polymorphism quest item within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class QuestItemPolymorphism extends QuestItem { // character buff to obtain enemies/bosses abilities.

	/** description for abstraction pillar */
	private String MY_DESCRIPTION =  "Obtaining this jewel can increase a character's " +
			"chance to hit their attacks.";

	public QuestItemPolymorphism(String theItemName) {
		super(theItemName);
	}

	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		float ATTACK_CHANCE = 2;
		float ATTACK_CHANCE_MODIFIER = (float) 1.2;
		float PERCENT = 100;

		theUser.setMyChanceToHit(theUser.getMyDefense() * ATTACK_CHANCE_MODIFIER);
		System.out.println(theUser.getMyCharacterName() + "'s defense was raised by " +
				((ATTACK_CHANCE_MODIFIER - ATTACK_CHANCE) * PERCENT) + " %!");
	}

}
