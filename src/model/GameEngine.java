package model;

import exceptions.Not2PlayersException;

/*
 * 0 = white
 * 1 = black
 */
public class GameEngine
{
	private Board board;
	private Player[] players;
	private int playersLength;
	private GameState gs;
	
	public GameEngine(){
		players = new Player[2];
		playersLength = 0;
		board = new Board();
	}
	
	public void createGame(int turnCount) throws Exception {
		if(playersLength != 2) {throw new Not2PlayersException();}
		gs = new GameState(turnCount);
	}
	public Board getBoard() {
		return board;
	}
	public Player[] getPlayers() {
		return players;
	}
	public int getAmountOfPlayers() {
		return playersLength;
	}
	public void createPlayer(Player newPlayer) throws Exception {
		if(playersLength > 1) 
			throw new Exception();
		for(Player player : players) {
			if(player != null) {
				if(player.getName().equals(newPlayer.getName())) {
					throw new Exception();
				}
			}
		}
		players[playersLength] = newPlayer; 
		playersLength++;
	}
	public Player getCurrentPlayer()
	{
		return players[gs.getTurnColour().ordinal()];
	}
	public Player getWinningPlayer()
	{
		if(players[0].getScore() > players[1].getScore())
		{
			return players[0];
		}
		else if(players[1].getScore() > players[0].getScore())
		{
			return players[1];
		}
		else {
			return null;
		}
	}

	public GameState getGameState()
	{
		return gs;
	}
	
}
