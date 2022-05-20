/* CharacterEnchantress.java */

package model;

/**
 * The stats and abilities of the Enchantress character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class CharacterEnchantress extends DungeonCharacter {
	
	/** amount of hit points restored for the enchantress's first ability */
	private static final int MY_HP_RESTORE = 50;
	
	/** amount of damage dealt to opponents for the enchantress's second ability */
	private static final int MY_ABILITY2_DAMAGE = 25;

	/** description for the enchantress */
	private static final String MY_DESCRIPTION = "The holy enchantress, descent of a line " +
			"of priests to the king. She imbues her hands with magic to summon " +
			"powerful spells, vanquishing those who oppose her. Her first special " + 
			"ability is to heal herself when in danger. Her second special ability is " +
			"a powerful explosion of holy magic that does major damage and vapourises undead enemies.";
	
	/**  the enchantress's character type */
	private static final String MY_CHARACTER_TYPE = "Human";

	/**  the enchantress's first ability */
	private static final String MY_ABILITY1 = "Revitalise";

	/**  the enchantress's second ability */
	private static final String MY_ABILITY2 = "Wrath of God";

	/**  the enchantress's maximum attack power */
	private static final int MY_AD_MAX = 21;

	/**  the enchantress's minimum attack power */
	private static final int MY_AD_MIN = 15;

	/**  the enchantress's attack speed */
	private static final int MY_AS = 1;

	/**  the enchantress's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.7;

	/**  the enchantress's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.2;

	/**  the enchantress's defense */
	private static final float MY_DEF = (float) 0.3;

	/**  the enchantress's total hit points */
	private static final int MY_HP = 100;

	/**
	 * Solidifies the enchantress's stats within the game
	 * 
	 * @param theName the name of the enchantress character
	 */
	public CharacterEnchantress(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setMyAbility2(MY_ABILITY2);
		setHasTwoAbilities(true);
		setMyAttackDamageMax(MY_AD_MAX);
		setMyAttackDamageMin(MY_AD_MIN);
		setMyDefaultAttackDamageMax(MY_AD_MAX);
		setMyDefaultAttackDamageMin(MY_AD_MIN);
		setMyAttackSpeed(MY_AS);
		setMyChanceToHit(MY_ACHANCE);
		setMyAbilityChance(MY_ABILITYCHANCE);
		setMyDefense(MY_DEF);
		setMyHitPointsMax(MY_HP);
		setMyCurrentHitPoints(MY_HP);
	}

	/**
	 * the enchantress's first ability where she heals herself when in dire need against
	 * an enemy in battle.
	 * 
	 * @param theTarget the current opponent that the enchantress character is facing
	 */
	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " +
				this.getMyAbility1() + "! " + this.getMyCharacterName() +
				"'s HP is now " + this.getMyCurrentHitPoints() + ".");
		System.out.println(this.getMyCharacterName() + "'s HP is now " +
				(this.getMyCurrentHitPoints() + MY_HP_RESTORE) + ".");

		this.setMyCurrentHitPoints(this.getMyCurrentHitPoints() + MY_HP_RESTORE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() +
				"! " + this.getMyCharacterName() + "'s HP is now " + (this.getMyCurrentHitPoints()) + ".");
	}

	/**
	 * the enchantress's second ability where she blasts an enemy with a powerful explosion 
	 * of holy magic dealing great damage and double damage for undead enemies.
	 * 
	 * @param theTarget the current opponent that the enchantress character is facing
	 */
	void useAbility2(DungeonCharacter theTarget) {
		final int TWO = 2;

		if (theTarget.getMyCharacterType() == "Undead") {
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - (MY_ABILITY2_DAMAGE * TWO));
			System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() +
					" on an Undead enemy! Critical damage: " + (MY_ABILITY2_DAMAGE * TWO) + ". " +
					theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		} else {
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY2_DAMAGE);
			System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "! Damage: " +
					(MY_ABILITY2_DAMAGE) + ". " +
					theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		}
	}

}
