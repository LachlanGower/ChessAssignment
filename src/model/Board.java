package model;

public class Board
{
	private final int ROWS = 6;
	private final int COLS = 6;
	private Piece[][] board;

	public Board()
	{
		board = new Piece[COLS][ROWS];
		board[0][0] = new Piece(Piece.BLACK, Piece.ROOK);
		board[1][0] = new Piece(Piece.BLACK, Piece.KNIGHT);
		board[2][0] = new Piece(Piece.BLACK, Piece.BISHOP);
		board[3][0] = new Piece(Piece.BLACK, Piece.BISHOP);
		board[4][0] = new Piece(Piece.BLACK, Piece.KNIGHT);
		board[5][0] = new Piece(Piece.BLACK, Piece.ROOK);

		board[0][5] = new Piece(Piece.WHITE, Piece.ROOK);
		board[1][5] = new Piece(Piece.WHITE, Piece.KNIGHT);
		board[2][5] = new Piece(Piece.WHITE, Piece.BISHOP);
		board[3][5] = new Piece(Piece.WHITE, Piece.BISHOP);
		board[4][5] = new Piece(Piece.WHITE, Piece.KNIGHT);
		board[5][5] = new Piece(Piece.WHITE, Piece.ROOK);

	}

	public Piece getPiece(Coord c)
	{
		Piece piece;
		if(c != null)
			piece =  board[c.getX()][c.getY()];
		else
			piece = null;
		return piece;
	}

	public Coord selectPiece(Coord c, int colour)
	{
		Piece piece = getPiece(c);
		if (piece == null || piece.getColour() != colour)
		{
			c = null;
		}
		return c;
	}
	public Piece[][] getBoard(){
		return board;
	}
	public int movePiece(Coord xy, Coord newXY, int colour) throws IllegalMoveException, PieceNullPointerException
	{
		Piece piece = getPiece(xy);
		MoveStrategy ms = null;
		int score = -1;
		if (piece != null)
		{
			if (piece.getType() == Piece.ROOK)
			{
				ms = new RookStrategy();
			} else if (piece.getType() == Piece.KNIGHT)
			{
				ms = new KnightStrategy();
			} else if (piece.getType() == Piece.BISHOP)
			{
				ms = new BishopStrategy();
			}
			if (ms.isLegalMove(xy.getX() - newXY.getX(), xy.getY() - newXY.getY()))
			{
				if (getPiece(newXY) != null)
				{
					if (getPiece(newXY).getColour() != colour)
					{
						board[xy.getX()][xy.getY()] = null;
						board[newXY.getX()][newXY.getY()] = piece;
						score = 5;
					}
					else {
						score = 0;
					}
					// merge implement here
				} else
				{
					board[xy.getX()][xy.getY()] = null;
					board[newXY.getX()][newXY.getY()] = piece;
					score = 0;
				}
			} else
			{
				throw new IllegalMoveException("Cannot Move Here Please Try Again\n");
			}
		}
		else 
		{
			throw new PieceNullPointerException("You done goofed");
		}
		return score;
	}

	public String toString()
	{
		String boardString = "";
		boardString += "  0  1  2  3  4  5 ";
		for (int y = 0; y < ROWS; y++)
		{
			boardString += "\n" + y;
			for (int x = 0; x < COLS; x++)
			{
				if (board[x][y] == null)
				{
					boardString += " . ";
				} else
					boardString += board[x][y].toString();
			}

		}

		return boardString;
	}
}
