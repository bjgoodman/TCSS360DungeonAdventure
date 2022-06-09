package model;

/**
 * A plain Room that can be occupied.
 */
public class RoomPlain extends RoomOccupiable {
	private static String MY_ROOM_TYPE = "Plain";
	private static char MY_ROOM_CHARACTER = ' ';

	/**
	 * Constructor for a plain Room.
	 */
	public RoomPlain() {
		setMyRoomType(MY_ROOM_TYPE);
		setMyRoomCharacter(MY_ROOM_CHARACTER);
	}
}
