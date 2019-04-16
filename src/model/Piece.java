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
	
	public Piece(int type, int colour) {
		this.type = type;
		this.colour = colour;
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
			if(getType() == KNIGHT)
				return " K ";
			if(getType() == ROOK)
				return " R ";
		}
		if(getColour() == BLACK) {
			if(getType() == BISHOP)
				return " b ";
			if(getType() == KNIGHT)
				return " k ";
			if(getType() == ROOK)
				return " r ";
		}
		return "   ";
	}
}
