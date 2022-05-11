package model;

public class DungeonTester {

	public static void main(String[] theArgs) {
		OverlordEnemy EnemyTester = new OverlordEnemy("Addison");
<<<<<<< HEAD
		HeroCharacter HeroTester = new HeroCharacter("Benji");
		EnchantressCharacter EnchantressTester = new EnchantressCharacter("Celine");
=======
		SkeletonEnemy SkellyTester = new SkeletonEnemy("Skelly");
		BarbarianCharacter HeroTester = new BarbarianCharacter("Benji");
		EnchantressCharacter EnchantressTester = new EnchantressCharacter("Celine");
		
>>>>>>> 9088d30a0677da8de45c551d7a57635e3001ef3e

		ItemPotion potion1 = new ItemPotion("pot1");
		ItemPotion potion2 = new ItemPotion("pot2");
		ItemPotion potion3 = new ItemPotion("pot3");
		ItemPotion potion4 = new ItemPotion("pot4");

		Item[] HeroTesterInventory = {potion1, potion2, potion3, null, null, null};
		HeroTester.setMyInventory(HeroTesterInventory);

		Item[] EnchantressTesterInventory = {potion1, potion2, potion3, potion4, null, null};
		EnchantressTester.setMyInventory(EnchantressTesterInventory);

		// combatTesterHelper(HeroTester, EnemyTester);
<<<<<<< HEAD
		combatTesterHelper(EnchantressTester, EnemyTester);
=======
		combatTesterHelper(EnchantressTester, SkellyTester);
>>>>>>> 9088d30a0677da8de45c551d7a57635e3001ef3e
	}

	public static void combatTesterHelper(DungeonCharacter combatant1, DungeonCharacter combatant2) {
		System.out.println(combatant1.inventoryToString());
		while (combatant1.isAlive() && combatant2.isAlive()) {
			if (combatant1.isAlive()) {
				combatant1.Attack(combatant2);
			}
			if (combatant2.isAlive()) {
				combatant2.Attack(combatant1);
			}
			if (combatant1.getMyCurrentHitPoints() < 80) {
				for (int i = 0; i < 5; i++) {
					if (combatant1.getMyInventory()[i] != null) {
						combatant1.useItemSelf(i);
						break;
					}
				}
			}
		}
		System.out.println(combatant1.inventoryToString());
	}
}
