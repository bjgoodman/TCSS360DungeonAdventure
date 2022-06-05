package model;

import static model.MonsterFactory.theMonsterFactory;

public class MonsterOgre extends Monster {

	private final String MY_DESCRIPTION = "";
	private final String MY_CHARACTER_TYPE = "Ogre";
	private final char MY_REPRESENTING_CHARACTER = 'W';
	private final String MY_ABILITY = "Hammer Down"; // will come back and figure ability out
	private int MY_ABILITY1_DAMAGE = 52;
	private int MY_MAX_HP = 145;
	private int MY_AD_MAX = 26;
	private int MY_AD_MIN = 19;
	private float MY_ACHANCE = (float) 0.75;
	private float MY_ABILITYCHANCE = (float) 0.18;

	//TODO Do Something with this
	//private float MY_DEF = (float) 0.3;
	private float MY_HEAL_CHANCE = (float) 0.33;

	public MonsterOgre(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Ogre"), theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_HEAL_CHANCE);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");

	}
}
