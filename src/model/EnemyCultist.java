/* EnemyCultist.java  */

package model;

/**
 * The stats and abilities of the Cultist character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class EnemyCultist extends DungeonCharacter {

	/** amount of damage dealt to opponents for the cultist's first ability */
	private static final int MY_ABILITY1_DAMAGE = 19;

	/** amount of opponent's hit points siphoned to restore cultist's hit points
	 * for the cultist's second ability */
	private static final int MY_ABILITY2_DAMAGE = 12;

	/** description for the cultist */
	private static final String MY_DESCRIPTION = "Mustered from the souls of anguish uprises a" +
			"sinister creature. Devastating villages with its ghostly presence, it " +
			"banishes those who are nearby. Its first ability is to summon an undead " + 
			"ally behind the enemy and clutching its back and self-destructing. Its second " +
			"ability is to restore its hit piints by siphoning the HP of its enemy.";

	/**  the cultist's character type */
	private static final String MY_CHARACTER_TYPE = "Eldritch";

	/**  the cultist's first ability */
	private static final String MY_ABILITY1 = "Call of the Haunted";

	/**  the cultist's second ability */
	private static final String MY_ABILITY2 = "Soul Drain"; // get HP from opponent

	/**  the cultist's maximum attack power */
	private static final int MY_AD_MAX = 22;

	/**  the cultist's minimum attack power */
	private static final int MY_AD_MIN = 13;

	/**  the cultist's attack speed */
	private static final int MY_AS = 1;

	/**  the cultist's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.8;

	/**  the cultist's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.14;

	/**  the cultist's defense */
	private static final float MY_DEF = (float) 0.22;

	/**  the cultist's total hit points */
	private static final int MY_HP = 113;

	/**
	 * Solidifies the cultist's stats within the game
	 * 
	 * @param theName the name of the cultist character
	 */
	public EnemyCultist(String theName) {
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
	 * the cultist's first ability where it summons an undead ally from the ground to
	 * behind its enemies which proceeds to clutch the back of its enemy and then explode
	 * on contact.
	 * 
	 * @param theTarget the current opponent that the cultist character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}

	/**
	 * the cultist's second ability is to restore its own hit points by siphoning enemie's hit points.
	 * 
	 * @param theTarget the current opponent that the cultist character is facing
	 */
	@Override
	void useAbility2(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY2_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "! Damage: " +
				(MY_ABILITY2_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		this.setMyCurrentHitPoints(this.getMyCurrentHitPoints() + MY_ABILITY2_DAMAGE);
		System.out.println(this.getMyCharacterName() + "'s HP is now " + this.getMyCurrentHitPoints());
	}
}
