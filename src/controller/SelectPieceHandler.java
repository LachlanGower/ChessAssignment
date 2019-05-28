package controller;

import exceptions.CoordinateOutOfBoundsException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Coord;
import model.GameEngine;
import view.BoardGUI;

public class SelectPieceHandler implements EventHandler<MouseEvent>
{
	GameEngine ge;
	BoardGUI board;
	public SelectPieceHandler(GameEngine ge, BoardGUI board) {
		this.ge = ge;
		this.board = board;
	}
	@Override
	public void handle(MouseEvent e)
	{
		try
		{
			ge.getGameState().setSelectedPiece(ge.getBoard().selectPiece(new Coord(e.getSource().toString()), ge.getGameState().getTurnColour()));
			board.setDeselect(false);
			board.setSplit(false);
			board.reDraw();
		} catch (NumberFormatException nfe)
		{
		} catch (CoordinateOutOfBoundsException coobe)
		{
		}

	}

}
