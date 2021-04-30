import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * <h3> GameType class </h3>
 * <p> Here the user can choose how many players there are. </p>
 */
public class GameType {
    Stage window;
    TextField nameField;
    int players;
    String nume;

    public GameType(Stage window) {
        this.window = window;
    }

    //functia pentru alegerea numarului de jucatori
    public void init() {
        AnchorPane layoutNewGame = new AnchorPane();

        BackgroundImage myBI = new BackgroundImage(new Image("/background/shadyBG.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutNewGame.setBackground(new Background(myBI));

        MeniuBar meniuBar = new MeniuBar(window, layoutNewGame);
        meniuBar.init();

        Image image = new Image("/logo/bang-logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(350);
        imageView.setY(80);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        layoutNewGame.getChildren().add(imageView);

        Label text = new Label("Choose the number of players for the game:");
        text.setStyle("-fx-font: 25 Nunito;");
        AnchorPane.setTopAnchor(text, 300.00);
        AnchorPane.setRightAnchor(text, 250.00);
        layoutNewGame.getChildren().add(text);

        Button patru = new Button("4");
        patru.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 100px;" + "-fx-font: 18 Nunito;");
        patru.setOnAction(fourHandler);

        Button cinci = new Button("5");
        cinci.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 100px;" + "-fx-font: 18 Nunito;");
        cinci.setOnAction(fiveHandler);

        Button sase = new Button("6");
        sase.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 100px;" + "-fx-font: 18 Nunito;");
        sase.setOnAction(sixHandler);

        Button sapte = new Button("7");
        sapte.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 100px;" + "-fx-font: 18 Nunito;");
        sapte.setOnAction(sevenHandler);

        AnchorPane.setTopAnchor(patru, 375.00);
        AnchorPane.setLeftAnchor(patru, 360.00);

        AnchorPane.setTopAnchor(cinci, 375.00);
        AnchorPane.setRightAnchor(cinci, 360.00);

        AnchorPane.setTopAnchor(sase, 435.00);
        AnchorPane.setLeftAnchor(sase, 360.00);

        AnchorPane.setTopAnchor(sapte, 435.00);
        AnchorPane.setRightAnchor(sapte, 360.00);

        layoutNewGame.getChildren().addAll(patru, cinci, sase, sapte);

        Scene scene = new Scene(layoutNewGame, 1000, 600);
        window.setScene(scene);
    }

    //functia pentru alegerea numelui persoanei care a creat jocul / main player
    private void initGetName() {
        AnchorPane layoutNewGame = new AnchorPane();

        BackgroundImage myBI = new BackgroundImage(new Image("/background/shadyBG.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutNewGame.setBackground(new Background(myBI));

        MeniuBar meniuBar = new MeniuBar(window, layoutNewGame);
        meniuBar.init();

        Image image = new Image("/logo/bang-logo.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(350);
        imageView.setY(80);
        imageView.setFitWidth(300);
        imageView.setPreserveRatio(true);
        layoutNewGame.getChildren().add(imageView);

        Label text = new Label("Choose a name for yourself:");
        text.setStyle("-fx-font: 27 Nunito;");
        AnchorPane.setTopAnchor(text, 350.00);
        AnchorPane.setLeftAnchor(text, 235.00);
        layoutNewGame.getChildren().add(text);

        nameField = new TextField ("...");
        nameField.setStyle("-fx-font: 25 Nunito;" + "-fx-background-color: transparent;" + "-fx-border-color: grey;" + "-fx-border-width: 0 0 1 0;");
        nameField.setPrefColumnCount(15);
        nameField.setPrefWidth(200);
        AnchorPane.setTopAnchor(nameField, 340.00);
        AnchorPane.setRightAnchor(nameField, 235.00);
        layoutNewGame.getChildren().add(nameField);

        Button submit = new Button("Submit");
        submit.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
        submit.setOnAction(submitHandler);
        AnchorPane.setTopAnchor(submit, 450.00);
        AnchorPane.setRightAnchor(submit,425.00);
        layoutNewGame.getChildren().add(submit);

        Scene scene = new Scene(layoutNewGame, 1000, 600);
        window.setScene(scene);
    }

    //verificarea numelui pentru a nu contine alte caractere in afara de litere si cifre
    // + verificare sa nu depaseasca lungimea de 7 caractere (scopul numelui este sa se simta mai personalizabil jocul)
    private boolean isInputValid() {
        Boolean verif = false;
        String input = nameField.getText();
        if (!(input == null || input.length() == 0)) {
            try {
                //validation rules:
                if (!input.matches(".*[[{(<,./?;:'\"+=_*&^%$#@!~`>)}]].*") && input.length()<8) {
                    verif = true;
                }
            } catch (NumberFormatException e) {
            }
            return verif;
        }
        return verif;
    };

    //handle-rui pentru numarul de jucatori, salveaza optiunea aleasa si trimite jucatorul mai departa la alegerea unui nume
    EventHandler<ActionEvent> fourHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            players = 4;
            initGetName();
        }
    };

    EventHandler<ActionEvent> fiveHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            players = 5;
            initGetName();
        }
    };

    EventHandler<ActionEvent> sixHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            players = 6;
            initGetName();
        }
    };

