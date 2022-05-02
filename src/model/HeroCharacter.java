package model;

import java.util.concurrent.ThreadLocalRandom;

public class HeroCharacter extends DungeonCharacter {
	
	private static final String MY_DESCRIPTION = "The Hero is a stalwart warrior, honed in"
			+ " the art of the blade. He carries a claymore, a greatsword he wields with"
			+ " both hands. His special ability is a great swing that attempts to cleave"
			+ " his enemies limbs off, lowering their ability to deal damage.";
	private static final String MY_ABILITY = "Dismembering Swing";
	private static final int MY_AD_MAX = 32;
	private static final int MY_AD_MIN = 15;
	private static final int MY_AS = 1;
	private static final float MY_ACHANCE = (float) 0.69;
	private static final float MY_ABILITYCHANCE = (float) 0.20;
	private static final float MY_DEF = (float) 0.4;
	private static final int MY_HP = 175;
	
	public HeroCharacter(String theName) {
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
		final int SWING_MULTIPLIER = 2;
		final float SWING_DEBUFF = (float) 0.8;
		
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbilityName() + "!");
		
		if (theTarget.isAlive() ) {
			if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
				int damageDone = SWING_MULTIPLIER * (Math.round(damageDealt() * theTarget.getMyAttackReduction()));
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				theTarget.setMyDefense(theTarget.getMyDefense() * SWING_DEBUFF);
				String abilityText = (this.getMyCharacterName() + " dealt " + damageDone 
						+ " to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName() 
						+ "'s defense dropped to " + Math.round(theTarget.getMyDefense() * 100) + "%.");
				
				System.out.println(abilityText);
			} else {
				System.out.println(this.getMyCharacterName() + "'s " + getMyAbilityName() + " missed!");
			}
		if (theTarget.getMyCurrentHitPoints() <= ZERO) {
				System.out.println(theTarget.getMyCharacterName() + " died!");
				theTarget.setAlive(false);
			}
		}
	}

	@Override
	void useItem(DungeonCharacter theTarget, Item theItem) {
		// TODO Auto-generated method stub
		
	}
	
}
