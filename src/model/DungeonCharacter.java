/* DungeonCharacter.java */

package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The stats and abilities of each characters within Dungeon Adventure as well
 * as the attacks and items used for adventurers.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public abstract class DungeonCharacter {

	/* deciding factor to use for adventurer's attack/abilities to hit */
	private static final int ZERO = 0;

	/* deciding factor to use for adventurer's attack/abilities to hit */
	private static final int ONE = 1;

	/** the name of the character */
	private String myCharacterName;

	/** the description of the character */
	private String myCharacterDescription;

	/** the type of the character */
	private String myCharacterType;

	/** the first ability of the character */
	private String myAbility1;

	/** the second ability of the character */
	private String myAbility2;

	/** checks if the character has two abilities or not */
	private boolean hasTwoAbilities;

	/** checks if the character is alive */
	private boolean myIsAlive;

	/** the max hit points of the character */
	private int myHitPointsMax;

	/** the curent hit points of the character */
	private int myCurrentHitPoints;

	/** the attack speed of the character */
	private float myAttackSpeed;

	/** the default maximum attack damage of the character */
	private int myDefaultAttackDamageMax;

	/** the default minimum attack damage of the character */
	private int myDefaultAttackDamageMin;

	/** the maximum attack damage of the character */
	private int myAttackDamageMax;

	/** the minimum attack damage of the character */
	private int myAttackDamageMin;

	/** the chance to hit opponents from the character */
	private float myChanceToHit;

	/** the chance for character's ability to use */
	private float myAbilityChance;

	/** the character's defense */
	private float myDefense;

	/** the character's vision range */
	private int myVisionRange;

	/** the character's x position */
	private int myX;

	/** the character's y position */
	private int myY;

	/** an item inventory holding 5 items */
	private Item[] myInventory = new Item[6];

	/** an accessory inventory holding 3 items, mostly holding pillars of OO */
	private Accessory[] myAccessories = new Accessory[4];

	/**
	 * checks character's name and is alive in the game
	 * 
	 * @param theName the name of the character
	 */
	public DungeonCharacter(final String theName) {
		myCharacterName = theName;
		myIsAlive = true;
	}

	/**
	 * retrieves character's name
	 * 
	 * @return character's name
	 */
	public String getMyCharacterName() {
		return myCharacterName;
	}

	/**
	 * solidifying character's name in the game
	 * 
	 * @param theCharacterName the name of the character
	 */
	public void setMyCharacterName(final String theCharacterName) {
		myCharacterName = theCharacterName;
	}

	/**
	 * retrieves character's type
	 * 
	 * @return character's type
	 */
	public final String getMyCharacterType() {
		return myCharacterType;
	}

	/**
	 * solidifying character's name in the game
	 * 
	 * @param theCharacterName the name of the character
	 */
	public final void setMyCharacterType(String theCharacterType) {
		myCharacterType = theCharacterType;
	}

	/**
	 * retrieves character's first ability
	 * 
	 * @return character's first ability
	 */
	public String getMyAbility1() {
		return myAbility1;
	}

	/**
	 * solidifying character's first ability in the game
	 * 
	 * @param theCharacterName the name of the character
	 */
	public void setMyAbility1(final String theAbility1) {
		myAbility1 = theAbility1;
	}

	/**
	 * retrieves character's second ability
	 * 
	 * @return character's second ability
	 */
	public String getMyAbility2() {
		return myAbility2;
	}

	/**
	 * solidifying character's second ability in the game
	 * 
	 * @param theCharacterName the name of the character
	 */
	public void setMyAbility2(final String theAbility2) {
		myAbility2 = theAbility2;
	}

	/**
	 * checks if character has two abilities in the game or not
	 * 
	 * @return if character has two abilities or not
	 */
	public final boolean hasTwoAbilities() {
		return hasTwoAbilities;
	}

	/**
	 * solidifying character's second ability in the game
	 * 
	 * @param theHasTwoAbilities checks character if they have two ability
	 */
	public final void setHasTwoAbilities(boolean theHasTwoAbilities) {
		hasTwoAbilities = theHasTwoAbilities;
	}

	/**
	 * retrieves character if alive
	 * 
	 * @return character if alive
	 */
	public boolean isAlive() {
		return myIsAlive;
	}

	/**
	 * checks character if alive or not in the game
	 * 
	 * @param theIsAlive checks character if they are alive
	 */
	public void setAlive(boolean theIsAlive) {
		myIsAlive = theIsAlive;
	}

	/**
	 * retrieves character max hit points in the game
	 * 
	 * @return character max hit points
	 */
	public int getMyHitPointsMax() {
		return myHitPointsMax;
	}

	/**
	 * solidifying the character's max hit points in the game
	 * 
	 * @param theHitPointsMax character's max hit points
	 */
	public void setMyHitPointsMax(final int theHitPointsMax) {
		myHitPointsMax = theHitPointsMax;
	}

	/**
	 * retrieves character current hit points in the game
	 * 
	 * @return character current hit points
	 */
	public int getMyCurrentHitPoints() {
		return myCurrentHitPoints;
	}

	/**
	 * solidifying the character's current hit points through different scenarios
	 * in the game
	 * 
	 * @param theCurrentHitPoints character's current hit points
	 */
	public void setMyCurrentHitPoints(final int theCurrentHitPoints) {
		if (theCurrentHitPoints >= this.getMyHitPointsMax()) {
			myCurrentHitPoints = getMyHitPointsMax();
		} else if (theCurrentHitPoints <= ZERO) {
			myCurrentHitPoints = ZERO;
			this.setAlive(false);
		} else {
			myCurrentHitPoints = theCurrentHitPoints;
		}
	}

	/**
	 * retrieves character's attack speed in the game
	 * 
	 * @return character's attack speed
	 */
	public float getMyAttackSpeed() {
		return myAttackSpeed;
	}

	/**
	 * solidifying the character's attack points in the game
	 * 
	 * @param theAttackSpeed character's attacking speed
	 */
	public void setMyAttackSpeed(final float theAttackSpeed) {
		myAttackSpeed = theAttackSpeed;
	}

	/**
	 * retrieves character's max attack damage in the game
	 * 
	 * @return character's max attack damage
	 */
	public int getMyAttackDamageMax() {
		return myAttackDamageMax;
	}

	/**
	 * solidifying the character's max attacking damage in the game
	 * 
	 * @param theAttackDamageMax character's max attacking damage
	 */
	public void setMyAttackDamageMax(final int theAttackDamageMax) {
		myAttackDamageMax = theAttackDamageMax;
	}

	/**
	 * retrieves character's min attack damage in the game
	 * 
	 * @return character's min attack damage
	 */
	public int getMyAttackDamageMin() {
		return myAttackDamageMin;
	}

	/**
	 * solidifying the character's min attacking damage in the game
	 * 
	 * @param theAttackDamageMax character's min attacking damage
	 */
	public void setMyAttackDamageMin(final int theAttackDamageMin) {
		myAttackDamageMin = theAttackDamageMin;
	}

	/**
	 * retrieves character's default max attack damage in the game
	 * 
	 * @return character's default max attack damage
	 */
	public int getMyDefaultAttackDamageMax() {
		return myDefaultAttackDamageMax;
	}

	/**
	 * solidifying the character's default max attacking damage in the game
	 * 
	 * @param theAttackDamageMax character's max attacking damage
	 */
	public void setMyDefaultAttackDamageMax(final int theDefaultAttackDamageMax) {
		myDefaultAttackDamageMax = theDefaultAttackDamageMax;
	}

	/**
	 * retrieves character's default min attack damage in the game
	 * 
	 * @return character's default min attack damage
	 */
	public int getMyDefaultAttackDamageMin() {
		return myDefaultAttackDamageMin;
	}

	/**
	 * solidifying the character's default min attacking damage in the game
	 * 
	 * @param theAttackDamageMax character's min attacking damage
	 */
	public void setMyDefaultAttackDamageMin(final int theDefaultAttackDamageMin) {
		myDefaultAttackDamageMin = theDefaultAttackDamageMin;
	}

	/**
	 * retrieves character's chance to attack enemy in the game
	 * 
	 * @return character's chance to attack enemy
	 */
	public float getMyChanceToHit() {
		return myChanceToHit;
	}

	/**
	 * solidifying the character's chance to attack enemy in the game
	 * 
	 * @param theChanceToHit character's chance to attack enemy
	 */
	public void setMyChanceToHit(final float theChanceToHit) {
		myChanceToHit = theChanceToHit;
	}

	/**
	 * retrieves character's chance to use its ability in the game
	 * 
	 * @return character's chance to use its ability
	 */
	public float getMyAbilityChance() {
		return myAbilityChance;
	}

	/**
	 * solidifying the character's chance to use its ability in the game
	 * 
	 * @param theAbilityChance character's chance to use its ability
	 */
	public void setMyAbilityChance(final float theAbilityChance) {
		myAbilityChance = theAbilityChance;
	}

	/**
	 * retrieves character's defense in the game
	 * 
	 * @return character's defense
	 */
	public float getMyDefense() {
		return myDefense;
	}

	/**
	 * solidifying the character's defense in the game
	 * 
	 * @param theDefense the character's defense
	 */
	public void setMyDefense(final float theDefense) {
		myDefense = theDefense;
	}

	/**
	 * retrieves character's attack reduced to a float in the game
	 * 
	 * @return character's damage
	 */
	public float getMyAttackReduction() {
		return (1 - getMyDefense());
	}

	/**
	 * retrieves character's description in the game
	 * 
	 * @return character's description
	 */
	public String getMyCharacterDescription() {
		return myCharacterDescription;
	}

	/**
	 * solidifying the character's description in the game
	 * 
	 * @param theCharacterDescription the character's description
	 */
	public void setMyCharacterDescription(final String theCharacterDescription) {
		myCharacterDescription = theCharacterDescription;
	}

	/**
	 * retrieves inventory in the game
	 * 
	 * @return inventory for the character's use
	 */
	public Item[] getMyInventory() {
		return myInventory;
	}

	/**
	 * solidifying the inventory in the game
	 * 
	 * @param theInventory the inventory the character's use in the game
	 */
	public void setMyInventory(final Item[] theInventory) {
		myInventory = theInventory;
	}

	/**
	 * retrieves accessory in the game
	 * 
	 * @return accessory for character's use
	 */
	public Accessory[] getMyAccessories() {
		return myAccessories;
	}

	/**
	 * solidifying the accessory in the game
	 * 
	 * @param theAccessories the accessory the character's use in the game
	 */
	public void setMyAccessories(Accessory[] theAccessories) {
		myAccessories = theAccessories;
	}

	/**
	 * retrieves vision range in the game
	 * 
	 * @return vision range for the characters
	 */
	public final int getMyVisionRange() {
		return myVisionRange;
	}

	/**
	 * solidifying the vision range in the game
	 * 
	 * @param theVisionRange the vision range character's use in the game
	 */
	public final void setMyVisionRange(int theVisionRange) {
		myVisionRange = theVisionRange;
	}

	/**
	 * retrieves x position of the character in the game
	 * 
	 * @return x position of the character
	 */
	public int getMyX() {
		return myX;
	}

	/**
	 * solidifying the x position of the character in the game
	 * 
	 * @param theX the x position of the character in the game
	 */
	public void setMyX(int theX) {
		myX = theX;
	}

	/**
	 * retrieves y position of the character in the game
	 * 
	 * @return y position of the character
	 */
	public int getMyY() {
		return myY;
	}

	/**
	 * solidifying the y position of the character in the game
	 * 
	 * @param theX the y position of the character in the game
	 */
	public void setMyY(int theY) {
		myY = theY;
	}

	/**
	 * damage dealt from each character in the game
	 * 
	 * @return damage dealt by each character
	 */
	public int damageDealt() {
		return ThreadLocalRandom.current().nextInt(this.getMyAttackDamageMin(), this.getMyAttackDamageMax() + ONE);
	}

	/**
	 * testing capabilities of each characters probability of using their
	 * abilities and attacking each other as well as deciding which character
	 * is dead based on hit points below ZERO first in the game
	 * 
	 * @param theTarget the target the character is facing in the game
	 */
	public void Attack(DungeonCharacter theTarget) {
		final int ONE = 1;
		final int TWO = 2;
		if (this.getMyAbilityChance() > ThreadLocalRandom.current().nextFloat()) {
			if (this.hasTwoAbilities()) {
				int fiftyFifty = ThreadLocalRandom.current().nextInt(ONE, (TWO + ONE));
				if (fiftyFifty == ONE) {
					this.useAbility1(theTarget);
				} else if (fiftyFifty == TWO) {
					this.useAbility2(theTarget);
				}
			} else {
				this.useAbility1(theTarget);
			}
		} else {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round(damageDealt() * theTarget.getMyAttackReduction());
				// needs to be fixed? characters ATK DMG differs from their min & max ATK PWR
				// System.out.println(damageDealt());
				// System.out.println(theTarget.getMyAttackReduction());
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

	/**
	 * pulls inventory for characters to use for self and sets the position of item used to null
	 * 
	 * @param theItemSlot the slot of the item
	 */
	public void useItemSelf(final int theItemSlot) {
		Item item = getMyInventory()[theItemSlot];
		item.itemEffectActivate(this);
		this.getMyInventory()[theItemSlot] = null;
	}

	/**
	 * pulls inventory for characters to use against others and sets the position of item used to null
	 * 
	 * @param theItemSlot the slot of the item
	 * @param theTarget the target for the item to be used against
	 */
	public void useItemTargeted(final int theItemSlot, final DungeonCharacter theTarget) {
		Item item = getMyInventory()[theItemSlot];
		if (item.isTargetable()) {
			item.itemEffectActivate(theTarget);
		}
		this.getMyInventory()[theItemSlot] = null;
	}

	/**
	 * lists inventory for character in the game
	 * 
	 * @return toString of inventory listed for character
	 */
	public String inventoryToString() {
		String str = getMyCharacterName() + "'s inventory: ";
		for (Item item: getMyInventory()) {
			if (item != null) {
				str += "[" + item.getMyItemName() + "] ";
			}
		}
		return str;
	}

	/**
	 * character's first ability
	 * 
	 * @param theTarget the character's opponent
	 */
	abstract void useAbility1(final DungeonCharacter theTarget);

	/**
	 * character's second ability
	 * 
	 * @param theTarget the character's opponent
	 */
	abstract void useAbility2(final DungeonCharacter theTarget);
}
