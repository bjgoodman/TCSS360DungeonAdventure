package model;

import java.util.ArrayList;

public class Game {

    static ArrayList<Dungeon> levels = new ArrayList<>();

    public void addlevel(Dungeon theLevel) {
        levels.add(theLevel);
    }
}
