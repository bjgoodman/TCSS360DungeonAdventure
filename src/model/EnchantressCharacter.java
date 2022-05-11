package model;

// import java.util.concurrent.ThreadLocalRandom;

public class EnchantressCharacter extends DungeonCharacter {
<<<<<<< HEAD

	/* make another character to lessen our user stories for the TEAM!! */

	private static final String MY_DESCRIPTION = "The Enchantress is magical goddess, descent from a Magician " +
			"of black chaos. She embues magic with her hands to summon her " +
			"most powerful spells to vanquish those who oppose. Her special " + 
			"ability is heal herself when in danger.";

	private static final String MY_ABILITY = "Revitilize";
	// maybe add spells to increase her attributes later?
	private static final int MY_AD_MAX = 25;
	private static final int MY_AD_MIN = 16;
	private static final int MY_AS = 2;
	private static final float MY_ACHANCE = (float) 0.53;
	private static final float MY_ABILITYCHANCE = (float) 0.35;
	private static final float MY_DEF = (float) 0.3;
	private static final int MY_HP = 185;
=======
	private static final int MY_HP_RESTORE = 50;
	private static final int MY_ABILITY2_DAMAGE = 34;
	
	private static final String MY_DESCRIPTION = "The Enchantress is magical goddess, the descent of a line " +
			"of priests to the king. She imbues her hands with magic to summon " +
			"powerful spells, vanquishing those who oppose her. Her first special " + 
			"ability is heal herself when in danger. Her second special ability is " +
			"a powerful explosion of holy magic that vapourises undead enemies.";
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY1 = "Revitalise";
	private static final String MY_ABILITY2 = "Wrath of God";
	private static final int MY_AD_MAX = 21;
	private static final int MY_AD_MIN = 15;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.7;
	private static final float MY_ABILITYCHANCE = (float) 0.2;
	private static final float MY_DEF = (float) 0.3;
	private static final int MY_HP = 100;
>>>>>>> 9088d30a0677da8de45c551d7a57635e3001ef3e

	public EnchantressCharacter(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
<<<<<<< HEAD
		setMyAbilityName(MY_ABILITY);
		setMyAttackDamageMax(MY_AD_MAX);
		setMyAttackDamageMin(MY_AD_MIN);
=======
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setMyAbility2(MY_ABILITY2);
		setHasTwoAbilities(true);
		setMyAttackDamageMax(MY_AD_MAX);
		setMyAttackDamageMin(MY_AD_MIN);
		setMyDefaultAttackDamageMax(MY_AD_MAX);
		setMyDefaultAttackDamageMax(MY_AD_MIN);
>>>>>>> 9088d30a0677da8de45c551d7a57635e3001ef3e
		setMyAttackSpeed(MY_AS);
		setMyChanceToHit(MY_ACHANCE);
		setMyAbilityChance(MY_ABILITYCHANCE);
		setMyDefense(MY_DEF);
<<<<<<< HEAD
		setMyHitPoints(MY_HP);
		setMyCurrentHitPoints(MY_HP);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		// final int SWING_MULTIPLIER = 2;
		// final float SWING_DEBUFF = (float) 0.8;

		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbilityName() + "!");


		if (this.getMyHitPoints() <= 40) {
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() * 2);
		} else {
			// sometimes special ability misses?
			System.out.println(this.getMyCharacterName() + "'s " + getMyAbilityName() + " missed!");
		}
		if (theTarget.getMyCurrentHitPoints() <= ZERO) {
			System.out.println(theTarget.getMyCharacterName() + " died!");
			theTarget.setAlive(false);
		}


	}

=======
		setMyHitPointsMax(MY_HP);
		setMyCurrentHitPoints(MY_HP);
	}

	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! "
				+ this.getMyCharacterName() + "'s HP is now " + this.getMyCurrentHitPoints() + ".");
		this.setMyCurrentHitPoints(this.getMyCurrentHitPoints() + MY_HP_RESTORE);
	}

	void useAbility2(DungeonCharacter theTarget) {
		final int TWO = 2;
		
		if (theTarget.getMyCharacterType() == "Undead") {
			System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + " on an Undead enemy! Critical damage! "
					+ theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - (MY_ABILITY2_DAMAGE * TWO));
		} else {
			System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "! "
					+ theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY2_DAMAGE);
		}
	}
>>>>>>> 9088d30a0677da8de45c551d7a57635e3001ef3e
}
