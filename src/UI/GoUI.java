package UI;

import GoGame.GameBoard;
import GoGame.Player;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class GoUI {
    private static final String PRINT = "print";
    private static final String EXIT = "exit";
    private static final String CONNECT = "connect";
    private static final String OPEN = "open";
    private static final String SET = "set";
    private Player player1;
    private String playerName;
    //private final TicTacToeImpl gameEngine;
    private final GameBoard gameBoard;
    private String partnerName;

    private final PrintStream outStream;
    private final BufferedReader inBufferedReader;

    public GoUI(PrintStream os, InputStream is) {
        this.inBufferedReader = new BufferedReader(new InputStreamReader(is));
        this.outStream = os;
        this.printUsage();
        this.gameBoard = new GameBoard();;
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
        b.append(".. connect as tcp client");
        b.append("\n");
        b.append(OPEN);
        b.append(".. open port become tcp server");
        b.append("\n");
        b.append(PRINT);
        b.append(".. print board");
        b.append("\n");
        b.append(SET);
        b.append(".. set a piece");
        b.append("\n");
        b.append(EXIT);
        b.append(".. exit");
        b.append("\n");

        this.outStream.println(b.toString());
    }

    public void commandLoop(){
        while (true) {
            this.outStream.print("<Enter command>: ");
            try {
                String line = inBufferedReader.readLine();
                if (line == null) {
                    break;
                }
                String[] tokens = line.split(" ");
                if (tokens.length == 0) {
                    continue;
                }
                String command = tokens[0];
                String arg1 = tokens.length > 1 ? tokens[1].trim() : null;
                switch (command) {
                    case PRINT:
                        this.outStream.println(this.gameBoard.toString());
                        break;
                    case EXIT:
                        return;
                    case CONNECT:
                        this.connect(arg1);
                        break;
                    case OPEN:
                        this.open();
                        break;
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
        int color = Integer.parseInt(tokens[2]);
        this.gameBoard.setStone(x, y, color);
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