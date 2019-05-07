package model;

public abstract class MoveStrategy
{
	public MoveStrategy()
	{
		
	}
	public abstract boolean isLegalMove(int dx, int dy);
}
