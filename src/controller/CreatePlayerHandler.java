package controller;

import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.ChessColour;
import model.Player;
import view.CreateGameMenuGUI;
import view.GraphicsEngine;

public class CreatePlayerHandler implements EventHandler<MouseEvent>
{
	GraphicsEngine gui;
	TextField user;
	PasswordField pass;
	CreateGameMenuGUI menu;
	public CreatePlayerHandler(GraphicsEngine gui,CreateGameMenuGUI menu, TextField user, PasswordField pass) {
		this.gui = gui;
		this.user = user;
		this.pass = pass;
		this.menu = menu;
	}
	
	@Override
	public void handle(MouseEvent event)
	{
		try
		{
			gui.getGameEngine().createPlayer(new Player(user.getText(), pass.getText(),(gui.getGameEngine().getAmountOfPlayers() == 0) ? ChessColour.WHITE : ChessColour.BLACK));
			menu.addPlayerModal(gui.getGameEngine().getAmountOfPlayers() - 1, user.getText());
		} catch (Exception e)
		{
		}
		pass.clear();
	}

}
