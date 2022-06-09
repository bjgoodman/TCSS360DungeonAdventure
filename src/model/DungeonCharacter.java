package model;

import view.Interface;

import java.io.Serial;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Defines abstract behaviors of an entity inhabiting a dungeon.
 */
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

	/**
	 * Constructor for DungeonCharacter.
	 *
	 * @param theCharacterName The name of the DungeonCharacter
	 * @param theDungeon The dungeon in which the DungeonCharacter resides
	 */
	public DungeonCharacter(final String theCharacterName, final Dungeon theDungeon) {
		myIsAlive = true;
		setMyCharacterName(theCharacterName);
		setMyDungeon(theDungeon);
	}

	/* CHARACTER GOING DOWN */

	/**
	 * Moves the character down.
	 */
	void increaseY() {
		nextStep(getMyX(), getMyY() + 1);
	}

	/* CHARACTER GOING UP */

	/**
	 * Moves the character up.
	 */
	void decreaseY() {
		nextStep(getMyX(), getMyY() - 1);
	}

	/* CHARACTER GOING RIGHT */

	/**
	 * Moves the character right.
	 */
	void increaseX() {
		nextStep(getMyX() + 1, getMyY());
	}

	/* CHARACTER GOING LEFT */

	/**
	 * Moves the character left.
	 */
	void decreaseX() {
		nextStep(getMyX() - 1, getMyY());
	}

	/**
	 * Moves the character.
	 *
	 * @param dir The direction in which the character is being moved
	 */
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

	/**
	 * The attack sequence for two DungeonCharacters.
	 *
	 * @param theTarget The DungeonCharacter which is being attacked
	 */
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

	/**
	 * A helper method for healing a DungeonCharacter.
	 *
	 * @param theTarget The DungeonCharacter being healed
	 */
	private void healHelper(DungeonCharacter theTarget) {
		if (((Monster) theTarget).getMyHealChance() > ThreadLocalRandom.current().nextFloat()) {
			int heal = (int) Math.round(theTarget.getMyHitPointsMax() * 0.15);
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() + heal);
			Interface.newEvent(theTarget.getMyCharacterName() + " healed for " + heal + ".");
		}
	}

	/**
	 * A helper method for attacking a DungeonCharacter.
	 *
	 * @param theTarget The DungeonCharacter being attacked
	 */
	private void attackHelper(DungeonCharacter theTarget) {
		int damageDone = Math.round(damageDealt());
		theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
		Interface.newEvent(this.getMyCharacterName() + " dealt " + damageDone
				+ " to " + theTarget.getMyCharacterName() + ".");
	}

	/**
	 * A helper method for blocking attacks.
	 *
	 * @param theTarget The DungeonCharacter being blocked
	 */
	private void blockHelper(DungeonCharacter theTarget) {
		int damageDone = (int) Math.round(damageDealt() * 0.5);
		theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
		Interface.newEvent(theTarget.getMyCharacterName() + " blocked. " + this.getMyCharacterName() + " dealt " + damageDone
				+ " to " + theTarget.getMyCharacterName() + ".");
	}

	/**
	 * Determines a random damage value according to this DungeonCharacter's attack range.
	 *
	 * @return the attack value
	 */
	public int damageDealt() {
		return ThreadLocalRandom.current().nextInt(this.getMyAttackDamageMin(), this.getMyAttackDamageMax() + ONE);
	}

	/**
	 * Retrieves the name of this DungeonCharacter.
	 *
	 * @return the name
	 */
	public String getMyCharacterName() {
		return myCharacterName;
	}

	/**
	 * Sets the name of this DungeonCharacter
	 *
	 * @param theCharacterName The name
	 */
	public void setMyCharacterName(final String theCharacterName) {
		myCharacterName = theCharacterName;
	}

	/**
	 * Retrieves the character type of this DungeonCharacter.
	 *
	 * @return the character type
	 */
	public final String getMyCharacterType() {
		return myCharacterType;
	}

	/**
	 * Sets the character type of this DungeonCharacter.
	 *
	 * @param theCharacterType The character type
	 */
	public final void setMyCharacterType(String theCharacterType) {
		myCharacterType = theCharacterType;
	}

	/**
	 * Retrieves the character representation of this DungeonCharacter.
	 *
	 * @return the character representation
	 */
	public char getMyCharacterRepresentation() {
		return myCharacterRepresentation;
	}

	/**
	 * Sets the character representation of this DungeonCharacter.
	 *
	 * @param myCharacterRepresentation the character representation
	 */
	public void setMyCharacterRepresentation(char myCharacterRepresentation) {
		this.myCharacterRepresentation = myCharacterRepresentation;
	}

	/**
	 * Retrieves the ability of this DungeonCharacter.
	 *
	 * @return the ability
	 */
	public String getMyAbility() {
		return myAbility;
	}

	/**
	 * Sets the ability of this DungeonCharacter.
	 *
	 * @param theAbility The ability
	 */
	public void setMyAbility(final String theAbility) {
		myAbility = theAbility;
	}

	/**
	 * Retrieves the alive status of this DungeonCharacter.
	 *
	 * @return the alive status
	 */
	public boolean isAlive() {
		return myIsAlive;
	}

	/**
	 * Sets the alive status of this DungeonCharacter.
	 *
	 * @param theIsAlive The alive status
	 */
	public void setAlive(boolean theIsAlive) {
		myIsAlive = theIsAlive;
	}

	/**
	 * Retrieves the max hit points of this DungeonCharacter.
	 *
	 * @return the max hit points
	 */
	public int getMyHitPointsMax() {
		return myHitPointsMax;
	}

	/**
	 * Sets the max hit points of this DungeonCharacter.
	 *
	 * @param theHitPointsMax The max hit points
	 */
	public void setMyHitPointsMax(final int theHitPointsMax) {
		myHitPointsMax = theHitPointsMax;
	}

	/**
	 * Retrieves the current hit points of this DungeonCharacter.
	 *
	 * @return the current hit points
	 */
	public int getMyCurrentHitPoints() {
		return myCurrentHitPoints;
	}

	/**
	 * Sets the current hit points of this DungeonCharacter.
	 *
	 * @param theCurrentHitPoints The current hit points
	 */
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

	/**
	 * Retrieves the max attack damage of this DungeonCharacter.
	 *
	 * @return the max attack damage
	 */
	public int getMyAttackDamageMax() {
		return myAttackDamageMax;
	}

	/**
	 * Sets the max attack damage of this DungeonCharacter.
	 *
	 * @param theAttackDamageMax The max attack damage
	 */
	public void setMyAttackDamageMax(final int theAttackDamageMax) {
		myAttackDamageMax = theAttackDamageMax;
	}

	/**
	 * Retrieves the minimum attack damage of this DungeonCharacter.
	 *
	 * @return the minimum attack damage
	 */
	public int getMyAttackDamageMin() {
		return myAttackDamageMin;
	}

	/**
	 * Sets the minimum attack damage of this DungeonCharacter.
	 *
	 * @param theAttackDamageMin The minimum attack damage
	 */
	public void setMyAttackDamageMin(final int theAttackDamageMin) {
		myAttackDamageMin = theAttackDamageMin;
	}

	/**
	 * Retrieves the hit chance of this DungeonCharacter.
	 *
	 * @return the hit chance
	 */
	public float getMyChanceToHit() {
		return myChanceToHit;
	}

	/**
	 * Sets the hit chance of this DungeonCharacter.
	 *
	 * @param theChanceToHit The hit chance
	 */
	public void setMyChanceToHit(final float theChanceToHit) {
		myChanceToHit = theChanceToHit;
	}

	/**
	 * Retrieves the ability chance of this DungeonCharacter.
	 *
	 * @return the ability chance
	 */
	public float getMyAbilityChance() {
		return myAbilityChance;
	}

	/**
	 * Sets the ability chance of this DungeonCharacter.
	 *
	 * @param theAbilityChance The ability chance
	 */
	public void setMyAbilityChance(final float theAbilityChance) {
		myAbilityChance = theAbilityChance;
	}

	/**
	 * Retrieves the character description of this DungeonCharacter.
	 *
	 * @return the character description
	 */
	public String getMyCharacterDescription() {
		return myCharacterDescription;
	}

	/**
	 * Sets the character description of this DungeonCharacter.
	 *
	 * @param theCharacterDescription the character description
	 */
	public void setMyCharacterDescription(final String theCharacterDescription) {
		myCharacterDescription = theCharacterDescription;
	}

	/**
	 * Retrieves the dungeon in which this DungeonCharacter resides.
	 *
	 * @return the dungeon
	 */
	public Dungeon getMyDungeon() {
		return myDungeon;
	}

	/**
	 * Sets the dungeon in which this DungeonCharacter resides.
	 *
	 * @param myDungeon The dungeon
	 */
	public void setMyDungeon(Dungeon myDungeon) {
		this.myDungeon = myDungeon;
	}

	/**
	 * Retrieves the x coordinate of this DungeonCharacter.
	 *
	 * @return the x coordinate
	 */
	public int getMyX() {
		return myX;
	}

	/**
	 * Sets the x coordinate of this DungeonCharacter.
	 *
	 * @param theX The x coordinate
	 */
	public void setMyX(int theX) {
		myX = theX;
	}

	/**
	 * Retrieves the y coordinate of this DungeonCharacter.
	 *
	 * @return the y coordinate
	 */
	public int getMyY() {
		return myY;
	}

	/**
	 * Sets the y coordinate of this DungeonCharacter.
	 *
	 * @param theY The y coordinate
	 */
	public void setMyY(int theY) {
		myY = theY;
	}


	/**
	 * Attempts the next step of this DungeonCharacter.
	 *
	 * @param step_x The x value
	 * @param step_y The y value
	 */
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

	/**
	 * Sets this DungeonCharacter to dead.
	 */
	private void die() {
		setAlive(false);
	}

	/**
	 * Uses this DungeonCharacter's ability against a target.
	 *
	 * @param theTarget The DungeonCharacter being targeted
	 */
	abstract void useAbility(final DungeonCharacter theTarget);
}
