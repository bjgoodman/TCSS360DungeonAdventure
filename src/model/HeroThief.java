package model;

import view.Interface;

import java.util.concurrent.ThreadLocalRandom;

public class HeroThief extends Hero { // might change name to ASSASSIN

	//fields
	private final String MY_DESCRIPTION = "The thief stalks through the night of its prey ...";
	private final String MY_CHARACTER_TYPE = "Human";
	private final char MY_REPRESENTING_CHARACTER = 'T';
	private final String MY_ABILITY = "Twofold Slice" ; // will come back to implement
	private int MY_MAX_HP = 80;
	private int MY_AD_MAX = 41;
	private int MY_AD_MIN = 11;
	private float MY_ACHANCE = (float) 0.65;
	private float MY_ABILITYCHANCE = (float) 0.25;

	private float MY_BLOCK_CHANCE = (float) 0.25;

	public HeroThief(String theName, Dungeon theDungeon) {
		super(theName, theDungeon);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_BLOCK_CHANCE);
	}

	void useAbility(DungeonCharacter theTarget) {
		int damageDone = this.twoFoldStrike(theTarget, 1);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() + ", dealing " + damageDone + "!");
	}

	// BAD CODE SMELL HERE?
	private int twoFoldStrike(DungeonCharacter theTarget, int strikeNumber) {
		float twoFoldModifier = (float) 2;
		if (theTarget.isAlive()) {
				int damageDone = Math.round((damageDealt()) * twoFoldModifier);
				theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
				return damageDone;
			}
		return 0;
	}
}
