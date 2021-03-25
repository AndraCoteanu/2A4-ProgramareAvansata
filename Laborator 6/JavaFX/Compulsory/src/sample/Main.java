package sample;

import com.sun.javafx.menu.MenuItemBase;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBase;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.util.EventObject;

public class Main extends Application{

    private void loadWhenClicked(ActionEvent event){
        Button button = (Button) event.getSource();
        System.out.println(button.getText()); // prints out button's text
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scena = new Scene(root, 600, 400);
        primaryStage.setTitle("Laborator 6");
        primaryStage.setScene(scena);
        primaryStage.setIconified(false);
       /* javafx.scene.shape.Polygon hexagon = new Polygon();
        hexagon.getPoints().addAll(new Double[]{
                200.0, 50.0,
                400.0, 50.0,
                450.0, 150.0,
                400.0, 250.0,
                200.0, 250.0,
                150.0, 150.0,
        });
        Group root1 = new Group(hexagon);
        Scene scene = new Scene(root1 ,600, 300);
        primaryStage.setScene(scene);*/



        primaryStage.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
            if(key.getCode()== KeyCode.ENTER) {
                System.out.println("You pressed enter");
            }
        });



        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
