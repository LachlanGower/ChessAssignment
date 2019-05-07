package controller;

import exceptions.Not2PlayersException;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.BoardGUI;
import view.GraphicsEngine;
import view.PlayerModalGUI;

public class CreateGameHandler implements EventHandler<MouseEvent>
{
	GraphicsEngine gui;
	PlayerModalGUI[] players;
	public CreateGameHandler(GraphicsEngine gui, PlayerModalGUI[] players) {
		this.gui = gui;
		this.players = players;
	}

	@Override
	public void handle(MouseEvent event)
	{
		try
		{
			int turnCount1 = players[0].getTurnCount();
			int turnCount2 = players[1].getTurnCount();
			gui.getGameEngine().createGame((int) ((turnCount1 + turnCount2) /2));
			gui.root.getChildren().remove(0);
			System.out.print("test");
			gui.root.getChildren().add(new BoardGUI(gui));
		}catch (Not2PlayersException e)
		{
			//gameengine doesnt have own two players
			System.err.println("Only 2 Players may be added to the game");
		}catch(NumberFormatException e)
		{
			//preferred counts arent numbers
			System.err.println("Please Enter a Number into the Preferred Turn Count Fields");
		} catch (NullPointerException e)
		{
			//A player modal doesnt exist
			System.err.println("Only 2 Players may be added to the game");
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

}
