package model;

import view.Interface;

/**
 * The Room in which the Pillar of Inheritance can be activated.
 */
public class RoomOOPInheritance extends RoomActivatable {
    @Override
    public void onActivate() {
        ((Hero) getMyOccupant()).setHasPolymorphism(true);
        this.setHasBeenActivated(true);
        Interface.newEvent("Inheritance activated.");
        getMyOccupant().getMyDungeon().setInheritanceActivated(true);
        if (getMyOccupant().getMyDungeon().isAbstractionActivated() &&
                getMyOccupant().getMyDungeon().isEncapsulationActivated() &&
                getMyOccupant().getMyDungeon().isInheritanceActivated() &&
                getMyOccupant().getMyDungeon().isPolymorphismActivated()) {
            Interface.newEvent("You win!");
        }
    }
}
