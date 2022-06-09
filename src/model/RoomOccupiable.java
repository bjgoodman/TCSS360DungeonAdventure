package model;

/**
 * Defines an abstract Room that can be occupied.
 */
public abstract class RoomOccupiable extends Room {

    private DungeonCharacter myOccupant;
    private boolean hasOccupant;

    /**
     * Retrieves the occupant.
     *
     * @return the occupant
     */
    public DungeonCharacter getMyOccupant() {
        return myOccupant;
    }

    /**
     * Sets the occupant.
     *
     * @param myOccupant The occupant
     */
    public void setMyOccupant(DungeonCharacter myOccupant) {
        this.myOccupant = myOccupant;
    }

    /**
     * Retrieves the occupation status.
     *
     * @return the occupation status
     */
    public boolean hasOccupant() {
        return hasOccupant;
    }

    /**
     * Sets the occupation status.
     *
     * @param hasOccupant The occupation status
     */
    public void setHasOccupant(boolean hasOccupant) {
        this.hasOccupant = hasOccupant;
    }

    /**
     * Adds an occupant.
     *
     * @param theOccupant The occupant
     */
    public void addOccupant(DungeonCharacter theOccupant) {
        setMyOccupant(theOccupant);
        setHasOccupant(true);
    }

    /**
     * Removes the current occupant.
     */
    public void removeOccupant() {
        setMyOccupant(null);
        setHasOccupant(false);
    }
}
