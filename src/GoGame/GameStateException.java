package GoGame;

public class GameStateException extends Exception {
    public GameStateException() { super(); }
    public GameStateException(String message) { super(message); }
    public GameStateException(String message, Throwable t) { super(message, t); }
}
