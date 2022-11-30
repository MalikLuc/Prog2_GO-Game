package GoGame;

/**
 * @author:  <Yannick Kandulski, Yannik Zander, Can Wrobel>
 * The GoInterface class is the interface for the Go game.
 */
public interface GoInterface {

    /**
     * @param stone the stone to be placed, can be black or white
     * @param position the position on the board in (x,y) coordinates
     * @return true if the game is won
     * @throws PositionOutOfBoundsExeption if the position is outside the board
     * @throws GameStateException if the game is not in a state where a stone can be placed
     * @throws PositionNotEmptyException if the position is not empty
     */
    boolean set(Stone stone, Position position) throws PositionNotEmptyException, PositionOutOfBoundsExeption, GameStateException;

    /**
     *
     * @return returns the current GameBoard
     * @throws GameStateException if the game is not in a state where a board has been created
     */
    GameBoard getBoard() throws GameStateException;

    /**
     * @return the current status of the game
     */
    Status getStatus();

    /**
     * @return the current status of the game
     * @param status
     */
    void setStatus(Status status);

    /**
     * @return if active - can set a piece, false otherwise
     */
    boolean isActive(); //throws StatusException{};

    /**
     * @return true if won, false otherwise
     */
    boolean hasWon();

    /**
     * @return true if lost, false otherwise
     */
    boolean hasLost();

    /**
     * @return the current player
     */
    Player getPlayer();

    /**
     * @param player
     * @throws GameStateException the state is PREGAME and "WHITE" is passed as player
     * or the state is not CONNECTED and "BLACK" is passed as player
     */
    void setPlayer(Player player) throws GameStateException;

    /**
     * set black stone as Player and set status to PREGAME
     * @throws GameStateException
     */
    public void initializeGame() throws GameStateException;

}
