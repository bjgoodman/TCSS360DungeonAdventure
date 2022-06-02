package model;

public abstract class Monster extends DungeonCharacter {
	
	private float myHealChance;
	private float myAbilityChance;
	
	public Monster(String theName, String theDescription, char theRepresentingCharacter, String theCharacterType,
			int theHP, int theADMax, int theADMin, float theAttackSpeed, float theAttackChance, float theAbilityChance,
			float theDefense, float theHealChance, String theAbility1) {
		super(theName, theDescription, theRepresentingCharacter, theCharacterType, theHP, theADMax, theADMin, theAttackSpeed,
				theAttackChance, theAbilityChance, theDefense);
		super.setMyAbility1(theAbility1);
		setMyHealChance(theHealChance);
	}

	public final float getMyHealChance() {
		return myHealChance;
	}

	public final void setMyHealChance(float myHealChance) {
		this.myHealChance = myHealChance;
	}

	@Override
	public float getMyAbilityChance() {
		return myAbilityChance;
	}

	@Override
	public void setMyAbilityChance(float myAbilityChance) {
		this.myAbilityChance = myAbilityChance;
	}
}
