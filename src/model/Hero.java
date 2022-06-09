package model;

public abstract class Hero extends DungeonCharacter {

	private boolean hasAbstraction;
	private boolean hasEncapsulation;
	private boolean hasInheritance;
	private boolean hasPolymorphism;
	private float myBlockChance;

	/**
	 * Constructor for Hero.
	 *
	 * @param theCharacterName The name of the Hero
	 * @param theDungeon The dungeon in which the Hero resides
	 */
	public Hero(final String theCharacterName, Dungeon theDungeon) {
		super(theCharacterName, theDungeon);
		setHasAbstraction(false);
		setHasEncapsulation(false);
		setHasInheritance(false);
		setHasPolymorphism(false);
	}

	/**
	 * Retrieves the block chance of the Hero.
	 *
	 * @return the block chance
	 */
	public float getMyBlockChance() {
		return myBlockChance;
	}

	/**
	 * Sets the block chance of the Hero.
	 *
	 * @param myBlockChance The block chance
	 */
	public void setMyBlockChance(float myBlockChance) {
		this.myBlockChance = myBlockChance;
	}

	/**
	 * Retrieves the status indicating whether the Hero has activated the Abstraction Pillar.
	 *
	 * @return the activation status
	 */
	public boolean HasAbstraction() {
		return hasAbstraction;
	}

	/**
	 * Sets the status indicating whether the Hero has activated the Abstraction Pillar.
	 *
	 * @param hasAbstraction The activation status
	 */
	public void setHasAbstraction(boolean hasAbstraction) {
		this.hasAbstraction = hasAbstraction;
	}

	/**
	 * Retrieves the status indicating whether the Hero has activated the Encapsulation Pillar.
	 *
	 * @return the activation status
	 */
	public boolean HasEncapsulation() {
		return hasEncapsulation;
	}

	/**
	 * Sets the status indicating whether the Hero has activated the Encapsulation Pillar.
	 *
	 * @param hasEncapsulation The activation status
	 */
	public void setHasEncapsulation(boolean hasEncapsulation) {
		this.hasEncapsulation = hasEncapsulation;
	}

	/**
	 * Retrieves the status indicating whether the Hero has activated the Inheritance Pillar.
	 *
	 * @return the activation status
	 */
	public boolean HasInheritance() {
		return hasInheritance;
	}

	/**
	 * Sets the status indicating whether the Hero has activated the Inheritance Pillar.
	 *
	 * @param hasInheritance The activation status
	 */
	public void setHasInheritance(boolean hasInheritance) {
		this.hasInheritance = hasInheritance;
	}

	/**
	 * Retrieves the status indication whether the Hero has activated the Polymorphism Pillar.
	 *
	 * @return the activation status
	 */
	public boolean HasPolymorphism() {
		return hasPolymorphism;
	}

	/**
	 * Sets the status indicating whether the Hero has activated the Polymorphism Pillar.
	 *
	 * @param hasPolymorphism The activation status
	 */
	public void setHasPolymorphism(boolean hasPolymorphism) {
		this.hasPolymorphism = hasPolymorphism;
	}

	/**
	 * A helper method to ease construction of a Hero.
	 *
	 * @param theCharacterDescription The character description of the Hero
	 * @param theCharacterType The character type of the Hero
	 * @param theCharacterRepresentation The character representation of the Hero
	 * @param theAbility The ability of the Hero
	 * @param theHitPointsMax The max hit points of the Hero
	 * @param theAttackDamageMin The minimum attack damage of the Hero
	 * @param theAttackDamageMax The maximum attack damage of the Hero
	 * @param theChanceToHit The hit chance of the Hero
	 * @param theAbilityChance The ability chance of the Hero
	 * @param theBlockChance The block chance of the Hero
	 */
	public void constructionHelper (final String theCharacterDescription,
									  final String theCharacterType, final char theCharacterRepresentation,
									  final String theAbility, final int theHitPointsMax, final int theAttackDamageMin,
									  final int theAttackDamageMax, final float theChanceToHit, final float theAbilityChance,
									  float theBlockChance) {

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
		setMyBlockChance(theBlockChance);
	}
}
