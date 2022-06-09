package model;

/**
 * Defines an abstract Room that can be activated.
 */
abstract class RoomActivatable extends RoomOccupiable {

    private boolean hasBeenActivated = false;

    /**
     * Retieves the activation status of the Room.
     *
     * @return the activation status
     */
    public boolean HasBeenActivated() {
        return hasBeenActivated;
    }

    /**
     * Sets the activation status of the Room.
     *
     * @param hasBeenActivated The activation status
     */
    public void setHasBeenActivated(boolean hasBeenActivated) {
        this.hasBeenActivated = hasBeenActivated;
    }

    /**
     * Defines activation behaviors.
     */
    abstract void onActivate();
}
