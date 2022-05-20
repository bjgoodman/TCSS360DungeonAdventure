/* DungeonTester.java */

package model;

/**
 * The start of Dungeon Adventure with characters having an amount of
 * potions and facing their enemies.
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class DungeonTester {

	/**
	 * Calling characters (adventurers && enemies) classes and items classes
	 * and setting a certain amount of potions for each adventurer for the
	 * users in the game. Then, we call another method to test our combating
	 * with each character.
	 * 
	 * @param args - the command line arguments (ignored for now).
	 */
	public static void main(String[] theArgs) {
		EnemySkeleton SkellyTester = new EnemySkeleton("Skelly");
		EnemyCultist cultistTester = new EnemyCultist("Raymond");
		EnemyGoblin goblinTester = new EnemyGoblin("Pandora");

		// EnemyEldritchGod eldritchGodTester = EnemyEldritchGod("Malice"); 
		EnemyOverlord EnemyTester = new EnemyOverlord("Addison");


		CharacterBarbarian HeroTester = new CharacterBarbarian("Benji");
		CharacterEnchantress EnchantressTester = new CharacterEnchantress("Celine");

		ItemPotion potion1 = new ItemPotion("pot1");
		ItemPotion potion2 = new ItemPotion("pot2");
		ItemPotion potion3 = new ItemPotion("pot3");
		ItemPotion potion4 = new ItemPotion("pot4");

		Item[] HeroTesterInventory = {potion1, potion2, potion3, null, null, null};
		HeroTester.setMyInventory(HeroTesterInventory);

		Item[] EnchantressTesterInventory = {potion1, potion2, potion3, potion4, null, null};
		EnchantressTester.setMyInventory(EnchantressTesterInventory);

		// note: use if statements for controller code when user selects character for game
		//		combatTesterHelper(HeroTester, EnemyTester);
		//		combatTesterHelper(HeroTester, SkellyTester);
		//		combatTesterHelper(HeroTester, cultistTester);
		//		combatTesterHelper(HeroTester, goblinTester);

		//		combatTesterHelper(EnchantressTester, EnemyTester);
		//		combatTesterHelper(EnchantressTester, SkellyTester);
		//		combatTesterHelper(EnchantressTester, cultistTester);
		combatTesterHelper(EnchantressTester, goblinTester);
	}

	/**
	 * Tests our combating situations with our characters; adventurers versus
	 * their enemies while having an inventory of potions.
	 * 
	 * @param thetheCombatant1 the first person to fight
	 * @param theCombatant2 the second person to fight
	 */
	public static void combatTesterHelper(DungeonCharacter theCombatant1, DungeonCharacter theCombatant2) {
		System.out.println(theCombatant1.inventoryToString());
		while (theCombatant1.isAlive() && theCombatant2.isAlive()) {
			if (theCombatant1.isAlive()) {
				theCombatant1.Attack(theCombatant2);
			}
			if (theCombatant2.isAlive()) {
				theCombatant2.Attack(theCombatant1);
			}
			if (theCombatant1.getMyCurrentHitPoints() < 80) {
				for (int i = 0; i < 5; i++) {
					if (theCombatant1.getMyInventory()[i] != null) {
						theCombatant1.useItemSelf(i);
						break;
					}
				}
			}
		}
		System.out.println(theCombatant1.inventoryToString());
	}
}
