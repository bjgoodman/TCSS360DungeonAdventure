/* CharacterBarbarian.java */

package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The stats and abilities of the Barbarian character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class CharacterBarbarian extends DungeonCharacter {

	/** description for the barbarian */
	private static final String MY_DESCRIPTION = "The Barbarian is a fierce warrior, honed in" +
			" the art of the blade. He carries a claymore, a greatsword he wields with" +
			" both hands. His first ability is a great swing that attempts to cleave" +
			" his enemies limbs off, lowering their ability to defend themself. His second" +
			" ability is enrage, which raises his damage until the end of combat.";

	/**  the barbarian's character type */
	private static final String MY_CHARACTER_TYPE = "Human";

	/**  the barbarian's first ability */
	private static final String MY_ABILITY1 = "Dismembering Swing";

	/**  the barbarian's second ability */
	private static final String MY_ABILITY2 = "Enrage";

	/**  the barbarian's maximum attack power */
	private static final int MY_AD_MAX = 32;

	/**  the barbarian's minimum attack power */
	private static final int MY_AD_MIN = 19;

	/**  the barbarian's attack speed */
	private static final int MY_AS = 1;

	/**  the barbarian's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.69;

	/**  the barbarian's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.2;

	/**  the barbarian's defense */
	private static final float MY_DEF = (float) 0.4;

	/**  the barbarian's total hit points */
	private static final int MY_HP = 175;

	/**
	 * Solidifies the Barbarian's stats within the game
	 * 
	 * @param theName the name of the Barbarian character
	 */
	public CharacterBarbarian(String theName) {
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
	 * the Barbarian's first ability
	 * 
	 * @param theTarget the current opponent that the Barbarian character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		final int SWING_MULTIPLIER = 2;
		final float SWING_DEBUFF = (float) 0.8;

		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "!");

		if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
			int damageDone = SWING_MULTIPLIER * (Math.round(damageDealt() * theTarget.getMyAttackReduction()));
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
			theTarget.setMyDefense(theTarget.getMyDefense() * SWING_DEBUFF);
			String abilityText = (this.getMyCharacterName() + " dealt " + damageDone +
					" to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName() +
					"'s defense dropped to " + Math.round(theTarget.getMyDefense() * 100) + "%.");

			System.out.println(abilityText);
		} else {
			System.out.println(this.getMyCharacterName() + "'s " + getMyAbility1() + " missed!");
		}
	}

	/**
	 * the Barbarian's second ability is when he building strength
	 * 
	 * @param theTarget the current opponent that the Barbarian character is facing
	 */
	void useAbility2(DungeonCharacter theTarget) {
		final int ATTACK_DEBUFF = 2;

		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "!");

		this.setMyAttackDamageMin(getMyAttackDamageMin() * ATTACK_DEBUFF);
		this.setMyAttackDamageMax(getMyAttackDamageMax() * ATTACK_DEBUFF);
	}

}
