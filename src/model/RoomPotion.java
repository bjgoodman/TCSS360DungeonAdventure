package model;

public class RoomPotion extends Room {
	private static String MY_ROOM_TYPE = "Potion Room";
	private static char MY_ROOM_CHARACTER = 'P';
	
	public RoomPotion() {
		super(MY_ROOM_TYPE, MY_ROOM_CHARACTER);
	}
	
	// CODE TO HEAL A CHARACTER ON ENTRY AND THEN TURN ROOM TO AN OCCUPIABLE 
}
