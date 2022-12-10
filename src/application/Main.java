package application;
	


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;


public class Main extends Application 
{
	
	
	@Override
	public void start(Stage stage)  
	{
		try {
			Database database =  new Database();
			database.connect_to_database();	
			Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
			Scene scene = new Scene(root,1920,1030);
			Image icon= new Image("food.png");
			stage.getIcons().add(icon);
			stage.setTitle("Restauraunt");
			stage.setScene(scene);
			stage.show();	
			stage.setFullScreen(true);
		} 
		catch(Exception e) 
		{		
		
			SceneController sceneController = new SceneController();
			sceneController.showfailedScreen("Could not open login screen");
		}
	}
	
	public static void main(String[] args) 
	{
		
		launch(args);
	}
}

