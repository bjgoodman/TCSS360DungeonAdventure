/* AccessoryTwinbladeTalisman.java */

package model;

/**
 * A certain character will receive accessory within Dungeon Adventure
 * 
 * 
 * @author Ben Goodman, Chris Nichol, Komisi Petelo
 * @version 05/19/2022
 */
public class AccessoryTwinbladeTalisman extends Accessory {

	/** The attack bonus of the accessory */
	private static int ATTACK_DAMAGE_BONUS = 10;

	/**
	 * Constructor for the class - solidifying the name of the accessory 
	 * */
	public AccessoryTwinbladeTalisman() {
		super("Twinblade Talisman");
	}
	
	/**
	 * An accessory the character will use against an enemy to see if it's effective
	 * 
	 * @param theUser the character that receives the accessory for the game
	 */
	@Override
	public void accessoryEffectActivate(DungeonCharacter theUser) {
		theUser.setMyAttackDamageMax(theUser.getMyAttackDamageMax() + ATTACK_DAMAGE_BONUS);
		theUser.setMyAttackDamageMin(theUser.getMyAttackDamageMin() + ATTACK_DAMAGE_BONUS);
	}

}
