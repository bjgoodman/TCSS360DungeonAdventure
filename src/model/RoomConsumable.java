package model;

/**
 * Defines an abstract Room with a consumable.
 */
public abstract class RoomConsumable extends RoomActivatable {
    private boolean hasConsumed;
    abstract void onConsume();

    /**
     * Retrieves the consumption status of the consumable.
     *
     * @return the consumption status
     */
    public boolean hasConsumed() {
        return hasConsumed;
    }

    /**
     * Sets the consumption status of the consumable.
     *
     * @param hasConsumed The consumption status
     */
    public void setHasConsumed(boolean hasConsumed) {
        this.hasConsumed = hasConsumed;
    }
}
