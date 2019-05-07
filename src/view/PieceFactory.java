package view;

import java.io.File;

public class PieceFactory
{
	public static String getPiece(int colour, int type) {
		String url = String.format("%schs_pieces%s%s_%s.png",File.separator,File.separator, (colour == 1)? "blk":"wht", (type == 0)? "b":(type == 1)? "h":"r");
		return url;
	}
}