    EventHandler<ActionEvent> sevenHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            players = 7;
            initGetName();
        }
    };

    //daca numele este valid se va incepe jocul, daca nu se va reseta scena
    //si se va mai insera un timeline, un pop-up de cateva secunde care anunta jucatorul ca numele ales nu este okay
    EventHandler<ActionEvent> submitHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(isInputValid()) {
                nume = nameField.getText();
                Game joc = new Game(window, players, nume);

            } else {
                AnchorPane layoutGame = new AnchorPane();

                BackgroundImage myBI = new BackgroundImage(new Image("/background/shadyBG.jpg", 1000, 600, false, true),
                        BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                        BackgroundSize.DEFAULT);
                layoutGame.setBackground(new Background(myBI));

                MeniuBar meniuBar = new MeniuBar(window, layoutGame);
                meniuBar.init();

                Image image = new Image("/logo/bang-logo.png");
                ImageView imageView = new ImageView();
                imageView.setImage(image);
                //Setting the image view parameters
                imageView.setX(350);
                imageView.setY(80);
                imageView.setFitWidth(300);
                imageView.setPreserveRatio(true);
                layoutGame.getChildren().add(imageView);

                Label text = new Label("Choose a name for yourself:");
                text.setStyle("-fx-font: 27 Nunito;");
                AnchorPane.setTopAnchor(text, 350.00);
                AnchorPane.setLeftAnchor(text, 235.00);
                layoutGame.getChildren().add(text);

                nameField = new TextField ("...");
                nameField.setStyle("-fx-font: 25 Nunito;" + "-fx-background-color: transparent;" + "-fx-border-color: grey;" + "-fx-border-width: 0 0 1 0;");
                nameField.setPrefColumnCount(15);
                nameField.setPrefWidth(200);
                AnchorPane.setTopAnchor(nameField, 340.00);
                AnchorPane.setRightAnchor(nameField, 235.00);
                layoutGame.getChildren().add(nameField);

                Button submit = new Button("Submit");
                submit.setStyle("-fx-pref-height: 35px;" + "-fx-pref-width: 150px;" + "-fx-font: 18 Nunito;");
                submit.setOnAction(submitHandler);
                AnchorPane.setTopAnchor(submit, 450.00);
                AnchorPane.setRightAnchor(submit,425.00);
                layoutGame.getChildren().add(submit);


                Image image2 = new Image("/others/pop-up.png");
                ImageView imageView2 = new ImageView();
                imageView2.setImage(image2);
                imageView2.setX(425);
                imageView2.setY(285);
                imageView2.setFitWidth(150);
                imageView2.setPreserveRatio(true);
                Timeline timeline = new Timeline(
                        new KeyFrame(Duration.ZERO, new KeyValue(imageView2.imageProperty(), image2)),
                        new KeyFrame(Duration.seconds(1), new KeyValue(imageView2.imageProperty(), image2)),
                        new KeyFrame(Duration.seconds(5), new KeyValue(imageView2.imageProperty(), null))
                );
                timeline.play();
                layoutGame.getChildren().add(imageView2);
                Scene scene = new Scene(layoutGame, 1000, 600);
                window.setScene(scene);
            }

        }
    };
}