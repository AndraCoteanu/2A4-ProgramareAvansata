import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <h3> CardPack class </h3>
 * <p> In this class is used the Card class to initialise the pack of cards needed for the game. </p>
 */
public class CardPack {
    protected List<Card> pachet = new ArrayList<>();

    public CardPack() {
        initCards();
        suffle();
    }

    //se initializeaza pachetul principal de carti
    private void initCards() {
        /* BANG */
        Card bang1 = new Card(1, "bang","2","clubs");
        pachet.add(bang1);
        Card bang2 = new Card(2, "bang","3","clubs");
        pachet.add(bang2);
        Card bang3 = new Card(3, "bang","4","clubs");
        pachet.add(bang3);
        Card bang4 = new Card(4, "bang","5","clubs");
        pachet.add(bang4);
        Card bang5 = new Card(5, "bang","6","clubs");
        pachet.add(bang5);
        Card bang6 = new Card(6, "bang","7","clubs");
        pachet.add(bang6);
        Card bang7 = new Card(7, "bang","8","clubs");
        pachet.add(bang7);
        Card bang8 = new Card(8, "bang","9","clubs");
        pachet.add(bang8);
        Card bang9 = new Card(9, "bang","2","diamonds");
        pachet.add(bang9);
        Card bang10 = new Card(10, "bang","3","diamonds");
        pachet.add(bang10);
        Card bang11 = new Card(11, "bang","4","diamonds");
        pachet.add(bang11);
        Card bang12 = new Card(12, "bang","5","diamonds");
        pachet.add(bang12);
        Card bang13 = new Card(13, "bang","6","diamonds");
        pachet.add(bang13);
        Card bang14 = new Card(14, "bang","7","diamonds");
        pachet.add(bang14);
        Card bang15 = new Card(15, "bang","8","diamonds");
        pachet.add(bang15);
        Card bang16 = new Card(16, "bang","9","diamonds");
        pachet.add(bang16);
        Card bang17 = new Card(17, "bang","10","diamonds");
        pachet.add(bang17);
        Card bang18 = new Card(18, "bang","J","diamonds");
        pachet.add(bang18);
        Card bang19 = new Card(19, "bang","Q","diamonds");
        pachet.add(bang19);
        Card bang20 = new Card(20, "bang","K","diamonds");
        pachet.add(bang20);
        Card bang21 = new Card(21, "bang","A","diamonds");
        pachet.add(bang21);
        Card bang22 = new Card(22, "bang","Q","hearts");
        pachet.add(bang22);
        Card bang23 = new Card(23, "bang","K","hearts");
        pachet.add(bang23);
        Card bang24 = new Card(24, "bang","A","hearts");
        pachet.add(bang24);
        Card bang25 = new Card(25, "bang","A","spades");
        pachet.add(bang25);

        /* MISSED */
        Card missed1 = new Card(26, "missed", "10", "clubs");
        pachet.add(missed1);
        Card missed2 = new Card(27, "missed", "J", "clubs");
        pachet.add(missed2);
        Card missed3 = new Card(28, "missed", "Q", "clubs");
        pachet.add(missed3);
        Card missed4 = new Card(29, "missed", "K", "clubs");
        pachet.add(missed4);
        Card missed5 = new Card(30, "missed", "A", "clubs");
        pachet.add(missed5);
        Card missed6 = new Card(31, "missed", "2", "spades");
        pachet.add(missed6);
        Card missed7 = new Card(32, "missed", "3", "spades");
        pachet.add(missed7);
        Card missed8 = new Card(33, "missed", "4", "spades");
        pachet.add(missed8);
        Card missed9 = new Card(34, "missed", "5", "spades");
        pachet.add(missed9);
        Card missed10 = new Card(35, "missed", "7", "spades");
        pachet.add(missed10);

        /* ARME */
        Card gun1 = new Card(36, "volcanic", "10", "spades"); //distanta 1
        pachet.add(gun1);
        Card gun2 = new Card(37, "volcanic", "10", "clubs");
        pachet.add(gun2);
        Card gun3 = new Card(38, "schofield", "K", "spades"); //distanta 2
        pachet.add(gun3);
        Card gun4 = new Card(39, "schofield", "Q", "clubs");
        pachet.add(gun4);
        Card gun5 = new Card(40, "schofield", "J", "clubs");
        pachet.add(gun5);
        Card gun6 = new Card(41, "remington", "K", "clubs"); //distanta 3
        pachet.add(gun6);
        Card gun7 = new Card(42, "carabine", "A", "clubs"); //distanta 4
        pachet.add(gun7);
        Card gun8 = new Card(43, "winchester", "8", "spades"); //distanta 5
        pachet.add(gun8);

        /* +VIATA */
        Card life1 = new Card(44, "saloon", "5", "hearts");
        pachet.add(life1);
        Card life7 = new Card(50, "beer", "6", "hearts");
        pachet.add(life7);
        Card life2 = new Card(45, "beer", "7", "hearts");
        pachet.add(life2);
        Card life3 = new Card(46, "beer", "8", "hearts");
        pachet.add(life3);
        Card life4 = new Card(47, "beer", "9", "hearts");
        pachet.add(life4);
        Card life5 = new Card(48, "beer", "10", "hearts");
        pachet.add(life5);
        Card life6 = new Card(49, "beer", "J", "hearts");
        pachet.add(life6);

        /* +CARDS */
        Card card1 = new Card(51, "store", "9", "clubs");
        pachet.add(card1);
        Card card2 = new Card(52, "store", "Q", "spades");
        pachet.add(card2);
        Card card3 = new Card(53, "diligenza", "9", "spades"); // +2 carti
        pachet.add(card3);
        Card card4 = new Card(54,"diligenza", "9", "spades");
        pachet.add(card4);
        Card card5 = new Card(55, "wellsFargo", "3", "hearts");
        pachet.add(card5);

        /* TAKE CARD */
        Card take1 = new Card(56, "catBalou", "9", "diamonds");
        pachet.add(take1);
        Card take2 = new Card(57, "catBalou", "10", "diamonds");
        pachet.add(take2);
        Card take3 = new Card(58, "catBalou", "J", "diamonds");
        pachet.add(take3);
        Card take4 = new Card(59, "catBalou", "K", "hearts");
        pachet.add(take4);
        Card take5 = new Card(60, "panic", "8", "diamonds");
        pachet.add(take5);
        Card take6 = new Card(61, "panic", "J", "hearts");
        pachet.add(take6);
        Card take7 = new Card(62, "panic", "Q", "hearts");
        pachet.add(take7);
        Card take8 = new Card(63, "panic", "A", "hearts");
        pachet.add(take8);

        /* BLUE CARDS */
        Card blue1 = new Card(64, "dynamite", "2", "hearts");
        pachet.add(blue1);
        Card blue2 = new Card(65, "mustang", "8", "hearts");
        pachet.add(blue2);
        Card blue3 = new Card(66, "mustang", "9", "hearts");
        pachet.add(blue3);
        Card blue4 = new Card(67, "jail", "4", "hearts");
        pachet.add(blue4);
        Card blue5 = new Card(68, "jail", "10", "spades");
        pachet.add(blue5);
        Card blue6 = new Card(69, "jail", "J", "spades");
        pachet.add(blue6);
        Card blue7 = new Card(70, "barrel", "Q", "spades");
        pachet.add(blue7);
        Card blue8 = new Card(71, "barrel", "K", "spades");
        pachet.add(blue8);
        Card blue9 = new Card(72, "scope", "A", "spades");
        pachet.add(blue9);

        /* OTHERS */
        Card other1 = new Card(73, "gatling", "10", "hearts");
        pachet.add(other1);
        Card other2 = new Card(74, "duel", "8", "clubs");
        pachet.add(other2);
        Card other3 = new Card(75, "duel", "J", "spades");
        pachet.add(other3);
        Card other4 = new Card(76, "duel", "Q", "diamonds");
        pachet.add(other4);
        Card other5 = new Card(77, "indians", "K", "diamonds");
        pachet.add(other5);
        Card other6 = new Card(78, "indians", "A", "diamonds");
        pachet.add(other6);
    }

    //functie pentru suffle in care apelez de 3 ori pentru a asigura o amestecare cat mai random
    private void suffle() {
        Collections.shuffle(pachet);
        Collections.shuffle(pachet);
        Collections.shuffle(pachet);
    }
}
