package model;

import view.Interface;

/**
 * The Room in which the Pillar of Polymorphism can be activated.
 */
public class RoomOOPPolymorphism extends RoomActivatable {
    @Override
    public void onActivate() {
        ((Hero) getMyOccupant()).setHasPolymorphism(true);
        this.setHasBeenActivated(true);
        Interface.newEvent("Polymorphism activated.");
        getMyOccupant().getMyDungeon().setPolymorphismActivated(true);
        if (getMyOccupant().getMyDungeon().isAbstractionActivated() &&
                getMyOccupant().getMyDungeon().isEncapsulationActivated() &&
                getMyOccupant().getMyDungeon().isInheritanceActivated() &&
                getMyOccupant().getMyDungeon().isPolymorphismActivated()) {
            Interface.newEvent("You win!");
        }
    }
}
