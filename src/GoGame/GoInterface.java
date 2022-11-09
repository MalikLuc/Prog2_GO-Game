package GoGame;

/**
 * The GoInterface class is the interface for the Go game.
 */
public interface GoInterface {

    /**
     * @param stone the stone to be placed, can be black or white
     * @param position the position on the board in (x,y) coordinates
     * @return true if the operation was successful
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
     *
     * @return game status
     * @throws GameStateException if the game is not in a state where a board has been created
     */
    Status getStatus() throws GameStateException;

    /**
     * @return if active - can set a piece, false otherwise
     */
    boolean isActive();

    /**
     * @return true if won, false otherwise
     */
    boolean hasWon();

    /**
     * @return true if lost, false otherwise
     */
    boolean hasLost();
}
