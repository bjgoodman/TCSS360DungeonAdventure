package model;

import java.util.concurrent.ThreadLocalRandom;

public class HeroBarbarian extends Hero {
	private static final int ZERO = 0;

	private static final String MY_DESCRIPTION = "The Barbarian is a fierce warrior, honed in" +
			" the art of the blade. He carries a claymore, a greatsword he wields with" +
			" both hands. His first ability is a great swing that attempts to cleave" +
			" his enemies limbs off, lowering their ability to defend themself.";
	private static final char MY_REPRESENTING_CHARACTER = 'B';
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY = "Dismembering Swing";
	private static final int MY_HP = 175;
	private static final int MY_AD_MAX = 32;
	private static final int MY_AD_MIN = 19;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.69;
	private static final float MY_ABILITYCHANCE = (float) 0.2;
	private static final float MY_DEF = (float) 0.4;
	private static final float MY_BLOCK_CHANCE = (float) 0.33;

	public HeroBarbarian(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_BLOCK_CHANCE, MY_ABILITY);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		final int SWING_MULTIPLIER = 2;
		final float SWING_DEBUFF = (float) 0.8;

		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "!");

		if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
			int damageDone = SWING_MULTIPLIER * (Math.round(damageDealt() * theTarget.getMyAttackReduction()));
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
			theTarget.setMyDefense(theTarget.getMyDefense() * SWING_DEBUFF);
			String abilityText = (this.getMyCharacterName() + " dealt " + damageDone +
					" to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName() +
					"'s defense dropped to " + Math.round(theTarget.getMyDefense() * 100) + "%.");

			System.out.println(abilityText);
		} else {
			System.out.println(this.getMyCharacterName() + "'s " + getMyAbility() + " missed!");
		}
	}
}
