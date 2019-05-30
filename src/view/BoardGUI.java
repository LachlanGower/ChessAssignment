package view;

import com.sun.prism.paint.Color;

import controller.DeselectPieceHandler;
import controller.SplitPieceHandler;
import exceptions.CoordinateOutOfBoundsException;
import exceptions.IllegalMoveException;
import exceptions.PieceNullPointerException;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import model.Coord;

public class BoardGUI extends Group
{
	Text currentPlayer;
	Text player1Score;
	Text player2Score;
	Text turns;
	PieceGUI[] pieces = new PieceGUI[12];
	SelectCollision[] selectCells = new SelectCollision[12];
	MoveCollision[] moveCells = new MoveCollision[16];
	GraphicsEngine gui;
	Button deselect;
	Button split;
	boolean splitEnabled = false;
	
	public BoardGUI(GraphicsEngine gui) {
		this.gui = gui;
		for(int y = 0; y < 6;y++) {
			for(int x = 0;x < 6;x++) {
				getChildren().add(new CellGUI(gui, this,(x + y) % 2, x, y));
			}
		}
		Font font = new Font("Verdana",30);

		currentPlayer = new Text();
		currentPlayer.setText(gui.getGameEngine().getCurrentPlayer().getName()+ "'s Turn");
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

		turns = new Text("Turns Remaining: " + gui.getGameEngine().getGameState().getTurnsRemaining());
		turns.setX(20);
		turns.setY(480);
		turns.setFont(font);
		
		split = new Button("Split");
		split.setLayoutX(270);
		split.setLayoutY(410);
		getChildren().add(split);
		split.setDisable(true);
		split.addEventFilter(MouseEvent.MOUSE_CLICKED, new SplitPieceHandler(gui, this));

		deselect = new Button("Deselect");
		deselect.setLayoutX(320);
		deselect.setLayoutY(410);
		getChildren().add(deselect);
		deselect.setDisable(true);
		deselect.addEventFilter(MouseEvent.MOUSE_CLICKED, new DeselectPieceHandler(gui.getGameEngine(), this));


		getChildren().add(turns);
		int length = 0;
		int selectLength = 0;
		for(int y = 0 ;y < 6 ;y++) {
			for(int x = 0 ;x < 6 ;x++) {
				try
				{
					if(gui.getGameEngine().getBoard().getPiece(new Coord(x,y))!=null) {
						pieces[length] = new PieceGUI(gui,gui.getGameEngine().getBoard().getPiece(new Coord(x,y)),x,y);
						getChildren().add(pieces[length]);
						length++;
					}
					if(gui.getGameEngine().getBoard().getPiece(new Coord(x,y)) != null && gui.getGameEngine().getBoard().getPiece(new Coord(x,y)).getColour() == gui.getGameEngine().getCurrentPlayer().getColour()) {
						selectCells[selectLength] = new SelectCollision(gui,this, x, y);
						getChildren().add(selectCells[selectLength]);
						selectLength++;
					}

				} catch (CoordinateOutOfBoundsException | IllegalMoveException | PieceNullPointerException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	public void reDraw() {
		currentPlayer.setText(gui.getGameEngine().getCurrentPlayer().getName()+ "'s Turn");
		player1Score.setText("Score: " + (gui.getGameEngine().getPlayers()[0].getScore()));
		player2Score.setText("Score: " + (gui.getGameEngine().getPlayers()[1].getScore()));
		turns.setText("Turns Remaining: " + gui.getGameEngine().getGameState().getTurnsRemaining());
		for(PieceGUI piece : pieces) {
			getChildren().remove(piece);
		}
		for(MoveCollision move : moveCells) {
			getChildren().remove(move);
		}
		for(SelectCollision select : selectCells) {
			getChildren().remove(select);
		}
		int length = 0;
		int moveLength = 0;
		int selectLength = 0;
		for(int x = 0; x < 6;x++) {
			for(int y = 0; y < 6;y++) {
				try
				{
					if(gui.getGameEngine().getBoard().getPiece(new Coord(x,y))!=null) {
						pieces[length] = new PieceGUI(gui,gui.getGameEngine().getBoard().getPiece(new Coord(x,y)),x,y);
						getChildren().add(pieces[length]);
						length++;
					}
					Coord select = gui.getGameEngine().getGameState().getSelectedPiece();
					if(select != null) {
						if(gui.getGameEngine().getBoard().validateMove(select,x,y)){
							//pass Colour value
							if(gui.getGameEngine().getBoard().isShitMove(select, x, y)){
								moveCells[moveLength] = new MoveCollision(gui,this, x, y, javafx.scene.paint.Color.RED);
							}
							else {
								moveCells[moveLength] = new MoveCollision(gui,this, x, y, javafx.scene.paint.Color.LIME);
							}
							getChildren().add(moveCells[moveLength]);
							moveLength++;
						}
					}
					else {
						if(gui.getGameEngine().getBoard().getPiece(new Coord(x,y)) != null && gui.getGameEngine().getBoard().getPiece(new Coord(x,y)).getColour() == gui.getGameEngine().getCurrentPlayer().getColour()) {
							selectCells[selectLength] = new SelectCollision(gui,this, x, y);
							getChildren().add(selectCells[selectLength]);
							selectLength++;
						}
					}

				} catch (CoordinateOutOfBoundsException e)
				{
					e.printStackTrace();
				} catch (IllegalMoveException e)
				{
					e.printStackTrace();
				} catch (PieceNullPointerException e)
				{
					e.printStackTrace();
				}
			}
		}
		
	}
	public void setDeselect(boolean b)
	{
		deselect.setDisable(b);
	}
	public void setSplit(boolean b)
	{
		if(b || gui.getGameEngine().getBoard().getPiece(gui.getGameEngine().getGameState().getSelectedPiece()).getMergeType() !=null) {
			split.setDisable(b);
		}
		
	}
	public boolean getSplit()
	{		
		return splitEnabled;
	}
	public void setSplitEnabled(boolean b)
	{
		splitEnabled = b;
		
	}
}
