package view;

import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import model.*;

import java.io.IOException;

public class View {

    private Image wall, floor, potion, adventurer, polymorphism;
    private int WIDTH = 75;
    private int HEIGHT = 35;
    static final int TILE_SIZE = 16;

    Label line4 = new Label("");
    Label line3 = new Label("");
    Label line2 = new Label("");
    Label line1 = new Label("");

    Dungeon dungeon;

    public View(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    public void loadAssets() throws IOException {
        wall = new Image("file:assets/level/wall.png");
        floor = new Image("file:assets/level/floor1.png");
        potion = new Image("file:assets/item/ruby_new.png");
        adventurer = new Image("file:assets/character/adventurer.png");
        polymorphism = new Image("file:assets/objectives/polymorphism.png");
    }

    public Pane draw(Hero player) {
        Pane root = new Pane();


        /* DRAW GAME BOARD */
        for (int x_tile = 0; x_tile < WIDTH; x_tile++) {
            for (int y_tile = 0; y_tile < HEIGHT; y_tile++) {
                ImageView tile = new ImageView();
                tile.setFitWidth(TILE_SIZE);
                tile.setFitHeight(TILE_SIZE);

                if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomWall) {
                    tile.setImage(wall);
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomPlain
                        && ((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant() == false) {
                    tile.setImage(floor);
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomPlain
                        && ((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant() == true) {
                    if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof HeroAdventurer) {
                        tile.setImage(adventurer);
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomPotion) {
                    if (((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                            && ((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                        tile.setImage(adventurer);
                    } else if (((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                            && !((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                        tile.setImage(floor);
                    } else {
                        tile.setImage(potion);
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomPoisonPotion) {
                if (((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                        && ((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                    tile.setImage(adventurer);
                } else if (((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                        && !((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                    tile.setImage(floor);
                } else {
                    tile.setImage(potion);
                }
            } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomOOPPolymorphism) {
                        tile.setImage(polymorphism);
                }

                tile.setX(x_tile * TILE_SIZE + 25);
                tile.setY(y_tile * TILE_SIZE + 25);
                root.getChildren().add(tile);
            }
        }

        new Interface(root, player);
        return root;
    }
}
