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

	@Test
	public void testAmountPlayers() {
		GameEngine ge = new GameEngine();
		Player player = new Player("Test", "Test", ChessColour.BLACK);
		Player player2 = new Player("Test2", "Test2", ChessColour.WHITE);
		try {
			ge.createPlayer(player);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " error creating player.");
		}
		try {
			ge.createPlayer(player2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e + " error creating player.");
		}
		assertEquals(ge.getAmountOfPlayers(), 2);
	}
	
	@Test(expected = Not2PlayersException.class)
	public void testCorrectPlayerNumber() throws Exception{
		GameEngine ge = new GameEngine();
		ge.createGame(10);
	}
	
	@Test(expected = Exception.class)
	public void testTooManyPlayers() throws Exception {
		GameEngine ge = new GameEngine();
		Player player = new Player("Test", "Test", ChessColour.BLACK);
		Player player2 = new Player("Test2", "Test2", ChessColour.WHITE);
		Player player3 = new Player("Test3", "Test3", ChessColour.WHITE);
		ge.createPlayer(player);
		ge.createPlayer(player2);
		ge.createPlayer(player3);
	}
	
	@Test
	public void testScoreCorrect() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException {
		GameEngine ge = new GameEngine();
		Player player = new Player("Test", "Test", ChessColour.WHITE);
		Player player2 = new Player("Test2", "Test2", ChessColour.BLACK);
		ge.getBoard().movePiece(new Coord(0,5), new Coord(0,3), ChessColour.WHITE);
		ge.getBoard().movePiece(new Coord(0,0), new Coord(0,2), ChessColour.BLACK);
		assertEquals(ge.getBoard().movePiece(new Coord(0,3), new Coord(0,2), ChessColour.WHITE), 5);
	}
	
	// Tests score when the piece taken is merged
	@Test
	public void testScoreCorrect2() throws IllegalMoveException, PieceNullPointerException, CoordinateOutOfBoundsException {
		GameEngine ge = new GameEngine();
		Player player = new Player("Test", "Test", ChessColour.WHITE);
		Player player2 = new Player("Test2", "Test2", ChessColour.BLACK);
		ge.getBoard().movePiece(new Coord(0,5), new Coord(0,3), ChessColour.WHITE);
		ge.getBoard().movePiece(new Coord(1,5), new Coord(0,3), ChessColour.WHITE);
		ge.getBoard().movePiece(new Coord(0,0), new Coord(0,2), ChessColour.BLACK);
		assertEquals(ge.getBoard().movePiece(new Coord(0,2), new Coord(0,3), ChessColour.BLACK), 10);
	}

}
