package model;

public abstract class Room {
	private String myRoomType;
	
	public final String getMyRoomType() {
		return myRoomType;
	}

	public final void setMyRoomType(final String theRoomType) {
		myRoomType = theRoomType;
	}

	public Room() {
		setMyRoomType("Room");
	}
}
