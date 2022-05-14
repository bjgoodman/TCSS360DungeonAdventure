package model;

public class EnemyCultist extends DungeonCharacter {

	private static final int MY_ABILITY1_DAMAGE = 19;
	private static final int MY_ABILITY2_DAMAGE = 12;

	private static final String MY_DESCRIPTION = "Mustered from the souls of anguish uprises a" +
			"sinister creature. Devastating villages with its ghostly presence, it " +
			"banishes those who are nearby. Its first ability is to summon an undead " + 
			"ally behind the enemy and clutching its back and self-destructing. Its second " +
			"ability is to syphon the HP of its enemy."; // do later
	private static final String MY_CHARACTER_TYPE = "Eldritch";
	private static final String MY_ABILITY1 = "Spirit Explosion";
	private static final String MY_ABILITY2 = "Soul Drain"; // get HP from opponent
	private static final int MY_AD_MAX = 22;
	private static final int MY_AD_MIN = 13;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.8;
	private static final float MY_ABILITYCHANCE = (float) 0.14;
	private static final float MY_DEF = (float) 0.22;
	private static final int MY_HP = 113;

	public EnemyCultist(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setMyAbility2(MY_ABILITY2);
		setHasTwoAbilities(true);
		setMyAttackDamageMax(MY_AD_MAX);
		setMyAttackDamageMin(MY_AD_MIN);
		setMyDefaultAttackDamageMax(MY_AD_MAX);
		setMyDefaultAttackDamageMax(MY_AD_MIN);
		setMyAttackSpeed(MY_AS);
		setMyChanceToHit(MY_ACHANCE);
		setMyAbilityChance(MY_ABILITYCHANCE);
		setMyDefense(MY_DEF);
		setMyHitPointsMax(MY_HP);
		setMyCurrentHitPoints(MY_HP);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility1() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}

	@Override
	void useAbility2(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY2_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility2() + "! Damage: " +
				(MY_ABILITY2_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
		this.setMyCurrentHitPoints(this.getMyCurrentHitPoints() + MY_ABILITY2_DAMAGE);
		System.out.println(this.getMyCharacterName() + "'s HP is now " + this.getMyCurrentHitPoints());
	}
}
