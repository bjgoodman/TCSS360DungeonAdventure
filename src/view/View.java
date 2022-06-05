package view;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.image.Image;
import model.*;

import java.io.IOException;

public class View {

    private Image wall, floor, potion, adventurer, barbarian, thief, enchantress, blood,
            polymorphism, polymorphismactivated, encapsulation, encapsulationactivated,
            abstraction, abstractionactivated, inheritance, inheritanceactivated,
            eldritch, skeleton, goblin, ogre, overlord;
    private int WIDTH = 75;
    private int HEIGHT = 35;
    static final int TILE_SIZE = 16;
    Dungeon dungeon;

    public View(Dungeon dungeon) {
        this.dungeon = dungeon;
    }
    public void loadAssets() throws IOException {
        wall = new Image("file:assets/level/wall.png");
        floor = new Image("file:assets/level/floor1.png");
        potion = new Image("file:assets/item/ruby_new.png");
        adventurer = new Image("file:assets/character/adventurer.png");
        barbarian = new Image("file:assets/character/barbarian.png");
        thief = new Image("file:assets/character/thief.png");
        enchantress = new Image("file:assets/character/enchantress.png");
        eldritch = new Image("file:assets/character/eldritch.png");
        skeleton = new Image("file:assets/character/skeleton.png");
        goblin = new Image("file:assets/character/goblin.png");
        ogre = new Image("file:assets/character/ogre.png");
        overlord = new Image("file:assets/character/overlord.png");
        blood = new Image("file:assets/effects/blood_red.png");
        polymorphism = new Image("file:assets/objectives/polymorphism.png");
        polymorphismactivated = new Image("file:assets/objectives/polymorphismactivated.png");
        encapsulation = new Image("file:assets/objectives/encapsulation.png");
        encapsulationactivated = new Image("file:assets/objectives/encapsulationactivated.png");
        abstraction = new Image("file:assets/objectives/abstraction.png");
        abstractionactivated = new Image("file:assets/objectives/abstractionactivated.png");
        inheritance = new Image("file:assets/objectives/inheritance.png");
        inheritanceactivated = new Image("file:assets/objectives/inheritanceactivated.png");
    }

    public Pane draw(Hero player) {
        Pane root = new Pane();

        Image playerImage = null;

        if (player instanceof HeroAdventurer) {
            playerImage = adventurer;
        } else if (player instanceof HeroBarbarian) {
            playerImage = barbarian;
        }

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
                    if (!((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant().isAlive()) {
                        tile.setImage(blood);
                    } else {
                        if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof Hero) {
                            tile.setImage(playerImage);
                        } else if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof MonsterEldritch) {
                            tile.setImage(eldritch);
                        } else if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof MonsterSkeleton) {
                            tile.setImage(skeleton);
                        } else if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof MonsterGoblin) {
                            tile.setImage(goblin);
                        } else if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof MonsterOgre) {
                            tile.setImage(ogre);
                        } else if (((RoomOccupiable) dungeon.getMyDungeon()[y_tile][x_tile]).getMyOccupant() instanceof MonsterOverlord) {
                            tile.setImage(overlord);
                        }
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomPotion) {
                    if (((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                            && ((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                        tile.setImage(playerImage);
                    } else if (((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                            && !((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                        tile.setImage(floor);
                    } else if (!((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                            && ((RoomPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                        tile.setImage(playerImage);
                    } else {
                        tile.setImage(potion);
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomPoisonPotion) {
                if (((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                        && ((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                    tile.setImage(playerImage);
                } else if (((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                        && !((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()) {
                    tile.setImage(floor);
                } else if (!((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasConsumed()
                        && ((RoomPoisonPotion) dungeon.getMyDungeon()[y_tile][x_tile]).hasOccupant()){
                    tile.setImage(playerImage);
                } else {
                    tile.setImage(potion);
                }
            } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomOOPPolymorphism) {
                    if (((RoomOOPPolymorphism) dungeon.getMyDungeon()[y_tile][x_tile]).HasBeenActivated()) {
                        tile.setImage(polymorphismactivated);
                    } else {
                        tile.setImage(polymorphism);
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomOOPEncapsulation) {
                    if (((RoomOOPEncapsulation) dungeon.getMyDungeon()[y_tile][x_tile]).HasBeenActivated()) {
                        tile.setImage(encapsulationactivated);
                    } else {
                        tile.setImage(encapsulation);
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomOOPAbstraction) {
                    if (((RoomOOPAbstraction) dungeon.getMyDungeon()[y_tile][x_tile]).HasBeenActivated()) {
                        tile.setImage(abstractionactivated);
                    } else {
                        tile.setImage(abstraction);
                    }
                } else if (dungeon.getMyDungeon()[y_tile][x_tile] instanceof RoomOOPInheritance) {
                    if (((RoomOOPInheritance) dungeon.getMyDungeon()[y_tile][x_tile]).HasBeenActivated()) {
                        tile.setImage(inheritanceactivated);
                    } else {
                        tile.setImage(inheritance);
                    }
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
