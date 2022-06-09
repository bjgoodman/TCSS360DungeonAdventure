package model;

import java.io.Serial;
import java.io.Serializable;

/**
 * Defines an abstract Room.
 */
public abstract class Room implements Serializable {
	@Serial
	private static final long serialVersionUID = 8364789748739375438L;
	private String myRoomType;
	private char myRoomCharacter;

	/**
	 * Retrieves the Room type.
	 *
	 * @return the room type
	 */
	public String getMyRoomType() {
		return myRoomType;
	}

	/**
	 * Sets the Room type.
	 *
	 * @param myRoomType The room type
	 */
	public void setMyRoomType(String myRoomType) {
		this.myRoomType = myRoomType;
	}

	/**
	 * Retrieves the Room character.
	 *
	 * @return the room character
	 */
	public char getMyRoomCharacter() {
		return myRoomCharacter;
	}

	/**
	 * Sets the Room character.
	 *
	 * @param myRoomCharacter The room character
	 */
	public void setMyRoomCharacter(char myRoomCharacter) {
		this.myRoomCharacter = myRoomCharacter;
	}
}
