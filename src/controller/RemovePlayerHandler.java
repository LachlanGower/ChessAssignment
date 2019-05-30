package controller;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.CreateGameMenuGUI;
import view.GraphicsEngine;

public class RemovePlayerHandler implements EventHandler<MouseEvent>
{
	GraphicsEngine gui;
	String username;
	CreateGameMenuGUI cgm;
	public RemovePlayerHandler(GraphicsEngine gui, String username, CreateGameMenuGUI cgm) {
		this.gui = gui;
		this.username = username;
		this.cgm = cgm;
	}

	@Override
	public void handle(MouseEvent event)
	{
		cgm.removePlayerModal(username);
		gui.getGameEngine().removePlayer(username);
	}

}
