/* EnemyGoblin.java */

package model;

/**
 * The stats and abilities of the Goblin character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class EnemyGoblin extends DungeonCharacter {

	/** amount of damage dealt to opponents for the goblin's first ability */
	private static final int MY_ABILITY1_DAMAGE = 14;

	/** amount of damage dealt to opponents for the goblin's second ability */
	private static final int MY_ABILITY2_DAMAGE = 17;

	/** description for the goblin */
	private static final String MY_DESCRIPTION = "Born into the abyss of the willow forest lies a maleficent  " +
			"creature. Found a scythe as a child and trained daily. There is no ordeal that he cannot cut his way " +
			"through. Her first ability is to slash the air with rapid speed towards opponent damaging them. Her " +
			"second ability is to grip her scythe and spin uncontrollably causing the enemy to be sucked into her " +
			"cyclone of horrifying cuts.";

	/**  the goblin's character type */
	private static final String MY_CHARACTER_TYPE = "Eldritch";

	/**  the goblin's first ability */
	private static final String MY_ABILITY1 = "Sonic Slash";

	/**  the goblin's second ability */
	private static final String MY_ABILITY2 = "Cyclone"; // spins with scythe in a circle bringing the enemy closer to get slashed

	/**  the goblin's maximum attack power */
	private static final int MY_AD_MAX = 19;

	/**  the goblin's minimum attack power */
	private static final int MY_AD_MIN = 11;

	/**  the goblin's attack speed */
	private static final int MY_AS = 2; // have more speed

	/**  the goblin's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.75;

	/**  the goblin's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.16;

	/**  the goblin's defense */
	private static final float MY_DEF = (float) 0.17;

	/**  the goblin's total hit points */
	private static final int MY_HP = 98;

	/**
	 * Solidifies the goblin's stats within the game
	 * 
	 * @param theName the name of the goblin character
	 */
	public EnemyGoblin(String theName) {
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
	 * the goblin's first ability is where it swings its scythe with tremendous speed
	 * slashing its opponent from afar.
	 * 
	 * @param theTarget the current opponent that the goblin character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}

	/**
	 * the goblin's second ability is where it clutches its scythe and twirls creating
	 * an enormous cyclone causing the opponent to be sucked in and damaged by numerous slashes.
	 * 
	 * @param theTarget the current opponent that the goblin character is facing
	 */
	@Override
	void useAbility2(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY2_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "! Damage: " +
				(MY_ABILITY2_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}

}
