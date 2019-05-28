package view;

import controller.MovePieceHandler;
import controller.SelectPieceHandler;
import exceptions.CoordinateOutOfBoundsException;
import exceptions.IllegalMoveException;
import exceptions.PieceNullPointerException;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SelectCollision extends Rectangle
{
	private int x;
	private int y;
	GraphicsEngine gui;
	BoardGUI board;
	
	public SelectCollision(GraphicsEngine gui,BoardGUI board, int x, int y) throws CoordinateOutOfBoundsException, IllegalMoveException, PieceNullPointerException {
		this.gui = gui;
		this.board = board;
		this.x = x;
		this.y = y;
		int length = 60;
		this.setWidth(length);
		this.setHeight(length);
		this.setX(x * length + 20);
		this.setY(y * length + 50);
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, new SelectPieceHandler(gui.getGameEngine(), board));
		this.setFill(Color.YELLOW);
		this.setOpacity(.50);
		
	}
	public String toString() {
		return x + "" + y;
	}
}
