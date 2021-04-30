import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <h3> Main Class </h3>
 * <p> From this class starts the application. </p>
 */
public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        //se seteaza scena: nu poate fi modificata dimensiunea, nu este "responsive"
        window = primaryStage;
        window.setResizable(false);
        window.setTitle("BANG! The Game");
        window.getIcons().add(new Image("/icon/BANG-icon.png"));

        AnchorPane layout = new AnchorPane();

        //create first/start scene
        MainMenuScene scene1 = new MainMenuScene(layout, window);
        scene1.initStart();

        //inserting layout into a scene and in the window stage
        Scene scene = new Scene(layout,1000,600);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
