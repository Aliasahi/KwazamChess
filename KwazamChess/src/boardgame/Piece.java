/*
 * Name: Nur Alia Shazwani Binti Mohd Nazri
 * ID: 1231302985
 * 
 */

package boardgame;

// Abstract base class for all game pieces.
public abstract class Piece {
    protected Position position;
    private boolean isBlue;

    public Piece(Position position, boolean isBlue) {
        this.position = position;
        this.isBlue = isBlue;
    }

    public abstract boolean canMove(Position newPosition, Board board);

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isBlue() {
        return isBlue;
    }

    @Override
    public String toString() {
        return (isBlue ? "Blue" : "Red") + " Piece at " + position;
    }

	protected abstract void updatePosition(Position to);
}
