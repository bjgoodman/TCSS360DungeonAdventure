package model;

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
	private Item[] myInventory = new Item[6];
	
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

	public float getMyAttackReduction() {
		return (1 - getMyDefense());
	}
	
	public String getMyCharacterDescription() {
		return myCharacterDescription;
	}

	public void setMyCharacterDescription(final String theCharacterDescription) {
		myCharacterDescription = theCharacterDescription;
	}

	public Item[] getMyInventory() {
		return myInventory;
	}

	public void setMyInventory(final Item[] theInventory) {
		myInventory = theInventory;
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
						+ " to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName()
						+ "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
			} else {
				System.out.println(this.getMyCharacterName() + "'s attack missed!");
			}
			if (theTarget.getMyCurrentHitPoints() <= ZERO) {
				System.out.println(theTarget.getMyCharacterName() + " died!");
				theTarget.setAlive(false);
			}
		}
	}
	
	public void useItemSelf(final int theItemSlot) {
		Item item = getMyInventory()[theItemSlot];
		item.itemEffectActivate(this);
		if (!(item.isReusable())) {
			this.getMyInventory()[theItemSlot] = null;
		}
	}
	
	public void useItemTargeted(final int theItemSlot, final DungeonCharacter theTarget) {
		Item item = getMyInventory()[theItemSlot];
		if (item.isTargetable()) {
			item.itemEffectActivate(theTarget);
		}
		if (!(item.isReusable())) {
			this.getMyInventory()[theItemSlot] = null;
		}
	}
	
	public String inventoryToString() {
		String str = getMyCharacterName() + "'s inventory: ";
		for (Item item: getMyInventory()) {
			if (item != null) {
				str += "[" + item.getMyItemName() + "] ";
			}
		}
		return str;
	}
	
	abstract void useAbility(final DungeonCharacter theTarget);
}
