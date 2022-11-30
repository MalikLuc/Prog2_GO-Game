package GoGame;

public class GoGameImpl implements GoInterface{

    private Status status;
    private Player player;

    public GoGameImpl() throws GameStateException {
        initializeGame();
    }

    public void initializeGame() throws GameStateException {
        setStatus(Status.PREGAME);
        setPlayer(Player.BLACK);
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
    public Status getStatus(){
        return null;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    @Override
    public Player getPlayer() {
        return player;
    }

    @Override
    public void setPlayer(Player player) throws GameStateException {

    }


}
