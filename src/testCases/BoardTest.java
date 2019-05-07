package testCases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.CoordinateOutOfBoundsException;
import exceptions.IllegalMoveException;
import exceptions.PieceNullPointerException;
import model.Board;
import model.Piece;

public class BoardTest
{
	Board board;
	
	@Before
	public void setUp() throws Exception
	{
		board = new Board();
	}

	@Test
	public void RookMovesTest()
	{
		//
		/*
		try
		{
			Piece piece = board.getPiece(0, 0);
			board.movePiece(0,0,0,1,1);
			assert(board.getPiece(0, 1) == piece);
		} catch (CoordinateOutOfBoundsException | PieceNullPointerException | IllegalMoveException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

}
