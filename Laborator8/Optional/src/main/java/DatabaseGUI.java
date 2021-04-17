import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import java.io.FileNotFoundException;
import java.sql.SQLException;

/**
 * <h3> Clasa DatabaseGUI </h3>
 * <p> Construieste fereastra / scena + elemente de grafica pentru a avea o interfata mai simpatica pentru utilizator.</p>
 */
public class DatabaseGUI {
    Stage window;
    AnchorPane layout;
    ComboBox byGenre = new ComboBox();

    /**
     * <p> Constructorul va salva coordonatele ferestrei unde trebuie sa adauge elemnte de grafica. </p>
     *
     * @param window fereastra in care se adauga layout-ul
     * @param layout layout-ul pe care se ataseaza diverse obiecte de grafica
     */
    public DatabaseGUI(Stage window, AnchorPane layout) throws FileNotFoundException, SQLException {
        this.window = window;
        this.layout = layout;
    }

    /**
     * <h3> Functia initStage </h3>
     * <p> Initializeza toate obiectele si le adauga in scena. </p>
     * <p> Adauga functionalitate butoanelor </p>
     */
    public void initStage() throws FileNotFoundException {
        //imagine de fundal pe toata fereastra
        BackgroundImage myBI = new BackgroundImage(new Image("bg-bd.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        //imaginea din jumatatea stanga de fereastra
        Image image = new Image("db-pic.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        AnchorPane.setTopAnchor(imageView, 0.00);
        AnchorPane.setBottomAnchor(imageView, 0.00);
        AnchorPane.setRightAnchor(imageView, 500.00);
        AnchorPane.setLeftAnchor(imageView, 0.00);
        layout.getChildren().add(imageView);

        //titlul aplicatiei
        Label titlu = new Label("Movie Database");
        titlu.setFont(new Font("Nunito", 40));
        titlu.setTextFill(Color.web("#3b136b"));
        AnchorPane.setRightAnchor(titlu, 110.00);
        AnchorPane.setTopAnchor(titlu, 110.00);
        layout.getChildren().add(titlu);

        Label titlu2 = new Label("Management App");
        titlu2.setFont(new Font("Nunito", 30));
        titlu2.setTextFill(Color.web("#3b136b"));
        AnchorPane.setRightAnchor(titlu2, 132.00);
        AnchorPane.setTopAnchor(titlu2, 155.00);
        layout.getChildren().add(titlu2);

        //mini movie icon
        Image image2 = new Image("clapboard.png");
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        //Setting the image view parameters
        imageView2.setFitWidth(50);
        imageView2.setPreserveRatio(true);
        AnchorPane.setTopAnchor(imageView2, 245.00);
        AnchorPane.setRightAnchor(imageView2, 225.00);
        layout.getChildren().add(imageView2);

        //button de conectare la baza de date + (ca test:) inserarea a doua elemente
        Button connBtn = new Button("Test connection");
        connBtn.setStyle("-fx-pref-height: 40px;" + "-fx-pref-width: 160px;" + "-fx-font: 18 Nunito;" + "-fx-background-color: #9a7dfa;");
        connBtn.setOnAction(connHandler);
        AnchorPane.setTopAnchor(connBtn, 330.00);
        AnchorPane.setLeftAnchor(connBtn, 580.00);
        layout.getChildren().add(connBtn);

        Button movieBtn = new Button("All Movies Info");
        movieBtn.setStyle("-fx-pref-height: 40px;" + "-fx-pref-width: 160px;" + "-fx-font: 18 Nunito;" + "-fx-background-color: #9a7dfa;");
        movieBtn.setOnAction(movieHandler);
        AnchorPane.setTopAnchor(movieBtn, 330.00);
        AnchorPane.setRightAnchor(movieBtn, 80.00);
        layout.getChildren().add(movieBtn);

        byGenre.setStyle("-fx-pref-height: 40px;" + "-fx-pref-width: 160px;" + "-fx-font: 18 Nunito;" + "-fx-background-color: #9a7dfa;");
        byGenre.setOnAction(genreHandler);
        AnchorPane.setTopAnchor(byGenre, 390.00);
        AnchorPane.setRightAnchor(byGenre, 80.00);
        byGenre.getItems().addAll("Comedy", "Action", "Romance", "Drama", "Crime");
        byGenre.setPromptText("Genre");
        layout.getChildren().add(byGenre);

        //buton de exit - inchide aplicatia
        Button exitBtn = new Button("Exit");
        exitBtn.setStyle("-fx-pref-height: 40px;" + "-fx-pref-width: 160px;" + "-fx-font: 18 Nunito;" + "-fx-background-color: #9a7dfa;");
        exitBtn.setOnAction(exitHandler);
        AnchorPane.setTopAnchor(exitBtn, 390.00);
        AnchorPane.setLeftAnchor(exitBtn, 580.00);
        layout.getChildren().add(exitBtn);
    }

    /**
     * <p> Handler pentru butonul de conectare: indica exact codul care va fi rulat la apasarea acestuia</p>
     */
    EventHandler<ActionEvent> connHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Database database;
            try {
                database = Database.getInstance();
                MovieController movies = new MovieController(database);
                movies.create(4, "12 Angry men", 1957, 96, 9.0);
                GenreController genres = new GenreController(database);
                genres.create(4, "Comedy");

                //show output in new window
                Stage windowConn = new Stage();
                windowConn.setResizable(false);
                windowConn.setTitle("Connected!");
                windowConn.getIcons().add(new Image("db-logo.png"));
                AnchorPane layoutConn = new AnchorPane();
                //create first/start scene
                //imagine de fundal pe toata fereastra
                BackgroundImage myBI = new BackgroundImage(new Image("bg-bd.jpg", 280, 90, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                layoutConn.setBackground(new Background(myBI));
                //outputul:
                Label out = new Label("2 rows were inserted");
                out.setFont(new Font("Nunito", 20));
                AnchorPane.setTopAnchor(out, 27.00);
                AnchorPane.setLeftAnchor(out, 20.00);
                layoutConn.getChildren().add(out);
                //inserting layout into a scene and in the window stage
                Scene sceneConn = new Scene(layoutConn, 230, 90);
                windowConn.setScene(sceneConn);
                windowConn.show();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * <p> Handler pentru butonul de exit - inchide aplciatia. </p>
     */
    EventHandler<ActionEvent> exitHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            window.close();
        }
    };

    /**
     * <p> Handler pentru butonul de Movies info - afiseaza in consola toate informatiile. </p>
     */
    EventHandler<ActionEvent> movieHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Database database;
            try {
                database = Database.getInstance();
                MovieController movies = new MovieController(database);
                movies.allInfo();

                //show output in new window
                Stage window2 = new Stage();
                window2.setResizable(false);
                window2.setTitle("Movies");
                window2.getIcons().add(new Image("db-logo.png"));
                AnchorPane layout2 = new AnchorPane();
                //create first/start scene
                //imagine de fundal pe toata fereastra
                BackgroundImage myBI = new BackgroundImage(new Image("bg-bd.jpg", 280, 90, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                layout2.setBackground(new Background(myBI));
                //outputul:
                Label out = new Label("all info is in console");
                out.setFont(new Font("Nunito", 20));
                AnchorPane.setTopAnchor(out, 27.00);
                AnchorPane.setLeftAnchor(out, 25.00);
                layout2.getChildren().add(out);
                //inserting layout into a scene and in the window stage
                Scene scene2 = new Scene(layout2, 230, 90);
                window2.setScene(scene2);
                window2.show();

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    };

    /**
     * <p> Handler pentru butonul de movies by genre - afiseaza in consola toate filmele de acel gen </p>
     */
    EventHandler<ActionEvent> genreHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Database database;
            try {
                database = Database.getInstance();
                GenreController gen = new GenreController(database);
                gen.findByName((String)byGenre.getValue());

                //show output in new window
                Stage window2 = new Stage();
                window2.setResizable(false);
                window2.setTitle("Genre");
                window2.getIcons().add(new Image("db-logo.png"));
                AnchorPane layout2 = new AnchorPane();
                //create first/start scene
                //imagine de fundal pe toata fereastra
                BackgroundImage myBI = new BackgroundImage(new Image("bg-bd.jpg", 280, 90, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                layout2.setBackground(new Background(myBI));
                //outputul:
                Label out = new Label("all info is in console");
                out.setFont(new Font("Nunito", 20));
                AnchorPane.setTopAnchor(out, 27.00);
                AnchorPane.setLeftAnchor(out, 25.00);
                layout2.getChildren().add(out);
                //inserting layout into a scene and in the window stage
                Scene scene2 = new Scene(layout2, 230, 90);
                window2.setScene(scene2);
                window2.show();


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    };
}
