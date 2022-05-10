package model;

public abstract class Item {
	
	private String myItemName;
	private int myItemSlot;
	private boolean myReusable;
	private boolean myTargetable;
	
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

	public int getMyItemSlot() {
		return myItemSlot;
	}

	public void setMyItemSlot(final int theItemSlot) {
		myItemSlot = theItemSlot;
	}

	public boolean isReusable() {
		return myReusable;
	}

	public void setMyReusable(final boolean theReusable) {
		myReusable = theReusable;
	}
	
	public boolean isTargetable() {
		return myTargetable;
	}

	public void setMyTargetable(final boolean theTargetable) {
		myTargetable = theTargetable;
	}
}
