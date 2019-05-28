package controller;

import exceptions.CoordinateOutOfBoundsException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.Coord;
import model.GameEngine;

public class SelectPieceHandler implements EventHandler<MouseEvent>
{
	GameEngine ge;
	public SelectPieceHandler(GameEngine ge) {
		this.ge = ge;
	}
	@Override
	public void handle(MouseEvent e)
	{
		try
		{
			ge.getGameState().setSelectedPiece(ge.getBoard().selectPiece(new Coord(e.getSource().toString()), ge.getGameState().getTurnColour()));
		} catch (NumberFormatException nfe)
		{
		} catch (CoordinateOutOfBoundsException coobe)
		{
		}

	}

}
