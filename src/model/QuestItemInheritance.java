package model;

public class QuestItemInheritance extends QuestItem {
	/** description for inheritance pillar */
	private String MY_DESCRIPTION =  "Obtaining this jewel can boost a character's speed.";


	public QuestItemInheritance(String theItemName) {
		super(theItemName);
	}

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
