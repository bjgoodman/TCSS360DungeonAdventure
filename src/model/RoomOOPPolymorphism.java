package model;

public class RoomOOPPolymorphism extends RoomActivatable {
    @Override
    public void onActivate() {
        String name = getMyOccupant().getMyCharacterName();
        Dungeon dungeon = getMyOccupant().getMyDungeon();
        if (getMyOccupant() instanceof HeroAdventurer) {
            setMyOccupant(new HeroBarbarian(name, dungeon));
        } else if (getMyOccupant() instanceof HeroBarbarian) {
            setMyOccupant(new HeroEnchantress(name, dungeon));
        } else if (getMyOccupant() instanceof HeroBarbarian) {
            setMyOccupant(new HeroThief(name, dungeon));
        } else {
            setMyOccupant(new HeroAdventurer(name, dungeon));
        }
    }
}
