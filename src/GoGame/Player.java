package GoGame;

// player in go game
public class Player {
    // the player's color
    private int color;
    // the player's name
    private String name;
    // the player's constructor
    public Player(int color) {
        this.color = color;
    }
    // returns the player's color
    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
