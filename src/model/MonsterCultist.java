package model;

public class MonsterCultist extends Monster {

	private static final String MY_DESCRIPTION = "Mustered from the souls of anguish uprises a" +
			"sinister creature. Devastating villages with its ghostly presence, it " +
			"banishes those who are nearby. Its first ability is to summon an undead " + 
			"ally behind the enemy and clutching its back and self-destructing. Its second " +
			"ability is to syphon the HP of its enemy."; // do later
	private static final String MY_CHARACTER_TYPE = "Eldritch";
	private static final char MY_REPRESENTING_CHARACTER = 'C';
	private static final String MY_ABILITY = "Spirit Explosion";
	private static final int MY_ABILITY1_DAMAGE = 19;
	private static final int MY_HP = 113;
	private static final int MY_AD_MAX = 22;
	private static final int MY_AD_MIN = 13;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.8;
	private static final float MY_ABILITYCHANCE = (float) 0.14;
	private static final float MY_DEF = (float) 0.22;
	private static final float MY_HEAL_CHANCE = (float) 0.15;

	public MonsterCultist(String theName) {
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
