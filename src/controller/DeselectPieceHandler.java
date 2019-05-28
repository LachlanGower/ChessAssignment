package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import model.GameEngine;
import view.BoardGUI;

public class DeselectPieceHandler implements EventHandler<MouseEvent>
{
	GameEngine ge;
	BoardGUI board;
	public DeselectPieceHandler(GameEngine ge,BoardGUI board) {
		this.ge = ge;
		this.board = board;
	}
	
	@Override
	public void handle(MouseEvent event)
	{
		ge.getGameState().setSelectedPiece(null);
		board.reDraw();
		board.setDeselect(true);
		board.setSplit(true);
	}

}
