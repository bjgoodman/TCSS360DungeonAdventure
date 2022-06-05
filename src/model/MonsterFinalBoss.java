package model;

import static model.MonsterFactory.theMonsterFactory;

public class MonsterFinalBoss extends Monster {

	private final String MY_DESCRIPTION = "The Final Boss... yeah, RUN!";
	private final String MY_CHARACTER_TYPE = "Humanoid"; //will decide later
	private final char MY_REPRESENTING_CHARACTER = 'B';
	private final String MY_ABILITY = "God of Destruction"; // will create later
	private int MY_ABILITY_DAMAGE = 60;
	private int MY_MAX_HP = 250;
	private int MY_AD_MAX = 45;
	private int MY_AD_MIN = 38;
	private float MY_ACHANCE = (float) 0.9;
	private float MY_ABILITYCHANCE = (float) 0.25;

	//TODO Do something with this
	//private float MY_DEF = (float) 0.5;
	private float MY_HEAL_CHANCE = (float) 0.3;

	public MonsterFinalBoss(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Final Boss"), theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_HEAL_CHANCE);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "! Damage: " +
				(MY_ABILITY_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}
}
