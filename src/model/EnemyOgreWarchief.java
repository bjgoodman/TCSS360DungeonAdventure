/* EnemyOgreWarchief.java */

package model;

/**
 * The stats and abilities of the OgreWarchief character within
 * Dungeon Adventure.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/20/2022
 */
public class EnemyOgreWarchief extends DungeonCharacter {

	/** amount of damage dealt to opponents for the OgreWarchief’s first ability */
	private static final int MY_ABILITY1_DAMAGE = 34;

	/** description for the OgreWarchief */
	private static final String MY_DESCRIPTION = " Coming from the abyss of the " +
			"Orichalcum's cave is a beast that was caged by overlords. Crept in the " + 
			"shadows were cultists who confronted the beast with an offer for " +
			"freedom. Now set free rampaging across parts of the nation comes a new " +
			"ally for the cultist which is labeled as their tank for destruction; " + 
			"OgreWarchief with an ability to smash its opponents with a terrifying club.";

	/**  the OgreWarchief's character type */
	private static final String MY_CHARACTER_TYPE = "Ogre";

	/**  the OgreWarchief's first ability */
	private static final String MY_ABILITY1 = "Full Throttle Smash";

	/**  the OgreWarchief's maximum attack power */
	private static final int MY_AD_MAX = 26;

	/**  the OgreWarchief's minimum attack power */
	private static final int MY_AD_MIN = 19;

	/**  the OgreWarchief's attack speed */
	private static final int MY_AS = 1;

	/**  the OgreWarchief's chances of attacking enemies */
	private static final float MY_ACHANCE = (float) 0.75;

	/**  the OgreWarchief's chances of his abilities activating */
	private static final float MY_ABILITYCHANCE = (float) 0.18;

	/**  the OgreWarchief's defense */
	private static final float MY_DEF = (float) 0.3;

	/**  the OgreWarchief's total hit points */
	private static final int MY_HP = 145;

	/**
	 * Solidifies the OgreWarchief's stats within the game
	 * 
	 * @param theName the name of the OgreWarchief character
	 */
	public EnemyOgreWarchief(String theName) {
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
	 * the OgreWarchief's first ability is to smash its opponent with a club at
	 * tremendous speed
	 * 
	 * @param theTarget the current opponent that the OgreWarchief character is facing
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
		// DOES NOTHING BY DESIGN!
	}

}
