// score of the go game
public class GameScore {
    // the score's black stones
    private int blackStones;
    // the score's white stones
    private int whiteStones;
    // the score's constructor
    public GameScore() {
        blackStones = 0;
        whiteStones = 0;
    }
    // returns the score's black stones
    public int getBlackStones() {
        return blackStones;
    }
    // returns the score's white stones
    public int getWhiteStones() {
        return whiteStones;
    }
    // sets the score's black stones
    public void setBlackStones(int blackStones) {
        this.blackStones = blackStones;
    }
    // sets the score's white stones
    public void setWhiteStones(int whiteStones) {
        this.whiteStones = whiteStones;
    }
    // adds a black stone
    public void addBlackStone() {
        blackStones++;
    }
    // adds a white stone
    public void addWhiteStone() {
        whiteStones++;
    }
    // prints the score
    public void printScore() {
        System.out.println("Black: " + blackStones);
        System.out.println("White: " + whiteStones);
    }
}
