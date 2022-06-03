package model;

public abstract class RoomOccupiable extends Room {

    private DungeonCharacter myOccupant;
    private boolean hasOccupant;

    public DungeonCharacter getMyOccupant() {
        return myOccupant;
    }

    public void setMyOccupant(DungeonCharacter myOccupant) {
        this.myOccupant = myOccupant;
    }

    public boolean hasOccupant() {
        return hasOccupant;
    }

    public void setHasOccupant(boolean hasOccupant) {
        this.hasOccupant = hasOccupant;
    }

    public void addOccupant(DungeonCharacter theOccupant) {
        setMyOccupant(theOccupant);
        setHasOccupant(true);
    }

    public void removeOccupant(DungeonCharacter theOccupant) {
        setMyOccupant(theOccupant);
        setHasOccupant(true);
    }
}
