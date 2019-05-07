package model;

public class BishopStrategy extends MoveStrategy
{

	@Override
	public boolean isLegalMove(int dx, int dy)
	{
		if (dx == -2 && (dy == -2 || dy == 2))
		{
			return true;
		} else if (dx == -1 && (dy == -1 || dy == 1))
		{
			return true;
		} else if (dx == 1 && (dy == -1 || dy == 1))
		{
			return true;
		} else if (dx == 2 && (dy == -2 || dy == 2))
		{
			return true;
		} else
			return false;

	}

}
