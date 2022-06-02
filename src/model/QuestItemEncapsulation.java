package model;

public class QuestItemEncapsulation extends QuestItem {

	private static String MY_DESCRIPTION = "PLACEHOLDER";

	public QuestItemEncapsulation(String theItemName) {
		super(theItemName, MY_DESCRIPTION);
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
