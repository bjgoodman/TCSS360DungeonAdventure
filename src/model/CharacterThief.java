package model;


/**
 * The stats and abilities of the Thief character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class CharacterThief extends DungeonCharacter {

	/** amount of damage dealt to opponents for the thief’s first ability */
	private static final int MY_ABILITY1_DAMAGE = 18;

	/** amount of damage dealt to opponents for the thief’s second ability */
	private static final int MY_ABILITY2_DAMAGE = 9;

	/** description for the thief */
	private static final String MY_DESCRIPTION = "Raised by assassins, the thief " +
			"stalks through the night searching for its prey. His first ability to " +
			"attack their a opponent with a dagger.";

	/**  the thief's character type */
	private static final String MY_CHARACTER_TYPE = "Human";

	/**  the thief's first ability */
	private static final String MY_ABILITY1 = "Cutthroat Mode";

	/**  the thief's second ability */
	private static final String MY_ABILITY2 = "Cutthroat Mode";

	/**  the thief's maximum attack power */
	private static final int MY_AD_MAX = 16;

	/**  the thief's minimum attack power */
	private static final int MY_AD_MIN = 11;

	/**  the thief's attack speed */
	private static final int MY_AS = 3;

	/**  the thief's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.65;

	/**  the thief's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.25;

	/**  the thief's defense */
	private static final float MY_DEF = (float) 0.35;

	/**  the thief's total hit points */
	private static final int MY_HP = 140;

	/**
	 * Solidifies the thief's stats within the game
	 * 
	 * @param theName the name of the thief character
	 */
	public CharacterThief(String theName) {
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
	 * the thief's first ability to run towards its enemy and slash them with a
	 * dagger gifted by the assassins.
	 * 
	 * @param theTarget the current opponent that the thief character is facing
	 */
	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");

	}

	/**
	 * the thief's second ability is to attack multiple times if the attack speed is
	 * faster than the opponent's.
	 * 
	 * @param theTarget the current opponent that the thief character is facing
	 */
	@Override
	void useAbility2(DungeonCharacter theTarget) {

		int heroesATKSpeed = (int) this.getMyAttackSpeed();
		int enemiesATKSpeed = (int) theTarget.getMyAttackSpeed();
		int heroesATKSpeedLossed = 0;

		while (heroesATKSpeed > enemiesATKSpeed) {
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY2_DAMAGE);
			System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "! Damage: " +
					(MY_ABILITY2_DAMAGE) + ". " +
					theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
			heroesATKSpeed--;
			heroesATKSpeedLossed++;
		}

		heroesATKSpeed += heroesATKSpeedLossed; // restore character's speed back to normal


	}

}
