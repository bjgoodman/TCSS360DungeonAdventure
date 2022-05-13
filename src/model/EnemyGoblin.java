package model;

public class EnemyGoblin extends DungeonCharacter {

	private static final String MY_DESCRIPTION = "";
	private static final String MY_CHARACTER_TYPE = ""; // might change name of enemy and type too
	private static final String MY_ABILITY1 = ""; // will come back and figure ability out
	private static final String MY_ABILITY2 = ""; // will come back and figure ability out
	private static final int MY_AD_MAX = 19;
	private static final int MY_AD_MIN = 11;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.8;
	private static final float MY_ABILITYCHANCE = (float) 0.14;
	private static final float MY_DEF = (float) 0.17;
	private static final int MY_HP = 98;

	public EnemyGoblin(String theName) {
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
		// TODO Auto-generated method stub

	}

	@Override
	void useAbility2(DungeonCharacter theTarget) {
		// TODO Auto-generated method stub

	}

}
