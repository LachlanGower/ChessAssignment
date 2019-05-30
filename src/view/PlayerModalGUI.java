package view;

import controller.RemovePlayerHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PlayerModalGUI extends Group
{
	TextField turnCount;
	CreateGameMenuGUI createGameMenuGUI;
	public String username;
	
	public PlayerModalGUI(GraphicsEngine gui, String username, CreateGameMenuGUI cgm) {
		this.username = username;
		Text text = new Text(username);
		text.setX(320);
		text.setY(50);
		text.setFont(new Font("Verdana",30));
		
		Text text2 = new Text("Preferred Turn Count: ");
		text2.setX(410);
		text2.setY(85);
		turnCount = new TextField();
		turnCount.setPrefWidth(50);
		turnCount.setPrefHeight(10);
		turnCount.setLayoutX(530);
		turnCount.setLayoutY(70);
		
		Button removePlayer = new Button("Remove Player");
		removePlayer.addEventFilter(MouseEvent.MOUSE_CLICKED, new RemovePlayerHandler(gui, username, cgm));
	    removePlayer.setLayoutX(320);
	    removePlayer.setLayoutY(100);
	    
		getChildren().add(text);
		getChildren().add(text2);
		getChildren().add(turnCount);
		getChildren().add(removePlayer);
	}
	public int getTurnCount() throws NumberFormatException{
		return Integer.parseInt(turnCount.getText());
	}
	
}
