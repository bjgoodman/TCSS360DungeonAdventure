package model;

public class AccessoryTwinbladeTalisman extends Accessory {
	
	private static int ATTACK_DAMAGE_BONUS = 10;
	
	public AccessoryTwinbladeTalisman() {
		super("Twinblade Talisman");
	}

	@Override
	public void accessoryEffectActivate(DungeonCharacter theUser) {
		theUser.setMyAttackDamageMax(theUser.getMyAttackDamageMax() + ATTACK_DAMAGE_BONUS);
		theUser.setMyAttackDamageMin(theUser.getMyAttackDamageMin() + ATTACK_DAMAGE_BONUS);
	}
	
}
