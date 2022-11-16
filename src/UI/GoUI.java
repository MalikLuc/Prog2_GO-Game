package UI;

import GoGame.GameBoard;
import GoGame.GoGameImpl;
import GoGame.Player;

import java.io.*;
import java.util.Random;


public class GoUI {
    private static final String PRINT = "print", PRINTSHORT = "p", PRINTDESC = ".. print board";
    private static final String EXIT = "exit", EXITSHORT = "e", EXITDESC = "... exit the game";
    private static final String CONNECT = "connect", CONNECTSHORT = "c", CONNECTDESC = "... connect as a tcp client";
    private static final String OPEN = "open", OPENSHORT = "o", OPENDESC = "... open port to become the tcp server";
    private static final String SET = "set", SETSHORT = "s", SETDESC = "... set a piece";
    private final GameBoard gameBoard;
    private final PrintStream outStream;
    private final BufferedReader inBufferedReader;

    private GoGameImpl goGameImpl;

    public GoUI(PrintStream os, InputStream is) {
        this.inBufferedReader = new BufferedReader(new InputStreamReader(is));
        this.outStream = os;
        this.printUsage();
        this.gameBoard = new GameBoard();
    }

    public static void main(String[] args) {
        // create the players
        System.out.println("Welcome to Go Multiplayer");
        GoUI goUI = new GoUI(System.out, System.in);
        // wait for user input
        goUI.commandLoop();
    }

    public void printUsage() {
        StringBuilder b = new StringBuilder();

        b.append("\n");
        b.append("valid commands:");
        b.append("\n");
        b.append(CONNECT);
        b.append(CONNECTDESC);
        b.append("\n");
        b.append(OPEN);
        b.append(OPENDESC);
        b.append("\n");
        b.append(PRINT);
        b.append(PRINTDESC);
        b.append("\n");
        b.append(SET);
        b.append(SETDESC);
        b.append("\n");
        b.append(EXIT);
        b.append(EXITDESC);
        b.append("\n");

        this.outStream.println(b);
    }
    // TODO check if game is initialized before allowing to set stones
    public void commandLoop(){
        while (true) {
            this.outStream.print("<Enter command>: ");
            try {
                String line = inBufferedReader.readLine();
                String[] tokens = line.split(" ");
                String command = tokens[0];
                String arg1 = tokens.length > 1 ? tokens[1].trim() : null;
                switch (command) {
                    case PRINTSHORT:
                    case PRINT:
                        this.outStream.println(this.gameBoard.toString());
                        break;
                    case EXITSHORT:
                    case EXIT:
                        return;
                    case CONNECTSHORT:
                    case CONNECT:
                        this.connect(arg1);
                        break;
                    case OPENSHORT:
                    case OPEN:
                        this.open();
                        break;
                    case SETSHORT:
                    case SET:
                        this.set(arg1);
                        break;
                    default:
                        this.outStream.println("\nUnknown command: " + command);
                        this.printUsage();
                        break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void set(String arguments) {
        // check if the player is initialized
        if (goGameImpl.isInitialized()){
            this.outStream.println("You need to connect or open a server first");
            return;
        }
        String errorMessage = "\nPlease enter a valid position\n";
        if (arguments == null) {
            this.outStream.println(errorMessage);
            return;
        }
        String[] tokens = arguments.split(",");
        if (tokens.length != 2) {
            this.outStream.println(errorMessage);
            return;
        }
        try{
            int x = Integer.parseInt(tokens[0]);
            int y = Integer.parseInt(tokens[1]);
            //this.gameBoard.setStone(x, y, this.player.getColor());
        } catch (NumberFormatException e){
            this.outStream.println(errorMessage);
        }

    }

    private void open() {
        // generate a port number
        int port = new Random().nextInt(7000);
        // check if valid
        if (port < 1024){
            port += 1024;
        }
        this.outStream.println("\nSuccessfully opened a game-server!\n" +
                "Your Game-Code is: " + port + "\nYour opponent can connect to you by typing: connect " + port + "\n");

    }

    private void connect(String argument) {
        if (argument == null) {
            this.outStream.println("\nPlease enter a valid game-server port!\nFormat: connect <server port>\n");
            return;
        }
            int port = Integer.parseInt(argument);
            //this.gameEngine.connect(port)   ;
            this.outStream.println("Successfully connected to game-server!\n");
    }
}
