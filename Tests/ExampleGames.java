import GoGame.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// @author:  <Yannick Kandulski, Yannik Zander, Can Wrobel>
// test class for the go game

public class ExampleGames {


    private GoInterface getGoGameImpl() throws GameStateException {
        GoInterface goGame = new GoGameImpl();
        // TODO initialize the game
        goGame.setStatus(Status.x_TURN);
        return goGame;
    }


    /** Bad Test 1 - Set stone on board
     * 1. Set stone on specific position on board when the game has not been initialized
     * 2. method 'set' returns false, since method checks as boolean
     * if move OKAY or if move wins the game
     */
    @Test
    public void set() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException { // TODO, whats the point?
        GoInterface goGame = new GoGameImpl();
        Assertions.assertThrows(GameStateException.class, () -> goGame.set(Stone.x, new Position(1, 1)));
    }

    /** Bad Test 2 - Set stone out of bounds
     * 1. Set stone on specific out-of-bounds position
     * expected result: GameException thrown
     */
    @Test
    public void setOutOfBounds() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        Assertions.assertThrows(PositionOutOfBoundsExeption.class, () -> goGame.set(Stone.x, new Position(-1, -1)));
    }

    /** Bad Test 3 - Set stone out of bounds
     * 1. Set stone on specific out-of-bounds position
     * expected result: GameException thrown
     */
    @Test
    public void setOnNotEmpty() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        goGame.set(Stone.x, new Position(1, 1));
        Assertions.assertThrows(PositionNotEmptyException.class, () -> goGame.set(Stone.x, new Position(1, 1)));
    }

    /**
     * Bad Test 4 - Get board when game has not been initialized
     * @throws GameStateException
     */
    @Test
    public void getBoardBeforeGame() throws GameStateException {
        GoInterface goGame = new GoGameImpl();
        Assertions.assertThrows(GameStateException.class, () -> goGame.getBoard());
    }

    /**
     * Bad Test 5 -
     * @throws GameStateException the state is PREGAME and "WHITE" is passed as player
     */
    @Test
    public void setPlayer() throws GameStateException {
        GoInterface goGame = new GoGameImpl();
        goGame.setStatus(Status.PREGAME);
        Assertions.assertThrows(GameStateException.class, () -> goGame.setPlayer(Player.WHITE));
    }

    /**
     * Bad Test 6 -
     * @throws GameStateException the state is CONNECTED and "BLACK" is passed as player
     */
    @Test
    public void setPlayer2() throws GameStateException {
        GoInterface goGame = new GoGameImpl();
        goGame.setStatus(Status.CONNECTED);
        Assertions.assertThrows(GameStateException.class, () -> goGame.setPlayer(Player.BLACK));
    }

    /**
     * Good Test 7 - Check the corners of the board
     * 1. Set stone in the top left corner
     * 2. Set stone in the top right corner
     * 3. Set stone in the bottom left corner
     * 4. Set stone in the bottom right corner
     */
    @Test
    public void setCorner() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 0)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 18)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(18, 0)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(18, 18)));
    }

    /**
     * Good Test 8 - check if the return is true when five stones are set in a row
     */
    @Test
    public void setFiveInRow() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 0)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 1)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 2)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 3)));
        Assertions.assertTrue(goGame.set(Stone.x, new Position(0, 4)));
    }

    /**
     * Good Test 9 - check that the return of has won is true when the game is over
     */
    @Test
    public void hasWon() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 0)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 1)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 2)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 3)));
        Assertions.assertTrue(goGame.set(Stone.x, new Position(0, 4)));
        Assertions.assertTrue(goGame.hasWon());
    }

    /**
     * Good Test 10 - check that the return of has won is false when the game is not over
     */
    @Test
    public void hasWon2() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 0)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 1)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 2)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 3)));
        Assertions.assertFalse(goGame.set(Stone.x, new Position(0, 4)));
        Assertions.assertFalse(goGame.hasWon());
    }

/**
     * Good Test 11 - check that the return of hasLost is true when the game has been lost
     */
    @Test
    public void hasLost() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGameBlack = getGoGameImpl();
        GoInterface goGameWhite = getGoGameImpl();
        goGameWhite.setPlayer(Player.WHITE);
        goGameBlack.setStatus(Status.x_TURN);
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 0)));
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 1)));
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 2)));
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 3)));
        Assertions.assertTrue(goGameBlack.set(Stone.x, new Position(0, 4)));
        Assertions.assertTrue(goGameWhite.hasLost());
    }

    /**
     * Good Test 12 - check that the return of hasLost is false when the game has not been lost
     */
    @Test
    public void hasLost2() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGameBlack = getGoGameImpl();
        GoInterface goGameWhite = getGoGameImpl();
        goGameWhite.setPlayer(Player.WHITE);
        goGameBlack.setStatus(Status.x_TURN);
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 0)));
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 1)));
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 2)));
        Assertions.assertFalse(goGameBlack.set(Stone.x, new Position(0, 3)));
        Assertions.assertFalse(goGameWhite.hasLost());
    }


    /** Testing a complete game round
     * 1. PL1 chooses x
     * 2. PL2 chooses o
     * 3... set stones accordingly so that PL1 wins.
     */
    @Test
    public void setCompleteGame() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoInterface goGame = getGoGameImpl();
        Assertions.assertTrue(goGame.set(Stone.x, new Position(1, 1)));
        Assertions.assertTrue(goGame.set(Stone.o, new Position(1, 2)));
        Assertions.assertTrue(goGame.set(Stone.x, new Position(2, 1)));
        Assertions.assertTrue(goGame.set(Stone.o, new Position(2, 2)));
        Assertions.assertTrue(goGame.set(Stone.x, new Position(3, 1)));
        Assertions.assertTrue(goGame.set(Stone.o, new Position(3, 3)));
        Assertions.assertTrue(goGame.set(Stone.x, new Position(4, 1)));
        Assertions.assertTrue(goGame.set(Stone.o, new Position(4, 3)));
        Assertions.assertTrue(goGame.set(Stone.x, new Position(5, 1)));
    }

}
