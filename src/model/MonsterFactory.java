package model;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A factory for creating Monster names.
 */
public class MonsterFactory {

    public static MonsterFactory theMonsterFactory = new MonsterFactory();

    /**
     * Creates a name for a Monster.
     *
     * @param theMonsterType The Monster type
     * @return the name
     */
    public String createName(String theMonsterType) {
        String name;
        String[] names = new String[]{"Figgs Vinaigrette", "Scratchensniff", "Ovaltine", "Bad News",
        " Bud 'Lite' Hootkins", "Cornbread Rubbins", "Worm", "Greasy Jim Johnson", "Skidmark Clutterbuck",
                "Schlomo Splern", "Al Capella", "Russel N. Bushes", "Dain Bramage", "Roamin' Joe", "Taco Man",
                "Mr. Unnamed", "Pauly D", "D'Pengu", "Thief Admirer", "Barbarian Dropout", "Carmack",
        "Reclusive Adventurer", "Enchantress Stalker"};
        int rand = ThreadLocalRandom.current().nextInt(names.length);
        name = names[rand] + " the " + theMonsterType;
        return name;
    }
}
