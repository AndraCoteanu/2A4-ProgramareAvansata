public class Token {
    public int x;
    public int y;
    public int cost;

    public Token(int x, int y, int cost) {
        this.x = x;
        this.y = y;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Token{" +
                "x=" + x +
                ", y=" + y +
                ", cost=" + cost +
                '}';
    }
}
