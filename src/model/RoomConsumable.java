package model;

public abstract class RoomConsumable extends RoomActivatable {
    private boolean hasConsumed;
    abstract void onConsume();

    public boolean hasConsumed() {
        return hasConsumed;
    }

    public void setHasConsumed(boolean hasConsumed) {
        this.hasConsumed = hasConsumed;
    }
}
