package model;

import java.util.concurrent.ThreadLocalRandom;

public abstract class DungeonCharacter {
	private static final int ZERO = 0;
	private static final int ONE = 1;

	private String myCharacterName;
	private String myCharacterDescription;
	private String myCharacterType;
	private char myCharacterRepresentation;
	private String myAbility;
	private boolean myIsAlive;
	private int myHitPointsMax;
	private int myCurrentHitPoints;
	private float myAttackSpeed;
	private int myDefaultAttackDamageMax;
	private int myDefaultAttackDamageMin;
	private int myAttackDamageMax;
	private int myAttackDamageMin;
	private float myChanceToHit;
	private float myAbilityChance;
	private float myDefense;
	private int myX;
	private int myY;

	public DungeonCharacter(final String theName, String theDescription, char theRepresentingCharacter, String theCharacterType, 
							int theHP, int theADMax, int theADMin, float theAttackSpeed, float theAttackChance, float theAbilityChance, float theDefense) {
		myCharacterName = theName;
		myIsAlive = true;
		setMyCharacterDescription(theDescription);
		setMyCharacterRepresentation(theRepresentingCharacter);
		setMyCharacterType(theCharacterType);
		setMyHitPointsMax(theHP);
		setMyCurrentHitPoints(theHP);
		setMyAttackDamageMax(theADMax);
		setMyAttackDamageMin(theADMin);
		setMyDefaultAttackDamageMax(theADMax);
		setMyDefaultAttackDamageMax(theADMin);
		setMyAttackSpeed(theAttackSpeed);
		setMyChanceToHit(theAttackChance);
		setMyAbilityChance(theAbilityChance);
		setMyDefense(theDefense);
	}

	public String getMyCharacterName() {
		return myCharacterName;
	}

	public void setMyCharacterName(final String theCharacterName) {
		myCharacterName = theCharacterName;
	}

	public final String getMyCharacterType() {
		return myCharacterType;
	}

	public final void setMyCharacterType(String theCharacterType) {
		myCharacterType = theCharacterType;
	}

	public char getMyCharacterRepresentation() {
		return myCharacterRepresentation;
	}

	public void setMyCharacterRepresentation(char myCharacterRepresentation) {
		this.myCharacterRepresentation = myCharacterRepresentation;
	}

	public String getMyAbility() {
		return myAbility;
	}

	public void setMyAbility1(final String theAbility) {
		myAbility = theAbility;
	}

	public boolean isAlive() {
		return myIsAlive;
	}

	public void setAlive(boolean theIsAlive) {
		myIsAlive = theIsAlive;
	}

	public int getMyHitPointsMax() {
		return myHitPointsMax;
	}

	public void setMyHitPointsMax(final int theHitPointsMax) {
		myHitPointsMax = theHitPointsMax;
	}

	public int getMyCurrentHitPoints() {
		return myCurrentHitPoints;
	}

	public void setMyCurrentHitPoints(final int theCurrentHitPoints) { // set exception by Ben??
		if (theCurrentHitPoints >= this.getMyHitPointsMax()) {
			myCurrentHitPoints = getMyHitPointsMax();
		} else if (theCurrentHitPoints <= ZERO) {
			myCurrentHitPoints = ZERO;
			this.setAlive(false);
		} else {
			myCurrentHitPoints = theCurrentHitPoints;
		}
	}

	public float getMyAttackSpeed() {
		return myAttackSpeed;
	}

	public void setMyAttackSpeed(final float theAttackSpeed) {
		myAttackSpeed = theAttackSpeed;
	}

	public int getMyAttackDamageMax() {
		return myAttackDamageMax;
	}

	public void setMyAttackDamageMax(final int theAttackDamageMax) {
		myAttackDamageMax = theAttackDamageMax;
	}

	public int getMyAttackDamageMin() {
		return myAttackDamageMin;
	}

	public void setMyAttackDamageMin(final int theAttackDamageMin) {
		myAttackDamageMin = theAttackDamageMin;
	}

