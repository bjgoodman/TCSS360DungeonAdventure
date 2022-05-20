/* EnemyFinalBoss.java */

package model;

/**
 * The stats and abilities of the final boss character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class EnemyFinalBoss extends DungeonCharacter {

	/** amount of damage dealt to opponents for the final boss first ability */
	private static final int MY_ABILITY1_DAMAGE = 60;

	/** description for the final boss */
	private static final String MY_DESCRIPTION = "Distrubance can result to death. " +
			"Please proceed with precaution unless you want a deathwish. Its first ability to " +
			"blast a beam of gammawaves leaving no chance of the opponent with no chance of escape.";

	/**  the final boss's character type */
	private static final String MY_CHARACTER_TYPE = "Eldritch";

	/**  the final boss's first ability */
	private static final String MY_ABILITY1 = "God of Destruction";

	/**  the final boss's maximum attack power */
	private static final int MY_AD_MAX = 45;

	/**  the final boss's minimum attack power */
	private static final int MY_AD_MIN = 38;

	/**  the final boss's attack speed */
	private static final int MY_AS = 1;

	/**  the final boss's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.9;

	/**  the final boss's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.25;

	/**  the final boss's defense */
	private static final float MY_DEF = (float) 0.5;

	/**  the final boss's total hit points */
	private static final int MY_HP = 250;

	/**
	 * Solidifies the final boss's stats within the game
	 * 
	 * @param theName the name of the final boss character
	 */
	public EnemyFinalBoss(String theName) {
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
	 * the final boss's first ability is blast a gamma beam from its mouth and deal a
	 * devastating damage to their opponent
	 * 
	 * @param theTarget the current opponent that the final boss character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}

	@Override
	void useAbility2(DungeonCharacter theTarget) { // will implement later
		// DOES NOTHING BY DESIGN!

	}

}
