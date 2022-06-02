package model;

import java.util.concurrent.ThreadLocalRandom;

public class MonsterSkeleton extends Monster {

	private static final String MY_DESCRIPTION = "The Skeleton is a reanimated cadaver that " +
			"has long lost its flesh, only consisting of bones and scraps of cloth. " +
			"It was doomed to walk the crypt forever... until now. His special ability " +
			"is to rush the opponent down, attempting to inflict 5 instances of pitiful damage.";
	private static final String MY_CHARACTER_TYPE = "Undead";
	private static final char MY_REPRESENTING_CHARACTER = 'S';
	private static final String MY_ABILITY = "Rickety Rushdown";
	private static final int MY_HP = 80;
	private static final int MY_AD_MAX = 18;
	private static final int MY_AD_MIN = 9;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.7;
	private static final float MY_ABILITYCHANCE = (float) 0.15;
	private static final float MY_DEF = (float) 0.1;
	private static final float MY_HEAL_CHANCE = (float) 0.05;

	public MonsterSkeleton(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_HEAL_CHANCE, MY_ABILITY);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "!");
		this.fiveFoldRushdown(theTarget, 1);
		this.fiveFoldRushdown(theTarget, 2);
		this.fiveFoldRushdown(theTarget, 3);
		this.fiveFoldRushdown(theTarget, 4);
		this.fiveFoldRushdown(theTarget, 5);
	}

	// BAD CODE SMELL HERE?
	private void fiveFoldRushdown(DungeonCharacter theTarget, int strikeNumber) {
		float fiveFoldModifier = (float) 0.3;
		if (theTarget.isAlive()) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt() * theTarget.getMyAttackReduction()) * fiveFoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone +
						" to " + theTarget.getMyCharacterName() + ".");
				if (strikeNumber == 1) {
					abilityText += " One..!";
				} else if (strikeNumber == 2) {
					abilityText += " Two..!";
				} else if (strikeNumber == 3) {
					abilityText += " Three..!";
				} else if (strikeNumber == 4) {
					abilityText += " Four..!";
				} else if (strikeNumber == 5) {
					abilityText += " Five..!?";
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
}
