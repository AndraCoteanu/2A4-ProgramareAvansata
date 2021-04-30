import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class Game {
    Stage window;
    int noPlayers;
    String nameMainPlayer;
    AnchorPane layoutGame;
    List<Player> players = new ArrayList<>();
    CardPack pachet = new CardPack();

    public Game(Stage window, int noPlayers, String nameMainPlayer) {
        this.window = window;
        this.noPlayers = noPlayers;
        this.nameMainPlayer = nameMainPlayer;
        startGame();
    }

    //in functie de numarul de jucatori, este apelata functia pentru initializarea jocului
    private void startGame() {
        layoutGame = new AnchorPane();
        if(noPlayers == 4) {
            initGame4();
        } else if(noPlayers == 5) {
            initGame5();
        } else if(noPlayers == 6) {
            initGame6();
        } else if(noPlayers == 7) {
            initGame7();
        }

        //ce au in comun toate jocurile indiferent de numarul de jucatori este butonul de leave care ii permite jucatorului sa paraseasca jocul
        Button leave = new Button();
        leave.setStyle("-fx-pref-height: 100px;" + "-fx-pref-width: 100px;" + "-fx-font: 18 Nunito;");
        leave.setOnAction(leaveHandler);
        BackgroundImage backgroundImage = new BackgroundImage( new Image( getClass().getResource("/others/leave.png").toExternalForm()), BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background background = new Background(backgroundImage);
        leave.setBackground(background);
        AnchorPane.setTopAnchor(leave, 490.00);
        AnchorPane.setLeftAnchor(leave,25.00);
        layoutGame.getChildren().add(leave);
    }

    //functie ajutatoare pentru initializarea zonei cu informatii despre un jucator
    private void initMatt (int coordX, int coordY) {
        Image image = new Image("/others/matt3.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(coordX);
        imageView.setY(coordY);
        imageView.setFitWidth(280);
        imageView.setPreserveRatio(true);
        layoutGame.getChildren().add(imageView);
    }

    private void initMatt2 (int coordX, int coordY) {
        Image image = new Image("/others/matt3.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(coordX);
        imageView.setY(coordY);
        imageView.setFitWidth(230);
        imageView.setPreserveRatio(true);
        layoutGame.getChildren().add(imageView);
    }

    //functie ajutatoare pentru definirea zonei unde vor fi afisate informatiile despre mainPlayer
    private void initMainMatt (int coordX, int coordY) {
        Image image = new Image("/others/mainMatt2.png");
        ImageView imageView = new ImageView();
        imageView.setImage(image);
        //Setting the image view parameters
        imageView.setX(coordX);
        imageView.setY(coordY);
        imageView.setFitWidth(700);
        imageView.setPreserveRatio(true);
        layoutGame.getChildren().add(imageView);
    }

    //functie ajutatoare care eticheteaza fiecare astfel de zona cu nume jucatorului corespunzator
    private void nameTag (String nume, Double top, Double left) {
        Label text = new Label(nume);
        text.setStyle("-fx-font: 25 Nunito;");
        AnchorPane.setTopAnchor(text, top);
        AnchorPane.setLeftAnchor(text, left);
        layoutGame.getChildren().add(text);
    }

    //se initializeaza datele despre mainPlayer
    private void initMainPlayer (RoleSet rolList, CharacterSet caractere) {
        /* se creaza detaliile jucatorului care a initiat jocul */
        int viata = 0;

        /* generare caracter */
        Character persj = caractere.set.get(0);
        //afisare cartea cu personajul
        String path = "/characters/" + persj.getNume() + ".png";

        //pentru a putea mari cartea cu personajul (sa fie mai vizibila)
        Button pers = new Button();
        pers.setStyle("-fx-pref-height: 80px;" + "-fx-pref-width: 50px;" + "-fx-background-image: url(" + path + ");" + "-fx-background-size: 50px 80px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
        pers.setOnAction(persHandler);
        AnchorPane.setTopAnchor(pers, 513.00);
        AnchorPane.setLeftAnchor(pers,185.00);
        layoutGame.getChildren().add(pers);

        /* user codes: 0 - no one // -1 - player that created the game // 1 - bot 1 // 2 - bot 2 // 3 - bot 3 */
        persj.setUser(-1);
        viata = persj.getLifePoints();

        /* generare rol */
        Role rol = rolList.roluri.get(0);

        rolList.roluri.get(0).setUser(-1);
        System.out.println(rol);
        if (rol.getNume() == "Sheriff") {
            viata += 1;
            //oricine cu rolul de serif va fi vizibil tuturor celorlalti jucatori
            Button serif = new Button();
            serif.setStyle("-fx-pref-height: 50px;" + "-fx-pref-width: 50px;" + "-fx-background-image: url('/roles/sheriff.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 50px 50px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            serif.setOnAction(serifHandler);
            AnchorPane.setTopAnchor(serif, 475.00);
            AnchorPane.setLeftAnchor(serif,130.00);
            layoutGame.getChildren().add(serif);
        } else {
            nameTag(nameMainPlayer + " : " + rol.getNume(), 480.00, 200.00);
        }

        //se initializeaza lista cu cartile pe care le are jucatorul
        List<Card> hand = new ArrayList<>();
        List<Card> blue = new ArrayList<>();
        int k = viata;
        for(int i = 0; i<pachet.pachet.size() && k!=0; i++) {
            if (pachet.pachet.get(i).getUser() == 0) {
                hand.add(pachet.pachet.get(i));
                pachet.pachet.get(i).setUser(-1);
                System.out.println(pachet.pachet.get(i));
                k--;
            }
        }
        //se creaza un obiect de tip player care retine toate detele despre acesta si se adauga in lista cu toti jucatorii pentru jocul actual
        Player jucator = new Player(nameMainPlayer, viata, viata, viata, rol, persj, blue, hand);
        players.add(jucator);
        updateMainGUI();
        System.out.println("");
    }

    //initializeaza datele despre boti
    private void initBot (RoleSet rolList, CharacterSet caractere, double coordX, double coordY, int idBot) {
        /* se creaza detaliile jucatorului care a initiat jocul */
        int viata = 0;
        /* generare caracter */
        Character persj = caractere.set.get(idBot);
        //afisare cartea cu personajul
        String path = "/characters/" + persj.getNume() + ".png";
        Button pers = new Button();
        pers.setStyle("-fx-pref-height: 80px;" + "-fx-pref-width: 50px;" + "-fx-background-image: url(" + path + ");" + "-fx-background-size: 50px 80px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
        if(idBot==1) {
            pers.setOnAction(pers1Handler);
        } else if (idBot==2) {
            pers.setOnAction(pers2Handler);
        } else if (idBot==3) {
            pers.setOnAction(pers3Handler);
        } else if (idBot==4) {
            pers.setOnAction(pers4Handler);
        }else if (idBot==5) {
            pers.setOnAction(pers5Handler);
        } else {
            pers.setOnAction(pers6Handler);
        }
        AnchorPane.setTopAnchor(pers, coordY);
        AnchorPane.setLeftAnchor(pers,coordX);
        layoutGame.getChildren().add(pers);

        /* user codes: 0 - no one // -1 - player that created the game // 1 - bot 1 // 2 - bot 2 // 3 - bot 3 ...*/
        persj.setUser(idBot);
        viata = persj.getLifePoints();

        /* generare rol */
        Role rol = rolList.roluri.get(idBot);
        rolList.roluri.get(idBot).setUser(idBot);
        System.out.println(rol);
        if (rol.getNume() == "Sheriff") {
            viata += 1;
            Button serif = new Button();
            serif.setStyle("-fx-pref-height: 50px;" + "-fx-pref-width: 50px;" + "-fx-background-image: url('/roles/sheriff.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 50px 50px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            serif.setOnAction(serifHandler);
            AnchorPane.setTopAnchor(serif, (double)(coordY-35));
            AnchorPane.setLeftAnchor(serif,(double)(coordX-50));
            layoutGame.getChildren().add(serif);
        }

        List<Card> blue = new ArrayList<>();
        List<Card> hand = new ArrayList<>();
        int k = viata;
        for(int i = 0; i<pachet.pachet.size() && k!=0; i++) {
            if (pachet.pachet.get(i).getUser() == 0) {
                hand.add(pachet.pachet.get(i));
                pachet.pachet.get(i).setUser(-1);
                System.out.println(pachet.pachet.get(i));
                k--;
            }
        }
        //String name, int life, int maxLife, Role role, Character character, List<Card> hand
        Player jucator = new Player(nameMainPlayer, viata, viata, viata, rol, persj, blue, hand);
        players.add(jucator);
        updateBotGUI((int)coordX+80, (int)coordY-45, idBot);
        System.out.println("");
    }

    //functia ajutatoare pentru a updata constant datele afisate despre boti (viata si numarul de carti pe care le are in mana)
    private void updateBotGUI (int coordX, int coordY, int  idBot) {
        Image carti = new Image("/others/statistics.png");
        ImageView imageView = new ImageView();
        imageView.setImage(carti);
        //Setting the image view parameters
        imageView.setX(coordX);
        imageView.setY(coordY);
        imageView.setFitWidth(130);
        imageView.setPreserveRatio(true);
        layoutGame.getChildren().add(imageView);

        Label text1 = new Label(String.valueOf(players.get(idBot).getLife()));
        text1.setStyle("-fx-font: 24 Nunito;");
        AnchorPane.setTopAnchor(text1, (double)coordY+10);
        AnchorPane.setLeftAnchor(text1, (double)coordX+55);
        layoutGame.getChildren().add(text1);

        Label text2 = new Label(String.valueOf(players.get(idBot).getNoCards()));
        text2.setStyle("-fx-font: 20 Nunito;");
        AnchorPane.setTopAnchor(text2, (double)coordY);
        AnchorPane.setLeftAnchor(text2, (double)coordX+91);
        layoutGame.getChildren().add(text2);
    }

    //functie ajutatoare pentru a updata constant datele afisate despre mainPlayer (viata, numar de carti si cartile acestuia)
    private void updateMainGUI () {
        Image carti = new Image("/others/statistics.png");
        ImageView imageView = new ImageView();
        imageView.setImage(carti);
        //Setting the image view parameters
        imageView.setX(680);
        imageView.setY(440);
        imageView.setFitWidth(150);
        imageView.setPreserveRatio(true);
        layoutGame.getChildren().add(imageView);

        Label text1 = new Label(String.valueOf(players.get(0).getLife()));
        text1.setStyle("-fx-font: 24 Nunito;");
        AnchorPane.setTopAnchor(text1, 450.00);
        AnchorPane.setLeftAnchor(text1, 745.00);
        layoutGame.getChildren().add(text1);

        Label text2 = new Label(String.valueOf(players.get(0).getNoCards()));
        text2.setStyle("-fx-font: 21 Nunito;");
        AnchorPane.setTopAnchor(text2, 442.00);
        AnchorPane.setLeftAnchor(text2, 787.00);
        layoutGame.getChildren().add(text2);

        Image cardMatt = new Image("/others/cardMatt.png");
        ImageView imageView2 = new ImageView();
        imageView2.setImage(cardMatt);
        imageView2.setX(450);
        imageView2.setY(500);
        imageView2.setFitWidth(435);
        imageView2.setPreserveRatio(true);
        layoutGame.getChildren().add(imageView2);

        int realDim = 340 / players.get(0).getNoCards();
        for(int i = 0; i < players.get(0).getNoCards(); i++) {
            if(players.get(0).getNoCards() < 5) {
                String path = "cards/" + players.get(0).getHand().get(i).getName() + "-" + players.get(0).getHand().get(i).getValue() + "-" + players.get(0).getHand().get(i).getSymbol() + ".png";
                Button kard = new Button();
                kard.setStyle("-fx-pref-height: 100px;" + "-fx-pref-width: 70px;" + "-fx-background-image: url("+ path + ");" + "-fx-background-color: transparent;" + "-fx-background-size: 70px 100px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
                //kard.setOnAction(serifHandler);
                AnchorPane.setTopAnchor(kard, (double)(500));
                AnchorPane.setLeftAnchor(kard,(double)(480+i*75));
                layoutGame.getChildren().add(kard);
            } else {
                String path = "cards/" + players.get(0).getHand().get(i).getName() + "-" + players.get(0).getHand().get(i).getValue() + "-" + players.get(0).getHand().get(i).getSymbol() + ".png";
                Button kard = new Button();
                kard.setStyle("-fx-pref-height: 100px;" + "-fx-pref-width: 70px;" + "-fx-background-image: url("+ path + ");" + "-fx-background-color: transparent;" + "-fx-background-size: 70px 100px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
                //kard.setOnAction(serifHandler);
                AnchorPane.setTopAnchor(kard, (double)(500));
                AnchorPane.setLeftAnchor(kard,(double)(480+i*realDim));
                layoutGame.getChildren().add(kard);
            }
        }
    }

    //afiseaza pachetul de carti de unde vor trage jucatorii carti la inceputul fiecarei ture
    private void cardPackGUI () {
        Button pachet = new Button();
        pachet.setStyle("-fx-pref-height: 220px;" + "-fx-pref-width: 150px;" + "-fx-background-image: url('cards/backCard.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 150px 220px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
        //kard.setOnAction(serifHandler);
        AnchorPane.setTopAnchor(pachet, 200.00);
        AnchorPane.setLeftAnchor(pachet, 345.00);
        layoutGame.getChildren().add(pachet);
    }

    //folosind functiile de mai sus se creaza scena si toate datele pentru jocul in 4 jucatori (analog pentru 5,6,7)
    private void initGame4() {
        BackgroundImage myBI = new BackgroundImage(new Image("/background/table.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutGame.setBackground(new Background(myBI));

        initMatt(50, 20);
        nameTag("Bot 1", 28.00, 100.00);
        initMatt(360, 20);
        nameTag("Bot 2", 28.00, 410.00);
        initMatt(670, 20);
        nameTag( "Bot 3", 28.00, 720.00);
        initMainMatt( 150, 480);

        RoleSet rolList = new RoleSet(noPlayers);
        CharacterSet caractere = new CharacterSet();
        initMainPlayer(rolList, caractere);
        initBot(rolList, caractere, 85,65, 1);
        initBot(rolList, caractere, 395,65, 2);
        initBot(rolList, caractere, 705,65, 3);
        cardPackGUI();

        MeniuBar meniuBar = new MeniuBar(window, layoutGame);
        meniuBar.init();

        Scene scene = new Scene(layoutGame, 1000, 600);
        window.setScene(scene);
    }

    private void initGame5() {
        BackgroundImage myBI = new BackgroundImage(new Image("/background/table.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutGame.setBackground(new Background(myBI));

        MeniuBar meniuBar = new MeniuBar(window, layoutGame);
        meniuBar.init();

        initMatt2(19, 20);
        nameTag("Bot 1", 28.00, 69.00);
        initMatt2( 263, 20);
        nameTag("Bot 2", 28.00, 313.00);
        initMatt2( 507, 20);
        nameTag( "Bot 3", 28.00, 557.00);
        initMatt2( 751, 20);
        nameTag( "Bot 4", 28.00, 801.00);
        initMainMatt( 150, 480);

        RoleSet rolList = new RoleSet(noPlayers);
        CharacterSet caractere = new CharacterSet();
        initMainPlayer(rolList, caractere);
        initBot(rolList, caractere, 45,65, 1);
        initBot(rolList, caractere, 290,65, 2);
        initBot(rolList, caractere, 535,65, 3);
        initBot(rolList, caractere, 780,65, 4);
        cardPackGUI();

        Scene scene = new Scene(layoutGame, 1000, 600);
        window.setScene(scene);
    }

    private void initGame6() {

        BackgroundImage myBI = new BackgroundImage(new Image("/background/table.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutGame.setBackground(new Background(myBI));

        MeniuBar meniuBar = new MeniuBar(window, layoutGame);
        meniuBar.init();

        initMatt( 50, 20);
        nameTag("Bot 1", 28.00, 100.00);
        initMatt( 360, 20);
        nameTag("Bot 2", 28.00, 410.00);
        initMatt( 670, 20);
        nameTag( "Bot 3", 28.00, 720.00);
        initMatt(0, 165);
        nameTag( "Bot 4", 173.00, 50.00);
        initMatt(720, 165);
        nameTag("Bot 5", 173.00, 770.00);
        initMainMatt( 150, 480);

        RoleSet rolList = new RoleSet(noPlayers);
        CharacterSet caractere = new CharacterSet();
        initMainPlayer(rolList, caractere);
        initBot(rolList, caractere, 85,65, 1);
        initBot(rolList, caractere, 395,65, 2);
        initBot(rolList, caractere, 705,65, 3);
        initBot(rolList, caractere, 36,210, 4);
        initBot(rolList, caractere, 756,210, 5);
        cardPackGUI();

       // initMainPlayer(rolList);

        Scene scene = new Scene(layoutGame, 1000, 600);
        window.setScene(scene);
    }

    private void initGame7() {
        BackgroundImage myBI = new BackgroundImage(new Image("/background/table.jpg", 1000, 600, false, true),
                BackgroundRepeat.REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
        layoutGame.setBackground(new Background(myBI));

        MeniuBar meniuBar = new MeniuBar(window, layoutGame);
        meniuBar.init();

        initMatt2(19, 20);
        nameTag("Bot 1", 28.00, 69.00);
        initMatt2(263, 20);
        nameTag("Bot 2", 28.00, 313.00);
        initMatt2( 507, 20);
        nameTag( "Bot 3", 28.00, 557.00);
        initMatt2( 751, 20);
        nameTag( "Bot 4", 28.00, 801.00);
        initMatt2( 19, 160);
        nameTag( "Bot 5", 168.00, 69.00);
        initMatt2( 751, 160);
        nameTag( "Bot 6", 168.00, 801.00);
        initMainMatt(150, 480);


        RoleSet rolList = new RoleSet(noPlayers);
        CharacterSet caractere = new CharacterSet();
        initMainPlayer(rolList, caractere);
        initBot(rolList, caractere, 45,65, 1);
        initBot(rolList, caractere, 290,65, 2);
        initBot(rolList, caractere, 535,65, 3);
        initBot(rolList, caractere, 780,65, 4);
        initBot(rolList, caractere, 45,205, 5);
        initBot(rolList, caractere, 777,205, 6);
        cardPackGUI();

       // initMainPlayer(rolList);

        Scene scene = new Scene(layoutGame, 1000, 600);
        window.setScene(scene);
    }

    //handler pentru butonul de leave - paraseste jocul
    EventHandler<ActionEvent> leaveHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            layoutGame.getChildren().clear();
            MainMenuScene newGame = new MainMenuScene(layoutGame, window);
            newGame.initStart();
        }
    };

    //hanler pentru steluta de serif - afiseaza cartea cu rolul 'serif'
    EventHandler<ActionEvent> serifHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/roles/seriffCard.png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };

    //handler pentru cartile cu informatii despre caractere pentru mainPlayer (le deschide ca un pop-up pentru a fi mai vizibile informatiile) (analog pentru boti)
    EventHandler<ActionEvent> persHandler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(0).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            //buton de close pe pop-up pentru a putea inchide jucatorul aceasta fereastra cand doreste el
            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });
            layoutGame.getChildren().add(close);
        }
    };

    EventHandler<ActionEvent> pers1Handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(1).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };

    EventHandler<ActionEvent> pers2Handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(2).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };

    EventHandler<ActionEvent> pers3Handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(3).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };

    EventHandler<ActionEvent> pers4Handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(4).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };

    EventHandler<ActionEvent> pers5Handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(5).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };

    EventHandler<ActionEvent> pers6Handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            String path = "/characters/" + players.get(6).getCharacter().getNume() + ".png";
            Image image1 = new Image(path);
            ImageView imageView1 = new ImageView();
            imageView1.setImage(image1);
            //Setting the image view parameters
            imageView1.setX(375);
            imageView1.setY(100);
            imageView1.setFitWidth(250);
            imageView1.setPreserveRatio(true);
            layoutGame.getChildren().add(imageView1);

            Button close = new Button();
            close.setStyle("-fx-pref-height: 30px;" + "-fx-pref-width: 30px;" + "-fx-background-image: url('/others/close.png');" + "-fx-background-color: transparent;" + "-fx-background-size: 30px 30px;" + "-fx-background-repeat: no-repeat;" + "-fx-background-position: center;");
            AnchorPane.setTopAnchor(close, 100.00);
            AnchorPane.setLeftAnchor(close,595.00);
            close.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    layoutGame.getChildren().remove(close);
                    layoutGame.getChildren().remove(imageView1);
                }
            });

            layoutGame.getChildren().add(close);
        }
    };
}
