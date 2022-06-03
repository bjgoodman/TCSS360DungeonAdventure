package model;

public abstract class Room {
	private String myRoomType;
	private char myRoomCharacter;

	public String getMyRoomType() {
		return myRoomType;
	}

	public void setMyRoomType(String myRoomType) {
		this.myRoomType = myRoomType;
	}

	public char getMyRoomCharacter() {
		return myRoomCharacter;
	}

	public void setMyRoomCharacter(char myRoomCharacter) {
		this.myRoomCharacter = myRoomCharacter;
	}
}
