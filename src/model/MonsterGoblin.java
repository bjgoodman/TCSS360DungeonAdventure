package model;

public class MonsterGoblin extends Monster {


	private final String MY_DESCRIPTION = "Born into the abyss of the willow forest lies a maleficent  " +
			"creature. Found a scythe as a child and trained daily. There is no ordeal that he cannot cut his way " +
			"through. Her first ability is to slash the air with rapid speed towards opponent damaging them. Her " +
			"second ability is to grip her scythe and spin uncontrollably causing the enemy to be sucked into her " +
			"cyclone of horrifying cuts.";
	private final String MY_CHARACTER_TYPE = "Ogroid";
	private final char MY_REPRESENTING_CHARACTER = 'G';
	private final String MY_ABILITY = "Air Slash";
	private int MY_ABILITY_DAMAGE = 14;
	private int MY_MAX_HP = 98;
	private int MY_AD_MAX = 19;
	private int MY_AD_MIN = 11;
	private int MY_AS = 2;
	private float MY_ACHANCE = (float) 0.75;
	private float MY_ABILITYCHANCE = (float) 0.16;

	//TODO Do something with this
	//private float MY_DEF = (float) 0.17;
	private float MY_HEAL_CHANCE = (float) 0.1;
	
	public MonsterGoblin(String theName, Dungeon theDungeon) {
		super(theName, theDungeon);
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
