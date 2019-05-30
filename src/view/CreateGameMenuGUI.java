package view;

import controller.CreateGameHandler;
import controller.RegisterPlayerHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class CreateGameMenuGUI extends Group
{	
	private PlayerModalGUI[] players;
	private GraphicsEngine gui;
	public CreateGameMenuGUI(GraphicsEngine gui) {
		players = new PlayerModalGUI[2];
		this.gui = gui;
		
		Group playerCreateModal = new Group();
		
		Text text1 = new Text("Username: ");
		text1.setX(40); 
	    text1.setY(65); 
		TextField user = new TextField();
		user.setLayoutX(100); 
	    user.setLayoutY(50); 
		
	    Text text2 = new Text("PIN: ");
		text2.setX(75); 
	    text2.setY(95); 
		PasswordField pass = new PasswordField();
		pass.setLayoutX(100); 
	    pass.setLayoutY(80); 
		
	    Button createPlayer = new Button("Add Player");
	    createPlayer.addEventFilter(MouseEvent.MOUSE_CLICKED, new RegisterPlayerHandler(gui,this,user, pass));
		createPlayer.setLayoutX(180); 
	    createPlayer.setLayoutY(130); 
	    
	    playerCreateModal.getChildren().add(text1);
		playerCreateModal.getChildren().add(text2);
		playerCreateModal.getChildren().add(user);
		playerCreateModal.getChildren().add(pass);
		playerCreateModal.getChildren().add(createPlayer);
		playerCreateModal.setLayoutX(-10);
		playerCreateModal.setLayoutY(125);

		getChildren().add(playerCreateModal);
		
		
	    Button createGame = new Button("Create Game");
	    createGame.setLayoutX(440);
	    createGame.setLayoutY(440);
	    createGame.addEventFilter(MouseEvent.MOUSE_CLICKED, new CreateGameHandler(gui, players));
		getChildren().add(createGame);
		
		Rectangle divider = new Rectangle(300,0,1,500);
		getChildren().add(divider);
		
	}

	public void addPlayerModal(int length, String username)
	{
		players[length] = new PlayerModalGUI(gui, username, this);
		players[length].setLayoutY(length * 120);
		getChildren().add(players[length]);
	}
	
	public void removePlayerModal(String username) {
		for(int i = 0 ; i < players.length;i++) {
			if(players[i].username.equals(username)) {
				getChildren().remove(players[i]);
				if(i == 0) {
					players[0] = players[1];
					players[0].setLayoutY(i*120);
				}
				else if(i == 1) {
					players[1] = null;
				}
				i = players.length;
			}
		}
	}
}
