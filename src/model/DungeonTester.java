package model;

public class DungeonTester {

	public static void main(String[] theArgs) {
//		Dungeon test = new Dungeon(45, 75);
//		System.out.println(test);
	}

	public static void combatTesterHelper(Hero combatant1, DungeonCharacter combatant2) {
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