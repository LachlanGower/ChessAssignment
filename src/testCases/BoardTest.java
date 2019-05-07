package testCases;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import exceptions.CoordinateOutOfBoundsException;
import exceptions.IllegalMoveException;
import exceptions.PieceNullPointerException;
import model.Board;
import model.ChessColour;
import model.Coord;

public class BoardTest {
	
	Board board;
	
	@Before
	public void setUp() throws Exception
	{
		board = new Board();
	}

	@Test(expected=IllegalMoveException.class)
	public void RookMovesTest() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	@Test(expected=PieceNullPointerException.class)
	public void selectPieceTest() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(2,2);
		Coord newPos = new Coord(0,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	@Test(expected=CoordinateOutOfBoundsException.class)
	public void cantMovePieceOffBoardTest() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,7);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	@Test(expected=IllegalMoveException.class)
	public void cantJumpTest() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(0,2);
		newPos = new Coord(0,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(0,5);
		newPos = new Coord(0,3);
		board.movePiece(currentPos, newPos, ChessColour.BLACK);
	}

}
