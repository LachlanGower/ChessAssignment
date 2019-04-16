package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import model.GameEngine;
import model.Player;

class GameEngineTest {

	GameEngine gameEngine;
	
	@Test
	void test() {
		gameEngine.players[0] = new Player("player", "abcxyz");
		gameEngine.players[1] = new Player("player", "abcxyz");
		Assert.assertNotEquals(gameEngine.players[0].getName(), gameEngine.players[1].getName());
	}

}
