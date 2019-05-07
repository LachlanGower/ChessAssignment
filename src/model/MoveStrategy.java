package model;

//strategy pattern
public class MoveStrategy
{
	MoveStrategy[] strategies;
	int length = 0;
	public MoveStrategy() {
		strategies = new MoveStrategy[2];
	}
	//composite pattern
	public void add(MoveStrategy ms) {
		if(length < 2) {
			strategies[length] = ms;
			length++;
		}
	}
	public boolean isLegalMove(int dx, int dy) {
		boolean legal = false;
		for(MoveStrategy strategy: strategies) {
			if(strategy != null) {
				//check all strategies, if a move is legal 
				//OR gate will keep legal true for next check.
				legal = legal || strategy.isLegalMove(dx, dy);
			}
		}
		return legal;
	}
}
