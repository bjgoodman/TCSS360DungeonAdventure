package model;

import view.Interface;

/**
 * A Room with a poison potion to be consumed.
 */
public class RoomPoisonPotion extends RoomConsumable {
    private final String MY_ROOM_TYPE = "Poison Potion Room";
    private final char MY_ROOM_CHARACTER = 'T';
    private final int TRAP_VALUE = 25;

    /**
     * Constructor for a poison potion Room.
     */
    public RoomPoisonPotion() {
        setMyRoomType(MY_ROOM_TYPE);
        setMyRoomCharacter(MY_ROOM_CHARACTER);
    }

    /**
     * Defines behaviors for Room activation.
     */
    void onActivate() {
        if (hasConsumed()) {
            Interface.newEvent("I already drank the poison... Crap.");
        } else {
            getMyOccupant().setMyCurrentHitPoints(getMyOccupant().getMyCurrentHitPoints() - TRAP_VALUE);
            Interface.newEvent("This potion tastes like feet...");
        }
    }

    @Override
    public void onConsume() {
        onActivate();
        setHasConsumed(true);
    }
}
