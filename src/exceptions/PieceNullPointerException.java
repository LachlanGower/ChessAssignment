package exceptions;

public class PieceNullPointerException extends Exception
{
	public PieceNullPointerException(String string)
	{
		super(string + "\n");
	}
}
