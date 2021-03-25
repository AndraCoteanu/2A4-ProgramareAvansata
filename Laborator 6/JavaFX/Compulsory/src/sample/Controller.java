package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.datatransfer.StringSelection;
import java.io.IOException;
import java.util.Scanner;

public class Controller{
    @FXML
    public void exitApp()
    {
        Platform.exit();
        System.out.println("App closed.");
    }

    @FXML
    public void initializeSize() {
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("Big");
        choiceBox.getItems().add("Medium");
        choiceBox.getItems().add("Small");
        HBox hbox = new HBox(choiceBox);
    }

    @FXML
    private void drawShapes() {
        //Drawing a Circle
        Circle circle = new Circle();

        //Setting the properties of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(180.0f);
        circle.setRadius(90.0f);

        //Setting color to the circle
        circle.setFill(Color.DARKRED);

        //Setting the stroke width
        circle.setStrokeWidth(3);

        //Setting color to the stroke
        circle.setStroke(Color.DARKSLATEBLUE);

        //Creating a Group object
        Group root = new Group(circle);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        Stage stage = new Stage();
        //Setting title to the Stage
        stage.setTitle("Color Example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    @FXML
    public void initializeShape() {
        ChoiceBox choiceBox = new ChoiceBox();
        choiceBox.getItems().add("Square");
        choiceBox.getItems().add("Rectangle");
        choiceBox.getItems().add("Circle");
        choiceBox.getItems().add("Polygon");
        HBox hbox = new HBox(choiceBox);
    }

    public Controller() {
    }
}
