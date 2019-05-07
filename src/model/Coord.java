package model;

import exceptions.CoordinateOutOfBoundsException;

public class Coord {
	private int x;
	private int y;
	public Coord(int x, int y) throws CoordinateOutOfBoundsException
	{
		if(x > 6 || x < 0 || y > 6 || y < 0)
			throw new CoordinateOutOfBoundsException("Cannot Instantiate with these coordinates");
		this.x = x;
		this.y = y;
	}
	public Coord(String string) throws NumberFormatException, CoordinateOutOfBoundsException
	{
		this(Integer.parseInt(string.substring(0, 1)), Integer.parseInt(string.substring(1, 2)));
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
}
