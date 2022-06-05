package model;

public class MonsterCultist extends Monster {

	private final String MY_DESCRIPTION = "Mustered from the souls of anguish, rises a" +
			"sinister creature.";
	private final String MY_CHARACTER_TYPE = "Cultist";
	private final char MY_REPRESENTING_CHARACTER = 'C';
	private final String MY_ABILITY = "Spirit Explosion";
	private int MY_ABILITY_DAMAGE = 19;
	private int MY_MAX_HP = 113;
	private int MY_AD_MAX = 22;
	private int MY_AD_MIN = 13;
	private float MY_ACHANCE = (float) 0.8;
	private float MY_ABILITYCHANCE = (float) 0.14;

	//TODO Do something with this
	//private float MY_DEF = (float) 0.22;
	private float MY_HEAL_CHANCE = (float) 0.15;

	public MonsterCultist(Dungeon theDungeon, MonsterFactory theMonsterFactory) {
		super(theMonsterFactory.createName("Cultist"), theDungeon);
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
