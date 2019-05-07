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
	public MoveStrategy getMoveStrategy() {
		//Composition of Strategies
		MoveStrategy ms = new MoveStrategy();
		for(PieceType type : getTypes()) {
			if(type == PieceType.BISHOP) {
				ms.add(new BishopStrategy());
			}
			else if(type == PieceType.ROOK) {
				ms.add(new RookStrategy());
			}
			else if(type == PieceType.KNIGHT) {
				ms.add(new KnightStrategy());
}
		}
		return ms;
	}
	
	public boolean addType(Piece piece) {
		if(piece.getTypes()[1] == null && getTypes()[1] == null) {
			if(getTypes()[0] == piece.getTypes()[0]) {
				return false;
			}else {
				types[1] = piece.getTypes()[0];
				return true;
			}
		}
		else
			return false;
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
