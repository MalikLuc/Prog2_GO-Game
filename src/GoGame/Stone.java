package GoGame;

// go game stone
public class Stone {
    // the stone's x coordinate
    private int x;
    // the stone's y coordinate
    private int y;
    // the stone's color
    private int color;
    // the stone's constructor
    public Stone(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
    // returns the stone's x coordinate
    public int getX() {
        return x;
    }
    // returns the stone's y coordinate
    public int getY() {
        return y;
    }
    // returns the stone's color
    public int getColor() {
        return color;
    }
}
