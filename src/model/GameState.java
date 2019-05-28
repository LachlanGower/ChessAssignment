package model;

public class GameState
{
	private int turnCount;
	private ChessColour turn;
	private Coord selectedPiece;
	
	public GameState(int turnCount)
	{
		this.turnCount = turnCount;
		this.turn = ChessColour.WHITE;
		selectedPiece = null;
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
	public void nextTurn() {
		selectedPiece = null;
		if(turn == ChessColour.BLACK){
			turn = ChessColour.WHITE;
		}
		else if(turn == ChessColour.WHITE){
			turn = ChessColour.BLACK;
		}
		turnCount--;
	}


}
