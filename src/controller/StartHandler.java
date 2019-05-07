package controller;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import view.CreateGameMenuGUI;
import view.GraphicsEngine;

public class StartHandler implements EventHandler<MouseEvent>
{
	GraphicsEngine gui;
	public StartHandler(GraphicsEngine gui) {
		this.gui = gui;
	}

	@Override
	public void handle(MouseEvent arg0)
	{
		gui.root.getChildren().remove(0);
        gui.root.getChildren().add(new CreateGameMenuGUI(gui));
	}

}
