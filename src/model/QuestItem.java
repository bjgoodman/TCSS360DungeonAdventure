package model;

public abstract class QuestItem {
	
	private String myItemName;
	private String myDescription;
	
	public QuestItem(String myItemName, String theDescription) {
		setMyItemName(myItemName);
		setMyDescription(theDescription);
	}

	public String getMyItemName() {
		return myItemName;
	}

	public void setMyItemName(String myItemName) {
		this.myItemName = myItemName;
	}

	public String getMyDescription() {
		return myDescription;
	}

	public void setMyDescription(String myDescription) {
		this.myDescription = myDescription;
	}
	
	public void itemEffectActivate(DungeonCharacter theUser) {
	}
}
