/*
 * Name: Nur Alia Shazwani Binti Mohd Nazri
 * ID: 1231302985
 * 
 */

package boardgame;

public class Ram extends Piece {
    private boolean movingForward;

    public Ram(Position position, boolean isBlue) {
        super(position, isBlue);
        this.movingForward = isBlue; // Blue moves up, Red moves down initially
    }

    @Override
    public boolean canMove(Position newPosition, Board board) {
        if (!board.isValidPosition(newPosition)) return false;
        
        // Check if the destination is occupied
        Piece targetPiece = board.getPiece(newPosition);
        if (targetPiece != null) {
            // Block moving to a friendly piece
            if (targetPiece.isBlue() == this.isBlue()) {
                return false; // Can't move onto a friendly piece
            }
            // Allow capturing an enemy piece
        }

        int currentRow = position.getRow();
        int currentCol = position.getCol();
        int newRow = newPosition.getRow();
        int newCol = newPosition.getCol();

        // Movement logic for Ram: one step forward in the same column
        int direction = movingForward ? -1 : 1; // Up (-1) or down (+1)

        if (newCol != currentCol || newRow != currentRow + direction) {
            return false;
        }

        // Check for board edge and turn around
        if (movingForward && newRow == 0) {
            movingForward = false;
        } else if (!movingForward && newRow == board.getRows() - 1) {
            movingForward = true;
        }

        return true;
    }

    @Override
    public String toString() {
        return isBlue() ? "B_RAM" : "R_RAM";
    }

	@Override
	protected void updatePosition(Position to) {
		// TODO Auto-generated method stub
		
	}
}
