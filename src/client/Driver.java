package client;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.stage.Stage;
import model.GameEngine;
import view.GraphicsEngine;

public class Driver extends Application
{        
	public static void main(String args[]){           
	   launch(args);      
	}
	@Override     
	public void start(Stage stage) throws Exception { 
	   GameEngine ge = new GameEngine();
	   Group root = new Group();
	   GraphicsEngine gui = new GraphicsEngine(root, ge);
	   stage.setTitle("The Best Chess that ever Checked"); 
	   stage.setScene(gui); 
	   stage.show();
	} 
}
