package model;

public class Board
{
	private final int ROWS = 6;
	private final int COLS = 6;
	private Piece[][] board;
	
	public Board() {
		board = new Piece[COLS][ROWS];
		board[0][0] = new Piece(Piece.BLACK,Piece.ROOK);
		board[1][0] = new Piece(Piece.BLACK,Piece.KNIGHT);
		board[2][0] = new Piece(Piece.BLACK,Piece.BISHOP);
		board[3][0] = new Piece(Piece.BLACK,Piece.BISHOP);
		board[4][0] = new Piece(Piece.BLACK,Piece.KNIGHT);
		board[5][0] = new Piece(Piece.BLACK,Piece.ROOK);
		
		board[0][5] = new Piece(Piece.WHITE,Piece.ROOK);
		board[1][5] = new Piece(Piece.WHITE,Piece.KNIGHT);
		board[2][5] = new Piece(Piece.WHITE,Piece.BISHOP);
		board[3][5] = new Piece(Piece.WHITE,Piece.BISHOP);
		board[4][5] = new Piece(Piece.WHITE,Piece.KNIGHT);
		board[5][5] = new Piece(Piece.WHITE,Piece.ROOK);


	}
	public Piece getPiece(int x, int y) {
		return board[x][y];
	}
	
	public int movePiece(int x, int y, int newX, int newY, int colour) throws CoordinateOutOfBoundsException, PieceNullPointerException, IllegalMoveException {
		Piece currentPiece = this.getPiece(x, y);
		if(currentPiece == null)
			throw new PieceNullPointerException();
		if(currentPiece.getColour() != colour)
			throw new IllegalMoveException("Illegal Move -- Cannot Move Opponents Pieces");
		if(newX >= COLS || newX < 0 || newY >= ROWS || newY < 0)
			throw new CoordinateOutOfBoundsException(newX + " " + newY);
		if(currentPiece.getType() == Piece.ROOK) {
			if(isLegalRookMove(newX - x, newY - y)) {
				if(this.getPiece(newX, newY) != null) {
					System.out.println(this.getPiece(newX, newY).getColour() + " at " + newX + " " + newY);
					if(this.getPiece(newX, newY).getColour() != colour) {
						board[x][y] = null;
						board[newX][newY] = currentPiece;
						return 5;
					}else{
						//this will be merge functionality in the future
						throw new IllegalMoveException("Illegal Move -- Cannot take your own pieces");
					}
				}else{
					board[x][y] = null;
					board[newX][newY] = currentPiece;
					return 0;
				}
			}else{
				throw new IllegalMoveException("Illegal Move -- Coordinate Error");
			}
		}
		else if(currentPiece.getType() == Piece.KNIGHT) {
			if(isLegalKnightMove(newX - x, newY - y)) {
				if(this.getPiece(newX, newY) != null) {
					if(this.getPiece(newX, newY).getColour() != colour) {
						board[x][y] = null;
						board[newX][newY] = currentPiece;
						return 5;
					}else{
						throw new IllegalMoveException("Illegal Move -- Cannot take your own pieces");
					}
				}else{
					board[x][y] = null;
					board[newX][newY] = currentPiece;
					return 0;
				}
			}else{
				throw new IllegalMoveException("Illegal Move -- Coordinate Error");
			}
		}
		else if(currentPiece.getType() == Piece.BISHOP) {
			if(isLegalBishopMove(newX - x, newY - y)) {
				if(this.getPiece(newX, newY) != null) {
					if(this.getPiece(newX, newY).getColour() != colour) {
						board[x][y] = null;
						board[newX][newY] = currentPiece;
						return 5;
					}else{
						throw new IllegalMoveException("Illegal Move -- Cannot take your own pieces");
					}
				}else{
					board[x][y] = null;
					board[newX][newY] = currentPiece;
					return 0;
				}
			}else{
				throw new IllegalMoveException("Illegal Move -- Coordinate Error");
			}
		}
		return -1;
	}
	
	private boolean isLegalBishopMove(int dx, int dy) {
		if(dx == -2 && (dy == -2 || dy == 2)) {
			return true;
		}
		else if(dx == -1 && (dy == -1 || dy == 1)) {
			return true;
		}
		else if(dx == 1 && (dy == -1 || dy == 1)) {
			return true;
		}
		else if(dx == 2 && (dy == -2 || dy == 2)) {
			return true;
		}
		else
			return false;
	}
	
	private boolean isLegalRookMove(int dx, int dy) {
		if(dy == 0 && (dx == -2 || dx == -1 || dx == 1 || dx == 2)) {
			return true;
		}
		else if(dx == 0 && (dy == -2 || dy == -1 || dy == 1 || dy == 2)) {
			return true;
		}
		else
			return false;
	}
	
	private boolean isLegalKnightMove(int dx, int dy) {
		if(dx == -2 && (dy == -1 || dy == 1)) {
			return true;
		}
		else if(dx == -1 && (dy == -2 || dy == 2)) {
			return true;
		}
		else if(dx == 1 && (dy == -2 || dy == 2)) {
			return true;
		}
		else if(dx == 2 && (dy == -1 || dy == 1)) {
			return true;
		}
		else
			return false;
	}
	
	public String toString() {
		String boardString = "";
		boardString += "  0  1  2  3  4  5 ";
		for(int y = 0;y < ROWS; y ++) {
			boardString += "\n" + y;
			for(int x = 0; x < COLS; x ++) {
				if(board[x][y] == null) {
					boardString += " . ";
				}
				else
					boardString += board[x][y].toString();
			}
			
		}
			
		return boardString;
	}
}