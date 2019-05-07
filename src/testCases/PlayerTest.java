package testCases;

import static org.junit.Assert.*;

import org.junit.Test;

import model.Player;
import model.ChessColour;

public class PlayerTest {

	@Test
	public void testAddScore() {
		Player player = new Player("Test", "Test", ChessColour.WHITE);
		assertEquals(player.getScore(), 0);
		player.addScore(1);
		assertEquals(player.getScore(), 1);
	}

	public void setPlayerName() {
		Player player = new Player("Test", "Test", ChessColour.WHITE);
		assertEquals(player.getName(), "Test");
	}
}
