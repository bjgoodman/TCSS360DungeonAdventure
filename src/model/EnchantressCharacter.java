package model;

// import java.util.concurrent.ThreadLocalRandom;

public class EnchantressCharacter extends DungeonCharacter {

	/* make another character to lessen our user stories for the TEAM!! */

	private static final String MY_DESCRIPTION = "The Enchantress is magical goddess, descent from a Magician " +
			"of black chaos. She embues magic with her hands to summon her " +
			"most powerful spells to vanquish those who oppose. Her special " + 
			"ability is heal herself when in danger.";

	private static final String MY_ABILITY = "Revitilize";
	// maybe add spells to increase her attributes later?
	private static final int MY_AD_MAX = 25;
	private static final int MY_AD_MIN = 16;
	private static final int MY_AS = 2;
	private static final float MY_ACHANCE = (float) 0.53;
	private static final float MY_ABILITYCHANCE = (float) 0.35;
	private static final float MY_DEF = (float) 0.3;
	private static final int MY_HP = 185;

	public EnchantressCharacter(String theName) {
		super(theName);
		setMyCharacterDescription(MY_DESCRIPTION);
		setMyAbilityName(MY_ABILITY);
		setMyAttackDamageMax(MY_AD_MAX);
		setMyAttackDamageMin(MY_AD_MIN);
		setMyAttackSpeed(MY_AS);
		setMyChanceToHit(MY_ACHANCE);
		setMyAbilityChance(MY_ABILITYCHANCE);
		setMyDefense(MY_DEF);
		setMyHitPoints(MY_HP);
		setMyCurrentHitPoints(MY_HP);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		// final int SWING_MULTIPLIER = 2;
		// final float SWING_DEBUFF = (float) 0.8;

		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbilityName() + "!");


		if (this.getMyHitPoints() <= 40) {
			theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() * 2);
		} else {
			// sometimes special ability misses?
			System.out.println(this.getMyCharacterName() + "'s " + getMyAbilityName() + " missed!");
		}
		if (theTarget.getMyCurrentHitPoints() <= ZERO) {
			System.out.println(theTarget.getMyCharacterName() + " died!");
			theTarget.setAlive(false);
		}


	}

}
