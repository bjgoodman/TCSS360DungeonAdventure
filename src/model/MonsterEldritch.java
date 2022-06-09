package model;

import view.Interface;

import java.util.ArrayList;

import static model.Dungeon.monsterstats;
import static model.MonsterFactory.theMonsterFactory;

/**
 * Defines values and behaviors for Eldritch monsters.
 */
public class MonsterEldritch extends Monster {

	private final String MY_DESCRIPTION = "Horrific and untamed comes a abomination from the Proterazoic era " +
			"which dwells in the present. Resurrected from the Eldritch Cultist, this god has been globetrotting the " + 
			" depths of earth searching for the remains of its allies. Its first special ability is to muster the negative " +
			"energy of everything through space and time to create a concussive and terrfiying blast of chaos towards its opponent.";
	private final String MY_CHARACTER_TYPE = "Eldritch God";
	private final char MY_REPRESENTING_CHARACTER = 'E';
	private final String MY_ABILITY = "Chaotic Blast"; // change the name?
	private int MY_ABILITY_DAMAGE = 30;

	/**
	 * Constructor for Eldritch monsters.
	 *
	 * @param theName The name of the Eldritch monster
	 * @param theDungeon The dungeon in which the Eldritch monster resides
	 */
	public MonsterEldritch(String theName, Dungeon theDungeon) {
		super(theMonsterFactory.createName("Eldritch"), theDungeon);
		ArrayList<Float> myStats = monsterstats.get("Eldritch");
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
				MY_ABILITY_DAMAGE + "!");
	}
}
