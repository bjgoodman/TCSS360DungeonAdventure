package model;

import view.Interface;

/**
 * The Room in which the Pillar of Abstraction can be activated.
 */
public class RoomOOPAbstraction extends RoomActivatable {

    @Override
    public void onActivate() {
        ((Hero) getMyOccupant()).setHasAbstraction(true);
        this.setHasBeenActivated(true);
        Interface.newEvent("Abstraction activated.");
        getMyOccupant().getMyDungeon().setAbstractionActivated(true);
        if (getMyOccupant().getMyDungeon().isAbstractionActivated() &&
                getMyOccupant().getMyDungeon().isEncapsulationActivated() &&
                getMyOccupant().getMyDungeon().isInheritanceActivated() &&
                getMyOccupant().getMyDungeon().isPolymorphismActivated()) {
            Interface.newEvent("You win!");
        }
    }
}
