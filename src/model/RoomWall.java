package model;

public class RoomWall extends Room {
	private static String MY_ROOM_TYPE = "Wall";
	private static char MY_ROOM_CHARACTER = '?';
	
	public RoomWall() {
		super(MY_ROOM_TYPE, MY_ROOM_CHARACTER);
	}
}
