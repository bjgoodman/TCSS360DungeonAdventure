package model;

public class RoomPlain extends RoomOccupiable {
	private static String MY_ROOM_TYPE = "Plain";
	private static char MY_ROOM_CHARACTER = ' ';

	public RoomPlain() {
		setMyRoomType(MY_ROOM_TYPE);
		setMyRoomCharacter(MY_ROOM_CHARACTER);
	}
}
