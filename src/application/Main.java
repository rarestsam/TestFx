package application;
	



import java.io.IOException;

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
			
			Parent root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
			Scene scene = new Scene(root,1920,1030);
			Image icon= new Image("food.png");
			stage.getIcons().add(icon);
			stage.setTitle("Restauraunt");
			stage.setScene(scene);
			stage.show();
			
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) 
	{
		//30 lines
		System.out.print("hee");
		launch(args);
	}
}
