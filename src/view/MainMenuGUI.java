package view;

import controller.StartHandler;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class MainMenuGUI extends Group
{
	public MainMenuGUI(GraphicsEngine gui) {
		Text text = new Text("Welcome to Baby Chess!");
		text.setX(40); 
	    text.setY(80); 
	    text.setFont(Font.font("Verdana", 40));
		getChildren().add(text);
		Button startGame = new Button("Start Game");
		Button quitGame = new Button("Quit Game");
		startGame.setTranslateX(200);
		startGame.setTranslateY(200);
		startGame.setPrefWidth(200);
		startGame.setPrefHeight(50);
		startGame.setFont(Font.font("Verdana", 20));
		getChildren().add(startGame);
		quitGame.setTranslateX(200);
		quitGame.setTranslateY(300);
		quitGame.setPrefWidth(200);
		quitGame.setPrefHeight(50);
		quitGame.setFont(Font.font("Verdana", 20));
		getChildren().add(quitGame);
		EventHandler<MouseEvent> quitHandler = new EventHandler<MouseEvent>() { 
	         @Override 
	         public void handle(MouseEvent e) { 
	            System.exit(0);
	         } 
	      };
		quitGame.addEventFilter(MouseEvent.MOUSE_CLICKED,quitHandler);
		
		startGame.addEventFilter(MouseEvent.MOUSE_CLICKED,new StartHandler(gui));

	}
}
