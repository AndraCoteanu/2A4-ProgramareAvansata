public class Main extends Thread {
    public static void main(String[] args) {
        new Main().start();
    }

    @Override
    public void run() {
        Board mainBoard = new Board();
    }
}
