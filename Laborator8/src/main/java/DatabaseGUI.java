import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.control.Label;

public class DatabaseGUI {
    Stage window;
    AnchorPane layout;

    public DatabaseGUI(Stage window, AnchorPane layout) {
        this.window = window;
        this.layout = layout;
    }

    public void initStage() {
        BackgroundImage myBI= new BackgroundImage(new Image("bg-bd.jpg",1000,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layout.setBackground(new Background(myBI));

        Image image = new Image("db-pic.jpg");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setFitWidth(500);
        imageView.setPreserveRatio(true);
        AnchorPane.setTopAnchor(imageView, 0.00);
        AnchorPane.setBottomAnchor(imageView, 0.00);
        AnchorPane.setRightAnchor(imageView, 500.00);
        AnchorPane.setLeftAnchor(imageView,0.00);
        layout.getChildren().add(imageView);

        Label titlu = new Label("Movie Database");
        titlu.setFont(new Font("Nunito",40));
        titlu.setTextFill(Color.web("#3b136b"));
        AnchorPane.setRightAnchor(titlu, 110.00);
        AnchorPane.setTopAnchor(titlu,110.00);
        layout.getChildren().add(titlu);

        Label titlu2 = new Label("Management App");
        titlu2.setFont(new Font("Nunito",30));
        titlu2.setTextFill(Color.web("#3b136b"));
        AnchorPane.setRightAnchor(titlu2, 132.00);
        AnchorPane.setTopAnchor(titlu2,155.00);
        layout.getChildren().add(titlu2);

        Image image2 = new Image("clapboard.png");
        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        //Setting the image view parameters
        imageView2.setFitWidth(50);
        imageView2.setPreserveRatio(true);
        AnchorPane.setTopAnchor(imageView2, 245.00);
        AnchorPane.setRightAnchor(imageView2, 225.00);
        layout.getChildren().add(imageView2);

        Button connBtn = new Button("Connect to DB");
        connBtn.setStyle("-fx-pref-height: 40px;" + "-fx-pref-width: 160px;" + "-fx-font: 18 Nunito;" + "-fx-background-color: #9a7dfa;");
        connBtn.setOnAction(connHandler);
        AnchorPane.setTopAnchor(connBtn, 330.00);
        AnchorPane.setRightAnchor(connBtn, 170.00);
        layout.getChildren().add(connBtn);

        Button exitBtn = new Button("Exit");
        exitBtn.setStyle("-fx-pref-height: 40px;" + "-fx-pref-width: 160px;" + "-fx-font: 18 Nunito;" + "-fx-background-color: #9a7dfa;");
        exitBtn.setOnAction(exitHandler);
        AnchorPane.setTopAnchor(exitBtn, 400.00);
        AnchorPane.setRightAnchor(exitBtn, 170.00);
        layout.getChildren().add(exitBtn);
    }

    EventHandler<ActionEvent> connHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
             MovieController movies = new MovieController();
             movies.create(4, "12 Angry men", 1957, 96, 9.0);
        }
    };

    EventHandler<ActionEvent> exitHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            window.close();
        }
    };
}
