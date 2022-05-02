package model;

public class ItemTwinbladeTalisman extends Item {
	
	private static float ATTACK_SPEED_BONUS = (float) 0.2;
	
	public ItemTwinbladeTalisman() {
		super("Twinblade Talisman");
	}

	@Override
	public void itemEffectActivate(DungeonCharacter theUser) {
		theUser.setMyAttackSpeed(theUser.getMyAttackSpeed() + ATTACK_SPEED_BONUS);
	}
	
}
