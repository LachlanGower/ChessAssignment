package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import exceptions.Not2PlayersException;

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
	public void registerPlayer(String name, String pass) throws Exception {
		if(playersLength > 1) 
			throw new Exception("Maximum amount of players added");
		ArrayList<Player> registeredPlayers = checkLogin();
		boolean newPlayer = true;

		for(Player player : registeredPlayers) {
			if(player.getName().equals(name)) {
				newPlayer = false;
				if(player.getPassword().equals(pass)) {
					players[playersLength] = new Player(name, pass, ChessColour.values()[playersLength]);
					playersLength++;
				}
				else {
					throw new Exception("User Exists but Password is Wrong");
				}
			}
		}
		if(newPlayer) {
			FileWriter pw = new FileWriter(new File("userSheet.txt"), true);
			players[playersLength] = new Player(name, pass, ChessColour.values()[playersLength]);
			pw.write(players[playersLength].getName() + "," + players[playersLength].getPassword() + '\n' );
			pw.close();
			playersLength++;
		}
	}
	private ArrayList<Player> checkLogin()
	{
		ArrayList<Player> players = new ArrayList<Player>();
		try
		{
			File file = new File("userSheet.txt");
			Scanner scan = new Scanner(file);
			while(scan.hasNextLine()) {
				String line = scan.nextLine();
				String user =line.split(",")[0];
				String pass = line.split(",")[1];
				players.add(new Player(user, pass, null));
			}
			
			scan.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return players;
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

	public void removePlayer(String username)
	{
		for(int i = 0; i < playersLength;i++) {
			if(players[i].getName().equals(username)) {
				if(i == 1) {
					playersLength--;
					players[i] = null;
					i = playersLength;
				}
				if(i == 0) {
					if(playersLength == 2) {
						players[i] = players[i+1];
						if(players[i] != null) {
							players[i].setColour(ChessColour.WHITE);
						}
						players[i+1] = null;
						playersLength--;
						i = playersLength;
					}
					else {
						players[i] = null;
						playersLength--;
						i = playersLength;
					}
				}
				
			}
		}
	}
}
