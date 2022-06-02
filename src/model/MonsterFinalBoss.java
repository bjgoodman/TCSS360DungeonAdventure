package model;

public class MonsterFinalBoss extends Monster {

	private static final String MY_DESCRIPTION = "The Final Boss... yeah, RUN!";
	private static final String MY_CHARACTER_TYPE = "Humanoid"; //will decide later
	private static final char MY_REPRESENTING_CHARACTER = 'B';
	private static final String MY_ABILITY1 = "God of Destruction"; // will create later
	private static final int MY_ABILITY1_DAMAGE = 60;
	private static final int MY_HP = 250;
	private static final int MY_AD_MAX = 45;
	private static final int MY_AD_MIN = 38;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.9;
	private static final float MY_ABILITYCHANCE = (float) 0.25;
	private static final float MY_DEF = (float) 0.5;
	private static final float MY_HEAL_CHANCE = (float) 0.3;

	public MonsterFinalBoss(String theName) {
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
