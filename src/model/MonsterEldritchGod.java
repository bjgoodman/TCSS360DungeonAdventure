package model;

public class MonsterEldritchGod extends Monster {

	private final String MY_DESCRIPTION = "Horrific and untamed comes a abomination from the Proterazoic era " +
			"which dwells in the present. Resurrected from the Eldritch Cultist, this god has been globetrotting the " + 
			" depths of earth searching for the remains of its allies. Its first special ability is to muster the negative " +
			"energy of everything through space and time to create a concussive and terrfiying blast of chaos towards its opponent.";
	private final String MY_CHARACTER_TYPE = "Eldritch";
	private final char MY_REPRESENTING_CHARACTER = 'E';
	private final String MY_ABILITY = "Chaotic Blast"; // change the name?
	private int MY_ABILITY_DAMAGE = 30;
	private int MY_MAX_HP = 137;
	private int MY_AD_MAX = 24;
	private int MY_AD_MIN = 17;
	private int MY_AS = 1;
	private float MY_ACHANCE = (float) 0.75;
	private float MY_ABILITYCHANCE = (float) 0.14;

	//TODO Do something with this
	//private float MY_DEF = (float) 0.25;
	private float MY_HEAL_CHANCE = (float) 0.2;

	public MonsterEldritchGod(String theName, Dungeon theDungeon) {
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
