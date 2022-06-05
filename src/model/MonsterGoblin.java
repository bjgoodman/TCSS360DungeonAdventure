package model;

import view.Interface;

import static model.MonsterFactory.theMonsterFactory;

public class MonsterGoblin extends Monster {


	private final String MY_DESCRIPTION = "Born into the abyss of the willow forest lies a maleficent  " +
			"creature. Found a scythe as a child and trained daily. There is no ordeal that he cannot cut his way " +
			"through. Her first ability is to slash the air with rapid speed towards opponent damaging them. Her " +
			"second ability is to grip her scythe and spin uncontrollably causing the enemy to be sucked into her " +
			"cyclone of horrifying cuts.";
	private final String MY_CHARACTER_TYPE = "Goblin";
	private final char MY_REPRESENTING_CHARACTER = 'G';
	private final String MY_ABILITY = "Air Slash";
	private int MY_ABILITY_DAMAGE = 14;
	private int MY_MAX_HP = 48;
	private int MY_AD_MAX = 19;
	private int MY_AD_MIN = 11;
	private float MY_ACHANCE = (float) 0.75;
	private float MY_ABILITYCHANCE = (float) 0.16;

	private float MY_HEAL_CHANCE = (float) 0.1;
	
	public MonsterGoblin(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Goblin"), theDungeon);
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
