package model;

public class DungeonTester {
	
	public static void main(String[] theArgs) {
		Item[] OverlordItems = new Item[1];
		OverlordItems[0] = new ItemTwinbladeTalisman();
		OverlordEnemy EnemyTester = new OverlordEnemy("Addison");
		HeroCharacter HeroTester = new HeroCharacter("Benji");
		
		System.out.println(EnemyTester.getMyCharacterDescription());
		System.out.println(HeroTester.getMyCharacterDescription());
		
		combatTesterHelper(HeroTester, EnemyTester);
	}
	
	public static void combatTesterHelper(DungeonCharacter combatant1, DungeonCharacter combatant2) {
		while (combatant1.isAlive() && combatant2.isAlive()) {
			if (combatant1.isAlive()) {
				combatant1.Attack(combatant2);
			}
			if (combatant2.isAlive()) {
				combatant2.Attack(combatant1);
			}
		}
	}
}
