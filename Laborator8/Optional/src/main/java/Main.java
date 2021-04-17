import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * <h5> This is where everything starts. </h5>
 */
public class Main extends Application {

    Stage window;

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setResizable(false);
        window.setTitle("Movie Database");
        window.getIcons().add(new Image("db-logo.png"));

        AnchorPane layout = new AnchorPane();

        //create first/start scene
        DatabaseGUI gui = new DatabaseGUI(window, layout);
        gui.initStage();

        //inserting layout into a scene and in the window stage
        Scene scene = new Scene(layout, 1000, 600);
        window.setScene(scene);
        window.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
