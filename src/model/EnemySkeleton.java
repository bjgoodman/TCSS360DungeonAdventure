/* EnemySkeleton.java */

package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The stats and abilities of the skeleton character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class EnemySkeleton extends DungeonCharacter {

	/** description for the skeleton */
	private static final String MY_DESCRIPTION = "The Skeleton is a reanimated cadaver that " +
			"has long lost its flesh, only consisting of bones and scraps of cloth. " +
			"It was doomed to walk the crypt forever... until now. His special ability " +
			"is to rush the opponent down, attempting to inflict 5 instances of pitiful damage.";

	/**  the skeleton's character type */
	private static final String MY_CHARACTER_TYPE = "Undead";

	/**  the skeleton's first ability */
	private static final String MY_ABILITY1 = "Rickety Rushdown";

	/**  the skeleton's maximum attack power */
	private static final int MY_AD_MAX = 18;

	/**  the skeleton's minimum attack power */
	private static final int MY_AD_MIN = 9;

	/**  the skeleton's attack speed */
	private static final int MY_AS = 1;

	/**  the skeleton's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.7;

	/**  the skeleton's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.15;

	/**  the skeleton's defense */
	private static final float MY_DEF = (float) 0.1;

	/**  the skeleton's total hit points */
	private static final int MY_HP = 80;

	/**
	 * Solidifies the skeleton's stats within the game
	 * 
	 * @param theName the name of the skeleton character
	 */
	public EnemySkeleton(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setHasTwoAbilities(false);
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
	 * the skeleton's first ability is to rush down their opponent up to 5 times.
	 * 
	 * @param theTarget the current opponent that the skeleton character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "!");
		this.fiveFoldRushdown(theTarget, 1);
		this.fiveFoldRushdown(theTarget, 2);
		this.fiveFoldRushdown(theTarget, 3);
		this.fiveFoldRushdown(theTarget, 4);
		this.fiveFoldRushdown(theTarget, 5);
	}

	/**
	 * calculating the number of rush downs being dealt to the skeleton opponent
	 * whether the rush downs landed or missed.
	 * 
	 * @param theTarget the current opponent that the skeleton character is facing
	 * @param theStrikeNumber the number of rush downs that the skeleton dealt to the opponent
	 */
	private void fiveFoldRushdown(DungeonCharacter theTarget, int strikeNumber) {
		float fiveFoldModifier = (float) 0.3;
		if (theTarget.isAlive()) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt() * theTarget.getMyAttackReduction()) * fiveFoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone +
						" to " + theTarget.getMyCharacterName() + ".");
				if (strikeNumber == 1) {
					abilityText += " One..!";
				} else if (strikeNumber == 2) {
					abilityText += " Two..!";
				} else if (strikeNumber == 3) {
					abilityText += " Three..!";
				} else if (strikeNumber == 4) {
					abilityText += " Four..!";
				} else if (strikeNumber == 5) {
					abilityText += " Five..!?";
				}
				System.out.println(abilityText);
			} else {
				if (strikeNumber == 1) {
					System.out.println(this.getMyCharacterName() + "'s first hit missed!");
				} else if (strikeNumber == 2) {
					System.out.println(this.getMyCharacterName() + "'s second hit missed!");
				} else if (strikeNumber == 3) {
					System.out.println(this.getMyCharacterName() + "'s third hit missed!");
				} else if (strikeNumber == 4) {
					System.out.println(this.getMyCharacterName() + "'s fourth hit missed!");
				} else if (strikeNumber == 5) {
					System.out.println(this.getMyCharacterName() + "'s fifth hit missed!");
				}
			}
			System.out.println(theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		}
	}

	@Override
	void useAbility2(DungeonCharacter theTarget) {
		// DOES NOTHING BY DESIGN!
	}
}
