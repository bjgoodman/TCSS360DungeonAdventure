package model;

import java.io.Serial;
import java.io.Serializable;

public abstract class Room implements Serializable {
	@Serial
	private static final long serialVersionUID = 8364789748739375438L;
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
