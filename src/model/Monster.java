package model;

public abstract class Monster extends DungeonCharacter {
	
	private float myHealChance;
	private float myAbilityChance;
	
	public Monster(String theName, Dungeon theDungeon) {
		super(theName, theDungeon);
	}

	public void constructionHelper (final String theCharacterDescription,
									final String theCharacterType, final char theCharacterRepresentation,
									final String theAbility, final int theHitPointsMax, final int theAttackDamageMin,
									final int theAttackDamageMax, final float theChanceToHit, final float theAbilityChance,
									float theHealChance) {

		setMyCharacterDescription(theCharacterDescription);
		setMyCharacterType(theCharacterType);
		setMyCharacterRepresentation(theCharacterRepresentation);
		setMyAbility(theAbility);
		setMyHitPointsMax(theHitPointsMax);
		setMyCurrentHitPoints(theHitPointsMax);
		setMyAttackDamageMin(theAttackDamageMin);
		setMyAttackDamageMax(theAttackDamageMax);
		setMyChanceToHit(theChanceToHit);
		setMyAbilityChance(theAbilityChance);
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
