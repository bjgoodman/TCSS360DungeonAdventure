package model;

import java.util.concurrent.ThreadLocalRandom;

public class CharacterBarbarian extends DungeonCharacter {
	private static final int ZERO = 0;

	private static final String MY_DESCRIPTION = "The Barbarian is a fierce warrior, honed in" +
			" the art of the blade. He carries a claymore, a greatsword he wields with" +
			" both hands. His first ability is a great swing that attempts to cleave" +
			" his enemies limbs off, lowering their ability to defend themself. His second" +
			" ability is enrage, which raises his damage until the end of combat.";
	private static final char MY_REPRESENTING_CHARACTER = 'B';
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY1 = "Dismembering Swing";
	private static final String MY_ABILITY2 = "Enrage";
	private static final int MY_AD_MAX = 32;
	private static final int MY_AD_MIN = 19;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.69;
	private static final float MY_ABILITYCHANCE = (float) 0.2;
	private static final float MY_DEF = (float) 0.4;
	private static final int MY_HP = 175;

	public CharacterBarbarian(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterRepresentation(MY_REPRESENTING_CHARACTER);
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

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		final int SWING_MULTIPLIER = 2;
		final float SWING_DEBUFF = (float) 0.8;

		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "!");

		if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
			int damageDone = SWING_MULTIPLIER * (Math.round(damageDealt() * theTarget.getMyAttackReduction()));
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
			theTarget.setMyDefense(theTarget.getMyDefense() * SWING_DEBUFF);
			String abilityText = (this.getMyCharacterName() + " dealt " + damageDone +
					" to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName() +
					"'s defense dropped to " + Math.round(theTarget.getMyDefense() * 100) + "%.");

			System.out.println(abilityText);
		} else {
			System.out.println(this.getMyCharacterName() + "'s " + getMyAbility1() + " missed!");
		}
	}

	void useAbility2(DungeonCharacter theTarget) {
		// enrage ability goes here
		// have to figure out a limit to buff its DMG power in a battle later
	}
}
