package model;

import exceptions.IllegalMoveException;
import exceptions.PieceNullPointerException;

public class Board
{
	private final int ROWS = 6;
	private final int COLS = 6;
	private Piece[][] board;

	public Board()
	{
		board = new Piece[COLS][ROWS];
		board[0][0] = new Piece(ChessColour.BLACK, PieceType.ROOK);
		board[1][0] = new Piece(ChessColour.BLACK, PieceType.KNIGHT);
		board[2][0] = new Piece(ChessColour.BLACK, PieceType.BISHOP);
		board[3][0] = new Piece(ChessColour.BLACK, PieceType.BISHOP);
		board[4][0] = new Piece(ChessColour.BLACK, PieceType.KNIGHT);
		board[5][0] = new Piece(ChessColour.BLACK, PieceType.ROOK);

		board[0][5] = new Piece(ChessColour.WHITE, PieceType.ROOK);
		board[1][5] = new Piece(ChessColour.WHITE, PieceType.KNIGHT);
		board[2][5] = new Piece(ChessColour.WHITE, PieceType.BISHOP);
		board[3][5] = new Piece(ChessColour.WHITE, PieceType.BISHOP);
		board[4][5] = new Piece(ChessColour.WHITE, PieceType.KNIGHT);
		board[5][5] = new Piece(ChessColour.WHITE, PieceType.ROOK);

	}
	public Piece[][] getBoard(){
		return board;
	}
	//CHECK COORDINATE FOR A PIECE, return piece
	public Piece getPiece(Coord c)
	{
		Piece piece;
		if(c != null)
			piece =  board[c.getX()][c.getY()];
		else
			piece = null;
		return piece;
	}
	//CHECK COORDINATE FOR A PIECE OF COLOUR, return coordinate
	public Coord selectPiece(Coord c, ChessColour colour)
	{
		Piece piece = getPiece(c);
		if (piece == null || piece.getColour() != colour)
		{
			c = null;
		}
		return c;
	}
	//MOVE PIECES FROM ONE COORDINATE TO ANOTHER, VALIDATE COLOUR AND LEGAL MOVES SETS
	public int movePiece(Coord xy, Coord newXY, ChessColour colour) throws IllegalMoveException, PieceNullPointerException
	{
		Piece piece = getPiece(xy);
		int score = -1;
		if (piece != null)
		{
			if (validateMove(xy, newXY.getX(),newXY.getY()))
			{
				
				if (getPiece(newXY) != null)
				{
					//TAKE OPPONENTS PIECE
					if (getPiece(newXY).getColour() != colour)
					{
						score = board[newXY.getX()][newXY.getY()].getScore();
						board[xy.getX()][xy.getY()] = null;
						board[newXY.getX()][newXY.getY()] = piece;
						
					}
					//MERGE PIECES
					else {
						if(piece.mergeType(board[newXY.getX()][newXY.getY()])){
							board[xy.getX()][xy.getY()] = null;
							board[newXY.getX()][newXY.getY()] = piece;
							score = 0;
						}
						else {
							throw new IllegalMoveException("Cannot Move Here Please Try Again\n");
						}
					}
					
				} 
				//MOVE TO EMPTY SPACE
				else{
					board[xy.getX()][xy.getY()] = null;
					board[newXY.getX()][newXY.getY()] = piece;
					score = 0;
				}
			}
			//MOVE TO POSITION OUT OF MOVE SET
			else{
				throw new IllegalMoveException("Cannot Move Here Please Try Again\n");
			}
		}
		//PIECE NOT SELECTED
		else {
			throw new PieceNullPointerException("You done goofed");
		}
		return score;
	}

	public boolean validateMove(Coord select, int x, int y) throws IllegalMoveException, PieceNullPointerException
	{
		if(board[select.getX()][select.getY()] != null) {
			if(board[select.getX()][select.getY()].getMoveStrategy().isLegalMove(select.getX() - x, select.getY() - y, board[(select.getX()+x) /2][(select.getY()+y) /2])) {
				return true;
			}
		}
		return false;
	}
	
	//CONSOLE GUI FUNCTION
	public String toString()
	{
		//RECREATE THIS FUNCTION
		String boardString = "";
		return boardString;
	}
}
