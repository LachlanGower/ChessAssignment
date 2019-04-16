package model;

public class Player {
	
	private String name;
	private String password;
	private int score;
	
	public Player(String name, String password) {
		this.name = name;
		this.password = password;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

}