package model;

public abstract class Monster extends DungeonCharacter {
	
	private float myHealChance;
	private float myAbilityChance;
	
	public Monster(String theName, String theDescription, char theRepresentingCharacter, String theCharacterType) {
		super(theName, theDescription, theRepresentingCharacter, theCharacterType);
		super.setMyAbility(theAbility);
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
