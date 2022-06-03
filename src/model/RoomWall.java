package model;

public class RoomWall extends Room {
	private static String MY_ROOM_TYPE = "Wall";
	private static char MY_ROOM_CHARACTER = '?';
	
	public RoomWall() {
		setMyRoomType(MY_ROOM_TYPE);
		setMyRoomCharacter(MY_ROOM_CHARACTER);
	}
}
