package model;

// import java.util.concurrent.ThreadLocalRandom;

public class HeroEnchantress extends Hero {
	private static final int MY_HP_RESTORE = 50;
	private static final int MY_ABILITY2_DAMAGE = 25;
	private static final String MY_DESCRIPTION = "The holy enchantress, descent of a line " +
			"of priests to the king. She imbues her hands with magic to summon " +
			"powerful spells, vanquishing those who oppose her. Her first special " + 
			"ability is to heal herself when in danger. Her second special ability is " +
			"a powerful explosion of holy magic that does major damage and vapourises undead enemies.";
	private static final char MY_REPRESENTING_CHARACTER = 'E';
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY = "Revitalise";
	private static final int MY_HP = 100;
	private static final int MY_AD_MAX = 21;
	private static final int MY_AD_MIN = 15;
	private static final float MY_ACHANCE = (float) 0.7;
	private static final float MY_ABILITYCHANCE = (float) 0.2;
	private static final float MY_DEF = (float) 0.3;
	private static final float MY_BLOCK_CHANCE = (float) 0.25;


	public HeroEnchantress(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_BLOCK_CHANCE, MY_ABILITY);
	}

	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " +
				this.getMyAbility() + "! " + this.getMyCharacterName() +
				"'s HP is now " + this.getMyCurrentHitPoints() + ".");
		System.out.println(this.getMyCharacterName() + "'s HP is now " +
				(this.getMyCurrentHitPoints() + MY_HP_RESTORE) + ".");

		this.setMyCurrentHitPoints(this.getMyCurrentHitPoints() + MY_HP_RESTORE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() +
				"! " + this.getMyCharacterName() + "'s HP is now " + (this.getMyCurrentHitPoints()) + ".");
	}
}
