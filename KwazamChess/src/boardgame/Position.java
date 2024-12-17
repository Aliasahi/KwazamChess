/*
 * Name: Nur Alia Shazwani Binti Mohd Nazri
 * ID: 1231302985
 * 
 */

package boardgame;

//Represents a position on the board.
public class Position {

	    private int row;
	    private int col;

	    public Position(int row, int col) {
	        this.row = row;
	        this.col = col;
	    }

	    public int getRow() {
	        return row;
	    }

	    public int getCol() {
	        return col;
	    }

	    @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null || getClass() != obj.getClass()) return false;
	        Position other = (Position) obj;
	        return row == other.row && col == other.col;
	    }

	    @Override
	    public String toString() {
	        return "(" + row + "," + col + ")";
	    }
	}
