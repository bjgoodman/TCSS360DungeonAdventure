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
	private int myAttackDamageMin;
	private int myAttackDamageMax;
	private float myChanceToHit;
	private float myAbilityChance;
	private float myDefense;
	private int myX;
	private int myY;

	private Dungeon myDungeon;

	public DungeonCharacter(final String theCharacterName, final Dungeon theDungeon) {
		setMyCharacterName(theCharacterName);
		setMyDungeon(theDungeon);
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

	public void move(DIRECTION dir) {
		if (dir == DIRECTION.NORTH) {
			this.decreaseX();
		} else if (dir == DIRECTION.SOUTH) {
			this.increaseX();
		} else if (dir == DIRECTION.EAST) {
			this.increaseY();
		} else {
			this.decreaseY();
		}
	}

	public void Attack(DungeonCharacter theTarget) {
		if (this.getMyAbilityChance() > ThreadLocalRandom.current().nextFloat()) {
			this.useAbility(theTarget);
		} else {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round(damageDealt() * theTarget.getMyAttackReduction());		// ability behaviour moved into Hero and Monster classes, refactor this to BASIC Attack()
				// needs to be fixed? characters ATK DMG differs from their min & max ATK PWR
				theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
				System.out.println(this.getMyCharacterName() + " dealt " + damageDone
						+ " to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName()
						+ "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
			} else {
				System.out.println(this.getMyCharacterName() + "'s attack missed!");
			}
		}
		if (!theTarget.isAlive()) {
			System.out.println(theTarget.getMyCharacterName() + " died!");
		}
	}

	public int damageDealt() {
		return ThreadLocalRandom.current().nextInt(this.getMyAttackDamageMin(), this.getMyAttackDamageMax() + ONE);
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

	public void setMyAbility(final String theAbility) {
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
			die();
		} else {
			myCurrentHitPoints = theCurrentHitPoints;
		}
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

	public Dungeon getMyDungeon() {
		return myDungeon;
	}

	public void setMyDungeon(Dungeon myDungeon) {
		this.myDungeon = myDungeon;
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
		if (this.getMyDungeon().getMyDungeon()[step_x][step_y] instanceof RoomOccupiable) {
			((RoomOccupiable) this.getMyDungeon().getMyDungeon()[this.getMyX()][this.getMyY()]).removeOccupant(this);
			setMyX(step_x);
			setMyY(step_y);
			((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).addOccupant(this);
		} else {
			System.out.println("Invalid movement command.");
		}
	}

	// toString for DungeonCharacters
	private void die() {
		setAlive(false);
	}

	abstract void useAbility(final DungeonCharacter theTarget);
}
