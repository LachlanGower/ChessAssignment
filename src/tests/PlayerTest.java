package tests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import model.Player;

public class PlayerTest {
	
	Player player = new Player("player", "abcxyz");
	
	@Test
	public void testName() {
		Assert.assertEquals(player.getName(), "player");
	}
	
	@Test
	public void testPassword() {
		Assert.assertEquals(player.getPassword(), "abcxyz");
	} 
	
	@Test
	public void differentName() {
//		Player players[] = new Player[2];
//		players[0] = new Player("player", "abcxyz");
//		players[1] = new Player("player")
	}

}
