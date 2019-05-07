package model;

public class Player {
	
	private String name;
	private String password;
	private int score;
	private int colour;
	
	public Player(String name, String password, int colour) {
		this.name = name;
		this.password = password;
		this.colour = colour;
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
	public int getColour() {
		return colour;
	}

	public String getColourString()
	{
		if(colour == 0)
			return "White";
		else if(colour == 1)
			return "Black";
		return "";
	}

}