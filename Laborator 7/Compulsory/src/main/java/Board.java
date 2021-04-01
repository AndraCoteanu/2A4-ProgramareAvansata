import java.util.ArrayList;
import java.util.List;

public class Board {
    List<Token> tokens = new ArrayList<>();
    int tokenNumber;

    public Board() {
        init();
        soutBoard();
    }

    private void init() {
        tokenNumber = (int) (Math.random() * 10 + 5);
        int maxNumberOfPairs = tokenNumber * (tokenNumber - 1) / 2;
        System.out.println(tokenNumber); //
        for (int i = 1; i <= maxNumberOfPairs; i++) {
            int x = (int) (Math.random() * tokenNumber + 1);
            int y = (int) (Math.random() * tokenNumber + 1);
            while (x == y) {
                y = (int) (Math.random() * tokenNumber + 1);
            }
            int cost = (int) (Math.random() * 25);
            Token tok = new Token(x, y, cost);
            tokens.add(tok);
        }
    }

    private void soutBoard() {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println(tokens.get(i));
        }
    }
}
