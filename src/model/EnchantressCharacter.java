package model;

// import java.util.concurrent.ThreadLocalRandom;

public class EnchantressCharacter extends DungeonCharacter {
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

	public EnchantressCharacter(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setMyAbility2(MY_ABILITY2);
		setHasTwoAbilities(true);
		setMyAttackDamageMax(MY_AD_MAX);
		setMyAttackDamageMin(MY_AD_MIN);
		setMyDefaultAttackDamageMax(MY_AD_MAX);
		setMyDefaultAttackDamageMax(MY_AD_MIN);
		setMyAttackSpeed(MY_AS);
		setMyChanceToHit(MY_ACHANCE);
		setMyAbilityChance(MY_ABILITYCHANCE);
		setMyDefense(MY_DEF);
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
}
