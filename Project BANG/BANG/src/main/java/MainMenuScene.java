import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <h3> MainMenuScene class </h3>
 * <p> Here is configured the app GUI. </p>
 */
public class MainMenuScene {
    AnchorPane layout;
    Stage window;
    public MainMenuScene (AnchorPane layout, Stage window)
    {
        this.layout = layout;
        this.window = window;
    }

    //se initiaza ecranul principal al aplicatiei
    public void initStart()
    {
        BackgroundImage myBI= new BackgroundImage(new Image("/background/MainBackground.jpg",1000,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        //create menu bar
        MeniuBar meniu = new MeniuBar(window,layout);
        meniu.init();

        Image image = new Image("/logo/bang-logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(325);
        imageView.setY(100);
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);
        layout.getChildren().add(imageView);

        Button playButton = new Button("Play");
        playButton.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        playButton.setOnAction(playHandler);

        Button instructButton = new Button("Instructions");
        instructButton.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        instructButton.setOnAction(instructHandler);

        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        exitButton.setOnAction(exitHandler);

        AnchorPane.setTopAnchor(playButton, 350.00);
        AnchorPane.setRightAnchor(playButton,425.00);

        AnchorPane.setTopAnchor(instructButton, 400.00);
        AnchorPane.setRightAnchor(instructButton,425.00);

        AnchorPane.setTopAnchor(exitButton, 450.00);
        AnchorPane.setRightAnchor(exitButton,425.00);

        layout.getChildren().addAll(playButton,instructButton,exitButton);
    }

    public void init()
    {
        AnchorPane layoutStart = new AnchorPane();

        BackgroundImage myBI= new BackgroundImage(new Image("/background/MainBackground.jpg",1000,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutStart.setBackground(new Background(myBI));

        //create menu bar
        MeniuBar meniu = new MeniuBar(window,layoutStart);
        meniu.init();

        Image image = new Image("/logo/bang-logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(325);
        imageView.setY(100);
        imageView.setFitWidth(350);
        imageView.setPreserveRatio(true);
        layoutStart.getChildren().add(imageView);

        Button playButton = new Button("Play");
        playButton.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        playButton.setOnAction(playHandler);

        Button instructButton = new Button("Instructions");
        instructButton.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        instructButton.setOnAction(instructHandler);

        Button exitButton = new Button("Exit");
        exitButton.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        exitButton.setOnAction(exitHandler);

        AnchorPane.setTopAnchor(playButton, 350.00);
        AnchorPane.setRightAnchor(playButton,425.00);

        AnchorPane.setTopAnchor(instructButton, 400.00);
        AnchorPane.setRightAnchor(instructButton,425.00);

        AnchorPane.setTopAnchor(exitButton, 450.00);
        AnchorPane.setRightAnchor(exitButton,425.00);

        layoutStart.getChildren().addAll(playButton,instructButton,exitButton);

        Scene scene = new Scene(layoutStart,1000,600);
        window.setScene(scene);
    }

    EventHandler<ActionEvent> playHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            GameType newgame= new GameType(window);
            newgame.init();
        }
    };

    EventHandler<ActionEvent> instructHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            Rules regulament = new Rules(layout, window);
            regulament.init();
        }
    };

    EventHandler<ActionEvent> exitHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            window.close();
        }
    };

}
