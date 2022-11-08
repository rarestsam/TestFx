package application;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;



/*
 String insertSQL = "INSERT INTO table_name (column1, column2) VALUES (?, ?)";
PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);
preparedStatement.setString(1, "value1");
preparedStatement.setString(2, "value2");
preparedStatement.executeUpdate();
 */
public class Database 
{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement updateField = null;
	

	 public void connect_to_database() throws IOException, SQLException
	 {
		 
			String msAccDB = "restaurant.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			connection = DriverManager.getConnection(dbURL,"","");
			statement=connection.createStatement(); 	
	 }
	 
	 public void setResultset() throws IOException 
	 {
		 try {
			resultSet=statement.executeQuery("SELECT * FROM Employee");
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 public void closeConnection() 
	 {
		 try {
             if(null != connection) {
                 resultSet.close();
                 statement.close();	 
                 updateField.close();
                 updateField.close();
                 connection.close();
             }
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 
	 
	 
}
