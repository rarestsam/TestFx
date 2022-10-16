package application;
import java.awt.Button;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class SceneController
{
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 String [] j = new String[10];
	// database
	// setEditable(false) use this function for setting text in a textfield and not being played with
	 @FXML 
	 private TextField txtField;
	 
	
	 
	 public void loginreroute(ActionEvent event) throws IOException
	 {
		 /*
		 for(int i =0;i<j.length;i++)
			{
				String s = String.valueOf(i+1); 
				j[i]= s;
			//	System.out.print("it Worked");
			}
			
		 for(int i=0; i<j.length; i++) 
		 {
		 */
		 int value_of_txt; 
		 String text = txtField.getText();
		 value_of_txt = Integer.parseInt(text);
		
		 if( value_of_txt < 10) 
		     {
			  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
		     }
		 
		 if(value_of_txt > 10 && value_of_txt < 20)
		 {
			  Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
		 }
	 }
	 
	 public void switchToSceneWaitstaff(ActionEvent event) throws IOException
	 {
		
			  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
		 
		 
	 }
	 public void switchToManager() throws IOException
	 
	 {
		 
		  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		 
	 }
	 public void switchToSceneWaitstaff_manager(ActionEvent event) throws IOException
	 {		
		 		
			  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
	 }
	 
	 public void switchToLogin(ActionEvent event) throws IOException 
	 {
	  root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
	  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
	  scene = new Scene(root);
	  stage.setScene(scene);
	  stage.show();
	 }
	   
}

