package model;

public class RookStrategy extends MoveStrategy
{

	@Override
	public boolean isLegalMove(int dx, int dy,Piece piece)
	{
		if(dy == 0 && (dx == -2 || dx == -1 || dx == 1 || dx == 2)) {
			if((dx == -2 || dx == 2) && piece != null) {
				return false;
			}
			return true;
		}
		else if(dx == 0 && (dy == -2 || dy == -1 || dy == 1 || dy == 2)) {
			if((dy == -2 || dy == 2) && piece != null) {
				return false;
			}
			return true;
		}
		else
			return false;
	}

}
