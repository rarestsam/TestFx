package application;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;



import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
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
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;

public class SceneController 
{
	 private static final Paint WHITE = null;
	 private Stage stage;
	 private Scene scene;
	 private Parent root;
	 String [] j = new String[10];
	 private int fb = 1;
	 private double ph = 200.0;
	 private double tp = 0.0;
	 private String time;  
	 private SimpleDateFormat timeFormat;
	 Calendar calendar;
	 ArrayList<Employee> employees = new ArrayList<Employee>();
	 Database database = new Database();
	 ArrayList<Order> orders = new ArrayList<Order>();
	 
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
	 private RadioButton Wait_staff_rdb;
	 
	 @FXML
	 private RadioButton Kitchen_Staff_rdb;
	 
	 @FXML 
	 private RadioButton Cashier_rdb;
	 
	 @FXML
	 private ToggleGroup job_type;
	 
	 @FXML
	 private Label login_Label;
	 
	 @FXML 
	 private Pane foodBar;
	 
	 @FXML 
	 private VBox foodBarBox;
	 
	 @FXML
	 private Label totalPriceText;
	 
	 @FXML 
	 private Button pizzaButton;
	 
	 @FXML 
	 private Button burgerButton;
	 
	 @FXML 
	 private Button icecreamButton;
	 
	 @FXML 
	 private Button friesButton;
	 
	 @FXML 
	 private Button sodaButton;
	 
	 @FXML 
	 private Button waterButton;
	 
	 @FXML 
	 private Label failure;
	 
	 @FXML
	 private Label timeText;
	
	 @FXML 
	 private Button timeButton;
	 
	 @FXML 
	 private AnchorPane info;
	 	 
	 @FXML
	 private TextField wage_texField;
	 
	 @FXML
	 private TextField Id_Number_txtField;
	
	 @FXML 
	 private TextField hoursTxt;
	 
