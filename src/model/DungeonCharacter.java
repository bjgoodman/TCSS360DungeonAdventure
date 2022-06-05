package model;

import view.Interface;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

public abstract class DungeonCharacter implements Serializable {
	private static final int ZERO = 0;
	private static final int ONE = 1;
	@Serial
	private static final long serialVersionUID = -3603366188044536342L;
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
	private int myX;
	private int myY;

	private Dungeon myDungeon;

	public DungeonCharacter(final String theCharacterName, final Dungeon theDungeon) {
		myIsAlive = true;
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
			if (theTarget instanceof Monster) {
				if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
					attackHelper(theTarget);
				} else {
					Interface.newEvent(this.getMyCharacterName() + "'s attack missed!");
				}
				if (((Monster) theTarget).getMyHealChance() > ThreadLocalRandom.current().nextFloat()) {
					healHelper(theTarget);
				}
			} else if (theTarget instanceof Hero) {
				if (((Hero) theTarget).getMyBlockChance() > ThreadLocalRandom.current().nextFloat()) {
					if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
						blockHelper(theTarget);
					} else {
						Interface.newEvent(this.getMyCharacterName() + "'s attack missed!");
					}
				} else {
					if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
						attackHelper(theTarget);
					} else {
						Interface.newEvent(this.getMyCharacterName() + "'s attack missed!");
					}
				}
			}
		}
		if (!theTarget.isAlive()) {
			Interface.newEvent(theTarget.getMyCharacterName() + " died!");
		}
	}

	private void healHelper(DungeonCharacter theTarget) {
		if (((Monster) theTarget).getMyHealChance() > ThreadLocalRandom.current().nextFloat()) {
			int heal = (int) Math.round(theTarget.getMyHitPointsMax() * 0.15);
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() + heal);
			Interface.newEvent(theTarget.getMyCharacterName() + " healed for " + heal + ".");
		}
	}

	private void attackHelper(DungeonCharacter theTarget) {
		int damageDone = Math.round(damageDealt());
		theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
		Interface.newEvent(this.getMyCharacterName() + " dealt " + damageDone
				+ " to " + theTarget.getMyCharacterName() + ".");
	}

	private void blockHelper(DungeonCharacter theTarget) {
		int damageDone = (int) Math.round(damageDealt() * 0.5);
		theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
		Interface.newEvent(theTarget.getMyCharacterName() + " blocked. " + this.getMyCharacterName() + " dealt " + damageDone
				+ " to " + theTarget.getMyCharacterName() + ".");
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
		if (this.isAlive()) {
			if (this.getMyDungeon().getMyDungeon()[step_x][step_y] instanceof RoomOccupiable) {
				// if trying to enter a room with a monster
				if (((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).hasOccupant()) {
					this.Attack(((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).getMyOccupant());
					if (((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).getMyOccupant().isAlive()) {
						((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).getMyOccupant().Attack(this);
					} else {
						((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).removeOccupant();
					}
				} else {
					((RoomOccupiable) this.getMyDungeon().getMyDungeon()[this.getMyX()][this.getMyY()]).removeOccupant();
					setMyX(step_x);
					setMyY(step_y);
					((RoomOccupiable) this.getMyDungeon().getMyDungeon()[step_x][step_y]).addOccupant(this);
				}
			}
		} else {
			Interface.newEvent("You cannot do that, you are dead.");
		}
	}

	// toString for DungeonCharacters
	private void die() {
		setAlive(false);
	}

	abstract void useAbility(final DungeonCharacter theTarget);
}
