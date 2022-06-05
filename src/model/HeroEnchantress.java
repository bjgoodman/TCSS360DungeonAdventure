package model;

// import java.util.concurrent.ThreadLocalRandom;

import view.Interface;

public class HeroEnchantress extends Hero {
	private int MY_HP_RESTORE = 50;
	private final String MY_DESCRIPTION = "The holy enchantress, descent of a line " +
			"of priests to the king. She imbues her hands with magic to summon " +
			"powerful spells, vanquishing those who oppose her. Her first special " + 
			"ability is to heal herself when in danger.";
	private final char MY_REPRESENTING_CHARACTER = 'E';
	private final String MY_CHARACTER_TYPE = "Human";
	private final String MY_ABILITY = "Revitalise";
	private int MY_MAX_HP = 100;
	private int MY_AD_MAX = 29;
	private int MY_AD_MIN = 21;
	private float MY_ACHANCE = (float) 0.7;
	private float MY_ABILITYCHANCE = (float) 0.33;

	private float MY_BLOCK_CHANCE = (float) 0.25;

	public HeroEnchantress(String theName, Dungeon theDungeon) {
		super(theName, theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_BLOCK_CHANCE);
	}

	void useAbility(DungeonCharacter theTarget) {
		this.setMyCurrentHitPoints(this.getMyCurrentHitPoints() + MY_HP_RESTORE);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() +
				", healing for " + MY_HP_RESTORE + "!");
	}
}
