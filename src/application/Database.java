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






			String insertSQL = "INSERT INTO Books (BookId, Code, Description, ListPrice) VALUES (?, ?, ?, ?)";
			updateField = connection.prepareStatement(insertSQL);
			updateField.setInt(1, 8);
			updateField.setString(2, "value1");
			updateField.setString(3, "value2");
			updateField.setDouble(4, 11.2);
			updateField.executeUpdate();
 */
public class Database 
{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement updateField = null;
	

	Connection connection1=null;
	Statement statement1 = null;
	ResultSet rs2 = null;
	PreparedStatement updateField1 = null;
	
	
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
	 
	 
	 
	 public void connect_to_database1() throws IOException, SQLException
	 {	 
			String msAccDB = "restaurant.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			connection1 = DriverManager.getConnection(dbURL,"","");
			statement1=connection1.createStatement(); 	
	 }
	 
	 
	 public void setResultsetorder() throws IOException 
	 {
		 try {
			resultSet=statement.executeQuery("SELECT * FROM Orders");
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 public void setResultsetclockedin() throws IOException 
	 {
		 try {
			 rs2=statement1.executeQuery("SELECT * FROM ClockIn_Out");
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 public void setResultsetclockedout() throws IOException 
	 {
		 try {
			 resultSet = statement.executeQuery("SELECT * FROM ClockIn_Out");
		 	} 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 public void setResultsetorderdone() throws IOException 
	 {
		 try {
			 resultSet = statement.executeQuery("SELECT * FROM Orders");
		 	} 
		 catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 
	 public void closeConnection() 
	 {
		 try {
             if(null != connection) {                           
                 connection.close();           
             }             
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 
	 public void closeupdateField() 
	 {
		 try {
             if(null != updateField) {
                 updateField.close(); 
             }
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 public void closeresultSet() 
	 {
		 try {
             if(null != resultSet) {
            	 resultSet.close(); 
             }             
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 public void closestatement() 
	 {
		 try {
             if(null !=  statement) {
            	 statement.close(); 
             }             
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 
	 
	 
	 public void closeConnection1() 
	 {
		 try {
             if(null != connection1) {                           
                 connection1.close();           
             }             
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 
	 public void closeupdateField1() 
	 {
		 try {
             if(null != updateField1) {
                 updateField1.close(); 
             }
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 public void closers2() 
	 {
		 try {
             if(null != rs2) {
            	 rs2.close(); 
             }             
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 public void closestatement1() 
	 {
		 try {
             if(null !=  statement1) {
            	 statement1.close(); 
             }             
         }
         catch (SQLException sqlex) {
             sqlex.printStackTrace();
         }
	 }
	 
	 
	 

	 public void setResultsetorderkitchen() throws IOException 
	 {
		 try {
			resultSet=statement.executeQuery("SELECT * FROM Orders");
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 
	 public void setResultset10() throws IOException 
	 {
		 try {
			resultSet=statement.executeQuery("SELECT * FROM Orders");
		} catch (SQLException e)
		 {
			e.printStackTrace();
		}
	 }
	 
	 
	 
}
