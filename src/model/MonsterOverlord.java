package model;

import java.util.concurrent.ThreadLocalRandom;

public class MonsterOverlord extends Monster {
	private static final String MY_DESCRIPTION = "The Overlord is a fierce and agile fighter, armed with"
			+ " a deadly twinblade: a sword with blades on both sides of the hilt."
			+ " She attacks with speed, accuracy, and impunity. Her special ability is to"
			+ " spin her twinblade ferociously, attempting to inflict damage thrice.";
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY = "Threefold Slice";
	private static final char MY_REPRESENTING_CHARACTER = 'O';
	private static final int MY_HP = 150;
	private static final int MY_AD_MAX = 28;
	private static final int MY_AD_MIN = 21;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.8;
	private static final float MY_ABILITYCHANCE = (float) 0.21;
	private static final float MY_DEF = (float) 0.35;
	private static final float MY_HEAL_CHANCE = (float) 0.25;

	public MonsterOverlord(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_HEAL_CHANCE, MY_ABILITY);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "!");
		this.threeFoldStrikeSwing(theTarget, 1);
		this.threeFoldStrikeSwing(theTarget, 2);
		this.threeFoldStrikeSwing(theTarget, 3);
	}

	// BAD CODE SMELL HERE?
	private void threeFoldStrikeSwing(DungeonCharacter theTarget, int strikeNumber) {
		float threefoldModifier = (float) 0.9;
		if (theTarget.isAlive()) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt() * theTarget.getMyAttackReduction()) * threefoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ".");
				switch (strikeNumber) {
					case 1: abilityText += " One!";
					break;
					case 2: abilityText += " Two!";
					break;
					case 3: abilityText += " THREE!";
					break;
				}
				System.out.println(abilityText);
			} else {
				switch (strikeNumber) {
				case 1: System.out.println(this.getMyCharacterName() + "'s first swing missed!");
				break;
				case 2: System.out.println(this.getMyCharacterName() + "'s second swing missed!");
				break;
				case 3: System.out.println(this.getMyCharacterName() + "'s third swing missed!");
				break;
				}
			}
			System.out.println(theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		}
	}
}
