package model;

public class EnemyGoblin extends DungeonCharacter {

	private static final int MY_ABILITY1_DAMAGE = 14;
	private static final int MY_ABILITY2_DAMAGE = 17;
	private static final String MY_DESCRIPTION = "Born into the abyss of the willow forest lies a maleficent  " +
			"creature. Found a scythe as a child and trained daily. There is no ordeal that he cannot cut his way " +
			"through. Her first ability is to slash the air with rapid speed towards opponent damaging them. Her " +
			"second ability is to grip her scythe and spin uncontrollably causing the enemy to be sucked into her " +
			"cyclone of horrifying cuts.";
	private static final String MY_CHARACTER_TYPE = "Eldritch";
	private static final String MY_ABILITY1 = "Sonic Slash";
	private static final String MY_ABILITY2 = "Cyclone"; // spins with scythe in a circle bringing the enemy closer to get slashed
	private static final int MY_AD_MAX = 19;
	private static final int MY_AD_MIN = 11;
	private static final int MY_AS = 2; // have more speed
	private static final float MY_ACHANCE = (float) 0.75;
	private static final float MY_ABILITYCHANCE = (float) 0.16;
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
	}

}
