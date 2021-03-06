package model;

import view.Interface;

/**
 * The Room in which the Pillar of Encapsulation can be activated.
 */
public class RoomOOPEncapsulation extends RoomActivatable {
    @Override
    public void onActivate() {
        ((Hero) getMyOccupant()).setHasEncapsulation(true);
        this.setHasBeenActivated(true);
        Interface.newEvent("Encapsulation activated.");
        getMyOccupant().getMyDungeon().setEncapsulationActivated(true);
        if (getMyOccupant().getMyDungeon().isAbstractionActivated() &&
                getMyOccupant().getMyDungeon().isEncapsulationActivated() &&
                getMyOccupant().getMyDungeon().isInheritanceActivated() &&
                getMyOccupant().getMyDungeon().isPolymorphismActivated()) {
            Interface.newEvent("You win!");
        }
    }
}
