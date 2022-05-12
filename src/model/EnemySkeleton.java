package model;

import java.util.concurrent.ThreadLocalRandom;

public class EnemySkeleton extends DungeonCharacter {
	private static final int ZERO = 0;
	
	private static final String MY_DESCRIPTION = "The Skeleton is a reanimated cadaver that "
			+ "has long lost its flesh, only consisting of bones and scraps of cloth. "
			+ "It was doomed to walk the crypt forever... until now. His special ability "
			+ "is to rush the opponent down, attempting to inflict 5 instances of pitiful damage.";
	private static final String MY_CHARACTER_TYPE = "Undead";
	private static final String MY_ABILITY1 = "Rickety Rushdown";
	private static final int MY_AD_MAX = 18;
	private static final int MY_AD_MIN = 9;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.7;
	private static final float MY_ABILITYCHANCE = (float) 0.15;
	private static final float MY_DEF = (float) 0.1;
	private static final int MY_HP = 80;
	
	public EnemySkeleton(String theName) {
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
		this.fiveFoldStrikeSwing(theTarget, 1);
		this.fiveFoldStrikeSwing(theTarget, 2);
		this.fiveFoldStrikeSwing(theTarget, 3);
		this.fiveFoldStrikeSwing(theTarget, 4);
		this.fiveFoldStrikeSwing(theTarget, 5);
	}
	
	// BAD CODE SMELL HERE?
	private void fiveFoldStrikeSwing(DungeonCharacter theTarget, int strikeNumber) {
		float fiveFoldModifier = (float) 0.3;
		if (theTarget.isAlive() ) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt() * theTarget.getMyAttackReduction()) * fiveFoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ".");
				if (strikeNumber == 1) {
					abilityText += " One..!";
				} else if (strikeNumber == 2) {
					abilityText += " Two..!";
				} else if (strikeNumber == 3) {
					abilityText += " Three..!";
				} else if (strikeNumber == 4) {
					abilityText += " Four..!";
				} else if (strikeNumber == 5) {
					abilityText += " Five..?";
				}
				System.out.println(abilityText);
			} else {
				if (strikeNumber == 1) {
					System.out.println(this.getMyCharacterName() + "'s first hit missed!");
				} else if (strikeNumber == 2) {
					System.out.println(this.getMyCharacterName() + "'s second hit missed!");
				} else if (strikeNumber == 3) {
					System.out.println(this.getMyCharacterName() + "'s third hit missed!");
				} else if (strikeNumber == 4) {
					System.out.println(this.getMyCharacterName() + "'s fourth hit missed!");
				} else if (strikeNumber == 5) {
					System.out.println(this.getMyCharacterName() + "'s fifth hit missed!");
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
