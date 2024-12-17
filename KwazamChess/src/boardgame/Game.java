/*
 * Name: Nur Alia Shazwani Binti Mohd Nazri
 * ID: 1231302985
 * 
 */

package boardgame;

public class Game {
    public static void main(String[] args) {
        // Create a new board
        System.out.println("Creating new board...");
        Board board = new Board();

        // Create a blue Ram at position (4, 0)
        System.out.println("Placing a blue Ram at position (4, 0)...");
        Position startPosition = new Position(4, 0);
        Ram blueRam = new Ram(startPosition, true);
        board.setPiece(startPosition, blueRam);

        // Print the board
        System.out.println("\nInitial Board:");
        board.printBoard();

        // Attempt to move the Ram
        Position newPosition = new Position(3, 0);
        System.out.println("\nMoving blue Ram to position (3, 0)...");
        if (board.movePiece(startPosition, newPosition)) {
            System.out.println("Move successful!");
        } else {
            System.out.println("Move failed!");
        }

        // Print the updated board
        System.out.println("\nUpdated Board:");
        board.printBoard();
    }
}
