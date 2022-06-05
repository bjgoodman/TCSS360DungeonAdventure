package model;

abstract class RoomActivatable extends RoomOccupiable {
    private boolean isReactivatable;

    public boolean isReactivatable() {
        return isReactivatable;
    }

    public void setReactivatable(boolean reactivatable) {
        isReactivatable = reactivatable;
    }

    abstract void onActivate();
}
