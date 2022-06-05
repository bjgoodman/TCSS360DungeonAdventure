package model;

abstract class RoomActivatable extends RoomOccupiable {

    private boolean hasBeenActivated = false;

    public boolean HasBeenActivated() {
        return hasBeenActivated;
    }

    public void setHasBeenActivated(boolean hasBeenActivated) {
        this.hasBeenActivated = hasBeenActivated;
    }


    abstract void onActivate();
}
