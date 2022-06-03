package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import model.Dungeon;
import model.HeroAdventurer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import java.time.LocalDate;
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

        Dungeon dungeon = new Dungeon(35, 75);

        HeroAdventurer player = new HeroAdventurer("Player", dungeon);

        dungeon.placeHero(player);
        View view = new View(dungeon);
        view.loadAssets();

        Scene scene = new Scene(view.draw(), 1250, 800);
        new Movement(scene, view, primaryStage, player);
        primaryStage.setScene(scene);
    }

}
