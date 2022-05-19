package model;

public class RoomOccupiable extends Room {
	private DungeonCharacter[] myOccupants;
	private Item[] myItems;
	
	public RoomOccupiable() {
		myOccupants = new DungeonCharacter[2];
		myItems = new Item[6];
		setMyRoomType("Occupiable");
	}
	
	public void addOccupant(DungeonCharacter theOccupant) {
		for (int i = 0; i < myOccupants.length; i++) {
			if (myOccupants[i] != null) {
				myOccupants[i] = theOccupant;
				break;
			}
		}
	}
	
	public void removeOccupant(DungeonCharacter theOccupant) {
		for (int i = 0; i < myOccupants.length; i++) {
			if (myOccupants[i] == theOccupant) {
				myOccupants[i] = null;
				break;
			}
		}
	}
}
