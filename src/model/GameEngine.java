package model;
/*
 * 0 = white
 * 1 = black
 */
public class GameEngine
{
	private Board board;
	private Player[] players;
	private int playersLength;
	private int turnCount = 0;
	private int turn;
	private Coord selectedPiece;
	
	public GameEngine(){
		players = new Player[2];
		playersLength = 0;
		board = new Board();
	}
	
	public void createGame(int turnCount) throws Exception {
		if(playersLength != 2) {throw new Not2PlayersException();}
		this.turnCount = turnCount;
		turn = -1;
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

	public Player nextTurn()
	{
		turn = (turn + 1) % 2;
		turnCount--;
		return players[turn];
	}

	public int getTurnsRemaining()
	{
		return turnCount;
	}

	public int getTurnColour()
	{
		return turn;
	}

	public Coord getSelectedPiece()
	{
		return selectedPiece;
	}
	public void setSelectedPiece(Coord newXY)
	{
		selectedPiece = newXY;
	}

	public String endgame()
	{
		if(player)
		return null;
	}
}
