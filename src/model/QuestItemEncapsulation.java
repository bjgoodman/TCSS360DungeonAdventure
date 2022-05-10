package model;

public class QuestItemEncapsulation extends QuestItem {
	
	public QuestItemEncapsulation(String theItemName) {
		super(theItemName);
	}

	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		float DEFENSE = 1;
		float DEFENSE_MODIFIER = (float) 1.2;
		float PERCENT = 100;
		theUser.setMyDefense(theUser.getMyDefense() * DEFENSE_MODIFIER);
		System.out.println(theUser.getMyCharacterName() + "'s defense was raised by " + ((DEFENSE_MODIFIER - DEFENSE) * PERCENT) +
				" %!");
	}

}
