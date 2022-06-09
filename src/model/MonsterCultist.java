package model;

import view.Interface;

import java.util.ArrayList;

import static model.Dungeon.monsterstats;

/**
 * Defines values and behaviors for Cultists.
 */
public class MonsterCultist extends Monster {

	private final String MY_DESCRIPTION = "Mustered from the souls of anguish, rises a" +
			"sinister creature.";
	private final String MY_CHARACTER_TYPE = "Cultist";
	private final char MY_REPRESENTING_CHARACTER = 'C';
	private final String MY_ABILITY = "Spirit Explosion";
	private int MY_ABILITY_DAMAGE = 19;

	/**
	 * Constructor for Cultists.
	 *
	 * @param theDungeon The dungeon in which the Cultist resides
	 * @param theMonsterFactory The monster factory generating the Cultist's name
	 */
	public MonsterCultist(Dungeon theDungeon, MonsterFactory theMonsterFactory) {
		super(theMonsterFactory.createName("Cultist"), theDungeon);

		ArrayList<Float> myStats = monsterstats.get("Cultist");
		int maxhp = myStats.get(1).intValue();
		int admax = myStats.get(2).intValue();
		int admin = myStats.get(3).intValue();
		float achance = myStats.get(4);
		float abilitychance = myStats.get(5);
		float healchance = myStats.get(6);
		constructionHelper(MY_DESCRIPTION, MY_CHARACTER_TYPE, MY_REPRESENTING_CHARACTER,
				MY_ABILITY, maxhp, admin, admax, achance, abilitychance, healchance);
	}

	@Override
	void useAbility(DungeonCharacter theTarget) {
		theTarget.setMyCurrentHitPoints(theTarget.getMyCurrentHitPoints() - MY_ABILITY_DAMAGE);
		Interface.newEvent(this.getMyCharacterName() + " used " + this.getMyAbility() + ", dealing " +
				(MY_ABILITY_DAMAGE) + "!");
	}
}
