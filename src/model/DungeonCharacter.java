package model;

import java.util.LinkedList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class DungeonCharacter {
	public static final int ZERO = 0;
	private String myCharacterName;
	private String myCharacterDescription;
	private String myAbilityName;
	private boolean myIsAlive;
	private int myHitPointsMax;
	private int myCurrentHitPoints;
	private float myAttackSpeed;
	private int myAttackDamageMax;
	private int myAttackDamageMin;
	private float myChanceToHit;
	private float myAbilityChance;
	private float myDefense;
	private LinkedList<Item> myItems = new LinkedList<>();
	
	public DungeonCharacter(final String theName) {
		myCharacterName = theName;
		myIsAlive = true;
	}
	
	public String getMyCharacterName() {
		return myCharacterName;
	}

	public void setMyCharacterName(final String theCharacterName) {
		myCharacterName = theCharacterName;
	}

	public String getMyAbilityName() {
		return myAbilityName;
	}

	public void setMyAbilityName(final String theAbilityName) {
		myAbilityName = theAbilityName;
	}

	public boolean isAlive() {
		return myIsAlive;
	}

	public void setAlive(boolean theIsAlive) {
		myIsAlive = theIsAlive;
	}

	public float getMyHitPoints() {
		return myHitPointsMax;
	}

	public void setMyHitPoints(final int theHitPointsMax) {
		myHitPointsMax = theHitPointsMax;
	}

	public int getMyCurrentHitPoints() {
		return myCurrentHitPoints;
	}

	public void setMyCurrentHitPoints(final int theCurrentHitPoints) {
		myCurrentHitPoints = theCurrentHitPoints;
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

	// ITEM METHODS -> IMPLEMENT WITH LINKED LIST
	
//	public Item[] getMyItems() {
//		return myItems;
//	}
//
//	public void setMyItems(final Item[] theItems) {
//		myItems = theItems;
//	}

	public float getMyAttackReduction() {
		return (1 - getMyDefense());
	}
	
	public String getMyCharacterDescription() {
		return myCharacterDescription;
	}

	public void setMyCharacterDescription(final String theCharacterDescription) {
		myCharacterDescription = theCharacterDescription;
	}
	
	// MAGIC NUMBER
	public int damageDealt() {
		return ThreadLocalRandom.current().nextInt(this.getMyAttackDamageMin(), this.getMyAttackDamageMax() + 1);
	}

	public void Attack(DungeonCharacter theTarget) {
		if (this.getMyAbilityChance() > ThreadLocalRandom.current().nextFloat()) {
			this.useAbility(theTarget);
		} else {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round(damageDealt() * theTarget.getMyAttackReduction());
				theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
				System.out.println(this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ".");
			} else {
				System.out.println(this.getMyCharacterName() + "'s attack missed!");
			}
			if (theTarget.getMyCurrentHitPoints() <= ZERO) {
				System.out.println(theTarget.getMyCharacterName() + " died!");
				theTarget.setAlive(false);
			}
		}
	}
	
	abstract void useAbility(DungeonCharacter theTarget);
	
	abstract void useItem(DungeonCharacter theTarget, Item theItem);
}
