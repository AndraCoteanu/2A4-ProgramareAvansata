import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <h3> Rules Class </h3>
 * <p> This class creates the rules pages and shows them to the user when needed. </p>
 */
public class Rules {
    AnchorPane layout;
    Stage window;
    public Rules(AnchorPane layout, Stage window) {
        this.layout = layout;
        this.window = window;
    }
    //initializeaza tot setul de reguli
    public void init() {
        ScrollBar scroll = new ScrollBar();
        AnchorPane.setRightAnchor(scroll, 0.00);
        AnchorPane.setTopAnchor(scroll, 0.00);
        AnchorPane.setBottomAnchor(scroll,0.00);
        scroll.setMin(0);
        scroll.setMax(15600);
        scroll.setValue(0);
        scroll.setOrientation(Orientation.VERTICAL);
        scroll.setUnitIncrement(10);
        scroll.setBlockIncrement(100);

        AnchorPane layoutRules = new AnchorPane();

        BackgroundImage myBI= new BackgroundImage(new Image("/background/bej.png",1000,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutRules.setBackground(new Background(myBI));

        layoutRules.getChildren().add(scroll);

        Button backButton = new Button("");
        backButton.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 48px;" + "-fx-font: 10 Nunito;" + "-fx-focus-color: transparent;" + "-fx-background-image: url('/icon/back.jpg')");
        backButton.setOnAction(backHandler);
        layoutRules.getChildren().add(backButton);

        Image image1 = new Image("/rules/bang-rules-01.jpg");
        Image image2 = new Image("/rules/bang-rules-02.jpg");
        Image image3 = new Image("/rules/bang-rules-03.jpg");
        Image image4 = new Image("/rules/bang-rules-04.jpg");
        Image image5 = new Image("/rules/bang-rules-05.jpg");
        Image image6 = new Image("/rules/bang-rules-06.jpg");
        Image image7 = new Image("/rules/bang-rules-07.jpg");
        Image image8 = new Image("/rules/bang-rules-08.jpg");
        Image image9 = new Image("/rules/bang-rules-09.jpg");
        Image image10 = new Image("/rules/bang-rules-10.jpg");
        Image image11 = new Image("/rules/bang-rules-11.jpg");
        Image image12 = new Image("/rules/bang-rules-12.jpg");

        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(50);
        imageView1.setY(0);
        imageView1.setFitWidth(935);
        imageView1.setFitHeight(1409.00);
        imageView1.setPreserveRatio(true);

        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setX(50);
        imageView2.setY(0);
        imageView2.setFitWidth(935);
        imageView2.setFitHeight(1409.00);
        imageView2.setPreserveRatio(true);

        ImageView imageView3 = new ImageView();
        imageView3.setImage(image3);
        imageView3.setX(50);
        imageView3.setY(0);
        imageView3.setFitWidth(935);
        imageView3.setFitHeight(1409.00);
        imageView3.setPreserveRatio(true);

        ImageView imageView4 = new ImageView();
        imageView4.setImage(image4);
        imageView4.setX(50);
        imageView4.setY(0);
        imageView4.setFitWidth(935);
        imageView4.setFitHeight(1409.00);
        imageView4.setPreserveRatio(true);

        ImageView imageView5 = new ImageView();
        imageView5.setImage(image5);
        imageView5.setX(50);
        imageView5.setY(0);
        imageView5.setFitWidth(935);
        imageView5.setFitHeight(1409.00);
        imageView5.setPreserveRatio(true);

        ImageView imageView6 = new ImageView();
        imageView6.setImage(image6);
        imageView6.setX(50);
        imageView6.setY(0);
        imageView6.setFitWidth(935);
        imageView6.setFitHeight(1409.00);
        imageView6.setPreserveRatio(true);

        ImageView imageView7 = new ImageView();
        imageView7.setImage(image7);
        imageView7.setX(50);
        imageView7.setY(0);
        imageView7.setFitWidth(935);
        imageView7.setFitHeight(1409.00);
        imageView7.setPreserveRatio(true);

        ImageView imageView8 = new ImageView();
        imageView8.setImage(image8);
        imageView8.setX(50);
        imageView8.setY(0);
        imageView8.setFitWidth(935);
        imageView8.setFitHeight(1409.00);
        imageView8.setPreserveRatio(true);

        ImageView imageView9 = new ImageView();
        imageView9.setImage(image9);
        imageView9.setX(50);
        imageView9.setY(0);
        imageView9.setFitWidth(935);
        imageView9.setFitHeight(1409.00);
        imageView9.setPreserveRatio(true);

        ImageView imageView10 = new ImageView();
        imageView10.setImage(image10);
        imageView10.setX(50);
        imageView10.setY(0);
        imageView10.setFitWidth(935);
        imageView10.setFitHeight(1409.00);
        imageView10.setPreserveRatio(true);

        ImageView imageView11 = new ImageView();
        imageView11.setImage(image11);
        imageView11.setX(50);
        imageView11.setY(0);
        imageView11.setFitWidth(935);
        imageView11.setFitHeight(1409.00);
        imageView11.setPreserveRatio(true);

        ImageView imageView12 = new ImageView();
        imageView12.setImage(image12);
        imageView12.setX(50);
        imageView12.setY(0);
        imageView12.setFitWidth(935);
        imageView12.setFitHeight(1409.00);
        imageView12.setPreserveRatio(true);

        FlowPane container = new FlowPane();
        AnchorPane.setRightAnchor(container, 15.00);
        AnchorPane.setLeftAnchor(container, 50.00);
        container.getChildren().addAll(imageView1, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, imageView11, imageView12);



        scroll.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            container.setLayoutY(-new_val.doubleValue());
        });

        layoutRules.getChildren().add(container);


        Scene scene = new Scene(layoutRules,1000,600);
        window.setScene(scene);
    }

