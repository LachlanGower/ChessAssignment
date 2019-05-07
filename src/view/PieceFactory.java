package view;

import java.io.File;

import model.ChessColour;
import model.PieceType;

public class PieceFactory
{
	public static String getPiece(ChessColour chessColour, PieceType[] pieceTypes) {
		String url = String.format("%schs_pieces%s%s_%s.png",
				File.separator,
				File.separator, 
				(chessColour == ChessColour.BLACK)? "blk":"wht",
				(pieceTypes[0] == PieceType.BISHOP)? "b":(pieceTypes[0] == PieceType.KNIGHT)? "h":"r");
		return url;
	}
}
