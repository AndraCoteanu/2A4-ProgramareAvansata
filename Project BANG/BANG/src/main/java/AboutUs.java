import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * <h3> AboutUs Class </h3>
 * <p> Here is created the about us page </p>
 */
public class AboutUs {
    Stage window;

    public AboutUs(Stage window) {
        this.window = window;
    }

    public void init()
    {
        AnchorPane layoutAbout = new AnchorPane();

        //se adauga poza de background cu toate informatiile din about us
        BackgroundImage myBI= new BackgroundImage(new Image("/background/about.jpg",1000,600,false,true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutAbout.setBackground(new Background(myBI));

        //se insereaza si un meniu bar pentru a putea naviga in continuare in aplicatie
        MeniuBar meniuBar = new MeniuBar(window,layoutAbout);
        meniuBar.init();

        Scene scene = new Scene(layoutAbout,1000,600);
        window.setScene(scene);
    }
}
