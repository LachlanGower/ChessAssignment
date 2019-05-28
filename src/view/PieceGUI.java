package view;

import javafx.scene.Group;
import javafx.scene.image.ImageView;
import model.Piece;

public class PieceGUI extends Group
{
	int x;
	int y;
	ImageView pieceImage;
	public PieceGUI(GraphicsEngine gui, Piece piece, int x, int y)
	{
		this.x = x;
		this.y = y;
		pieceImage = new ImageView(PieceFactory.getPiece(piece.toString()));
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
