package model;

/**
 * An inaccessible Room surrounded by walls.
 */
public class RoomWall extends Room {
	private static String MY_ROOM_TYPE = "Wall";
	private static char MY_ROOM_CHARACTER = '?';

	/**
	 * Constructor for a wall Room.
	 */
	public RoomWall() {
		setMyRoomType(MY_ROOM_TYPE);
		setMyRoomCharacter(MY_ROOM_CHARACTER);
	}
}
