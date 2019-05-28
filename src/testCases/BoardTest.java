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
	// Setup for rest of the test cases.
	@Before
	public void setUp() throws Exception
	{
		board = new Board();
	}
	
	@Test(expected=PieceNullPointerException.class)
	// Tests for selecting piece.
	public void selectPieceTest() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(2,2);
		Coord newPos = new Coord(0,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	@Test(expected=CoordinateOutOfBoundsException.class)
	// Test for if the coordinate is outside the limits of the board, catches the exception.
	public void cantMovePieceOffBoardTest() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,7);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}

	// Ensures rook can't move diagonally
	@Test(expected=IllegalMoveException.class)
	public void rookMoveTest1() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(2,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	// Ensures rook can move legally vertically
	@Test
	public void rookMoveTest2() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	// Ensures rook can't jump test
	@Test(expected=IllegalMoveException.class)
	public void rookMoveTest3() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
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
	
	// Ensures bishop can move diagonally
	@Test
	public void bishopMoveTest1() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(3,0);
		Coord newPos = new Coord(5,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	// Ensures bishop can't move vertically
	@Test(expected=IllegalMoveException.class)
	public void bishopMoveTest2() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(3,0);
		Coord newPos = new Coord(3,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	// Ensures bishop can't jump test
	@Test(expected=IllegalMoveException.class)
	public void bishopMoveTest3() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(0,2);
		newPos = new Coord(0,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(0,4);
		newPos = new Coord(1,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(2,5);
		newPos = new Coord(0,3);
		board.movePiece(currentPos, newPos, ChessColour.BLACK);
	}
	
	// Ensures knight can move in an L shape
	@Test
	public void knightMoveTest1() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(1,0);
		Coord newPos = new Coord(2,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	// Ensures knight can't move horizontally
	@Test(expected=IllegalMoveException.class)
	public void knightMoveTest2() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(1,0);
		Coord newPos = new Coord(1,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
	}
	
	// Ensures knight can jump over pieces
	@Test
	public void knightMoveTest3() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException
	{
		Coord currentPos = new Coord(0,0);
		Coord newPos = new Coord(0,2);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(0,2);
		newPos = new Coord(0,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(0,4);
		newPos = new Coord(1,4);
		board.movePiece(currentPos, newPos, ChessColour.WHITE);
		currentPos = new Coord(1,5);
		newPos = new Coord(2,3);
		board.movePiece(currentPos, newPos, ChessColour.BLACK);
	}
}
