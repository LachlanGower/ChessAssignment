package view;

import controller.SelectPieceHandler;
import javafx.scene.Group;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import model.Piece;

public class PieceGUI extends Group
{
	int x;
	int y;
	public PieceGUI(GraphicsEngine gui, Piece piece, int x, int y)
	{
		this.x = x;
		this.y = y;
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new SelectPieceHandler(gui.getGameEngine()));
		ImageView pieceImage = new ImageView(PieceFactory.getPiece(piece.getColour(), piece.getType()));
		getChildren().add(pieceImage);
		setLayoutX(x*60 + 20);
		setLayoutY(y*60 + 50);
		pieceImage.setFitWidth(60);
		pieceImage.setFitHeight(60);
	}
	public String toString() {
		return x + "" + y;
	}
	
}
