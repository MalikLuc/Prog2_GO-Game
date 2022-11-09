package GoGame;

// the go game board
public class GameBoard {
    // the board's size
    private int size;
    // the board's stones
    private Stone[][] stones;
    // the board's constructor
    public GameBoard() {
        size = 9;
        stones = new Stone[size][size];
    }
    // returns the board's size
    public int getSize() {
        return size;
    }
    // returns the board's stones
    public Stone[][] getStones() {
        return stones;
    }
    // sets the board's stones
    public void setStones(Stone[][] stones) {
        this.stones = stones;
    }
    // sets the board's stone
    public void setStone(int x, int y, int color) {

    }
    // prints the board
    public void printBoard() {


    }

    @Override
    public String toString() {
        StringBuilder b = new StringBuilder();
        b.append("\n");
        b.append("  ");
        // print the top row
        for (int i = 0; i < size; i++) {
            b.append(i + " ");
        }
        b.append("\n");
        // print the rest of the board
        for (int i = 0; i < size; i++) {
            b.append(i + " ");
            for (int j = 0; j < size; j++) {
                if (stones[i][j] == null) {
                    b.append(". ");
                } else {
                    //b.append(stones[i][j].getColor() + " ");
                }
            }
            b.append("\n");
        }
        return b.toString();
    }
}
