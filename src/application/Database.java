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

/* 
 while(resultSet.next())
			{
				 System.out.printf("%-8d %-18s %-30s %10.2f\n",
               			 resultSet.getInt(1),
                         resultSet.getString(2),
                         resultSet.getString(3),
                         resultSet.getDouble(4));			
			}
			
*/

// getColumnCount() 
//use this function to find how many coloumns there are in a result set

/*   
 			statement.executeUpdate(sql);

            String updField = "java";
            String updatesql = "UPDATE Books " +
                    "SET ListPrice = ? WHERE Code = ?";
            updateField = connection.prepareStatement(updatesql);
            updateField.setDouble(1, newPrice);
            updateField.setString(2, updField);
            updateField.executeUpdate();
         
*/

public class Database 
{
	Connection connection = null;
	Statement statement = null;
	ResultSet resultSet = null;
	PreparedStatement updateField = null;
	
	

	 public void connect_to_database() throws IOException 
	 {
		 try {
			String msAccDB = "C:\\Users\\rares\\Desktop\\Senior Project\\database ex\\MyBooks.accdb";
			String dbURL = "jdbc:ucanaccess://" + msAccDB;
			connection = DriverManager.getConnection(dbURL,"","");
			statement=connection.createStatement();
			
		 }
		 catch (SQLException sqlex)
		 {
             sqlex.printStackTrace();
		 }
		 
	 }
	 
	 public void setResultset() throws IOException 
	 {
		 try {
			resultSet=statement.executeQuery("SELECT * FROM Books");
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
