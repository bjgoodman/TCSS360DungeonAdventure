package model;

import java.util.concurrent.ThreadLocalRandom;

public abstract class DungeonCharacter {
	private static final int ZERO = 0;
	private static final int ONE = 1;

	private String myCharacterName;
	private String myCharacterDescription;
	private String myCharacterType;
	private String myAbility1;
	private String myAbility2;
	private boolean hasTwoAbilities;
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
	private int myVisionRange;
	private Item[] myInventory = new Item[6];
	private Accessory[] myAccessories = new Accessory[4];
	// questItem inventory

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

	public final String getMyCharacterType() {
		return myCharacterType;
	}

	public final void setMyCharacterType(String theCharacterType) {
		myCharacterType = theCharacterType;
	}

	public String getMyAbility1() {
		return myAbility1;
	}

	public void setMyAbility1(final String theAbility1) {
		myAbility1 = theAbility1;
	}

	public String getMyAbility2() {
		return myAbility2;
	}

	public void setMyAbility2(final String theAbility2) {
		myAbility2 = theAbility2;
	}

	public final boolean hasTwoAbilities() {
		return hasTwoAbilities;
	}

	public final void setHasTwoAbilities(boolean theHasTwoAbilities) {
		hasTwoAbilities = theHasTwoAbilities;
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

	public void setMyCurrentHitPoints(final int theCurrentHitPoints) {
		if (theCurrentHitPoints >= this.getMyHitPointsMax()) {
			myCurrentHitPoints = getMyHitPointsMax();
		} else if (theCurrentHitPoints <= ZERO) {
			myCurrentHitPoints = ZERO;
			this.setAlive(false);
			System.out.println(getMyCharacterName() + " died!");
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

	public Item[] getMyInventory() {
		return myInventory;
	}

	public void setMyInventory(final Item[] theInventory) {
		myInventory = theInventory;
	}

	public Accessory[] getMyAccessories() {
		return myAccessories;
	}

	public void setMyAccessories(Accessory[] theAccessories) {
		myAccessories = theAccessories;
	}

	public final int getMyVisionRange() {
		return myVisionRange;
	}

	public final void setMyVisionRange(int myVisionRange) {
		this.myVisionRange = myVisionRange;
	}

	public int damageDealt() {
		return ThreadLocalRandom.current().nextInt(this.getMyAttackDamageMin(), this.getMyAttackDamageMax() + ONE);
	}

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
				System.out.println(this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName()
						+ "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
				theTarget.setMyCurrentHitPoints(theTarget.myCurrentHitPoints - damageDone);
			} else {
				System.out.println(this.getMyCharacterName() + "'s attack missed!");
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

	abstract void useAbility1(final DungeonCharacter theTarget);
	abstract void useAbility2(final DungeonCharacter theTarget);
}
