package model;

public class RoomPotion extends RoomActivatable {
	private final String MY_ROOM_TYPE = "Potion Room";
	private final char MY_ROOM_CHARACTER = 'P';
	private final int POTION_VALUE = 50;

	
	public RoomPotion() {
		setMyRoomType(MY_ROOM_TYPE);
		setMyRoomCharacter(MY_ROOM_CHARACTER);
		setCanActivate(true);
	}

	@Override
	public void onActivate() {
		getMyOccupant().setMyCurrentHitPoints(getMyOccupant().getMyCurrentHitPoints() + POTION_VALUE);
		setCanActivate(false);
	}
}
