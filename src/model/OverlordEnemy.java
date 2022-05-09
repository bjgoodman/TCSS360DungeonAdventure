package model;

import java.util.concurrent.ThreadLocalRandom;

public class OverlordEnemy extends DungeonCharacter {
	private static final int ZERO = 0;
	
	private static final String MY_DESCRIPTION = "The Overlord is a fierce and agile fighter, armed with"
			+ " a deadly twinblade: a sword with blades on both sides of the hilt."
			+ " She attacks with speed, accuracy, and impunity. Her special ability is to"
			+ " spin her twinblade ferociously, attempting to inflict damage thrice.";
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY1 = "Threefold Slice";
	private static final int MY_AD_MAX = 28;
	private static final int MY_AD_MIN = 21;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.8;
	private static final float MY_ABILITYCHANCE = (float) 0.12;
	private static final float MY_DEF = (float) 0.35;
	private static final int MY_HP = 150;
	
	public OverlordEnemy(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setHasTwoAbilities(false);
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
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "!");
		this.threeFoldStrikeSwing(theTarget, 1);
		this.threeFoldStrikeSwing(theTarget, 2);
		this.threeFoldStrikeSwing(theTarget, 3);
	}
	
	// BAD CODE SMELL HERE?
	private void threeFoldStrikeSwing(DungeonCharacter theTarget, int strikeNumber) {
		float threefoldModifier = (float) 0.9;
		if (theTarget.isAlive() ) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt() * theTarget.getMyAttackReduction()) * threefoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ".");
				if (strikeNumber == 1) {
					abilityText += " One!";
				} else if (strikeNumber == 2) {
					abilityText += " Two!";
				} else if (strikeNumber == 3) {
					abilityText += " THREE!";
				}
				System.out.println(abilityText);
			} else {
				if (strikeNumber == 1) {
					System.out.println(this.getMyCharacterName() + "'s first swing missed!");
				} else if (strikeNumber == 2) {
					System.out.println(this.getMyCharacterName() + "'s second swing missed!");
				} else if (strikeNumber == 3) {
					System.out.println(this.getMyCharacterName() + "'s third swing missed!");
				}
			}
			System.out.println(theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		}
	}

	@Override
	void useAbility2(DungeonCharacter theTarget) {
		// DOES NOTHING BY DESIGN!
	}
}
