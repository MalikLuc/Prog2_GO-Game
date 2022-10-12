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
        stones[x][y] = new Stone(x, y, color);
    }
    // prints the board
    public void printBoard() {
        // print the top row
        System.out.print("  ");
        for(int i = 0; i < size; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        // print the rest of the board
        for(int i = 0; i < size; i++) {
            System.out.print(i + " ");
            for(int j = 0; j < size; j++) {
                if(stones[i][j] == null) {
                    System.out.print(". ");
                } else {
                    System.out.print(stones[i][j].getColor() + " ");
                }
            }
            System.out.println();
        }
    }
}
