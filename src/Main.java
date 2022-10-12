import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create the game board
        GameBoard board = new GameBoard();
        // create the players
        Player player1 = new Player(1);
        Player player2 = new Player(2);
        // create the scanner
        Scanner scanner = new Scanner(System.in);
        // play the game
        while(true) {
            // print the board
            board.printBoard();
            // get the player's move
            System.out.print("Player " + player1.getColor() + "'s move: ");
            String move = scanner.nextLine();
            // get the x and y coordinates
            int x = Integer.parseInt(move.substring(0, 1));
            int y = Integer.parseInt(move.substring(2, 3));
            // set the stone
            board.setStone(x, y, player1.getColor());
            // print the board
            board.printBoard();
            // get the player's move
            System.out.print("Player " + player2.getColor() + "'s move: ");
            move = scanner.nextLine();
            // get the x and y coordinates
            x = Integer.parseInt(move.substring(0, 1));
            y = Integer.parseInt(move.substring(2, 3));
            // set the stone
            board.setStone(x, y, player2.getColor());
            // initial
        }
    }
}