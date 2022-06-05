package model;

import view.Interface;

import java.util.concurrent.ThreadLocalRandom;

public class HeroBarbarian extends Hero {
	private static final int ZERO = 0;

	private final String MY_DESCRIPTION = "The Barbarian is a fierce warrior, honed in" +
			" the art of the blade. He carries a claymore, a greatsword he wields with" +
			" both hands. His first ability is a great swing that attempts to cleave" +
			" his enemies limbs off, lowering their ability to defend themself.";
	private final char MY_REPRESENTING_CHARACTER = 'B';
	private final String MY_CHARACTER_TYPE = "Human";
	private final String MY_ABILITY = "Dismembering Swing";
	private int MY_MAX_HP = 175;
	private int MY_AD_MAX = 52;
	private int MY_AD_MIN = 8;
	private float MY_ACHANCE = (float) 0.69;
	private float MY_ABILITYCHANCE = (float) 0.2;
	private float MY_BLOCK_CHANCE = (float) 0.45;

	public HeroBarbarian(String theName, Dungeon theDungeon) {
		super(theName, theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_BLOCK_CHANCE);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		final int SWING_MULTIPLIER = 2;

		if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
			int damageDone = SWING_MULTIPLIER * (Math.round(damageDealt()));
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
			String abilityText = (this.getMyCharacterName() + " used " + getMyAbility() + ", dealing " +
					damageDone + "!");
			Interface.newEvent(abilityText);
		} else {
			Interface.newEvent(this.getMyCharacterName() + "'s " + getMyAbility() + " missed!");
		}
	}
}
