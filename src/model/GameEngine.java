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
	private ChessColour turn;
	private Coord selectedPiece;
	
	public GameEngine(){
		players = new Player[2];
		playersLength = 0;
		board = new Board();
	}
	
	public void createGame(int turnCount) throws Exception {
		if(playersLength != 2) {throw new Not2PlayersException();}
		this.turnCount = turnCount;
		turn = ChessColour.WHITE;
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
		if(turn == ChessColour.BLACK){
			turn = ChessColour.WHITE;
		}
		else if(turn == ChessColour.WHITE){
			turn = ChessColour.BLACK;
		}
		turnCount--;
		return players[turn.ordinal()];
	}

	public int getTurnsRemaining()
	{
		return turnCount;
	}

	public ChessColour getTurnColour()
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

	public String winningPlayer()
	{
		
		if(getPlayers()[0].getScore() > getPlayers()[1].getScore()) {
			return getPlayers()[0].getName() + " has Won!";
		}
		else if(getPlayers()[1].getScore() > getPlayers()[0].getScore()) {
			return getPlayers()[1].getName() + " has Won!";
		}
		else if(getPlayers()[0].getScore() == getPlayers()[1].getScore()) {
			return "Draw";
		}
		return "You've managed to break our game. Good job.";
	}
}
