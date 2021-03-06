package model;

import java.io.*;

/**
 * A manager for saved games.
 */
public class SaveManager {
    /**
     * Save the game.
     *
     * @param theDungeon The dungeon being saved
     */
    public void saveGame(Dungeon theDungeon) {
        String filename = "savegame.txt";

        // Serialization
        try {

            // Saving of object in a file
            FileOutputStream file = new FileOutputStream
                    (filename);
            ObjectOutputStream out = new ObjectOutputStream
                    (file);

            // Method for serialization of object
            out.writeObject(theDungeon);

            out.close();
            file.close();
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }

    /**
     * Load the game.
     *
     * @return the loaded dungeon
     */
    public Dungeon loadGame() {
        String filename = "savegame.txt";

        try {

            // Reading the object from a file
            FileInputStream file = new FileInputStream
                    (filename);
            ObjectInputStream in = new ObjectInputStream
                    (file);

            // Method for deserialization of object
            Dungeon dungeon = (Dungeon) in.readObject();

            in.close();
            file.close();

            return dungeon;
        }

        catch (IOException ex) {
            System.out.println("IOException is caught");
        }

        catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" +
                    " is caught");
        }

        return null;
    }
}
