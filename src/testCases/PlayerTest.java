package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.ChessColour;

public class PlayerTest {
	// Checks if player has score added.
	@Test
	public void testAddScore() {
		Player player = new Player("Test", "Test", ChessColour.WHITE);
		assertEquals(player.getScore(), 0);
		player.addScore(1);
		assertEquals(player.getScore(), 1);
	}
	// Checks if player name is correct.
	@Test
	public void setPlayerName() {
		Player player = new Player("Test", "Test", ChessColour.WHITE);
		assertEquals(player.getName(), "Test");
	}
	
//	@Test
//	public void testPlayerLogin() {
//		
//	}
}
