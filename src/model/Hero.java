package model;

public abstract class Hero extends DungeonCharacter {

	private boolean hasAbstraction;
	private boolean hasEncapsulation;
	private boolean hasInheritance;
	private boolean hasPolymorphism;
	private float myBlockChance;
	public Hero(final String theCharacterName, Dungeon theDungeon) {
		super(theCharacterName, theDungeon);
		setHasAbstraction(false);
		setHasEncapsulation(false);
		setHasInheritance(false);
		setHasPolymorphism(false);
	}

	public float getMyBlockChance() {
		return myBlockChance;
	}

	public void setMyBlockChance(float myBlockChance) {
		this.myBlockChance = myBlockChance;
	}

	public boolean HasAbstraction() {
		return hasAbstraction;
	}

	public void setHasAbstraction(boolean hasAbstraction) {
		this.hasAbstraction = hasAbstraction;
	}

	public boolean HasEncapsulation() {
		return hasEncapsulation;
	}

	public void setHasEncapsulation(boolean hasEncapsulation) {
		this.hasEncapsulation = hasEncapsulation;
	}

	public boolean HasInheritance() {
		return hasInheritance;
	}

	public void setHasInheritance(boolean hasInheritance) {
		this.hasInheritance = hasInheritance;
	}

	public boolean HasPolymorphism() {
		return hasPolymorphism;
	}

	public void setHasPolymorphism(boolean hasPolymorphism) {
		this.hasPolymorphism = hasPolymorphism;
	}

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
