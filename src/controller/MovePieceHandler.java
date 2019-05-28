package controller;

import exceptions.CoordinateOutOfBoundsException;
import exceptions.IllegalMoveException;
import exceptions.PieceNullPointerException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Coord;
import model.GameEngine;
import model.GameState;
import view.BoardGUI;
import view.GraphicsEngine;

public class MovePieceHandler implements EventHandler<MouseEvent>
{
	GraphicsEngine gui;
	BoardGUI board;
	public MovePieceHandler(GraphicsEngine gui, BoardGUI board) {
		this.gui = gui;
		this.board = board;
	}
	@Override
	public void handle(MouseEvent e)
	{
		try
		{
			GameEngine ge = gui.getGameEngine();
			gui.getGameEngine().getCurrentPlayer().addScore( 
					gui.getGameEngine().getBoard().movePiece(ge.getGameState().getSelectedPiece(),
					new Coord(e.getSource().toString()),
					ge.getGameState().getTurnColour()));
			ge.getGameState().nextTurn();
			board.reDraw();
			if(ge.getGameState().getTurnsRemaining() < 0 || (ge.getWinningPlayer() != null)? ge.getWinningPlayer().getScore() == 30 : false) {
				gui.root.getChildren().remove(0);
				gui.root.getChildren().add(new Text(20,30,
						(gui.getGameEngine().getWinningPlayer() != null)? gui.getGameEngine().getWinningPlayer().getName() + " Has Won!": "Itsa Draw :("));
			}
		} catch (NumberFormatException | IllegalMoveException | PieceNullPointerException
				| CoordinateOutOfBoundsException e1)
		{
			
		}
	}

}
