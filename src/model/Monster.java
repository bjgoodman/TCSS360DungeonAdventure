package model;

/**
 * Defines abstract behaviors for Monsters.
 */
public abstract class Monster extends DungeonCharacter {
	
	private float myHealChance;
	private float myAbilityChance;

	/**
	 * Constructor for Monsters.
	 *
	 * @param theName The name of the Monster
	 * @param theDungeon The dungeon in which the Monster resides
	 */
	public Monster(String theName, Dungeon theDungeon) {
		super(theName, theDungeon);
	}

	/**
	 * A helper method to aid in Monster construction.
	 *
	 * @param theCharacterDescription The character description of the Monster
	 * @param theCharacterType The character type of the Monster
	 * @param theCharacterRepresentation The character representation of the Monster
	 * @param theAbility The ability of the Monster
	 * @param theHitPointsMax The max hit points of the Monster
	 * @param theAttackDamageMin The minimum attack damage of the Monster
	 * @param theAttackDamageMax The maximum attack damage of the Monster
	 * @param theChanceToHit The hit chance of the Monster
	 * @param theAbilityChance The ability chance of the Monster
	 * @param theHealChance The heal chance of the Monster
	 */
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

	/**
	 * Retrieves the heal chance of the Monster.
	 *
	 * @return the heal chance
	 */
	public final float getMyHealChance() {
		return myHealChance;
	}

	/**
	 * Sets the heal chance of the Monster.
	 *
	 * @param myHealChance The heal chance
	 */
	public final void setMyHealChance(float myHealChance) {
		this.myHealChance = myHealChance;
	}

	/**
	 * Retrieves the ability chance of the Monster.
	 *
	 * @return the ability chance
	 */
	@Override
	public float getMyAbilityChance() {
		return myAbilityChance;
	}

	/**
	 * Sets the ability chance of the Monster.
	 *
	 * @param myAbilityChance The ability chance
	 */
	@Override
	public void setMyAbilityChance(float myAbilityChance) {
		this.myAbilityChance = myAbilityChance;
	}
}