	 public void loginreroute(ActionEvent event) 
	 {
		 try 
		{	
		 int value_of_txt; 
		 String text =  txtField.getText();
		 value_of_txt = Integer.parseInt(text);
		 login_Label.setStyle("-fx-text-alignment: center; ");
		 database.connect_to_database();
		 database.setResultset();
		 while(database.resultSet.next())
			{
				  Employee employee = new Employee();
				  employee.setEmployee_name(database.resultSet.getString("Name"));			
				  employee.setId_number(database.resultSet.getString("IdNumber"));
				  employee.setHours(database.resultSet.getInt("Hours"));
				  employee.setWage(database.resultSet.getDouble("Wage"));
				  employee.set_Job_Type(database.resultSet.getString("JobType"));
				  employee.Set_total_Pay();
				  employees.add(employee);				
			}
		 //5555
		 int size = employees.size();
		 System.out.print(size);
		 for(int i=0;i<=size;i++ )
		 {			 
			 System.out.println(i);
		 }
		 for(int i=0;i<=employees.size();i++ )
		 {		 
			 if(employees.get(i).getId_number().equals(text))
			 {
				 if(employees.get(i).getjobType().equals("Manager"))
				 {					 
					 Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
					  stage.setFullScreen(true);
					     database.closeConnection();
						 database.closeresultSet();
						 database.closestatement();
						 database.closeupdateField();
				 }
				 if(employees.get(i).getjobType().equals("WaitStaff"))
				 {
					 Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
				      stage.setFullScreen(true);
				      database.closeConnection();
				      database.closeresultSet();
				      database.closestatement();
					  database.closeupdateField();
				 }
				 
				 if(employees.get(i).getjobType().equals("KitchenStaff"))
				 {
					  Parent root = FXMLLoader.load(getClass().getResource("Kitchen.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
				      stage.setFullScreen(true);
				         database.closeConnection();
						 database.closeresultSet();
						 database.closestatement();
						 database.closeupdateField();
				 }	
				 
				 if(employees.get(i).getjobType().equals("Cashier"))
				 {
					  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
					  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					  scene = new Scene(root);
					  stage.setScene(scene);
					  stage.show();
				      stage.setFullScreen(true);
				         database.closeConnection();
						 database.closeresultSet();
						 database.closestatement();
						 database.closeupdateField();
				 }			
			 }
		  }
		   
		     database.closeConnection();
			 database.closeresultSet();
			 database.closestatement();
			 database.closeupdateField();
		}		 
		 catch(SQLException e)
		 {				 
			 login_Label.setText("Failed to connect to database");
			 database.closeConnection();
   			 database.closeresultSet();
   			 database.closestatement();
   			 database.closeupdateField();
		 }
		 catch(Exception e)
		 {				 
			 login_Label.setText("Incorrect Id number or not found in database");
			 database.closeConnection();
   			 database.closeresultSet();
   			 database.closestatement();
   			 database.closeupdateField();
		 }
	 }
	 
	 public void enter_manager(ActionEvent event) 
	 {
		 
		 /*
		   wage = DecimalFormat.getNumberInstance().parse(wageTxt).doubleValue();
       	          id = Integer.parseInt(id_Number);
       			 verify.setText("Success Please go back to login");
       			 System.out.print("just checking");
		   
		  */
		 try {
			 int lastdatabaseid=0;
	
			database.connect_to_database();
		    database.setResultset();
		    while(database.resultSet.next())
			{
				  Employee employee = new Employee();
				  employee.setdatabaseid(database.resultSet.getInt("employeeid"));
				  employee.setEmployee_name(database.resultSet.getString("Name"));			
				  employee.setId_number(database.resultSet.getString("IdNumber"));
				  employee.setHours(database.resultSet.getInt("Hours"));
				  employee.setWage(database.resultSet.getDouble("Wage"));
				  employee.set_Job_Type(database.resultSet.getString("JobType"));
				  employee.Set_total_Pay();
				  employees.add(employee);
				  lastdatabaseid = employee.getdatabaseid();
			}
		    
          String name = name_texField.getText();
          String wageTxt = wage_texField.getText();
          String id_Number = Id_Number_txtField.getText();
          String hour = hoursTxt.getText();
          String jobType;
          int hours = 0;
          double wage = 0;
          int id=0;
          Boolean checkID = true;
          int arraysize =employees.size();
          Employee tdb = new Employee();
	         
          if(name.equals(""))
          {
          	 verify.setText("Please enter a name");      	
          }         
         else if(wageTxt.equals(""))
         {
        	 verify.setText("Please enter a wage");     
         }
         else if(id_Number.equals(""))
         {
        	 verify.setText("Please enter an ID");     
         }
         else if(hour.equals(""))
         {
        	 verify.setText("Please enter an ID");     
         }
         else if(!Cashier_rdb.isSelected() && !Kitchen_Staff_rdb.isSelected() && !Manager_rdb.isSelected() && !Wait_staff_rdb.isSelected())
      	  {
      		  verify.setText("Please select a job type.");   
      	  }
         else if(verify_Nametext(name))
    	  {	
    			 verify.setText("Please enter name in the correct format");
    	  }
         else if(checkdatabaseid(employees,id_Number))
    	  {
    	   	  verify.setText("ID has been taken, please change it."); 
    	  }
         
          else {
        	  
        	  if(Manager_rdb.isSelected())
        	     {        		  
        		 jobType = "Manager";
        		 tdb.set_Job_Type(jobType);
        	     }
     
        	  else if( Wait_staff_rdb.isSelected())
    		  {        		  
    		    jobType = "WaitStaff";
    		    tdb.set_Job_Type(jobType);
    		    
    		  }
        	  else if(Kitchen_Staff_rdb.isSelected())
    		  {        		  
    		    jobType = "KitchenStaff";
    		    tdb.set_Job_Type(jobType);
    		  }
        	  
        	  else if(Cashier_rdb.isSelected())
    		  {     
        		  jobType = "Cashier";   
        		  tdb.set_Job_Type(jobType);
    		  }
        	  int newdatabaseid=lastdatabaseid;
        	  System.out.print(newdatabaseid);
        	  wage = DecimalFormat.getNumberInstance().parse(wageTxt).doubleValue();
   	          id = Integer.parseInt(id_Number);  
   	          hours = Integer.parseInt(hour);
   	          tdb.setHours(hours);
	          tdb.setEmployee_name(name);
   	          tdb.setWage(wage);
   	          tdb.setId_number(id_Number);
   	          tdb.setdatabaseid(newdatabaseid);
   	          tdb.Set_total_Pay();
   	          
   	          
   	   
   	          
   	          
   	         String insertSQL = "INSERT INTO Employee (employeeid, Name, IdNumber, Hours, Wage, TotalPay, JobType) VALUES (?, ?, ?, ?, ?, ?, ?)";
			 database.updateField = database.connection.prepareStatement(insertSQL);
			 database.updateField.setInt(1, tdb.getdatabaseid());
			 database.updateField.setString(2, tdb.getEmployee_name());
			 database.updateField.setString(3, tdb.getId_number());
			 database.updateField.setInt(4, tdb.getHours());
			 database.updateField.setDouble(5,tdb.getWage());
			 database.updateField.setDouble(6, tdb.get_totalpay());
			 database.updateField.setString(7, tdb.getjobType());
			 database.updateField.executeUpdate();	 
   			 database.closeConnection();
   			 database.closeresultSet();
   			 database.closestatement();
   			 database.closeupdateField();
   			 verify.setText("Success Please go back to login");
          }
		 }
		catch (IOException e) 
		 {		 
			verify.setText("Please enter the information in the correct format");
		 }
		 catch(SQLException e)
		 {				 
			 verify.setText("Failed to connect to database");
			 System.out.print(e);
		 }
		 catch (NumberFormatException e) 
		 {
			 verify.setText("Please enter the information in the correct format");			 
		 }
		 catch (Exception e) 
		 {			 
			
			 verify.setText("Please enter the information in the correct format");
			 System.out.println(e);
		 }
	 }
	 
	 public Boolean verify_Nametext(String txt) 
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
	 
	 
	 public boolean checkdatabaseid(ArrayList<Employee> employees, String id_Number) 
	 { 
		 boolean checkid = false;
	 for(int i=0;i<employees.size();i++)
     {
   	  if(employees.get(i).getId_number().equals(id_Number))
   	  {
   		checkid =true; 
   		break;
   	  }
     }
	return checkid;
	 }
	 
	 public void switchToCreate_New_User(ActionEvent event) throws IOException
	 {
			  Parent root = FXMLLoader.load(getClass().getResource("New_User.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  stage.setFullScreen(true);
			  
	 }
	 
	 public void switchToSceneWaitstaff(ActionEvent event) throws IOException
	 {
			  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  stage.setFullScreen(true);

	 }

	 public void switchToLogin(ActionEvent event) throws IOException 
	 {
		 	root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
		 	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		 	scene = new Scene(root);
		 	stage.setScene(scene);
		 	stage.show();
			stage.setFullScreen(true);
	 }
	 
	 public void switchToKitchenstaff(ActionEvent event) throws IOException
	 {
			  Parent root = FXMLLoader.load(getClass().getResource("Kitchen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  stage.setFullScreen(true);
	 }
		 
	 public void addFoodBar(ActionEvent event)throws IOException
	 {
		 
		 Font font21 = Font.font("Modern No. 20", 21);
		 Font font29 = Font.font("Modern No. 20", 29);
		 
		 Pane foodbar = new AnchorPane();
		 Label foodText = new Label(null);
		 Label priceText = new Label(null);
		 
		 
		 
		 foodbar.setStyle("-fx-background-color: #ffffff; ");
		 foodbar.setMinWidth(683);
		 foodbar.setMinHeight(68);
		 AnchorPane.setTopAnchor(foodbar, ph);
		 //foodbar.setPadding(new Insets(0,0,0,0));
		 foodbar.setId("foodbar"+fb);
		 
		 Spinner<Integer> spinner = new Spinner<> (1,1000,1);
		 spinner.setMaxWidth(100);
		 spinner.setMinHeight(49);
		 spinner.relocate(40.0,10.0);
		 spinner.setId("spinner"+fb);

		 foodText.setMinWidth(179);
		 foodText.setMinHeight(56);
		 foodText.relocate(150.0,8.0);
		 foodText.setFont(font29);
		 foodText.setId("foodText"+fb);
		 
		 Label dollarSign = new Label("$");
		 dollarSign.setMinWidth(16);
		 dollarSign.setMinHeight(56);
		 dollarSign.relocate(349.0,8.0);
		 dollarSign.setFont(font29);
		 dollarSign.setId("dollarSign"+fb);
		 
		 priceText.setMinWidth(103);
		 priceText.setMinHeight(56);
		 priceText.relocate(366.0,8.0);
		 priceText.setFont(font29);
		 priceText.setId("priceText"+fb);
		 
		 Button deleteButton= new Button("Delete");
		 deleteButton.setMinWidth(90);
		 deleteButton.setMinHeight(42);
		 deleteButton.relocate(482.0,14.0);
		 deleteButton.setStyle("-fx-background-color: #ff0000; ");
		 deleteButton.setFont(font21);
		 deleteButton.setId("deleteButton"+fb);
		 deleteButton.setOnAction(new EventHandler<ActionEvent>() 
		 	{
				@Override
				public void handle(ActionEvent event) 
				{
					if(deleteButton.isArmed()==true) 
					 {
						 deleteButton.getParent().setVisible(false);
					 }
				}
		 	});
		 
		 Button noteButton= new Button("Notes");
		 noteButton.setMinWidth(90);
		 noteButton.setMinHeight(42);
		 noteButton.relocate(584.0,14.0);
		 noteButton.setStyle("-fx-background-color: #8e8e8e; ");
		 noteButton.setFont(font21);
		 noteButton.setId("noteButton"+fb);
		 noteButton.setOnAction(new EventHandler<ActionEvent>() 
		 	{
				@Override
				public void handle(ActionEvent event) {
					if(noteButton.isArmed()==true) 
					 {
						 try 
						 {
							notesWindow(event);	
						 } 
						 catch (IOException e) 
						 {
							// TODO Auto-generated catch block
							e.printStackTrace();
						 }
					 }
				}
		 	});
		 
		 
		 
		 if(pizzaButton.isArmed()==true) 
		 {
			 foodText.setText("Pizza");
			 priceText.setText("24.23");
		 }
		 else if(burgerButton.isArmed()==true) 
		 {
			 foodText.setText("Burger");
			 priceText.setText("8.42");
		 }
		 else if(icecreamButton.isArmed()==true) 
		 {
			 foodText.setText("Ice Cream Scoop");
			 priceText.setText("3.50");
		 }
		 else if(friesButton.isArmed()==true) 
		 {
			 foodText.setText("Fries");
			 priceText.setText("3.02");
		 }
		 else if(sodaButton.isArmed()==true) 
		 {
			 foodText.setText("Soda");
			 priceText.setText("4.30");
		 }
		 else if(waterButton.isArmed()==true) 
		 {
			 foodText.setText("Water Bottle");
			 priceText.setText("2.54");
		 }
		 
		 
		 foodbar.getChildren().addAll(spinner,foodText,dollarSign,priceText,deleteButton,noteButton);
		
		 
		 foodBarBox.getChildren().addAll(foodbar);
		 
		 
		 ph += 100.0;
		 fb ++;
		 
		 
		 Double totalPriceDub;
		 String text = priceText.getText();
		 totalPriceDub = Double.parseDouble(text);
		 
		 tp = tp + totalPriceDub;
		 
		 String totalPriceStr = Double.toString(tp);
		 totalPriceText.setText(totalPriceStr);
		
		 
	 }
	 
	 public void pizzaFoodBar(ActionEvent event)throws IOException
	 {
		 /*
		 addFoodBar(event);
		 foodText.setText("Pizza");
		 priceText.setText("24.23");
		 */
	 }
	 
	 public void burgerFoodBar(ActionEvent event)throws IOException
	 {
		 /*
		 addFoodBar(event);
		 foodText.setText("Burger");
		 priceText.setText("8.42");
		 
		 ph += 100.0;
		 */
	 }
	 
	 public void notesWindow(ActionEvent event)throws IOException{
		 
		 Stage note = new Stage();
		 
		 note.initModality(Modality.APPLICATION_MODAL);
		 note.setTitle("Note");
		 note.setMinWidth(400);
		 note.setMinHeight(200);
		 
		 TextField noteText = new TextField();
		 noteText.setText(null);
		 noteText.setMinHeight(180);
		 noteText.setStyle("-fx-text-alignment: TOP_LEFT; ");
		 
		 Button closeButton = new Button("Complete");
		 closeButton.setOnAction(e -> note.close());
		 closeButton.relocate(350.0,170.0);
		 
		 VBox layout = new VBox(10);
		 layout.getChildren().addAll(noteText,closeButton);
		 
		 Scene noteScene = new Scene(layout);
		 note.setScene(noteScene);
		 note.showAndWait();
		 
	 }
	 
	 public void deleteFoodBar(ActionEvent event)throws IOException
	 {
		
		 
		 
	 }
	 
	 public void totalPrice(ActionEvent event)throws IOException
	 {
		 String totalPriceStr = Double.toString(tp);
		 totalPriceText.setText(totalPriceStr);
		 
	 }
	 
	 public void showfailedScreen(String err) 
	 {
		 stage = new Stage();
	 		
		 		try {
			    Parent root = FXMLLoader.load(getClass().getResource("Failed.fxml"));
				Scene scene = new Scene(root,1069,707);
				Image icon= new Image("food.png");
				stage.getIcons().add(icon);
				stage.setTitle("Restauraunt");
				stage.setScene(scene);
				stage.show();	
				stage.setFullScreen(true);
		 }
		 catch(Exception e)
		 {
		     
			 System.out.println(err); 
		 }
		 //failed_reasons.setMinWidth(179);
		 //failed_reasons.setMinHeight(56);
		 //failed_reasons.relocate(200,200);
		
	
	 }
	 
	 
	 public void showTime()
	 {
		 
		 //timeText.setText("12:30");
		 	//run();
		 
		 
	 }
	 
	 
	 public void run1(ActionEvent event) throws InterruptedException
	 {
		 
		Thread t = new Thread(()->{
			try {
			 for(int i=0; i<=100;i++) 
				{
				 timeFormat = new SimpleDateFormat("hh:mm:ss a");
			      time = timeFormat.format(Calendar.getInstance().getTime());				      
			    
				System.out.println(time);
				System.out.println(i);
				 Platform.runLater(()->
				 {								      
				    timeText.setText(time);
					 
			     });
				}
			 Thread.sleep(1000);
			}
			catch(Exception e)
			{				
				System.out.print(e);
			}
		});
	 
		t.start();
		System.out.println("it worked");
		
		 /*
		 timeFormat = new SimpleDateFormat("hh:mm:ss a");
		 Platform.runLater(()->
		 {		
			 for(int i=0; i<=1000;i++)
			 {
		   time = timeFormat.format(Calendar.getInstance().getTime());				      
		    timeText.setText(time);
			 }
	     });
	*/	 
		 
	 }
	 
	 
	 
}
	 

