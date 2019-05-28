package view;

import java.io.File;

import model.ChessColour;
import model.PieceType;

public class PieceFactory
{
	public static String getPiece(String pieceString) {
		String url = String.format("%schs_pieces%s%s.png",File.separator,File.separator,pieceString);
		return url;
	}
}
