package view;

import controller.MovePieceHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class CellGUI extends Rectangle
{
	private int x;
	private int y;
	public CellGUI(GraphicsEngine gui, BoardGUI board, int colour, int x, int y) {
		this.x = x;
		this.y = y;
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, new MovePieceHandler(gui, board));
		int length = 60;
		this.setWidth(length);
		this.setHeight(length);
		this.setX(x * length + 20);
		this.setY(y * length + 50);
		if(colour == 0)
			this.setFill(Color.GRAY);
		else
			this.setFill(Color.WHITE);
		
	}
	public String toString() {
		return x + "" + y;
	}
}
