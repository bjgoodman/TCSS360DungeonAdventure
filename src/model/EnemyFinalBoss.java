package model;

public class EnemyFinalBoss extends DungeonCharacter {

	private static final int MY_ABILITY1_DAMAGE = 60;
	private static final String MY_DESCRIPTION = "The Final Boss... yeah, RUN!";
	private static final String MY_CHARACTER_TYPE = ""; //will decide later
	private static final String MY_ABILITY1 = "God of Destruction"; // will create later
	private static final String MY_ABILITY2 = ""; // will create later
	private static final int MY_AD_MAX = 45;
	private static final int MY_AD_MIN = 38;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.9;
	private static final float MY_ABILITYCHANCE = (float) 0.25;
	private static final float MY_DEF = (float) 0.5;
	private static final int MY_HP = 250;

	public EnemyFinalBoss(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setMyAbility1(MY_ABILITY2);
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
	void useAbility2(DungeonCharacter theTarget) { // will implement later
		// TODO Auto-generated method stub

	}

}
