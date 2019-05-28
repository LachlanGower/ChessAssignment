package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.BoardGUI;
import view.GraphicsEngine;

public class SplitPieceHandler implements EventHandler<MouseEvent>
{
	GraphicsEngine gui;
	BoardGUI board;
	public SplitPieceHandler(GraphicsEngine gui,BoardGUI board) {
		this.gui = gui;
		this.board = board;
	}
	
	@Override
	public void handle(MouseEvent event)
	{
		System.out.println("doing");
		board.setSplitEnabled(true);
		board.setDeselect(true);
		board.setSplit(true);
	}


}
