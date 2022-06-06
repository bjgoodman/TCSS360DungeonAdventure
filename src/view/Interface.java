package view;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import model.Hero;
import model.SaveManager;

public class Interface {
    private static String[] message = new String[4];
    private Image fileImage;
    private Image aboutImage;
    private SaveManager sm = new SaveManager();

    public Interface(Pane root, Hero player) {
        menuBar(root);
        statusArea(root);
        statusBar(root, player);
    }

    public static void newEvent(String message) {
        Interface.message[3] = Interface.message[2];
        Interface.message[2] = Interface.message[1];
        Interface.message[1] = Interface.message[0];
        Interface.message[0] = message;
    }

    private void statusArea(Pane root) {
        Label status_area = new Label(
                message[3] + "\n"
                        + message[2] + "\n"
                        + message[1] + "\n"
                        + message[0]);
        status_area.setAlignment(Pos.CENTER);
        status_area.setPadding(new Insets(10, 50, 10, 50));
        status_area.getStyleClass().add("status_area");
        status_area.setLayoutX(60);
        status_area.layoutYProperty().bind(root.heightProperty()
                .subtract(status_area.heightProperty()).subtract(30));
        root.getChildren().add(status_area);
    }

    private void statusBar(Pane root, Hero player) {
        Label status_bar = new Label(
                "Name: " + player.getMyCharacterName() +
                "\nHP: " + player.getMyCurrentHitPoints() + "/" + player.getMyHitPointsMax());
        status_bar.setAlignment(Pos.CENTER);
        status_bar.getStyleClass().add("status_bar");
        status_bar.setPadding(new Insets(20, 10, 20, 10));
        status_bar.setLayoutY(50);
        status_bar.layoutXProperty().bind(root.widthProperty()
                .subtract(status_bar.widthProperty()).subtract(20));
        root.getChildren().add(status_bar);
    }

    private void menuBar(Pane root) {
        Image fileImage = new Image("file:assets/misc/file.png");
        Image aboutImage = new Image("file:assets/misc/about.png");
        MenuBar menuBar = new MenuBar();
        Menu file = new Menu(" File ");
        Menu about = new Menu(" About ");
        MenuItem newGameAdventurer = new MenuItem(" Adventurer ");
        MenuItem newGameBarb = new MenuItem(" Barbarian ");
        MenuItem newGameThief = new MenuItem(" Thief ");
        MenuItem newGameEnchantress = new MenuItem(" Enchantress ");
        MenuItem saveGame = new MenuItem(" Save Game ");
        MenuItem loadGame = new MenuItem(" Load Game ");
        MenuItem aboutGame = new MenuItem(" About ");
        MenuItem instructionsGame = new MenuItem(" How To Play ");
        Menu newGameSubMenu = new Menu(" New Game ");

        newGameSubMenu.getStyleClass().add("new_game");
        newGameAdventurer.getStyleClass().add("new_game_adv");
        newGameBarb.getStyleClass().add("new_game_barb");
        newGameThief.getStyleClass().add("new_game_thief");
        newGameEnchantress.getStyleClass().add("new_game_enchantress");
        saveGame.getStyleClass().add("save_game");
        loadGame.getStyleClass().add("load_game");
        aboutGame.getStyleClass().add("about_game");
        instructionsGame.getStyleClass().add("instructions_game");
        file.getStyleClass().add("file");
        about.getStyleClass().add("about");

        file.getItems().add(newGameSubMenu);
        newGameSubMenu.getItems().add(newGameAdventurer);
        newGameSubMenu.getItems().add(newGameBarb);
        newGameSubMenu.getItems().add(newGameThief);
        newGameSubMenu.getItems().add(newGameEnchantress);
        file.getItems().add(saveGame);
        file.getItems().add(loadGame);
        about.getItems().add(aboutGame);
        about.getItems().add(instructionsGame);

        file.setGraphic(new ImageView(fileImage));
        about.setGraphic(new ImageView(aboutImage));
        menuBar.getMenus().add(file);
        menuBar.getMenus().add(about);
        menuBar.getStyleClass().add("menu_bar");

        instructionsGame.setOnAction(e -> {

        });

        root.getChildren().add(menuBar);
    }
}
