package model;

import view.Interface;

import java.util.ArrayList;

import static model.Dungeon.monsterstats;
import static model.MonsterFactory.theMonsterFactory;

public class MonsterOgre extends Monster {

	private final String MY_DESCRIPTION = "";
	private final String MY_CHARACTER_TYPE = "Ogre";
	private final char MY_REPRESENTING_CHARACTER = 'W';
	private final String MY_ABILITY = "Hammer Down"; // will come back and figure ability out
	private int MY_ABILITY_DAMAGE = 38;
	public MonsterOgre(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Ogre"), theDungeon);
		ArrayList<Float> myStats = monsterstats.get("Ogre");
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
				(MY_ABILITY_DAMAGE) + "! ");
	}
}
