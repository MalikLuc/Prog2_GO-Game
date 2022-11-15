import org.junit.jupiter.api.Test;

// test class for the go game

public class ExampleGames {

    @Test
    public set() {
        // TODO implement here
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

    /** Bad Test 4 - Set stone out of bounds
     * 1. PL1 chooses Black
     * 2. PL2 chooses White
     * 3. Set stone on specific out of bounds position
     * expected result: GameException thrown
     */

    /** Bad Test 5-8 - Set stones at 4 outer corners of gameboard
     *
     */

    /** Bad Test 9 - Set stone BEFORE players chose colours
     * expected result: StatusException thrown
     */

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

}
