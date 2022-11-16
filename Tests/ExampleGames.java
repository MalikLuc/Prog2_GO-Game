import GoGame.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// test class for the go game

public class ExampleGames {


    private GoGameImpl getGoGameImpl() throws GameStateException {
        GoGameImpl goGame = new GoGameImpl();
        // TODO initialize the game
        return goGame;
    }


    /** Good Test 1 - Colour chosen & returned
     * - Player1 (PL1) chooses Black/White
     * - Black/White returned
     */

    /** Good Test 2 - PL1 & PL2 colour chosen & returned
     * 1. PL1 chooses Black
     * 2. PL2 chooses White
     * 3. expected result: return of both colours
     */

    /** Good Test 3 - PL1 & PL2 chose same colour - return of other colour to PL2
     * 1. PL1 chooses Black
     * 2. PL2 chooses Black
     * 3. PL1 gets Black returned
     * 4. PL2 gets White returned
     */

    /** Good Test 4 - The opposite from above
     * 1. PL2 chooses Black
     * 2. PL1 chooses Black
     * 3. PL2 gets Black returned
     * 4. PL1 gets White returned
     */

    /** Bad Test 1 - 3rd Players enters game
     * 1. PL1 chooses Black
     * 2. PL2 chooses White
     * 3. PL3 chooses i.e. White
     * expected result: game exception (no 3 players allowed)
     */

    /** Bad Test 2 - Player chooses colour twice
     * 1. PL1 chooses Black
     * 2. PL1 chooses White
     * 3. PL2 chooses Black
     * expected result: NO exception thrown.
     * Matter of definition if possible to alter decision
     */

    /** Bad Test 3 - Set stone on board
     * 1. PL1 chooses Black
     * 2. PL2 chooses White
     * 3. Set stone on specific position on board
     * 4. method 'set' returns false, since method checks as boolean
     * if move OKAY or if move wins the game
     */
    @Test
    public void set() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException { // TODO, whats the point?
        GoGameImpl goGame = getGoGameImpl();
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(1, 1)));
    }

    /** Bad Test 4 - Set stone out of bounds
     * 1. Set stone on specific out of bounds position
     * expected result: GameException thrown
     */
    @Test
    public void setOutOfBounds() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoGameImpl goGame = getGoGameImpl();
        Assertions.assertThrows(PositionNotEmptyException.class, () -> goGame.set(Stone.BLACK, new Position(-1, -1)));
    }

    /** Bad Test 5-8 - Set stones at 4 outer corners of gameboard
     *
     */
    @Test
    public void setCorner() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoGameImpl goGame = getGoGameImpl();
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(0, 0)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(0, 8)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(8, 0)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(8, 8)));
    }

    /** Bad Test 9 - Set stone BEFORE players chose colours
     * expected result: StatusException thrown
     */
    @Test
    public void setBeforeColourChosen() throws GameStateException {
        GoGameImpl goGame = new GoGameImpl();
        Assertions.assertThrows(GameStateException.class, () -> goGame.set(Stone.BLACK, new Position(1, 1)));
    }

    /** Bad Test 10 - Colour changed during game
     * 1. PL1 chooses Black
     * 2. PL2 chooses White
     * 3. PL1 sets stone on specific position
     * 4. PL1 chooses White
     */

    /** Testing a complete game round
     * 1. PL1 chooses Black
     * 2. PL2 chooses White
     * 3... set stones accordingly so that PL1 wins.
     */
    @Test
    public void setCompleteGame() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoGameImpl goGame = getGoGameImpl();
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(1, 1))); // TODO map out a real game (stones dont make sense)
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(1, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(2, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(2, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(3, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(3, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(4, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(4, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(5, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(5, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(6, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(6, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(7, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(7, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(8, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(8, 2)));
    }

    /** Testing the ko rule
     * 1... set stones to repeatedly beat the completing of the other eye
     */
    @Test
    public void setKoRule() throws GameStateException, PositionOutOfBoundsExeption, PositionNotEmptyException {
        GoGameImpl goGame = getGoGameImpl();
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(1, 1))); // TODO map out real ko (stones dont make sense)
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(1, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(2, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(2, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(3, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(3, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(4, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(4, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(5, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(5, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(6, 1)));
        Assertions.assertTrue(goGame.set(Stone.WHITE, new Position(6, 2)));
        Assertions.assertTrue(goGame.set(Stone.BLACK, new Position(7, 1)));
    }
}
