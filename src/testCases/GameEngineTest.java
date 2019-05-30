package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.ChessColour;
import model.Coord;
import model.GameEngine;
import exceptions.CoordinateOutOfBoundsException;
import exceptions.IllegalMoveException;
import exceptions.Not2PlayersException;
import exceptions.PieceNullPointerException;
import model.Player;

public class GameEngineTest {
	// Try to create player 1 and player 2, if unsuccesful catches the exception.
	@Test
	public void testAmountPlayers() {
		GameEngine ge = new GameEngine();
		try {
			ge.registerPlayer("Test","Test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " error creating player.");
		}
		try {
			ge.registerPlayer("Test2","Test2");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " error creating player.");
		}
		assertEquals(ge.getAmountOfPlayers(), 2);
	}
	
	@Test(expected = Not2PlayersException.class)
	// Makes sure there can't be more than two players, in this case will throw exception as
	// there are '10' players.
	public void testCorrectPlayerNumber() throws Exception{
		GameEngine ge = new GameEngine();
		ge.createGame(10);
	}
	
	@Test(expected = Exception.class)
	// If there are too many players, catch the exception.
	public void testTooManyPlayers() throws Exception {
		GameEngine ge = new GameEngine();
		ge.registerPlayer("Test","Test");
		ge.registerPlayer("Test2", "Test2");
		ge.registerPlayer("Test3", "Test3");
	}
	
	@Test
	// Tests whether score is added for taking a normal piece, if not throws exception.
	public void testScoreCorrect() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException {
		GameEngine ge = new GameEngine();
		ge.getBoard().movePiece(new Coord(0,5), new Coord(0,3), ChessColour.WHITE);
		ge.getBoard().movePiece(new Coord(0,0), new Coord(0,2), ChessColour.BLACK);
		assertEquals(ge.getBoard().movePiece(new Coord(0,3), new Coord(0,2), ChessColour.WHITE), 5);
	}
	
	// Tests whether score is added for taking a merged piece, if not throws exception.
	@Test
	public void testScoreCorrect2() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException {
		GameEngine ge = new GameEngine();
		ge.getBoard().movePiece(new Coord(0,5), new Coord(0,3), ChessColour.WHITE);
		ge.getBoard().movePiece(new Coord(1,5), new Coord(0,3), ChessColour.WHITE);
		ge.getBoard().movePiece(new Coord(0,0), new Coord(0,2), ChessColour.BLACK);
		assertEquals(ge.getBoard().movePiece(new Coord(0,2), new Coord(0,3), ChessColour.BLACK), 10);
	}

}
