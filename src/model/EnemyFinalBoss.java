package model;

public class EnemyFinalBoss extends DungeonCharacter {

	private static final String MY_DESCRIPTION = "The Final Boss... yeah, RUN!";
	private static final String MY_CHARACTER_TYPE = ""; //will decide later
	private static final String MY_ABILITY1 = ""; // will create later
	private static final int MY_AD_MAX = 45;
	private static final int MY_AD_MIN = 38;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.8;
	private static final float MY_ABILITYCHANCE = (float) 0.4;
	private static final float MY_DEF = (float) 0.5;
	private static final int MY_HP = 250;

	public EnemyFinalBoss(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyCharacterType(MY_CHARACTER_TYPE);
		setMyAbility1(MY_ABILITY1);
		setHasTwoAbilities(false);
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
		// TODO Auto-generated method stub

	}

	@Override
	void useAbility2(DungeonCharacter theTarget) {
		// TODO Auto-generated method stub

	}

}
