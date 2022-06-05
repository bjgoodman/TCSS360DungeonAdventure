package model;

import view.Interface;

import java.util.concurrent.ThreadLocalRandom;

import static model.MonsterFactory.theMonsterFactory;

public class MonsterSkeleton extends Monster {

	private final String MY_DESCRIPTION = "The Skeleton is a reanimated cadaver that " +
			"has long lost its flesh, only consisting of bones and scraps of cloth. " +
			"It was doomed to walk the crypt forever... until now. His special ability " +
			"is to rush the opponent down, attempting to inflict 5 instances of pitiful damage.";
	private final String MY_CHARACTER_TYPE = "Skeleton";
	private final char MY_REPRESENTING_CHARACTER = 'S';
	private final String MY_ABILITY = "Rickety Rushdown";
	private int MY_MAX_HP = 45;
	private int MY_AD_MAX = 18;
	private int MY_AD_MIN = 9;
	private float MY_ACHANCE = (float) 0.7;
	private float MY_ABILITYCHANCE = (float) 0.15;

	private float MY_HEAL_CHANCE = (float) 0.33;

	public MonsterSkeleton(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Skeleton"), theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_HEAL_CHANCE);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		this.fiveFoldRushdown(theTarget, 1);
		this.fiveFoldRushdown(theTarget, 2);
		this.fiveFoldRushdown(theTarget, 3);
		this.fiveFoldRushdown(theTarget, 4);
		this.fiveFoldRushdown(theTarget, 5);
		int damageDone = this.fiveFoldRushdown(theTarget, 1) + this.fiveFoldRushdown(theTarget, 2)
				+ this.fiveFoldRushdown(theTarget, 3) + this.fiveFoldRushdown(theTarget, 4) +
				this.fiveFoldRushdown(theTarget, 5);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() + ", dealing " + damageDone + "!");
	}

	private int fiveFoldRushdown(DungeonCharacter theTarget, int strikeNumber) {
		float fiveFoldModifier = (float) 0.3;
		if (theTarget.isAlive()) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = Math.round((damageDealt()) * fiveFoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				return damageDone;
			}
		}
		return 0;
	}
}
