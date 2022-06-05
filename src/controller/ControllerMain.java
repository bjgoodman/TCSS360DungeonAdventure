package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.Interface;
import view.View;

import java.io.*;

public class ControllerMain extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        gameStart(stage, 0, "Player");
        stage.setTitle("Dungeon Delver");
        stage.show();
    }

    private void gameStart(Stage primaryStage, int characterSelect, String playerName) throws IOException {

        Dungeon dungeon = new Dungeon(35, 75);
        Hero player = null;

        if (characterSelect == 0) {
            player = new HeroAdventurer(playerName, dungeon);
        } else if (characterSelect == 1) {
            player = new HeroBarbarian(playerName, dungeon);
        } else if (characterSelect == 2) {
            player = new HeroEnchantress(playerName, dungeon);
        } else if (characterSelect == 3) {
            player = new HeroThief(playerName, dungeon);
        }

        dungeon.placeHero(player);
        View view = new View(dungeon);
        view.loadAssets();
        startMessage();
        Scene scene = new Scene(view.draw(player), 1250, 720);
        scene.getStylesheets().add("./stylesheet.css");
        new Movement(scene, view, primaryStage, player);
        primaryStage.setScene(scene);
    }

    private void startMessage() {
        Interface.newEvent(" ");
        Interface.newEvent("You have entered the dungeon.");
        Interface.newEvent("Good luck!");
        Interface.newEvent(" ");
    }

    private void saveGame(Dungeon theDungeon) {
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

    private Dungeon loadGame() {
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
