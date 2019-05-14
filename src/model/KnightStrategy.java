package model;

public class KnightStrategy extends MoveStrategy
{

	@Override
	public boolean isLegalMove(int dx, int dy,Piece piece)
	{
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

}
