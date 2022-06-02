package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Dungeon;
import model.HeroAdventurer;
import view.View;

import java.io.IOException;

public class ControllerMain extends Application {



    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        gameStart(stage);
        stage.setTitle("TEST");
        stage.show();
    }

    private void gameStart(Stage primaryStage) throws IOException {
        HeroAdventurer player = new HeroAdventurer("Player");

        Dungeon dungeon = new Dungeon(35, 75);
        View view = new View(dungeon);
        view.loadAssets();

        Scene scene = new Scene(view.draw(), 1250, 1000);
        new Movement(scene, view, primaryStage, player);
        primaryStage.setScene(scene);
    }

}
