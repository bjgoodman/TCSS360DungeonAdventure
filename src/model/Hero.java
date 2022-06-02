package model;

public abstract class Hero extends DungeonCharacter {
	
	private QuestItem[] myQuestItems = new QuestItem[4];
	
	public Hero(String theName, String theDescription, char theRepresentingCharacter, String theCharacterType,
			int theHP, int theADMax, int theADMin, float theAttackSpeed, float theAttackChance, float theAbilityChance,
			float theDefense, float theBlockChance, String theAbility1) {
		super(theName, theDescription, theRepresentingCharacter, theCharacterType, theHP, theADMax, theADMin, theAttackSpeed,
				theAttackChance, theAbilityChance, theDefense);
		super.setMyAbility1(theAbility1);

	}



	public QuestItem[] getMyQuestItems() {
		return myQuestItems;
	}

	public void setMyQuestItems(QuestItem[] myQuestItems) {
		this.myQuestItems = myQuestItems;
	}

	public void move(DIRECTION dir) {
		if (dir == DIRECTION.NORTH) {
			this.increaseY();
		} else if (dir == DIRECTION.SOUTH) {
			this.decreaseY();
		} else if (dir == DIRECTION.EAST) {
			this.increaseX();
		} else  {
			this.decreaseY();
		}
	}

}
