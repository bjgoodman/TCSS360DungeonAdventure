package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.*;
import view.Interface;
import view.View;

import java.io.IOException;

public class ControllerMain extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        gameStart(stage);
        stage.setTitle("Dungeon Delver");
        stage.show();
    }

    private void gameStart(Stage primaryStage) throws IOException {

        Dungeon dungeon = new Dungeon(35, 75);

        HeroAdventurer player = new HeroAdventurer("Player", dungeon);
        // monster factory, stored into arraylist of monster
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

}
