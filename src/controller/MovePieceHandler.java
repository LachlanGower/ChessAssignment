package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import model.Coord;
import model.CoordinateOutOfBoundsException;
import model.IllegalMoveException;
import model.PieceNullPointerException;
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
		System.out.println("fun facts: " + e.getSource().toString());
		try
		{
			gui.getGameEngine().getPlayers()[gui.getGameEngine().getTurnColour()].addScore( 
					gui.getGameEngine().getBoard().movePiece(gui.getGameEngine().getSelectedPiece(),
					new Coord(e.getSource().toString()),
					gui.getGameEngine().getTurnColour()));
			
			board.reDraw();
			if(gui.getGameEngine().getTurnsRemaining() < 0) {
				gui.root.getChildren().remove(0);
				
			}
		} catch (NumberFormatException | IllegalMoveException | PieceNullPointerException
				| CoordinateOutOfBoundsException e1)
		{
			
		}
	}

}
