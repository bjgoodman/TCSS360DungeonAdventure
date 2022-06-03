package model;

public class RoomTrap extends RoomActivatable {
    private final String MY_ROOM_TYPE = "Trap Room";
    private final char MY_ROOM_CHARACTER = 'T';
    private final int TRAP_VALUE = 50;

    public RoomTrap() {
        setMyRoomType(MY_ROOM_TYPE);
        setMyRoomCharacter(MY_ROOM_CHARACTER);
    }

    @Override
    public void onActivate() {
        getMyOccupant().setMyCurrentHitPoints(getMyOccupant().getMyCurrentHitPoints() - TRAP_VALUE);
    }
}
