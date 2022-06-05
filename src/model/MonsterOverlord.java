package model;

import view.Interface;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static model.Dungeon.monsterstats;
import static model.MonsterFactory.theMonsterFactory;

public class MonsterOverlord extends Monster {
	private final String MY_DESCRIPTION = "The Overlord is a fierce and agile fighter, armed with"
			+ " a deadly twinblade: a sword with blades on both sides of the hilt."
			+ " She attacks with speed, accuracy, and impunity. Her special ability is to"
			+ " spin her twinblade ferociously, attempting to inflict damage thrice.";
	private final String MY_CHARACTER_TYPE = "Overlord";
	private final String MY_ABILITY = "Threefold Slice";
	private final char MY_REPRESENTING_CHARACTER = 'O';
	private int MY_ABILITY_DAMAGE = 35;

	public MonsterOverlord(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Overlord"), theDungeon);
		ArrayList<Float> myStats = monsterstats.get("Overlord");
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
