package UI;

import GoGame.GameBoard;
import GoGame.Player;

import java.io.*;


public class GoUI {
    private static final String PRINT = "print", PRINTSHORT = "p", PRINTDESC = ".. print board";
    private static final String EXIT = "exit", EXITSHORT = "e", EXITDESC = "... exit the game";
    private static final String CONNECT = "connect", CONNECTSHORT = "c", CONNECTDESC = "... connect as a tcp client";
    private static final String OPEN = "open", OPENSHORT = "o", OPENDESC = "... open port to become the tcp server";
    private static final String SET = "set", SETSHORT = "s", SETDESC = "... set a piece";
    private Player player1;
    private String playerName;
    //private final GO! gameEngine;
    private final GameBoard gameBoard;
    private String partnerName;

    private final PrintStream outStream;
    private final BufferedReader inBufferedReader;

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

    public void initializeGame(){

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

        this.outStream.println(b.toString());
    }
    // TODO check if game is initialized before allowing to set stones
    public void commandLoop(){
        while (true) {
            this.outStream.print("<Enter command>: ");
            try {
                String line = inBufferedReader.readLine();
                String[] tokens = line.split(" ");
                String command = tokens[0];
                String arg1 = (tokens.length == 2) ? tokens[1].trim() : null; //TODO wenn null dann passende exception werfen
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
        if (this.player1 == null){
            this.outStream.println("You need to connect to the server first");
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
        int x = Integer.parseInt(tokens[0]);
        int y = Integer.parseInt(tokens[1]);
        this.gameBoard.setStone(x, y, this.player1.getColor());
    }

    private void open() {
        int port = 7000;
        //this.gameEngine.open(port);
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
