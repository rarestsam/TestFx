package application;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.text.html.ImageView;

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
import javafx.scene.text.TextAlignment;

public class SceneController extends Thread
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
	 Thread mythread = new Thread();
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
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 public void loginreroute(ActionEvent event) 
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
		 login_Label.setStyle("-fx-text-alignment: center; ");
		 
		 if( value_of_txt < 10) 
		     {
			  Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
		      stage.setFullScreen(true);

		     }
	
		 if(value_of_txt >= 10 && value_of_txt <= 20)
		 {
			  Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
			  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			  scene = new Scene(root);
			  stage.setScene(scene);
			  stage.show();
			  stage.setFullScreen(true);

		 }
		 if(value_of_txt > 20)
		 {
			 login_Label.setText("Incorrect Password");
		 }
		}
		 catch(Exception e)
		 {	
			 
			 login_Label.setText("Please enter in the correct format. No letters and symbols");
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
		 System.out.println("added butt");
		 
		 foodBarBox.getChildren().addAll(foodbar);
		 System.out.println(fb);
		 
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
	 
	 
	 public void run1(ActionEvent event) throws IOException
	 {
		 // mythread.run(new Thread<run>);
		// timeButton.setOnAction(new EventHandler<ActionEvent>() 
		 SceneController sceneController = new SceneController();
	
		 sceneController.start();
		
				
				
	}
	 
	 
	 @Override
	 public void run()
	 {		 
		 timeFormat = new SimpleDateFormat("hh:mm:ss a");
		// if(timeButton.isArmed()==true) {				 					   
		 		Pane info = new AnchorPane();
				for(int i=0; i<=5;i++) 
				{				
				Label timeText = new Label();				
			    timeText.setMinWidth(103);
				timeText.setMinHeight(56);
			    timeText.relocate(180,3.0);
				timeText.setStyle("-fx-background-color:  #ff0000; ");
				info.getChildren().addAll(timeText);
				time = timeFormat.format(Calendar.getInstance().getTime());				
				timeText.setText(time);
				System.out.println(timeText.getText());
				//System.out.println(timeText.getText());
				  try {
				   Thread.sleep(1000);
				  } 
				  catch (InterruptedException e) 
				  {
				   e.printStackTrace();
				  }
				  System.out.println(i);
			}
	 }
			
}
	 

