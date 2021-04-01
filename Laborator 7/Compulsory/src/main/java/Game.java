public class Game extends Thread{
    private Board board;
    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void runGame()
    {
        this.player1.activateTurn();
        boolean player1Turn = this.player1.isTurnActive();

        Thread player1Thread = new Thread((Runnable) this.player1);
        player1Thread.start();
        Thread player2Thread = new Thread((Runnable) this.player2);
        player2Thread.start();
    }
}
