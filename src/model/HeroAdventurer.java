package model;

import java.util.concurrent.ThreadLocalRandom;

public class HeroAdventurer extends Hero {
    private final int ZERO = 0;
    private final String MY_DESCRIPTION = "A base Hero. A reflection of who you are, and who you want" +
            "to be.";
    private final char MY_REPRESENTING_CHARACTER = 'H';
    private final String MY_CHARACTER_TYPE = "Human";
    private final String MY_ABILITY = "Heroic Strike";
    private int MY_MAX_HP = 100;
    private int MY_AD_MAX = 32;
    private int MY_AD_MIN = 19;
    private float MY_ACHANCE = (float) 0.69;
    private float MY_ABILITYCHANCE = (float) 0.2;

    //TODO either implement Def or remove it
    //private float MY_DEF = (float) 0.4;
    private float MY_BLOCK_CHANCE = (float) 0.33;

    public HeroAdventurer(String theName, Dungeon theDungeon) {
        super(theName, theDungeon);
        constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
                MY_ABILITY, MY_MAX_HP, MY_AD_MIN, MY_AD_MAX, MY_ACHANCE, MY_ABILITYCHANCE, MY_BLOCK_CHANCE);
    }

    @Override
    void useAbility(DungeonCharacter theTarget) {
        final float SWING_MULTIPLIER = (float) 1.5;
        final float SWING_DEBUFF = (float) 0.8;

        System.out.println(this.getMyCharacterName() + " used " + this.getMyAbility() + "!");

        if (this.getMyChanceToHit() > ThreadLocalRandom.current().nextFloat()) {
            int damageDone = Math.round(SWING_MULTIPLIER * damageDealt() * theTarget.getMyAttackReduction());
            theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - damageDone);
//            String abilityText = (this.getMyCharacterName() + " dealt " + damageDone +
//                    " to " + theTarget.getMyCharacterName() + ". " + theTarget.getMyCharacterName() +
//                    "'s defense dropped to " + Math.round(theTarget.getMyDefense() * 100) + "%.");
//
//            System.out.println(abilityText);
        } else {
            System.out.println(this.getMyCharacterName() + "'s " + getMyAbility() + " missed!");
        }
    }
}
