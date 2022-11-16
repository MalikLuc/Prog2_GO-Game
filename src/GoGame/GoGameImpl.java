package GoGame;

public class GoGameImpl implements GoInterface{

    private boolean isInitialized;

    public GoGameImpl() {
        this.isInitialized = false;
    }

    private void initializeGame(){
        this.isInitialized = true;
    }

    public boolean isInitialized(){
        return isInitialized;
    }

    @Override
    public boolean set(Stone stone, Position position) throws PositionNotEmptyException, PositionOutOfBoundsExeption, GameStateException {
        return false;
    }

    @Override
    public GameBoard getBoard() throws GameStateException {
        return null;
    }

    @Override
    public Status getStatus() throws GameStateException {
        return null;
    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public boolean hasWon() {
        return false;
    }

    @Override
    public boolean hasLost() {
        return false;
    }
}