    EventHandler<ActionEvent> backHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            layout.getChildren().clear();
            MainMenuScene scene1 = new MainMenuScene(layout, window);
            scene1.init();
        }
    };

    //initializeaza setul de reguli pentru roluri
    //deschide o noua fereastra pentru a lasa jucatorul sa acceseze informatii despre joc in timp ce se joaca (in cazul incepatorilor)
    public void initRoles() {
        Stage roluri = new Stage();
        roluri.setResizable(false);
        roluri.setTitle("BANG! The Roles");
        roluri.getIcons().add(new Image("/icon/BANG-icon.png"));
        AnchorPane layoutRol = new AnchorPane();

        ScrollBar scroll = new ScrollBar();
        AnchorPane.setRightAnchor(scroll, 0.00);
        AnchorPane.setTopAnchor(scroll, 0.00);
        AnchorPane.setBottomAnchor(scroll,0.00);
        scroll.setMin(0);
        scroll.setMax(750);
        scroll.setValue(0);
        scroll.setOrientation(Orientation.VERTICAL);
        scroll.setUnitIncrement(10);
        scroll.setBlockIncrement(100);
        layoutRol.getChildren().add(scroll);

        Image image0 = new Image("/rules/roles/bang-rules-00.jpg");
        Image image1 = new Image("/rules/roles/bang-rules-01.jpg");
        Image image2 = new Image("/rules/roles/bang-rules-02.jpg");
        Image image4 = new Image("/rules/roles/bang-rules-04.jpg");

        ImageView imageView0 = new ImageView();
        imageView0.setImage(image0);
        imageView0.setX(50);
        imageView0.setY(0);
        imageView0.setFitWidth(685);
        //imageView0.setFitHeight(1409.00);
        imageView0.setPreserveRatio(true);

        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(50);
        imageView1.setY(0);
        imageView1.setFitWidth(685);
       // imageView1.setFitHeight(1409.00);
        imageView1.setPreserveRatio(true);

        ImageView imageView2 = new ImageView();
        imageView2.setImage(image2);
        imageView2.setX(50);
        imageView2.setY(0);
        imageView2.setFitWidth(685);
        //imageView2.setFitHeight(1409.00);
        imageView2.setPreserveRatio(true);

        ImageView imageView4 = new ImageView();
        imageView4.setImage(image4);
        imageView4.setX(50);
        imageView4.setY(0);
        imageView4.setFitWidth(685);
       // imageView4.setFitHeight(1409.00);
        imageView4.setPreserveRatio(true);

        FlowPane container = new FlowPane();
        AnchorPane.setRightAnchor(container, 15.00);
        AnchorPane.setLeftAnchor(container, 0.00);
        container.getChildren().addAll(imageView0, imageView1, imageView2, imageView4);


        scroll.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            container.setLayoutY(-new_val.doubleValue());
        });

        layoutRol.getChildren().add(container);


        //inserting layout into a scene and in the window stage
        Scene sceneRol = new Scene(layoutRol,700,400);
        roluri.setScene(sceneRol);
        roluri.show();
    }

    //initializeaza fereastra cu regulile ce privesc cartile de joc
    public void initCard() {
        Stage roluri = new Stage();
        roluri.setResizable(false);
        roluri.setTitle("BANG! The Cards");
        roluri.getIcons().add(new Image("/icon/BANG-icon.png"));
        AnchorPane layoutRol = new AnchorPane();

        ScrollBar scroll = new ScrollBar();
        AnchorPane.setRightAnchor(scroll, 0.00);
        AnchorPane.setTopAnchor(scroll, 0.00);
        AnchorPane.setBottomAnchor(scroll,0.00);
        scroll.setMin(0);
        scroll.setMax(4390);
        scroll.setValue(0);
        scroll.setOrientation(Orientation.VERTICAL);
        scroll.setUnitIncrement(10);
        scroll.setBlockIncrement(100);
        layoutRol.getChildren().add(scroll);

        Image image1 = new Image("/rules/cards/bang-rules-01.jpg");
        Image image5 = new Image("/rules/cards/bang-rules-05.jpg");
        Image image6 = new Image("/rules/cards/bang-rules-06.jpg");
        Image image7 = new Image("/rules/cards/bang-rules-07.jpg");
        Image image8 = new Image("/rules/cards/bang-rules-08.jpg");
        Image image9 = new Image("/rules/cards/bang-rules-09.jpg");

        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(50);
        imageView1.setY(0);
        imageView1.setFitWidth(685);
        imageView1.setPreserveRatio(true);

        ImageView imageView5 = new ImageView();
        imageView5.setImage(image5);
        imageView5.setX(50);
        imageView5.setY(0);
        imageView5.setFitWidth(685);
        imageView5.setPreserveRatio(true);

        ImageView imageView6 = new ImageView();
        imageView6.setImage(image6);
        imageView6.setX(50);
        imageView6.setY(0);
        imageView6.setFitWidth(685);
        imageView6.setPreserveRatio(true);

        ImageView imageView7 = new ImageView();
        imageView7.setImage(image7);
        imageView7.setX(50);
        imageView7.setY(0);
        imageView7.setFitWidth(685);
        imageView7.setPreserveRatio(true);

        ImageView imageView8 = new ImageView();
        imageView8.setImage(image8);
        imageView8.setX(50);
        imageView8.setY(0);
        imageView8.setFitWidth(685);
        imageView8.setPreserveRatio(true);

        ImageView imageView9 = new ImageView();
        imageView9.setImage(image9);
        imageView9.setX(50);
        imageView9.setY(0);
        imageView9.setFitWidth(685);
        imageView9.setPreserveRatio(true);

        FlowPane container = new FlowPane();
        AnchorPane.setRightAnchor(container, 15.00);
        AnchorPane.setLeftAnchor(container, 0.00);
        container.getChildren().addAll(imageView1, imageView5, imageView6, imageView7, imageView8, imageView9);

        scroll.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            container.setLayoutY(-new_val.doubleValue());
        });

        layoutRol.getChildren().add(container);

        //inserting layout into a scene and in the window stage
        Scene sceneRol = new Scene(layoutRol,700,400);
        roluri.setScene(sceneRol);
        roluri.show();
    }

    //initializeaza fereastra cu reguli despre caracterele existente
    public void initPersj() {
        Stage roluri = new Stage();
        roluri.setResizable(false);
        roluri.setTitle("BANG! The Characters");
        roluri.getIcons().add(new Image("/icon/BANG-icon.png"));
        AnchorPane layoutRol = new AnchorPane();

        ScrollBar scroll = new ScrollBar();
        AnchorPane.setRightAnchor(scroll, 0.00);
        AnchorPane.setTopAnchor(scroll, 0.00);
        AnchorPane.setBottomAnchor(scroll,0.00);
        scroll.setMin(0);
        scroll.setMax(1050);
        scroll.setValue(0);
        scroll.setOrientation(Orientation.VERTICAL);
        scroll.setUnitIncrement(10);
        scroll.setBlockIncrement(100);
        layoutRol.getChildren().add(scroll);

        Image image1 = new Image("/rules/abilities/bang-rules-01.jpg");
        Image image10 = new Image("/rules/abilities/bang-rules-10.jpg");
        Image image11 = new Image("/rules/abilities/bang-rules-11.jpg");

        ImageView imageView1 = new ImageView();
        imageView1.setImage(image1);
        imageView1.setX(50);
        imageView1.setY(0);
        imageView1.setFitWidth(685);
        imageView1.setPreserveRatio(true);

        ImageView imageView10 = new ImageView();
        imageView10.setImage(image10);
        imageView10.setX(50);
        imageView10.setY(0);
        imageView10.setFitWidth(685);
        imageView10.setPreserveRatio(true);

        ImageView imageView11 = new ImageView();
        imageView11.setImage(image11);
        imageView11.setX(50);
        imageView11.setY(0);
        imageView11.setFitWidth(685);
        imageView11.setPreserveRatio(true);

        FlowPane container = new FlowPane();
        AnchorPane.setRightAnchor(container, 15.00);
        AnchorPane.setLeftAnchor(container, 0.00);
        container.getChildren().addAll(imageView1, imageView10, imageView11);

        scroll.valueProperty().addListener((ObservableValue<? extends Number> ov, Number old_val, Number new_val) -> {
            container.setLayoutY(-new_val.doubleValue());
        });

        layoutRol.getChildren().add(container);

        //inserting layout into a scene and in the window stage
        Scene sceneRol = new Scene(layoutRol,700,400);
        roluri.setScene(sceneRol);
        roluri.show();
    }
}
