package model;

public class PieceNullPointerException extends Exception
{
	public PieceNullPointerException()
	{
		super("Piece Does Not Exist At Those Coordinates");
	}
}
