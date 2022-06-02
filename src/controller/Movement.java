package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import view.View;
import model.*;

import java.util.concurrent.ThreadLocalRandom;

import static model.Dungeon.dungeon_list;

public class Movement {

    private Scene scene;
    private View view;
    private Stage stage;
    private Hero player;

    Movement(Scene scene, View view, Stage stage, Hero player) {
        this.scene = scene;
        this.view = view;
        this.stage = stage;
        this.player = player;

        keyHandler();
    }

    private void keyHandler() {

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.UP) {
                player.move(DIRECTION.NORTH);
                scene.setRoot(view.draw());
                stage.setScene(scene);
                System.out.println("UP");
                System.out.println(player.getMyX() + ", " + player.getMyY());
            } else if (event.getCode() == KeyCode.DOWN) {
                player.move(DIRECTION.SOUTH);
                scene.setRoot(view.draw());
                stage.setScene(scene);
                System.out.println("DOWN");
                System.out.println(player.getMyX() + ", " + player.getMyY());
            } else if (event.getCode() == KeyCode.RIGHT) {
                player.move(DIRECTION.EAST);
                scene.setRoot(view.draw());
                stage.setScene(scene);
                System.out.println("RIGHT");
                System.out.println(player.getMyX() + ", " + player.getMyY());
            } else if (event.getCode() == KeyCode.LEFT) {
                player.move(DIRECTION.WEST);
                scene.setRoot(view.draw());
                stage.setScene(scene);
                System.out.println("LEFT");
                System.out.println(player.getMyX() + ", " + player.getMyY());
            }
        });
    }
}
