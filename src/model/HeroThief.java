package model;

public class HeroThief extends Hero { // might change name to ASSASSIN

	//fields
	private static final String MY_DESCRIPTION = "The thief stalks through the night of its prey ...";
	private static final String MY_CHARACTER_TYPE = "Human";
	private static final char MY_REPRESENTING_CHARACTER = 'T';
	private static final String MY_ABILITY = "Cutthroat"; // will come back to implement
	private static final int MY_HP = 140;
	private static final int MY_AD_MAX = 16;
	private static final int MY_AD_MIN = 11;
	private static final int MY_AS = 3;
	private static final float MY_ACHANCE = (float) 0.65;
	private static final float MY_ABILITYCHANCE = (float) 0.25;
	private static final float MY_DEF = (float) 0.35;
	private static final float MY_BLOCK_CHANCE = (float) 0.25;

	public HeroThief(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_BLOCK_CHANCE, MY_ABILITY);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		//
	}
}
