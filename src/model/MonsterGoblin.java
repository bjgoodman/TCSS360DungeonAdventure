package model;

public class MonsterGoblin extends Monster {


	private static final String MY_DESCRIPTION = "Born into the abyss of the willow forest lies a maleficent  " +
			"creature. Found a scythe as a child and trained daily. There is no ordeal that he cannot cut his way " +
			"through. Her first ability is to slash the air with rapid speed towards opponent damaging them. Her " +
			"second ability is to grip her scythe and spin uncontrollably causing the enemy to be sucked into her " +
			"cyclone of horrifying cuts.";
	private static final String MY_CHARACTER_TYPE = "Ogroid";
	private static final char MY_REPRESENTING_CHARACTER = 'G';
	private static final String MY_ABILITY1 = "Air Slash"; 
	private static final int MY_ABILITY1_DAMAGE = 14;
	private static final int MY_HP = 98;
	private static final int MY_AD_MAX = 19;		 	 
	private static final int MY_AD_MIN = 11;
	private static final int MY_AS = 2; 
	private static final float MY_ACHANCE = (float) 0.75;
	private static final float MY_ABILITYCHANCE = (float) 0.16;
	private static final float MY_DEF = (float) 0.17;
	private static final float MY_HEAL_CHANCE = (float) 0.1;
	
	public MonsterGoblin(String theName) {
		super(theName, MY_DESCRIPTION, MY_REPRESENTING_CHARACTER, MY_CHARACTER_TYPE, MY_HP,
				MY_AD_MAX, MY_AD_MIN, MY_AS, MY_ACHANCE, MY_ABILITYCHANCE, MY_DEF, MY_HEAL_CHANCE, MY_ABILITY1);
	}

	@Override
	void useAbility1(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY1_DAMAGE);
		System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "! Damage: " +
				(MY_ABILITY1_DAMAGE) + ". " +
				theTarget.getMyCharacterName() + "'s HP is now " + theTarget.getMyCurrentHitPoints() + ".");
	}
}
