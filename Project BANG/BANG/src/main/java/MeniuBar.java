import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <h3> MeniuBar class </h3>
 * <p> This class creates the meniu bar that is desplayed at the top of the window. </p>
 */
public class MeniuBar {
    AnchorPane layout;
    Stage window;
    public MeniuBar(Stage window, AnchorPane layout) {
        this.window = window;
        this.layout = layout;
    }

    //se insereaza in maniu bar toate optiunile pentru a naviga mai usor in aplicatie
    public void init() {
        //create menu separator
        SeparatorMenuItem sep1 = new SeparatorMenuItem();
        SeparatorMenuItem sep2 = new SeparatorMenuItem();

        //create menu for the menu bar
        Menu gameMenu = new Menu("Game");
        Menu helpMenu = new Menu("How to play?");
        Menu aboutMenu = new Menu("About us");

        //empty menu for extendind the menu bar from left to right edge of the window
        Menu emptyMenu = new Menu("");
        emptyMenu.setDisable(true);

        //menu items for every menu
        MenuItem m1 = new MenuItem("New Game");
        m1.setOnAction(handleNewGame);
        MenuItem m3 = new MenuItem("Exit");
        m3.setOnAction(handleExit);

        MenuItem m4 = new MenuItem("Game rules");
        m4.setOnAction(handleRules);
        MenuItem m5 = new MenuItem("Roles");
        m5.setOnAction(handleRoles);
        MenuItem m6 = new MenuItem("Abilities");
        m6.setOnAction(handleAbilities);
        MenuItem m7 = new MenuItem("Cards");
        m7.setOnAction(handleCards);

        MenuItem m8 = new MenuItem("About us");
        m8.setOnAction(handleAbout);

        //inserting menu items to their menu label
        gameMenu.getItems().addAll(m1,sep1,m3);
        helpMenu.getItems().addAll(m4,sep2,m5,m6,m7);
        aboutMenu.getItems().add(m8);

        //create the menu bar and insert menus
        javafx.scene.control.MenuBar GameBar = new javafx.scene.control.MenuBar();
        GameBar.getMenus().addAll(gameMenu,helpMenu,aboutMenu);
        for(int i=0;i<45;i++) {
            GameBar.getMenus().add(emptyMenu);
        }

        //add menu bar to the window layout
        layout.getChildren().add(GameBar);
    }

    EventHandler<ActionEvent> handleNewGame = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            MainMenuScene scena = new MainMenuScene(layout, window);
            scena.init();
        }
    };

    EventHandler<ActionEvent> handleExit = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            window.close();
        }
    };

    EventHandler<ActionEvent> handleRules = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Rules regulament = new Rules(layout, window);
            regulament.init();
        }
    };

    EventHandler<ActionEvent> handleRoles = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Rules rol = new Rules(layout, window);
            rol.initRoles();
        }
    };

    EventHandler<ActionEvent> handleAbilities = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Rules rol = new Rules(layout, window);
            rol.initPersj();
        }
    };

    EventHandler<ActionEvent> handleCards = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Rules rol = new Rules(layout, window);
            rol.initCard();
        }
    };

    EventHandler<ActionEvent> handleAbout = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            AboutUs about = new AboutUs(window);
            about.init();
        }
    };
}
