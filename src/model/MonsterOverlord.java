package model;

import view.Interface;

import java.util.concurrent.ThreadLocalRandom;

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
	private int MY_MAX_HP = 100;
	private int MY_AD_MAX = 28;
	private int MY_AD_MIN = 15;
	private float MY_ACHANCE = (float) 0.8;
	private float MY_ABILITYCHANCE = (float) 0.21;

	private float MY_HEAL_CHANCE = (float) 0.1;

	public MonsterOverlord(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Overlord"), theDungeon);
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
