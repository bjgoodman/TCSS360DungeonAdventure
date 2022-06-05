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
	private int MY_ABILITY_DAMAGE = 19;
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
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY_DAMAGE);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() + ", dealing " +
				(MY_ABILITY_DAMAGE) + "! ");
	}
}
