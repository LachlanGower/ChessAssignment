package model;

public class Piece
{
	
	private PieceType[] types;
	private ChessColour colour;
	
	public Piece(ChessColour colour, PieceType type) {
		types = new PieceType[2];
		this.colour = colour;
		this.types[0] = type;
	}
	
	public ChessColour getColour() {
		return colour;
	}
	
	public PieceType[] getTypes() {
		return types;
	}
	
	public String toString() {
		
		if(getColour() == ChessColour.WHITE) {
			 
		}
		else if(getColour() == ChessColour.BLACK) {
			
		}
		return "   ";
	}
}

//
