package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.ChessColour;
import model.GameEngine;
import model.Not2PlayersException;
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
	

}
