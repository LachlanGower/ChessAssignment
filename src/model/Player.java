package model;

public class Player {
	
	private String name;
	private String password;
	private int score;
	private ChessColour colour;
	
	public Player(String name, String password, ChessColour colour) {
		this.name = name;
		this.password = password;
		this.colour = colour;
		this.score = 0;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addScore(int score) {
		this.score += score;
	}
	
	public String getName() {
		return name;
	}

	public ChessColour getColour() {
		return colour;
	}

	public String getColourString()
	{
		if(colour == ChessColour.WHITE)
			return "White";
		else if(colour == ChessColour.BLACK)
			return "Black";
		return "";
	}

}