package model;

import view.Interface;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static model.Dungeon.monsterstats;
import static model.MonsterFactory.theMonsterFactory;

/**
 * Defines values and behaviors for Skeletons.
 */
public class MonsterSkeleton extends Monster {

	private final String MY_DESCRIPTION = "The Skeleton is a reanimated cadaver that " +
			"has long lost its flesh, only consisting of bones and scraps of cloth. " +
			"It was doomed to walk the crypt forever... until now. His special ability " +
			"is to rush the opponent down, attempting to inflict 5 instances of pitiful damage.";
	private final String MY_CHARACTER_TYPE = "Skeleton";
	private final char MY_REPRESENTING_CHARACTER = 'S';
	private final String MY_ABILITY = "Rickety Rushdown";
	private int MY_ABILITY_DAMAGE = 19;

	/**
	 * Constructor for Skeletons
	 *
	 * @param theName The name of the Skeleton
	 * @param theDungeon The dungeon in which the Skeleton resides
	 */
	public MonsterSkeleton(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Skeleton"), theDungeon);
		ArrayList<Float> myStats = monsterstats.get("Skeleton");
		int maxhp = myStats.get(1).intValue();
		int admax = myStats.get(2).intValue();
		int admin = myStats.get(3).intValue();
		float achance = myStats.get(4);
		float abilitychance = myStats.get(5);
		float healchance = myStats.get(6);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, maxhp, admin, admax, achance, abilitychance, healchance);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY_DAMAGE);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() + ", dealing " +
				(MY_ABILITY_DAMAGE) + "! ");
	}
}
