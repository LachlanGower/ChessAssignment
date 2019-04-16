package testCases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import model.Piece;

public class PieceTest
{
	Piece[] pieces = new Piece[12];
	@Before
	public void setUp() throws Exception
	{
		pieces[0] = new Piece(Piece.BLACK, Piece.BISHOP);
		pieces[1] = new Piece(Piece.BLACK, Piece.ROOK);
		pieces[2] = new Piece(Piece.BLACK, Piece.KNIGHT);
		pieces[3] = new Piece(Piece.WHITE, Piece.BISHOP);
		pieces[4] = new Piece(Piece.WHITE, Piece.ROOK);
		pieces[5] = new Piece(Piece.WHITE, Piece.KNIGHT);
	}

	@Test
	public void ColourTest()
	{
		assert(pieces[0].getColour() == Piece.BLACK);
		assert(pieces[1].getColour() == Piece.BLACK);
		assert(pieces[2].getColour() == Piece.BLACK);
		assert(pieces[3].getColour() == Piece.WHITE);
		assert(pieces[4].getColour() == Piece.WHITE);
		assert(pieces[5].getColour() == Piece.WHITE);
	}

}
