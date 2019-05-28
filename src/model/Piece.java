package model;

public class Piece
{
	
	private PieceType baseType;
	private PieceType mergedType;
	private ChessColour colour;
	
	public Piece(ChessColour colour, PieceType type) {
		baseType = type;
		this.colour = colour;
		mergedType = null;
	}
	
	public ChessColour getColour() {
		return colour;
	}
	
	public PieceType getBaseType() {
		return baseType;
	}
	public PieceType getMergeType() {
		return mergedType;
	}
	public MoveStrategy getMoveStrategy() {
		//Composition of Strategies
		MoveStrategy ms = new MoveStrategy();
		if(baseType == PieceType.BISHOP || mergedType == PieceType.BISHOP) {
			ms.add(new BishopStrategy());
		}
		if(baseType == PieceType.ROOK || mergedType == PieceType.ROOK) {
			ms.add(new RookStrategy());
		}
		if(baseType == PieceType.KNIGHT || mergedType == PieceType.KNIGHT) {
			ms.add(new KnightStrategy());
		}
		return ms;
	}
	public int getScore() {
		int count = 1;
		if(mergedType != null) {
			count++;
		}
		return 5 * count;
	}
	public boolean mergeType(Piece piece) {
		if(piece.getMergeType() == null && mergedType == null) {
			mergedType = piece.getBaseType();
			return true;
		}
		return false;
	}
	
	/*public boolean splitType(PieceType newType) {
		
	}*/
	
	public String toString() {
		String toString = "";
		if(getColour() == ChessColour.WHITE) {
			 toString+="wht_";
		}
		else if(getColour() == ChessColour.BLACK) {
			toString+="blk_";
		}
		if(mergedType == null) {
			if(baseType == PieceType.BISHOP) {
				toString+="b";
			}
			else if(baseType == PieceType.ROOK) {
				toString+="r";
			}
			else if(baseType == PieceType.KNIGHT) {
				toString+="h";
			}
		}else {
			if((baseType == PieceType.BISHOP || mergedType == PieceType.BISHOP) && (baseType == PieceType.KNIGHT || mergedType == PieceType.KNIGHT)) {
				toString+="b_h";
			}
			else if((baseType == PieceType.ROOK || mergedType == PieceType.ROOK) && (baseType == PieceType.KNIGHT || mergedType == PieceType.KNIGHT)) {
				toString+="h_r";
			}
			else if((baseType == PieceType.BISHOP || mergedType == PieceType.BISHOP) && (baseType == PieceType.ROOK || mergedType == PieceType.ROOK)) {
				toString+="r_b";
			}
		}
		return toString;
	}
}

//
