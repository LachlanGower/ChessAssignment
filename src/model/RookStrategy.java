package model;

public class RookStrategy extends MoveStrategy
{

	@Override
	public boolean isLegalMove(int dx, int dy)
	{
		if(dy == 0 && (dx == -2 || dx == -1 || dx == 1 || dx == 2)) {
			return true;
		}
		else if(dx == 0 && (dy == -2 || dy == -1 || dy == 1 || dy == 2)) {
			return true;
		}
		else
			return false;
	}

}
