package model;

public class Piece
{
	public static final int WHITE = 0;
	public static final int BLACK = 1;
	public static final int BISHOP = 0;
	public static final int KNIGHT = 1;
	public static final int ROOK = 2;
	
	private int type;
	private int colour;
	
	public Piece(int colour, int type) {
		this.colour = colour;
		this.type = type;
	}
	
	public int getColour() {
		return colour;
	}
	
	public int getType() {
		return type;
	}
	
	public String toString() {
		if(getColour() == WHITE) {
			if(getType() == BISHOP)
				return " B ";
			else if(getType() == KNIGHT)
				return " K ";
			else if(getType() == ROOK)
				return " R ";
		}
		else if(getColour() == BLACK) {
			if(getType() == BISHOP)
				return " b ";
			else if(getType() == KNIGHT)
				return " k ";
			else if(getType() == ROOK)
				return " r ";
		}
		return "   ";
	}
}
