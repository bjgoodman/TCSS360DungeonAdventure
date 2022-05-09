package model;

public abstract class Accessory {
	
	private String myAccessoryName;
	private int myAccessorySlot;
	
	public Accessory(final String myAccessoryName) {
		setMyAccessoryName(myAccessoryName);
	}
	
	public abstract void accessoryEffectActivate(DungeonCharacter theUser);

	public String getMyAccessoryName() {
		return myAccessoryName;
	}

	public void setMyAccessoryName(final String theAccessoryName) {
		myAccessoryName = theAccessoryName;
	}

	public int getMyAccessorySlot() {
		return myAccessorySlot;
	}

	public void setMyAccessorySlot(final int theAccessorySlot) {
		myAccessorySlot = theAccessorySlot;
	}
}
