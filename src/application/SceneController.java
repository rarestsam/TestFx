package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
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
	 
	 @FXML
	 private TextField name_texField;
	 
	 @FXML
	 private Label verify;
	 
	 @FXML 
	 private RadioButton Manager_rdb;
	 
	 @FXML
	 private Label login_Label;
	 
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
		 try 
		{			 
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
	
		 if(value_of_txt >= 10 && value_of_txt <= 20)
		 {
			  Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
		 }
		}
		 catch(Exception e)
		 {
			 login_Label.setText("Please enter in the correct format. No letters and symbols.");
		 }
	 }
	 
	 public void enter_manager(ActionEvent event) throws IOException
	 {
		 
	      int value_of_txt; 
          String text = name_texField.getText();
          
		if(verify_text(text))
		{	
			 verify.setText("Please enter in the correct format");
		}
		
		else
		{
			 verify.setText("Success Please go back to login");
		}
	 }
	 
	 public Boolean verify_text(String txt)
	 {
		 try
		 {
		 int s = Integer.parseInt(txt);
		 return true;
		 }
		 catch(Exception e)
		 {
			 return false;
		 }
	 }
	 
	 public void switchToCreate_New_User(ActionEvent event) throws IOException
	 {
			  Parent root = FXMLLoader.load(getClass().getResource("New_User.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
	 }
	 
	 public void switchToSceneWaitstaff(ActionEvent event) throws IOException
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

