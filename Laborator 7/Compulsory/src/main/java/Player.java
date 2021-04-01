public class Player implements Runnable{
    private int playerID;
    private String playerName;
    private int score;
    private boolean activePlayer;
    private boolean turnActive;
    private Board board;

    public Player(int playerID, String playerName, int score, boolean activePlayer, boolean turnActive) {
        this.playerID = playerID;
        this.playerName = playerName;
        this.score = score;
        this.activePlayer = activePlayer;
        this.turnActive = turnActive;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    private Board getBoard() {
        return this.board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public boolean isActivePlayer() {
        return activePlayer;
    }

    public void setActivePlayer(boolean activePlayer) {
        this.activePlayer = activePlayer;
    }

    public boolean isTurnActive() {
        return turnActive;
    }

    public void setTurnActive(boolean turnActive) {
        this.turnActive = turnActive;
    }

    public boolean activateTurn() {
        if (this.activePlayer)
            return false;
        this.activePlayer = true;
        return true;
    }

    private boolean deactivateTurn() {
        if (!this.turnActive)
            return false;
        this.turnActive = false;
        return true;
    }

    private void waitTurn() {
        while (!this.turnActive);
    }

    private int getRandomToken() {
        int tokenIndex = (int) (Math.random() * 10 + 5);
        return tokenIndex;
    }
    @Override
    public void run() {
        int tokID;
        while (this.activePlayer) {
            this.waitTurn();
            tokID = this.getRandomToken();
            this.deactivateTurn();
        }
    }
}
