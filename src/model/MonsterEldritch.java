package model;

import view.Interface;

import static model.MonsterFactory.theMonsterFactory;

public class MonsterEldritch extends Monster {

	private final String MY_DESCRIPTION = "Horrific and untamed comes a abomination from the Proterazoic era " +
			"which dwells in the present. Resurrected from the Eldritch Cultist, this god has been globetrotting the " + 
			" depths of earth searching for the remains of its allies. Its first special ability is to muster the negative " +
			"energy of everything through space and time to create a concussive and terrfiying blast of chaos towards its opponent.";
	private final String MY_CHARACTER_TYPE = "Eldritch God";
	private final char MY_REPRESENTING_CHARACTER = 'E';
	private final String MY_ABILITY = "Chaotic Blast"; // change the name?
	private int MY_ABILITY_DAMAGE = 30;
	private int MY_MAX_HP = 35;
	private int MY_AD_MAX = 24;
	private int MY_AD_MIN = 17;
	private float MY_ACHANCE = (float) 0.75;
	private float MY_ABILITYCHANCE = (float) 0.14;
	private float MY_HEAL_CHANCE = (float) 0.25;

	public MonsterEldritch(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Eldritch"), theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_HEAL_CHANCE);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY_DAMAGE);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() + ", dealing " +
				MY_ABILITY_DAMAGE + "!");
	}
}
