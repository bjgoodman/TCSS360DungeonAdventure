package model;

abstract class RoomActivatable extends RoomOccupiable {
    private boolean canActivate;

    public boolean canActivate() {
        return canActivate;
    }

    public void setCanActivate(boolean canActivate) {
        this.canActivate = canActivate;
    }
    public abstract void onActivate();
}
