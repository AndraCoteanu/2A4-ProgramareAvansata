import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterSet {
    public List<Character> set= new ArrayList<>();

    public CharacterSet() {
        //adaug caracterele disponibile in lista
        Character c0 = new Character(0, 4, "bart-cassidy");
        Character c1 = new Character(1, 4, "black-jack");
        Character c2 = new Character(2, 4, "calamity-janet");
        Character c3 = new Character(3, 3, "el-gringo");
        Character c4 = new Character(4, 4, "jesse-jones");
        Character c5 = new Character(5, 4, "jourdonnais");
        Character c6 = new Character(6, 4, "kit-carlson");
        Character c7 = new Character(7, 4, "lucky-duke");
        Character c8 = new Character(8, 3, "paul-regret");
        Character c9 = new Character(9, 4, "pedro-ramirez");
        Character c10 = new Character(10, 4, "rose-doolan");
        Character c11 = new Character(11, 4, "sid-ketchum");
        Character c12 = new Character(12, 4, "slab-the-killer");
        Character c13 = new Character(13, 4, "suzy-lafayette");
        Character c14 = new Character(14, 4, "vulture-sam");
        Character c15 = new Character(15, 4, "willy-the-kid");

        set.add(c0);
        set.add(c1);
        set.add(c2);
        set.add(c3);
        set.add(c4);
        set.add(c5);
        set.add(c6);
        set.add(c7);
        set.add(c8);
        set.add(c9);
        set.add(c10);
        set.add(c11);
        set.add(c12);
        set.add(c13);
        set.add(c14);
        set.add(c15);

        //amestec elementele in lista pentru a simula cat mai exact un scenariu real de a impartire a rolurilor pentru acest boardgame
        Collections.shuffle(set);
    }

//    public int chooseCharacter () {
//        int persona = (int) (Math.random() * 15) + 0;
//        while(set.get(persona).getUser() != 0) {
//            persona = (int) (Math.random() * 15) + 0;
//        }
//        return persona;
//    }

}
