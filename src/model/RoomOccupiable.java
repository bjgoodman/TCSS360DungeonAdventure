package model;

public class RoomOccupiable extends Room {
	private static String MY_ROOM_TYPE = "Occupiable";
	private static char MY_ROOM_CHARACTER = ' ';
	private DungeonCharacter myOccupant;
	
	public RoomOccupiable() {
		super(MY_ROOM_TYPE, MY_ROOM_CHARACTER);
	}
	
	public void addOccupant(DungeonCharacter theOccupant) {
		setMyOccupant(theOccupant);
		setHasOccupant(true);
	}
	
	public void removeOccupant() {
		myOccupant = null;
		setHasOccupant(false);
	}
}
