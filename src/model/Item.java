package model;

public abstract class Item {
	
	private String myItemName;
	
	public Item(final String myItemName) {
		setMyItemName(myItemName);
	}
	
	public abstract void itemEffectActivate(DungeonCharacter theUser);

	public String getMyItemName() {
		return myItemName;
	}

	public void setMyItemName(final String theItemName) {
		myItemName = theItemName;
	}
	
}
