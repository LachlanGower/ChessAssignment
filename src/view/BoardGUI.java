package view;

import javafx.scene.Group;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Coord;
import model.CoordinateOutOfBoundsException;

public class BoardGUI extends Group
{
	Text currentPlayer;
	Text player1Score;
	Text player2Score;
	Text turns;
	PieceGUI[] pieces = new PieceGUI[12];
	GraphicsEngine gui;
	public BoardGUI(GraphicsEngine gui) {
		this.gui = gui;
		for(int y = 0; y < 6;y++) {
			for(int x = 0;x < 6;x++) {
				getChildren().add(new CellGUI(gui, this,(x + y) % 2, x, y));
			}
		}
		Font font = new Font("Verdana",30);

		currentPlayer = new Text();
		currentPlayer.setText(gui.getGameEngine().nextTurn().getName()+ "'s Turn");
		currentPlayer.setX(20);
		currentPlayer.setY(40);
		currentPlayer.setFont(font);
		getChildren().add(currentPlayer);
		
		Text player1 = new Text(gui.getGameEngine().getPlayers()[0].getName());
		player1.setX(400);
		player1.setY(80);
		player1.setFont(font);
		Text color1 = new Text("Colour: " + gui.getGameEngine().getPlayers()[0].getColourString());
		color1.setX(450);
		color1.setY(110);
		player1Score = new Text("Score: " + (gui.getGameEngine().getPlayers()[1].getScore()));
		player1Score.setX(450);
		player1Score.setY(140);
		getChildren().add(player1);
		getChildren().add(color1);
		getChildren().add(player1Score);
		
		Text player2 = new Text(gui.getGameEngine().getPlayers()[1].getName());
		player2.setX(400);
		player2.setY(200);
		player2.setFont(font);
		Text color2 = new Text("Colour: " + gui.getGameEngine().getPlayers()[1].getColourString());
		color2.setX(450);
		color2.setY(230);
		player2Score = new Text("Score: " + (gui.getGameEngine().getPlayers()[1].getScore()));
		player2Score.setX(450);
		player2Score.setY(260);
		getChildren().add(player2);
		getChildren().add(color2);
		getChildren().add(player2Score);

		turns = new Text("Turns Remaining: " + gui.getGameEngine().getTurnsRemaining());
		turns.setX(20);
		turns.setY(480);
		turns.setFont(font);

		getChildren().add(turns);
		int length = 0;
		for(int y = 0 ;y < 6 ;y++) {
			for(int x = 0 ;x < 6 ;x++) {
				try
				{
					if(gui.getGameEngine().getBoard().getPiece(new Coord(x,y))!=null) {
						pieces[length] = new PieceGUI(gui,gui.getGameEngine().getBoard().getPiece(new Coord(x,y)),x,y);
						getChildren().add(pieces[length]);
						length++;
					}
				} catch (CoordinateOutOfBoundsException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void reDraw() {
		currentPlayer.setText(gui.getGameEngine().nextTurn().getName()+ "'s Turn");
		player1Score.setText("Score: " + (gui.getGameEngine().getPlayers()[0].getScore()));
		player2Score.setText("Score: " + (gui.getGameEngine().getPlayers()[1].getScore()));
		turns.setText("Turns Remaining: " + gui.getGameEngine().getTurnsRemaining());
		for(PieceGUI piece : pieces) {
			getChildren().remove(piece);
		}
		int length = 0;
		for(int x = 0; x < 6;x++) {
			for(int y = 0; y < 6;y++) {
				try
				{
					if(gui.getGameEngine().getBoard().getPiece(new Coord(x,y))!=null) {
						pieces[length] = new PieceGUI(gui,gui.getGameEngine().getBoard().getPiece(new Coord(x,y)),x,y);
						getChildren().add(pieces[length]);
						length++;
					}
				} catch (CoordinateOutOfBoundsException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
}
