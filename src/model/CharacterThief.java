package model;

public class CharacterThief extends DungeonCharacter{

	//fields
	private static final String MY_DESCRIPTION = "The thief stalks through the night of its prey ...";
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final String MY_ABILITY1 = ""; // will come back to implement
	private static final String MY_ABILITY2 = ""; // will come back to implement
	private static final int MY_AD_MAX = 16;
	private static final int MY_AD_MIN = 11;
	private static final int MY_AS = 3;
	private static final float MY_ACHANCE = (float) 0.65;
	private static final float MY_ABILITYCHANCE = (float) 0.25;
	private static final float MY_DEF = (float) 0.35;
	private static final int MY_HP = 140;

	public CharacterThief(String theName) {
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
