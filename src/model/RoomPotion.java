package model;

import view.Interface;

public class RoomPotion extends RoomConsumable {
	private final String MY_ROOM_TYPE = "Potion Room";
	private final char MY_ROOM_CHARACTER = 'P';
	private final int POTION_VALUE = 50;

	
	public RoomPotion() {
		setMyRoomType(MY_ROOM_TYPE);
		setMyRoomCharacter(MY_ROOM_CHARACTER);
		setReactivatable(false);
	}

	@Override
	void onActivate() {
		if (hasConsumed()) {
			Interface.newEvent("I already drank the potion.");
		} else {
			getMyOccupant().setMyCurrentHitPoints(getMyOccupant().getMyCurrentHitPoints() + POTION_VALUE);
			Interface.newEvent("Swig! Yummy...");
		}
	}

	@Override
	public void onConsume() {
		onActivate();
		setHasConsumed(true);
	}
}
