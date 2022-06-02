package model;

public abstract class Room {
	private String myRoomType;
	private char myRoomCharacter;
	private boolean hasOccupant;
	private DungeonCharacter myOccupant;

	public Room(String theRoomType, char theRoomCharacter) {
		setMyRoomType(theRoomType);
		setMyRoomCharacter(theRoomCharacter);
		hasOccupant = false;
	}
	
	public final String getMyRoomType() {
		return myRoomType;
	}

	public final void setMyRoomType(final String theRoomType) {
		myRoomType = theRoomType;
	}

	public final char getMyRoomCharacter() {
		return myRoomCharacter;
	}
	public boolean hasOccupant() {
		return hasOccupant;
	}

	public void setHasOccupant(boolean hasOccupant) {
		this.hasOccupant = hasOccupant;
	}

	public DungeonCharacter getMyOccupant() {
		return myOccupant;
	}
	public final void setMyRoomCharacter(char myRoomCharacter) {
		this.myRoomCharacter = myRoomCharacter;
	}

	public void setMyOccupant(DungeonCharacter myOccupant) {
		this.myOccupant = myOccupant;
	}
}
