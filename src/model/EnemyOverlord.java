/* EnemyOverlord.java */

package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The stats and abilities of the Overlord character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class EnemyOverlord extends DungeonCharacter {


	/** description for the Overlord */
	private static final String MY_DESCRIPTION = "The Overlord is a fierce and agile fighter, armed with"
			+ " a deadly twinblade: a sword with blades on both sides of the hilt."
			+ " She attacks with speed, accuracy, and impunity. Her special ability is to"
			+ " spin her twinblade ferociously, attempting to inflict damage thrice.";

	/**  the overlord's character type */
	private static final String MY_CHARACTER_TYPE = "Human";

	/**  the overlord's first ability */
	private static final String MY_ABILITY1 = "Threefold Slice";

	/**  the overlord's maximum attack power */
	private static final int MY_AD_MAX = 28;

	/**  the overlord's minimum attack power */
	private static final int MY_AD_MIN = 21;

	/**  the overlord's attack speed */
	private static final int MY_AS = 1;

	/**  the overlord's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.8;

	/**  the overlord's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.21;

	/**  the overlord's defense */
	private static final float MY_DEF = (float) 0.35;

	/**  the overlord's total hit points */
	private static final int MY_HP = 150;

	/**
	 * Solidifies the overlord's stats within the game
	 * 
	 * @param theName the name of the overlord character
	 */
	public EnemyOverlord(String theName) {
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
	 * the overlord's first ability where  against
	 * an enemy in battle.
	 * 
	 * @param theTarget the current opponent that the overlord character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "!");
		this.threeFoldStrikeSwing(theTarget, 1);
		this.threeFoldStrikeSwing(theTarget, 2);
		this.threeFoldStrikeSwing(theTarget, 3);
	}

	/**
	 * calculating the number of strikes being dealt to the overload's opponent
	 * whether the strikes landed or missed.
	 * 
	 * @param theTarget the current opponent that the overlord character is facing
	 * @param theStrikeNumber the number of strikes that the overload dealt to the opponent
	 */
	private void threeFoldStrikeSwing(DungeonCharacter theTarget, int theStrikeNumber) {
		float threefoldModifier = (float) 0.9;
		if (theTarget.isAlive()) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt() * theTarget.getMyAttackReduction()) * threefoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ".");
				if (theStrikeNumber == 1) {
					abilityText += " One!";
				} else if (theStrikeNumber == 2) {
					abilityText += " Two!";
				} else if (theStrikeNumber == 3) {
					abilityText += " THREE!";
				}
				System.out.println(abilityText);
			} else {
				if (theStrikeNumber == 1) {
					System.out.println(this.getMyCharacterName() + "'s first swing missed!");
				} else if (theStrikeNumber == 2) {
					System.out.println(this.getMyCharacterName() + "'s second swing missed!");
				} else if (theStrikeNumber == 3) {
					System.out.println(this.getMyCharacterName() + "'s third swing missed!");
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
