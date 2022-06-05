package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.Interface;
import view.View;

import java.io.*;

public class ControllerMain extends Application {

    private SaveManager sm = new SaveManager();

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

//        Scene charSelect = new Scene();

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

        dungeon.setMyPlayer(player);
        dungeon.placeHero(player);
        View view = new View(dungeon);
        view.loadAssets();
        startMessage();
        Scene scene = new Scene(view.draw(player), 1250, 720);
        scene.getStylesheets().add("./stylesheet.css");
        new Movement(scene, view, primaryStage, player);
        primaryStage.setScene(scene);
    }

    public void gameLoad(Stage primaryStage) throws IOException {
        Dungeon dungeon = sm.loadGame();
        Hero player = dungeon.getMyPlayer();
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



}
