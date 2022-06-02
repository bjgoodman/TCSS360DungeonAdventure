package model;

public class MonsterOgreWarchief extends Monster {

	private static final String MY_DESCRIPTION = "";
	private static final String MY_CHARACTER_TYPE = "Ogroid";
	private static final char MY_REPRESENTING_CHARACTER = 'W';
	private static final String MY_ABILITY1 = "Hammer Down"; // will come back and figure ability out
	private static final int MY_ABILITY1_DAMAGE = 52;
	private static final int MY_HP = 145;
	private static final int MY_AD_MAX = 26;
	private static final int MY_AD_MIN = 19;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.75;
	private static final float MY_ABILITYCHANCE = (float) 0.18;
	private static final float MY_DEF = (float) 0.3;
	private static final float MY_HEAL_CHANCE = (float) 0.33;

	public MonsterOgreWarchief(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_HEAL_CHANCE, MY_ABILITY1);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");

	}
}