	public int getMyDefaultAttackDamageMax() {
		return myDefaultAttackDamageMax;
	}

	public void setMyDefaultAttackDamageMax(final int theDefaultAttackDamageMax) {
		myDefaultAttackDamageMax = theDefaultAttackDamageMax;
	}

	public int getMyDefaultAttackDamageMin() {
		return myDefaultAttackDamageMin;
	}

	public void setMyDefaultAttackDamageMin(final int theDefaultAttackDamageMin) {
		myDefaultAttackDamageMin = theDefaultAttackDamageMin;
	}

	public float getMyChanceToHit() {
		return myChanceToHit;
	}

	public void setMyChanceToHit(final float theChanceToHit) {
		myChanceToHit = theChanceToHit;
	}

	public float getMyAbilityChance() {
		return myAbilityChance;
	}

	public void setMyAbilityChance(final float theAbilityChance) {
		myAbilityChance = theAbilityChance;
	}

	public float getMyDefense() {
		return myDefense;
	}

	public void setMyDefense(final float theDefense) {
		myDefense = theDefense;
	}

	public float getMyAttackReduction() {
		return (1 - getMyDefense());
	}

	public String getMyCharacterDescription() {
		return myCharacterDescription;
	}

	public void setMyCharacterDescription(final String theCharacterDescription) {
		myCharacterDescription = theCharacterDescription;
	}

	/* CHARACTER GOING DOWN */
	void increaseY() {
		nextStep(getMyX(), getMyY() + 1);
	}

	/* CHARACTER GOING UP */
	void decreaseY() {
		nextStep(getMyX(), getMyY() - 1);
	}

	/* CHARACTER GOING RIGHT */
	void increaseX() {
		nextStep(getMyX() + 1, getMyY());
	}

	/* CHARACTER GOING LEFT */
	void decreaseX() {
		nextStep(getMyX() - 1, getMyY());
	}

	public int getMyX() {
		return myX;
	}

	public void setMyX(int theX) {
		myX = theX;
	}

	public int getMyY() {
		return myY;
	}

	public void setMyY(int theY) {
		myY = theY;
	}

	private void nextStep(int step_x, int step_y) {
			setMyX(step_x);
			setMyY(step_y);
	}

	public int damageDealt() {
		return ThreadLocalRandom.current().nextInt(this.getMyAttackDamageMin(), this.getMyAttackDamageMax() + ONE);
	}

	public void Attack(DungeonCharacter theTarget) {
//		final int ONE = 1;
//		final int TWO = 2;
//		if (this.getMyAbilityChance() > ThreadLocalRandom.current().nextFloat()) {
//			if (this.hasTwoAbilities()) {
//				int fiftyFifty = ThreadLocalRandom.current().nextInt(ONE, (TWO + ONE));
//				if (fiftyFifty == ONE) {
//					this.useAbility1(theTarget);
//				} else if (fiftyFifty == TWO) {					// hook method ?
//					this.useAbility2(theTarget);
//				}
//			} else {
//				this.useAbility1(theTarget);
//			}
//		} else {
//			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
//				int damageDone = Math.round(damageDealt() * theTarget.getMyAttackReduction());		// ability behaviour moved into Hero and Monster classes, refactor this to BASIC Attack()
//				// needs to be fixed? characters ATK DMG differs from their min & max ATK PWR
//				// System.out.println(damageDealt());
//				// System.out.println(theTarget.getMyAttackReduction());
//				theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
//				System.out.println(this.getMyCharacterName() + " dealt " + damageDone
//						+ " to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName()
//						+ "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
//			} else {
//				System.out.println(this.getMyCharacterName() + "'s attack missed!");
//			}
//		}
//		if (!theTarget.isAlive()) {
//			System.out.println(theTarget.getMyCharacterName() + " died!");
//		}
	}
	
	// toString for DungeonCharacters

	abstract void useAbility1(final DungeonCharacter theTarget);
}
