package model;

/**
 * The stats and abilities of the EldritchGod character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class EnemyEldritchGod extends DungeonCharacter {

	private static final int MY_ABILITY1_DAMAGE = 30;

	/** description for the EldritchGod */
	private static final String MY_DESCRIPTION = "Horrific and untamed comes a abomination from the Proterazoic era " + 
			"which dwells in the present. Resurrected from the Eldritch Cultists, this god has been globetrotting the " + 
			"depths of earth searching for the remains of its allies. Its first special ability is to muster the negative " +
			"energy of everything through space and time to create a concussive and terrfiying blast of chaos towards its opponent.";

	/**  the EldritchGod's character type */
	private static final String MY_CHARACTER_TYPE = "Eldritch";

	/**  the EldritchGod's first ability */
	private static final String MY_ABILITY1 = "Chaotic Blast";

	/**  the EldritchGod's maximum attack power */
	private static final int MY_AD_MAX = 24;

	/**  the EldritchGod's minimum attack power */
	private static final int MY_AD_MIN = 17;

	/**  the EldritchGod's attack speed */
	private static final int MY_AS = 1;

	/**  the EldritchGod's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.75;

	/**  the EldritchGod's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.14;

	/**  the EldritchGod's defense */
	private static final float MY_DEF = (float) 0.25;

	/**  the EldritchGod's total hit points */
	private static final int MY_HP = 137;

	/**
	 * Solidifies the EldritchGod's stats within the game
	 * 
	 * @param theName the name of the EldritchGod character
	 */
	public EnemyEldritchGod(String theName) {
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
	 * the EldritchGod's first ability is a blast of negative energy mustered from
	 * everything through space and time
	 * an enemy in battle.
	 * 
	 * @param theTarget the current opponent that the EldritchGod character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}

	@Override
	void useAbility2(DungeonCharacter theTarget) {
		// DOES NOTHING BY DESIGN

	}

}
