package model;

import java.util.Scanner;

public class GameEngine
{
	Board board;
	public Player players[] = new Player[2];
	Scanner scan;
	int turnCount = 0;
	
	public void start() {
		board = new Board();
		scan = new Scanner(System.in);
		System.out.println("Welcome to Baby Chess");
		
		System.out.print("Player 1 Input Name: ");
		String user = scan.nextLine();
		System.out.print("Player1 Input Password: ");
		String pass = scan.nextLine();
		players[0] = new Player(user, pass);
		
		System.out.print("Player 2 Input Name: ");
		user = scan.nextLine();
		System.out.print("Player 2 Input Password: ");
		pass = scan.nextLine();
		players[1] = new Player(user, pass);
		
		System.out.print("Player 1 Input Turn Count: ");
		turnCount = scan.nextInt();
		System.out.print("Player 2 Input Turn Count: ");
		turnCount += scan.nextInt();
		turnCount /= 2;
		System.out.println("Turn Count = " + turnCount);
		
		for(int t = 0; t < turnCount;t++) {
			nextTurn((t % 2) + 1);
		}
		endGame(-1);
	}

	private void nextTurn(int player)
	{
		System.out.println("Player " + player + "'s turn");
		System.out.println(board.toString() + "\n");
		System.out.println("Make Your Move <X> <Y> <toX> <toY>");
		try
		{
			players[player-1].setScore(
					board.movePiece(
							scan.nextInt(),
							scan.nextInt(),
							scan.nextInt(),
							scan.nextInt(),
							player - 1));
		} catch (CoordinateOutOfBoundsException | PieceNullPointerException | IllegalMoveException e)
		{
			System.out.print(e);
			nextTurn(player);
		}
		if(players[player-1].getScore() == 30) {
			endGame(player - 1);
		}
	}

	private void endGame(int champion)
	{
		if(champion == -1) {
			if(players[0].getScore() > players[1].getScore())
				champion = 0;
			else if(players[0].getScore() < players[1].getScore())
				champion = 1;
			else {
				System.out.println("Draw Winner, Turn Count Exceeded");
			}
		}
		if(champion != -1)
			System.out.println("Player " + champion + " has Won with a score of " + players[champion].getScore());
	}
}
