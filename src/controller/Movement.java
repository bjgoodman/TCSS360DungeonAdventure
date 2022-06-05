package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import view.Interface;
import view.View;
import model.*;

import java.util.concurrent.ThreadLocalRandom;

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
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
                System.out.println("UP");
                System.out.println("[" + player.getMyY() + ", " + player.getMyX() + "]");
            } else if (event.getCode() == KeyCode.DOWN) {
                player.move(DIRECTION.SOUTH);
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
                System.out.println("DOWN");
                System.out.println("[" + player.getMyY() + ", " + player.getMyX() + "]");
            } else if (event.getCode() == KeyCode.RIGHT) {
                player.move(DIRECTION.EAST);
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
                System.out.println("RIGHT");
                System.out.println("[" + player.getMyY() + ", " + player.getMyX() + "]");
            } else if (event.getCode() == KeyCode.LEFT) {
                player.move(DIRECTION.WEST);
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
                System.out.println("LEFT");
                System.out.println("[" + player.getMyY() + ", " + player.getMyX() + "]");
            } else if (event.getCode() == KeyCode.Z) {
                // Todo NEED BETTER NAMES FOR THESE METHODS - CONFUSING
                if (player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomPotion) {
                    ((RoomPotion) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onConsume();
                } else if (player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomPoisonPotion) {
                    ((RoomPoisonPotion) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onConsume();
                } else if ((player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomOOPPolymorphism)) {
                    ((RoomOOPPolymorphism) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onActivate();
                }
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
            }
        });
    }
}
