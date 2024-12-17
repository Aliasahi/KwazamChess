package boardgame;

/*
 * Name: Nur Alia Shazwani Binti Mohd Nazri
 * ID: 1231302985
 * 
 */

// Main board class for a 5x8 chess-like game
public class Board {
    // 2D array representing the board
    private Piece[][] squares;

    // Constants for board dimensions
    private static final int ROWS = 5;
    private static final int COLS = 8;

    // Constructor to initialize the board
    public Board() {
        squares = new Piece[ROWS][COLS];
        makeEmptyBoard();
    }

    // Fill the board with empty (null) squares
    private void makeEmptyBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                squares[row][col] = null;
            }
        }
    }

    // Check if a position is within the board limits
    public boolean isValidPosition(Position position) {
        return position.getRow() >= 0 && position.getRow() < ROWS &&
               position.getCol() >= 0 && position.getCol() < COLS;
    }

    // Check if a position is occupied by a piece
    public boolean isOccupied(Position position) {
        if (!isValidPosition(position)) return false;
        return squares[position.getRow()][position.getCol()] != null;
    }

    // Get the piece at a specific position
    public Piece getPiece(Position position) {
        if (!isValidPosition(position)) return null;
        return squares[position.getRow()][position.getCol()];
    }

    // Place a piece at a specific position
    public void setPiece(Position position, Piece piece) {
        if (!isValidPosition(position)) return;
        squares[position.getRow()][position.getCol()] = piece;
    }

    // Move a piece from one position to another
    public boolean movePiece(Position from, Position to) {
        if (!isValidPosition(from) || !isValidPosition(to)) return false;

        Piece piece = getPiece(from);
        if (piece == null) return false; // No piece at the 'from' position

        // Check if the piece can legally move to the target position
        if (piece.canMove(to, this)) {
            setPiece(to, piece);         // Place the piece at the new position
            setPiece(from, null);        // Clear the old position
            piece.updatePosition(to);    // Update the piece's internal position
            return true;
        }
        return false; // Invalid move
    }

    // Check if a position has a piece (existing method with minor adjustments)
    public boolean hasAPiece(Position position) {
        return isOccupied(position); // Uses isOccupied for clarity
    }
    
    public boolean tryToMove(Position from, Position to) {
        Piece piece = getPiece(from);

        if (piece != null && piece.canMove(to, this)) {
            // Check if there's a piece at the destination
            if (hasAPiece(to)) {
                Piece target = getPiece(to);
                if (target.isBlue() != piece.isBlue()) {
                    System.out.println("Captured " + target + " at " + to);
                } else {
                    return false; // Can't move onto a friendly piece
                }
            }
            // Move the piece
            squares[to.getRow()][to.getCol()] = piece;
            squares[from.getRow()][from.getCol()] = null;
            piece.updatePosition(to);
            return true;
        }
        return false;
    }


    // Utility to print the current state of the board (for debugging)
    public void printBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (squares[row][col] != null) {
                    System.out.print(squares[row][col] + " ");
                } else {
                    System.out.print(". "); // Empty square
                }
            }
            System.out.println();
        }
    }

    // Get the number of rows
    public int getRows() {
        return ROWS;
    }

    // Get the number of columns
    public int getCols() {
        return COLS;
    }

    // Get the entire board array
    public Piece[][] getBoard() {
        return squares;
    }
}
