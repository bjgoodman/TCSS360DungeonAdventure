package model;

public class MonsterEldritchGod extends Monster {

	private static final String MY_DESCRIPTION = "Horrific and untamed comes a abomination from the Proterazoic era " + 
			"which dwells in the present. Resurrected from the Eldritch Cultist, this god has been globetrotting the " + 
			" depths of earth searching for the remains of its allies. Its first special ability is to muster the negative " +
			"energy of everything through space and time to create a concussive and terrfiying blast of chaos towards its opponent.";
	private static final String MY_CHARACTER_TYPE = "Eldritch";
	private static final char MY_REPRESENTING_CHARACTER = 'E';
	private static final String MY_ABILITY = "Chaotic Blast"; // change the name?
	private static final int MY_ABILITY1_DAMAGE = 30;
	private static final int MY_HP = 137;
	private static final int MY_AD_MAX = 24;
	private static final int MY_AD_MIN = 17;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.75;
	private static final float MY_ABILITYCHANCE = (float) 0.14;
	private static final float MY_DEF = (float) 0.25;
	private static final float MY_HEAL_CHANCE = (float) 0.2;

	public MonsterEldritchGod(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_HEAL_CHANCE, MY_ABILITY);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}
}
