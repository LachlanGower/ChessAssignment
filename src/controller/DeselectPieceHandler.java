package controller;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import model.GameEngine;

public class DeselectPieceHandler implements EventHandler<MouseEvent>
{
	GameEngine ge;
	Button button;
	public DeselectPieceHandler(GameEngine ge,Button button) {
		this.ge = ge;
		this.button = button;
	}
	
	@Override
	public void handle(MouseEvent event)
	{
		ge.getGameState().setSelectedPiece(null);
		button.setDisable(false);
	}

}
