package controller;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
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
            } else if (event.getCode() == KeyCode.DOWN) {
                player.move(DIRECTION.SOUTH);
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.RIGHT) {
                player.move(DIRECTION.EAST);
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.LEFT) {
                player.move(DIRECTION.WEST);
                scene.setRoot(view.draw(player));
                stage.setScene(scene);
            } else if (event.getCode() == KeyCode.Z) {
                // Todo NEED BETTER NAMES FOR THESE METHODS - CONFUSING
                if (player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomPotion) {
                    ((RoomPotion) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onConsume();
                } else if (player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomPoisonPotion) {
                    ((RoomPoisonPotion) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onConsume();
                } else if ((player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomOOPPolymorphism)) {
                    ((RoomOOPPolymorphism) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onActivate();
                } else if ((player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomOOPEncapsulation)) {
                    ((RoomOOPEncapsulation) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onActivate();
                } else if ((player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomOOPInheritance)) {
                    ((RoomOOPInheritance) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onActivate();
                } else if ((player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()] instanceof RoomOOPAbstraction)) {
                    ((RoomOOPAbstraction) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).onActivate();
                }
            } else if (event.getCode() == KeyCode.U) {
                ((RoomOccupiable) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).removeOccupant();
                player.setMyX(1);
                player.setMyY(1);
                ((RoomOOPPolymorphism) player.getMyDungeon().getMyDungeon()[1][1]).addOccupant(player);
                ((RoomOOPPolymorphism) player.getMyDungeon().getMyDungeon()[1][1]).onActivate();
            } else if (event.getCode() == KeyCode.I) {
                ((RoomOccupiable) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).removeOccupant();
                player.setMyX(33);
                player.setMyY(1);
                ((RoomOOPAbstraction) player.getMyDungeon().getMyDungeon()[33][1]).addOccupant(player);
                ((RoomOOPAbstraction) player.getMyDungeon().getMyDungeon()[33][1]).onActivate();
            } else if (event.getCode() == KeyCode.O) {
                ((RoomOccupiable) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).removeOccupant();
                player.setMyX(33);
                player.setMyY(73);
                ((RoomOOPInheritance) player.getMyDungeon().getMyDungeon()[33][73]).addOccupant(player);
                ((RoomOOPInheritance) player.getMyDungeon().getMyDungeon()[33][73]).onActivate();
            } else if (event.getCode() == KeyCode.P) {
                ((RoomOccupiable) player.getMyDungeon().getMyDungeon()[player.getMyX()][player.getMyY()]).removeOccupant();
                player.setMyX(1);
                player.setMyY(73);
                ((RoomOOPEncapsulation) player.getMyDungeon().getMyDungeon()[1][73]).addOccupant(player);
                ((RoomOOPEncapsulation) player.getMyDungeon().getMyDungeon()[1][73]).onActivate();
            }
            scene.setRoot(view.draw(player));
            stage.setScene(scene);
        });
    }
}
