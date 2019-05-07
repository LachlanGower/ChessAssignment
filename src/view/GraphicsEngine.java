package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import model.GameEngine;

public class GraphicsEngine extends Scene
{
	private GameEngine ge;
	public Group root;

	public GraphicsEngine(Group root, GameEngine ge)
	{
		super(root, 600,500);
		this.ge = ge;
		this.root = root;
		root.getChildren().add(new MainMenuGUI(this));
	}

	
	public GameEngine getGameEngine() {
		return ge;
	}
}
