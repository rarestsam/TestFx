package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.TextAlignment;

public class SceneController {
	private static final Paint WHITE = null;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private String employee_name;
	private String order_number;	
	private String table_number_text;
	private String lastorderstring;
	private String newordernumber1;
	private String time;

	private int neworderid;
	
	private int fb = 0;
	private int on = 1;
	private int o=0;
	private int os =0;
	private int currentbutton = 110000;
	private int iterator = 0;
	private int lastordernumber;
	private int newordernumber;
	private double ph = 200.0;
	private double tp = 0.0;
	private String pricetotalbutton = "";
	
	private Double priceText2 = null;
	private Double totalPriceDub;

	private boolean checkdelete = false;

	ArrayList<String> order = new ArrayList<String>();
	ArrayList<Order> orders = new ArrayList<Order>();
	ArrayList<Order> orderdone1 = new ArrayList<Order>();
	ArrayList<Employee> employees = new ArrayList<Employee>();
	ArrayList<String> foodbarList = new ArrayList<String>();
	ArrayList<String> testNote= new ArrayList<String>();
	
	HashMap<String,String> map= new HashMap<>();
	HashMap<String,String> nameMap= new HashMap<>();
	HashMap<String,Integer> amountMap= new HashMap<>();
	HashMap<String,String> priceMap= new HashMap<>();
	
	private Order new_order = new Order();
	private SimpleDateFormat timeFormat;
	private Calendar calendar;
	private Database database = new Database();
	
	
	@FXML
    private VBox employeeClocking;

    @FXML
    private DatePicker myDatePicker;
    
	@FXML
	private Label workerUsername10;
	
	@FXML
	private Label Label1;
	
	@FXML
	private Label Label2;
	
	@FXML
	private Label Label3;
		
	@FXML
	private Label Label4;
	
	@FXML
	private Label errorKO;
	
	@FXML
	private Label notesText2;
	
	@FXML
	private Label notesText1;
	
	@FXML
	private Label foodText2;
	
	@FXML
	private Label priceText12;
	
	@FXML
	private Label workerUsernamek;
	
	@FXML
	private Label totalPriceText1;
	
	@FXML
	private Label foodText1;
	
	@FXML 
	private Label tablek;
	
	@FXML
	private Label orderNumberk;
	
	@FXML
	private Label priceText11;
	
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
	 private VBox foodBarBox1;
	 
	 @FXML
	 private VBox buttonbarbox12;
	 
	 @FXML
	 private VBox orderlistK;
	 
	@FXML 
	 private VBox orderList;
	
	@FXML
	private VBox foodBarBox3;

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
	 private Button completeOrder;
	
	@FXML 
	 private Button clearButton;

	@FXML
	private AnchorPane info;

	@FXML
	private TextField wage_texField;

	@FXML
	private TextField Id_Number_txtField;

	@FXML
	private TextField hoursTxt;

	@FXML
	private TextField table_number;

	@FXML
	private TextField customers_name;
	
	@FXML
	private TextField customers_number;
	
	@FXML
	private Label workerUsername;

	@FXML
	private Label orderNumber;

	@FXML
	private Label checktable;
	
    @FXML
	private RadioButton Cashier_rdbE;

	@FXML
	private ToggleGroup Fired;

	 @FXML
	 private RadioButton Kitchen_Staff_rdbE;

	 @FXML
	private RadioButton Manager_rdbE;
	
	@FXML
	private RadioButton Wait_staff_rdbE;

	 @FXML
	 private TextField employeeId_text_field;

	 @FXML
	 private TextField employeehours_text_field;

	 @FXML
	 private TextField employeepass_text_field;

	 @FXML
	 private TextField employeewage_text_field;

	 @FXML
     private Label errorlabeledit;

	 @FXML
	 private ToggleGroup job_typeE;
	 
	 @FXML
	 private RadioButton EmployedStatusRBE;
	 
	 @FXML 
	 private VBox foodInfoBox;

	 @FXML
	 private Label customers_name2;
	 
	 @FXML 
	 private Label customers_number2;
	 
	 @FXML
	 private Label tableNumber;
	 
	 @FXML
	 private VBox foodBar21;
	 
	 @FXML
	 private Label orderNumber1;
	 
	 @FXML
	 private Label totalPriceText12;
	 
	 @FXML
	 private VBox foodBarBox18;
	// BufferedWriter writer2 = new BufferedWriter(new
	// FileWriter("order_number.txt"));

	 
	 
	 public void pulse(ActionEvent event) {
			/*
			 * for(int i=0; i<new_order.getfoodsize();i++) {
			 * System.out.println(new_order.getFood_name(i)); } int lastordernumber; int
			 * newordernumber; String lastorderstring ; String newordernumber1; id =
			 * Integer.parseInt(id_Number);
			 */

			try {

				database.connect_to_database();
				database.setResultsetorder();
				new_order.setnullall();
				
				while (database.resultSet.next()) {
					lastorderstring = database.resultSet.getString("OrderNumber");
				}

				lastordernumber = Integer.parseInt(lastorderstring);
				newordernumber = lastordernumber + 1;
				newordernumber1 = String.valueOf(newordernumber);

				BufferedReader readeremp = new BufferedReader(new FileReader("employee_name.txt"));
				employee_name = readeremp.readLine();
				readeremp.close();
				workerUsername.setText(employee_name);
				orderNumber.setText(newordernumber1);
				
			} catch (Exception e) 
			{
				System.out.print(e);

			}
		}
		public void clear(ActionEvent event) throws IOException
		{
			new_order.setnullall();
			foodBarBox.getChildren().clear();
			table_number.setText("");
			totalPriceText.setText("0.00");
			tp=0.0;
			nameMap.clear();
			amountMap.clear();
			priceMap.clear();
			
		}
	 
	 
	 
	 
	 
	public void loginreroute(ActionEvent event) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("employee_name.txt"));
			BufferedWriter writerjobtitle = new BufferedWriter(new FileWriter("jobtitle"));
			String jobtitle ="";
			int value_of_txt;
			String text = txtField.getText();
			value_of_txt = Integer.parseInt(text);
			login_Label.setStyle("-fx-text-alignment: center; ");
			database.connect_to_database();
			database.setResultset();
			while (database.resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployee_name(database.resultSet.getString("Name"));
				employee.setId_number(database.resultSet.getString("IdNumber"));
				employee.setHours(database.resultSet.getInt("Hours"));
				employee.setWage(database.resultSet.getDouble("Wage"));
				employee.set_Job_Type(database.resultSet.getString("JobType"));
				employee.setpassword(database.resultSet.getString("Password"));
				employee.Set_total_Pay();
				employees.add(employee);
			}
			/*
			 * int size = employees.size(); System.out.print(size); for(int i=0;i<=size;i++
			 * ) { System.out.println(i); }
			 */
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i).getpassword().equals(text)) 
				{
					if (employees.get(i).getjobType().equals("Manager")) 
					{
						Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();
						employee_name = employees.get(i).getEmployee_name();
						jobtitle = employees.get(i).getjobType();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						writer.write(employee_name);
						writer.close();

					}
					if (employees.get(i).getjobType().equals("WaitStaff"))
					{
						Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();
						jobtitle = employees.get(i).getjobType();
						employee_name = employees.get(i).getEmployee_name();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						writer.write(employee_name);
						writer.close();
					}

					if (employees.get(i).getjobType().equals("KitchenStaff")) 
					{
						Parent root = FXMLLoader.load(getClass().getResource("Kitchen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();
						jobtitle = employees.get(i).getjobType();
						employee_name = employees.get(i).getEmployee_name();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						writer.write(employee_name);
						writer.close();
					}

					if (employees.get(i).getjobType().equals("Cashier")) {
						Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();
						jobtitle = employees.get(i).getjobType();
						employee_name = employees.get(i).getEmployee_name();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						writer.write(employee_name);
						writer.close();
					}
				}
			}
		} 
		catch (SQLException e) 
		{
			login_Label.setText("Failed to connect to database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		}
		catch (Exception e) 
		{
			System.out.print(e);
			login_Label.setText("Incorrect Id number or not found in database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		}
	}

	public void switchToManager(ActionEvent event) throws IOException
	{

		Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
		database.closeConnection();
		database.closeresultSet();
		database.closestatement();
		database.closeupdateField();

	}

	public void enter_manager(ActionEvent event) {

		/*
		 * wage = DecimalFormat.getNumberInstance().parse(wageTxt).doubleValue(); id =
		 * Integer.parseInt(id_Number);
		 * verify.setText("Success Please go back to login");
		 * System.out.print("just checking");
		 * 
		 */
		
		try {
			int lastdatabaseid = 0;

			database.connect_to_database();
			database.setResultset();
			while (database.resultSet.next()) {
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
			int id = 0;
			Boolean checkID = true;
			int arraysize = employees.size();
			Employee tdb = new Employee();

			if (name.equals("")) {
				verify.setText("Please enter a name");
			} else if (wageTxt.equals("")) {
				verify.setText("Please enter a wage");
			} else if (id_Number.equals("")) {
				verify.setText("Please enter an ID");
			} else if (hour.equals("")) {
				verify.setText("Please enter an ID");
			} else if (!Cashier_rdb.isSelected() && !Kitchen_Staff_rdb.isSelected() && !Manager_rdb.isSelected()
					&& !Wait_staff_rdb.isSelected()) {
				verify.setText("Please select a job type.");
			} else if (verify_Nametext(name)) {
				verify.setText("Please enter name in the correct format");
			} else if (checkdatabaseid(employees, id_Number)) {
				verify.setText("ID has been taken, please change it.");
			}

			else {

				if (Manager_rdb.isSelected()) {
					jobType = "Manager";
					tdb.set_Job_Type(jobType);
				}

				else if (Wait_staff_rdb.isSelected()) {
					jobType = "WaitStaff";
					tdb.set_Job_Type(jobType);

				} else if (Kitchen_Staff_rdb.isSelected()) {
					jobType = "KitchenStaff";
					tdb.set_Job_Type(jobType);
				}

				else if (Cashier_rdb.isSelected()) {
					jobType = "Cashier";
					tdb.set_Job_Type(jobType);
				}
				int newdatabaseid = lastdatabaseid +1;
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
				database.updateField.setDouble(5, tdb.getWage());
				database.updateField.setDouble(6, tdb.get_totalpay());
				database.updateField.setString(7, tdb.getjobType());
				database.updateField.executeUpdate();
				database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
				verify.setText("Success Please press the back button to exit");
			}
		} catch (IOException e) {
			verify.setText("Please enter the information in the correct format");
		} catch (SQLException e) {
			verify.setText("Failed to connect to database");
			System.out.print(e);
		} catch (NumberFormatException e) {
			verify.setText("Please enter the information in the correct format");
		} catch (Exception e) {

			verify.setText("Please enter the information in the correct format");
			System.out.println(e);
		}
	}

	public Boolean verify_Nametext(String txt) 
	{
		try {
			int s = Integer.parseInt(txt);
			return true;
		   } 
		catch (Exception e)
		{
			return false;
		}
	}

	public boolean checkdatabaseid(ArrayList<Employee> employees, String id_Number) 
	{
		boolean checkid = false;
		for (int i = 0; i < employees.size(); i++) 
		{		
			if (employees.get(i).getId_number().equals(id_Number)) 
			{
				checkid = true;
				break;
			}
		}
		return checkid;
	}

	public void switchToCreate_New_User(ActionEvent event) throws IOException 
	{
		Parent root = FXMLLoader.load(getClass().getResource("New_User.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}

	public void switchToCreate_Edit_User(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("edituser.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}
	
	
	public void switchToemployeesclockin(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Clock_data.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}
	
	public void switchToSceneWaitstaff(ActionEvent event) throws IOException 
	{		
		Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}

	public void switchToLogin(ActionEvent event) throws IOException 
	{
		root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}

	public void switchToKitchenstaff(ActionEvent event) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("Kitchen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}
	
	public void switchTomanager(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}

	public void addFoodBar(ActionEvent event) {
		try {
			
			Font font14 = Font.font("Modern No. 20", 14);
			Font font15 = Font.font("Modern No. 20", 15);
			Font font21 = Font.font("Modern No. 20", 21);
			Font font29 = Font.font("Modern No. 20", 29);

			Pane foodbar = new AnchorPane();
			Label foodText = new Label(null);
			Label priceText = new Label(null);

			foodbar.setStyle("-fx-background-color: #ffffff; ");
			foodbar.setMinWidth(683);
			foodbar.setMinHeight(68);
			AnchorPane.setTopAnchor(foodbar, ph);
			foodbar.setId("foodbar" + fb);
			foodbarList.add(foodbar.getId());
			
			Spinner<Integer> spinner = new Spinner<>(1, 1000, 1);
			spinner.setMaxWidth(100);
			spinner.setMinHeight(49);
			spinner.relocate(40.0, 10.0);
			spinner.setId("spinner" + fb);
			
			TextField foodAmountText = new TextField("1");
			foodAmountText.setMaxWidth(60);
			foodAmountText.relocate(40.0, 16.0);
			foodAmountText.setFont(font21);
			
			Button plusButton = new Button("+");
			plusButton.setMaxWidth(20);
			plusButton.setMaxHeight(9);
			plusButton.relocate(105.0, 8.0);
			plusButton.setStyle("-fx-background-color: #d4c935; ");
			plusButton.setFont(font14);
			plusButton.setId("plusButton" + fb);
			plusButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					
					
					int foodAmountTextInt= Integer.parseInt(foodAmountText.getText());
					foodAmountTextInt++;//
					foodAmountText.setText(Integer.toString(foodAmountTextInt));
					
					Double foodAmountTextDub = Double.parseDouble(foodAmountText.getText());
					
					if(foodText.getText()=="Pizza") 
					{
						priceText2= 24.23;
					}
					if(foodText.getText()=="Burger") 
					{
						priceText2 = 8.42;
					}
					if(foodText.getText()=="Ice Cream Scoop") 
					{
						priceText2 = 3.50;
					}
					if(foodText.getText()=="Fries") 
					{
						priceText2 = 3.02;
					}
					if(foodText.getText()=="Soda") 
					{
						priceText2 = 4.30;
					}
					if(foodText.getText()=="Water Bottle") 
					{
						priceText2 = 2.54;
					}
					
					Double totalp = foodAmountTextDub*priceText2;
					String totalpStr = Double.toString(totalp);
					
					priceText.setText(totalpStr);
					
					amountMap.replace(foodbar.getId(),Integer.parseInt(foodAmountText.getText()));
					priceMap.replace(foodbar.getId(),priceText.getText());
					System.out.println("Plus " + priceMap);
					
					
				}
			});
			
			Button minusButton = new Button("-");
			minusButton.setMaxWidth(20);
			minusButton.setMaxHeight(9);
			minusButton.relocate(105.0, 34.0);
			minusButton.setStyle("-fx-background-color: #d4c935; ");
			minusButton.setFont(font15);
			minusButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{	
					String foodAmountActual= String.valueOf(foodAmountText.getText());
					
					if(!foodAmountActual.equals("1")) {
						int foodAmountTextInt= Integer.parseInt(foodAmountText.getText());
						foodAmountTextInt--;
						foodAmountText.setText(Integer.toString(foodAmountTextInt));
						
						Double foodAmountTextDub = Double.parseDouble(foodAmountText.getText());
						
						if(foodText.getText()=="Pizza") {
							priceText2= 24.23;
						}
						if(foodText.getText()=="Burger") {
							priceText2 = 8.42;
						}
						if(foodText.getText()=="Ice Cream Scoop") {
							priceText2 = 3.50;
						}
						if(foodText.getText()=="Fries") {
							priceText2 = 3.02;
						}
						if(foodText.getText()=="Soda") {
							priceText2 = 4.30;
						}
						if(foodText.getText()=="Water Bottle") {
							priceText2 = 2.54;
						}
						
						Double totalp = foodAmountTextDub*priceText2;
						String totalpStr = Double.toString(totalp);
						
						priceText.setText(totalpStr);
						
						amountMap.replace(foodbar.getId(),Integer.parseInt(foodAmountText.getText()));
						priceMap.replace(foodbar.getId(),priceText.getText());
						System.out.println("Minus " +priceMap);
						
						
					}
					
				}
			});

			foodText.setMinWidth(179);
			foodText.setMinHeight(56);
			foodText.relocate(150.0, 8.0);
			foodText.setFont(font29);
			foodText.setId("foodText" + fb);

			Label dollarSign = new Label("$");
			dollarSign.setMinWidth(16);
			dollarSign.setMinHeight(56);
			dollarSign.relocate(349.0, 8.0);
			dollarSign.setFont(font29);
			dollarSign.setId("dollarSign" + fb);

			priceText.setMinWidth(103);
			priceText.setMinHeight(56);
			priceText.relocate(366.0, 8.0);
			priceText.setFont(font29);
			priceText.setId("priceText" + fb);

			Button deleteButton = new Button("Delete");
			deleteButton.setMinWidth(90);
			deleteButton.setMinHeight(42);
			deleteButton.relocate(482.0, 14.0);
			deleteButton.setStyle("-fx-background-color: #ff0000; ");
			deleteButton.setFont(font21);
			deleteButton.setId("deleteButton" + fb);
			deleteButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) 
				{
					if (deleteButton.isArmed() == true)
					{
						foodBarBox.getChildren().remove(deleteButton.getParent());
						nameMap.replace(foodbar.getId(),null);
						amountMap.replace(foodbar.getId(),null);
						priceMap.replace(foodbar.getId(),null);

						iterator = iterator -1;
					}
				}
			});
			
			Button noteButton = new Button("Notes");
			noteButton.setMinWidth(90);
			noteButton.setMinHeight(42);
			noteButton.relocate(584.0, 14.0);
			noteButton.setStyle("-fx-background-color: #8e8e8e; ");
			noteButton.setFont(font21);
			noteButton.setId("noteButton" + fb);
			noteButton.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
									
							Stage note = new Stage();

							note.initModality(Modality.APPLICATION_MODAL);
							note.setTitle("Note");
							note.setMinWidth(400);
							note.setMinHeight(200);

							Font font29 = Font.font("Modern No. 20", 29);

							TextArea noteText = new TextArea();
							noteText.setText(null);
							noteText.setMinHeight(180);
							noteText.setStyle("-fx-text-alignment: TOP_LEFT; ");
							
							
							Button completeButton = new Button("Complete");
							completeButton.setFont(font29);
							completeButton.relocate(350.0, 170.0);
							completeButton.setOnAction(new EventHandler<ActionEvent>() {
								@Override
								public void handle(ActionEvent event) {
									String noteEntered= noteText.getText();
									testNote.add(noteEntered);
									if(map.get(foodbar.getId())== foodbar.getId()) {
										System.out.println("id found");
										map.replace(foodbar.getId(),noteEntered);
									}
									else {
										System.out.println("id NOT found");
										map.put(foodbar.getId(),noteEntered);
									}
								}
									
							});

							VBox layout = new VBox(10);
							layout.getChildren().addAll(noteText, completeButton);

							Scene noteScene = new Scene(layout);
							note.setScene(noteScene);
							note.showAndWait();
				}
			});
			
			if (pizzaButton.isArmed() == true) {
				foodText.setText("Pizza");
				priceText.setText("24.23");
				priceText2= 24.23;
			} else if (burgerButton.isArmed() == true) {
				foodText.setText("Burger");
				priceText.setText("8.42");
				priceText2= 24.23;
			} else if (icecreamButton.isArmed() == true) {
				foodText.setText("Ice Cream Scoop");
				priceText.setText("3.50");
				priceText2= 3.50;
			} else if (friesButton.isArmed() == true) {
				foodText.setText("Fries");
				priceText.setText("3.02");
				priceText2= 3.02;
			} else if (sodaButton.isArmed() == true) {
				foodText.setText("Soda");
				priceText.setText("4.30");
				priceText2= 4.30;
				// new_order.(4.30, iterator);
			} else if (waterButton.isArmed() == true) {
				foodText.setText("Water Bottle");
				priceText.setText("2.54");
				priceText2= 2.54;
			}
			
			foodbar.getChildren().addAll(foodAmountText, plusButton, minusButton, foodText, dollarSign, priceText, deleteButton, noteButton);
			foodBarBox.getChildren().addAll(foodbar);
			
			nameMap.put(foodbar.getId(),foodText.getText());
			amountMap.put(foodbar.getId(),Integer.parseInt(foodAmountText.getText()));
			priceMap.put(foodbar.getId(),priceText.getText());
			
			ph += 100.0;
			fb++;

			
			totalPriceDub = Double.parseDouble(priceText.getText());

			tp = tp + totalPriceDub;

			String totalPriceStr = Double.toString(tp);
			totalPriceText.setText(totalPriceStr);
			iterator++;
			
		} catch (Exception e) {
			System.out.print(e);
		}
	}

	
	public void complete(ActionEvent event) 
	{
		/*
		 * for(int i=0; i<new_order.getfoodsize();i++) {
		 * System.out.println(new_order.getFood_name(i)); }
		 */
		
		
		for(int i=0;i<fb;i++) {
		
			if(nameMap.get("foodbar"+i)!= null)
			{
				new_order.setFood_name(nameMap.get("foodbar"+i),i);
			}
			else {
				//new_order.setFood_name(null,i);
			}
			if(amountMap.get("foodbar"+i)!= null) 
			{
				new_order.setamount(amountMap.get("foodbar"+i),i);
			}
			else {
				//new_order.setamount(null,i);
			}
			if(priceMap.get("foodbar"+i)!= null) 
			{
				Double priceinMap= Double.parseDouble(priceMap.get("foodbar"+i));
				new_order.setFood_price(priceinMap,i);
			}
			else {
				//new_order.setFood_price(null,i);
			}
			if(priceMap.get("foodbar"+i)!= null) 
			{
			
				new_order.setNotes(map.get("foodbar" + i),i);
			}
		//	System.out.println("Name "+ nameMap.get("foodbar"+i));
		//	System.out.println("Amount "+ amountMap.get("foodbar"+i));
		//System.out.println("Price "+ priceMap.get("foodbar"+i));
		}
		//System.out.println(new_order.getFood_name(0));
		
		try
		{
			SimpleDateFormat timeFormat;
			SimpleDateFormat dateFormat;
			String time;
			String date;

			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			time = timeFormat.format(Calendar.getInstance().getTime());
			date = dateFormat.format(Calendar.getInstance().getTime());


			String incomplete = "incomplete";
			String orderpaid = "unpaid";
			String tableNumber = table_number.getText();
			String phonenumber = customers_number.getText();
			String customername = customers_name.getText();
			

			if(phonenumber.equals("") && !customername.equals(""))
			{
				
				checktable.setText("Enter Customer phonenumber");

			}

			else if(!phonenumber.equals("") && customername.equals(""))
			{
				
				checktable.setText("Enter Customer name ");

			}
			
			else if (tableNumber.equals(""))
			{
				if((phonenumber.equals("") && customername.equals("")))
						{
							checktable.setText("Enter Customer name and number or Table Number");
						}
				System.out.println("got here");
			} 
			
			else 
			{
				database.connect_to_database();
				int tablenumber;
				int orderid = 0;
				tablenumber = Integer.parseInt(tableNumber);
				BufferedReader readeremp = new BufferedReader(new FileReader("employee_name.txt"));
				employee_name = readeremp.readLine();
				neworderid = orderid + 1;				
				new_order.setEmployee_Name(employee_name);
				new_order.setOrder_number(newordernumber1);
				new_order.setTable_number(tableNumber);
				new_order.setDate(date);
				new_order.setTime_Of_Order(time);
				new_order.setComplete(incomplete);
				new_order.setPaid(orderpaid);
				
				String insertSQL = "INSERT INTO Orders (ID,OrderNumber, Customername, PhoneNumber, WaitStaff,Tablenumber,TimeofOrder, month_day_year, Price, Complete, Paid, "
						+ "item1, item1amount, notes1, item1cost, item2, item2amount, notes2, item2cost, item3, item3amount, notes3, item3cost, item4, item4amount, notes4, item4cost, "
						+ "item5, item5amount, notes5, item5cost, item6, item6amount, notes6, item6cost, item7, item7amount, notes7, item7cost, item8, item8amount, notes8, item8cost, "
						+ "item9, item9amount, notes9, item9cost, item10, item10amount, notes10, item10cost, item11, item11amount, notes11, item11cost, item12, item12amount, notes12, item12cost,"
						+ " item13, item13amount, notes13, item13cost, item14, item14amount, notes14, item14cost, item15, item15amount, notes15, item15cost, item16, item16amount, notes16, item16cost, "
						+ "item17, item17amount, notes17, item17cost, item18, item18amount, notes18, item18cost, item19, item19amount, notes19, item19cost, item20, item20amount, notes20, item20cost) "
	+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				
				database.updateField = database.connection.prepareStatement(insertSQL);
				database.updateField.setInt(1, 7);
				database.updateField.setString(2, new_order.getOrder_number());
				database.updateField.setString(3, customername);
				database.updateField.setString(4, phonenumber);
				database.updateField.setString(5, new_order.getEmployee_Name());
				database.updateField.setString(6, new_order.getTable_number());
				database.updateField.setString(7, new_order.getTime_Of_Order());
				database.updateField.setString(8, new_order.getDate());
				database.updateField.setDouble(9, new_order.getTotal());
				database.updateField.setString(10, new_order.getComplete());
				database.updateField.setString(11, new_order.getPaid());
				
				int foodnameiterator = 12;
				int foodamountiterator = 13;
				int foodnotesiterator = 14;
				int foodpriceiterator = 15;
				
				for(int i = 0; i<new_order.getfoodsize();i++)
				{
		
					
				database.updateField.setString(foodnameiterator, new_order.getFood_name(i));
				database.updateField.setInt(foodamountiterator, new_order.getamount(i));
				database.updateField.setString(foodnotesiterator, new_order.getnote(i));
				database.updateField.setDouble(foodpriceiterator, new_order.getFood_price(i));
				foodnameiterator = foodnameiterator + 4;
				foodamountiterator = foodamountiterator + 4;
				foodnotesiterator =  foodnotesiterator +4;
				foodpriceiterator =foodpriceiterator +4;
				}
								
				database.updateField.executeUpdate();
				database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
							
				checktable.setText("Success");
				
				clear(event);
				readeremp.close();
			}
		} 
		catch (Exception e) {
			checktable.setText("Enter table# in the right format");
			System.out.println(e);
		    //e.printStackTrace();
		}
	}

	public void notesWindow(ActionEvent event) throws IOException
	{

		Stage note = new Stage();

		note.initModality(Modality.APPLICATION_MODAL);
		note.setTitle("Note");
		note.setMinWidth(400);
		note.setMinHeight(200);

		Font font29 = Font.font("Modern No. 20", 29);

		TextArea noteText = new TextArea();
		noteText.setText(null);
		noteText.setMinHeight(180);
		noteText.setStyle("-fx-text-alignment: TOP_LEFT; ");

		Button closeButton = new Button("Complete");
		closeButton.setFont(font29);
		closeButton.setOnAction(e -> note.close());
		closeButton.relocate(350.0, 170.0);

		VBox layout = new VBox(10);
		layout.getChildren().addAll(noteText, closeButton);

		Scene noteScene = new Scene(layout);
		note.setScene(noteScene);
		note.showAndWait();

	}

	public void payTypeWindow(ActionEvent event) throws IOException {

		Stage paymentType = new Stage();

		paymentType.initModality(Modality.APPLICATION_MODAL);
		paymentType.setTitle("Payment Type");
		paymentType.setMinWidth(400);
		paymentType.setMinHeight(500);
		paymentType.setMaxWidth(400);
		paymentType.setMaxHeight(500);

		Font font50 = Font.font("Modern No. 20", 50);

		Button cashButton = new Button("Cash");
		cashButton.setFont(font50);
		cashButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (cashButton.isArmed() == true) {
					try {
						cashErrorWindow(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		Button cardButton = new Button("Card");
		cardButton.setFont(font50);
		cardButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (cardButton.isArmed() == true) {
					try {
						payInfoWindow(event);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		});

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(110, 0, 0, 115));
		layout.getChildren().addAll(cashButton, cardButton);

		Scene noteScene = new Scene(layout);
		paymentType.setScene(noteScene);
		paymentType.showAndWait();

	}

	public void payInfoWindow(ActionEvent event) throws IOException {

		Stage paymentInfo = new Stage();

		paymentInfo.initModality(Modality.APPLICATION_MODAL);
		paymentInfo.setTitle("Payment Information");
		paymentInfo.setMinWidth(600);
		paymentInfo.setMinHeight(400);
		paymentInfo.setMaxWidth(600);
		paymentInfo.setMaxHeight(400);

		Font font29 = Font.font("Modern No. 20", 29);

		Label cardNumText = new Label("Card Number:");
		cardNumText.setFont(font29);
		cardNumText.setStyle("-fx-text-alignment: TOP_LEFT; ");

		TextField cardNum = new TextField();
		cardNum.setText("");
		cardNum.setStyle("-fx-text-alignment: TOP_LEFT; ");

		Label expDateText = new Label("Expiration Date (MM/YY):");
		expDateText.setFont(font29);
		expDateText.setStyle("-fx-text-alignment: TOP_LEFT; ");

		TextField expDateM = new TextField();
		expDateM.setText("");
		expDateM.setMaxWidth(40);
		expDateM.setStyle("-fx-text-alignment: TOP_LEFT; ");

		Label slash = new Label("/");
		slash.setFont(font29);
		slash.setStyle("-fx-text-alignment: TOP_LEFT; ");

		TextField expDateY = new TextField();
		expDateY.setText("");
		expDateY.setMaxWidth(40);
		expDateY.setStyle("-fx-text-alignment: TOP_LEFT; ");

		Label secCodeText = new Label("Security Code:");
		secCodeText.setFont(font29);
		secCodeText.setStyle("-fx-text-alignment: TOP_LEFT; ");

		TextField secCode = new TextField();
		secCode.setText("");
		secCode.setStyle("-fx-text-alignment: TOP_LEFT; ");

		Button closeButton = new Button("Enter");
		closeButton.setFont(font29);
		closeButton.setOnAction(new EventHandler<ActionEvent>()
		{
			@Override
			public void handle(ActionEvent event) {
				if (closeButton.isArmed() == true) {

					String cardNumStr = String.valueOf(cardNum.getText());
					String expDateMStr = String.valueOf(expDateM.getText());
					String expDateYStr = expDateY.getText();
					String secCodeStr = secCode.getText();
					int cardNumLength = 16;
					int expDateLength = 2;
					int secCodeLength = 3;

					// Boolean checkID = true;
					// int arraysize = employees.size();
					// Employee tdb = new Employee();

					if (cardNum.getTypeSelector() == "Integer") {

						try {
							cardErrorWindow(event, "Please Enter Digits Only");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					} 
					else if (cardNumStr.equals("")) {
						try {
							cardErrorWindow(event, "Enter a Cardnumber");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (expDateMStr.equals("")) {
						try {
							cardErrorWindow(event, "Enter an Expiration Month");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (expDateYStr.equals("")) {
						try {
							cardErrorWindow(event, "Enter an Expiration Year");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (secCodeStr.equals("")) {
						try {
							cardErrorWindow(event, "Enter a Security Code");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (cardNumStr.length() != cardNumLength) {
						try {
							cardErrorWindow(event, "Incorrect Number of Digits for Card Number");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (expDateMStr.length() != expDateLength || expDateYStr.length() != expDateLength) {
						try {
							cardErrorWindow(event, "Incorrect Expiration Date Format");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (secCodeStr.length() != secCodeLength) {
						try {
							cardErrorWindow(event, "Incorrect Number of Digits for Security Code");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (secCodeStr.length() != secCodeLength) {
						try {
							cardErrorWindow(event, "Incorrect Number of Digits for Security Code");
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} 
					else if (cardNumStr.equals("1234567890123456") && expDateMStr.equals("10")&& expDateYStr.equals("24")
							&& secCodeStr.equals("123")) {
						try {
							cardErrorWindow(event, "Successful");
							// closeButton.setOnAction(e -> paymentInfo.close());
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					else {
							try {
								System.out.println(
										cardNumStr + " " + expDateMStr + " / " + expDateYStr + " " + secCodeStr);
										cardErrorWindow(event, "Declined");
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						
					}

				}
			}
		});

		// HBox layout0 = new HBox(10);
		// layout0.setPadding(new Insets(0,0,0,-400));
		// layout0.getChildren().addAll(errorText);
		HBox layout1 = new HBox(10);
		layout1.setPadding(new Insets(0, 0, 0, -360));
		layout1.getChildren().addAll(cardNumText, cardNum);
		HBox layout2 = new HBox(10);
		layout2.setPadding(new Insets(0, 0, 0, -360));
		layout2.getChildren().addAll(expDateText, expDateM, slash, expDateY);
		HBox layout3 = new HBox(10);
		layout3.setPadding(new Insets(0, 0, 80, -360));
		layout3.getChildren().addAll(secCodeText, secCode);
		VBox layout4 = new VBox(10);
		layout4.setPadding(new Insets(80, 0, 0, 430));
		layout4.getChildren().addAll(layout1, layout2, layout3, closeButton);

		Scene noteScene = new Scene(layout4);
		paymentInfo.setScene(noteScene);
		paymentInfo.showAndWait();

	}

	public void cashErrorWindow(ActionEvent event) throws IOException {
		/* differentiate between cashier and waitstaff here
		   most likly connect to a database and retrieve employees
		   find where the employyee name in file matches job description and then execute
		 */
		BufferedReader jobstitle = new BufferedReader(new FileReader("jobtitle"));
		String jobtitle = jobstitle.readLine();
		if(jobtitle.equals("Cashier"))
		{
			// textfields
			// parse double
			// pricetotalbutton 
			Stage cashError = new Stage();
			cashError.initModality(Modality.APPLICATION_MODAL);
			cashError.setTitle("Error");
			cashError.setMinWidth(650);
			cashError.setMinHeight(500);
			cashError.setMaxWidth(650);
			cashError.setMaxHeight(500);

			Font font35 = Font.font("Modern No. 20", 35);

			Text errorText = new Text(" Please Complete Cash Payment At Register!");
			errorText.setFont(font35);
			errorText.setStyle("-fx-text-alignment: TOP_LEFT; ");

			VBox layout = new VBox(10);
			layout.setPadding(new Insets(180, 0, 0, 0));
			layout.getChildren().addAll(errorText);

			Scene noteScene = new Scene(layout);
			cashError.setScene(noteScene);
			cashError.showAndWait();
			
		}
		else 
		{
		Stage cashError = new Stage();
		cashError.initModality(Modality.APPLICATION_MODAL);
		cashError.setTitle("Error");
		cashError.setMinWidth(650);
		cashError.setMinHeight(500);
		cashError.setMaxWidth(650);
		cashError.setMaxHeight(500);

		Font font35 = Font.font("Modern No. 20", 35);

		Text errorText = new Text(" Please Complete Cash Payment At Register!");
		errorText.setFont(font35);
		errorText.setStyle("-fx-text-alignment: TOP_LEFT; ");

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(180, 0, 0, 0));
		layout.getChildren().addAll(errorText);

		Scene noteScene = new Scene(layout);
		cashError.setScene(noteScene);
		cashError.showAndWait();
		}
	}

	public void cardErrorWindow(ActionEvent event, String errorString) throws IOException 
	{

		Stage cashError = new Stage();

		cashError.initModality(Modality.APPLICATION_MODAL);
		cashError.setTitle("Error");
		cashError.setMinWidth(650);
		cashError.setMinHeight(500);
		cashError.setMaxWidth(650);
		cashError.setMaxHeight(500);

		Font font35 = Font.font("Modern No. 20", 35);

		Text errorText = new Text(errorString);
		errorText.setFont(font35);
		errorText.setStyle("-fx-text-alignment: TOP_LEFT; ");

		VBox layout = new VBox(10);
		layout.setPadding(new Insets(180, 0, 0, 0));
		layout.getChildren().addAll(errorText);

		Scene noteScene = new Scene(layout);
		cashError.setScene(noteScene);
		cashError.showAndWait();

	}

	public void showfailedScreen(String err)
	{
		stage = new Stage();

		try {
			Parent root = FXMLLoader.load(getClass().getResource("Failed.fxml"));
			Scene scene = new Scene(root, 1069, 707);
			Image icon = new Image("food.png");
			stage.getIcons().add(icon);
			stage.setTitle("Restauraunt");
			stage.setScene(scene);
			stage.show();
			stage.setFullScreen(true);
		} catch (Exception e) {

			System.out.println(err);
		}
	}
	
	public void clockin(ActionEvent event) 
	{
		try
		{
			BufferedWriter writer = new BufferedWriter(new FileWriter("employee_name.txt"));
			BufferedWriter writerID = new BufferedWriter(new FileWriter("IdNumber.txt"));
			BufferedWriter writerjobtitle = new BufferedWriter(new FileWriter("jobtitle"));
			String jobtitle ="";
			int value_of_txt;
			String text = txtField.getText();
			value_of_txt = Integer.parseInt(text);
			login_Label.setStyle("-fx-text-alignment: center; ");
			database.connect_to_database();
			database.setResultset();
			int id = 0;
			while (database.resultSet.next()) {
				Employee employee = new Employee();
				employee.setEmployee_name(database.resultSet.getString("Name"));
				employee.setId_number(database.resultSet.getString("IdNumber"));
				employee.setHours(database.resultSet.getInt("Hours"));
				employee.setWage(database.resultSet.getDouble("Wage"));
				employee.set_Job_Type(database.resultSet.getString("JobType"));
				employee.setpassword(database.resultSet.getString("Password"));
				employee.Set_total_Pay();
				id = database.resultSet.getInt("ID");
				employees.add(employee);
			}

			for (int i = 0; i < employees.size(); i++)
			{
				if (employees.get(i).getpassword().equals(text)) 
					{
					if (employees.get(i).getjobType().equals("Manager"))
					    {
						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();
					
						writerID.write(employees.get(i).getId_number());
						writerID.close();
						
						jobtitle = employees.get(i).getjobType();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						 
						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
			
						int newid = id + 1;

						String insertSQL = "INSERT INTO ClockIn_Out (ID,EmployeeName,IdNumber,ClockInDate,ClockIn) VALUES (?,?,?,?,?)";
						database.updateField = database.connection.prepareStatement(insertSQL);
						database.updateField.setInt(1, newid);
						database.updateField.setString(2, employee_name);
						database.updateField.setString(3, employees.get(i).getId_number());
						database.updateField.setString(4, date);
						database.updateField.setString(5, time);
						database.updateField.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
					}
					if (employees.get(i).getjobType().equals("WaitStaff")) 
					{
						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();
					
						writerID.write(employees.get(i).getId_number());
						writerID.close();
						
						jobtitle = employees.get(i).getjobType();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						
						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
					

						int newid = id + 1;

						String insertSQL = "INSERT INTO ClockIn_Out (ID,EmployeeName,IdNumber,ClockInDate,ClockIn) VALUES (?,?,?,?,?)";
						database.updateField = database.connection.prepareStatement(insertSQL);
						database.updateField.setInt(1, newid);
						database.updateField.setString(2, employee_name);
						database.updateField.setString(3, employees.get(i).getId_number());
						database.updateField.setString(4, date);
						database.updateField.setString(5, time);
						database.updateField.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
				
					}

					if (employees.get(i).getjobType().equals("KitchenStaff")) 
					{						
						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();
					
						writerID.write(employees.get(i).getId_number());
						writerID.close();
						
						jobtitle = employees.get(i).getjobType();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						
						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
						

						int newid = id + 1;

						String insertSQL = "INSERT INTO ClockIn_Out (ID,EmployeeName,IdNumber,ClockInDate,ClockIn) VALUES (?,?,?,?,?)";
						database.updateField = database.connection.prepareStatement(insertSQL);
						database.updateField.setInt(1, newid);
						database.updateField.setString(2, employee_name);
						database.updateField.setString(3, employees.get(i).getId_number());
						database.updateField.setString(4, date);
						database.updateField.setString(5, time);
						database.updateField.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						Parent root = FXMLLoader.load(getClass().getResource("Kitchen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);

					}

					if (employees.get(i).getjobType().equals("Cashier")) {
						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();
					
						writerID.write(employees.get(i).getId_number());
						writerID.close();
						
						jobtitle = employees.get(i).getjobType();
						writerjobtitle.write(jobtitle);
						writerjobtitle.close();
						
						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
					
						int newid = id + 1;


						String insertSQL = "INSERT INTO ClockIn_Out (ID,EmployeeName,IdNumber,ClockInDate,ClockIn) VALUES (?,?,?,?,?)";
						database.updateField = database.connection.prepareStatement(insertSQL);
						database.updateField.setInt(1, newid);
						database.updateField.setString(2, employee_name);
						database.updateField.setString(3, employees.get(i).getId_number());
						database.updateField.setString(4, date);
						database.updateField.setString(5, time);
						database.updateField.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();
						Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
					}
				}
			}

		} catch (SQLException e) 
		{
			System.out.print(e);
			login_Label.setText("Failed to connect to database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		} 
		catch (Exception e) 
		{
			System.out.print(e);
			login_Label.setText("Incorrect Id number or not found in database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		}

	}

	public void clockout(ActionEvent event) {
		try {
			BufferedReader readeremp = new BufferedReader(new FileReader("employee_name.txt"));
			employee_name = readeremp.readLine();
			BufferedReader readerID = new BufferedReader(new FileReader("IdNumber.txt"));
			String ID = readerID.readLine();
			SimpleDateFormat timeFormat;
			SimpleDateFormat dateFormat;
			String time;
			String date;
			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			time = timeFormat.format(Calendar.getInstance().getTime());
			date = dateFormat.format(Calendar.getInstance().getTime());
			database.connect_to_database();
			database.setResultsetclockedin();
			int id = 0;
			while (database.resultSet.next())
			{
			  id = database. resultSet.getInt("ID");
			}
			int newid = id + 1;
	//WHERE favorite_website = 'techonthenet.com'
			//AND customer_id > 6000;
			String SQL = "UPDATE ClockIn_Out " + "SET ClockOutDate = ?, " + "ClockOut = ? " + "WHERE IdNumber = " + ID + " AND ClockInDate = ?" ;
			database.updateField = database.connection.prepareStatement(SQL);
			database.updateField.setString(1,date);
			database.updateField.setString(2,time);
			database.updateField.setString(3, date);
			database.updateField.executeUpdate();
			root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			stage.setFullScreen(true);
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
			readeremp.close();
		} catch (Exception e) {
			System.out.println(e);
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
			e.printStackTrace();
		}

	}
	
	public void addOrder(ActionEvent event) throws InterruptedException
	 {
		//setnullamount(); 
		//setnullfood_name() 	
		//setnullfood_price(); 
		//setnullfoodnotes() 
		
		 Font font33 = Font.font("Modern No. 20", 33);
		 try {

			database.connect_to_database();
			database.setResultsetorder();

			 while(database.resultSet.next())
			 {
				  
				 String completeStatus = database.resultSet.getString("Complete");
				 if(completeStatus.equals("incomplete"))
				 {
			
				Order previousorder = new Order();
				previousorder.setnullall();
				previousorder.setOrder_number(database.resultSet.getString("OrderNumber"));
				previousorder.setWaitress(database.resultSet.getString("WaitStaff"));
				previousorder.setTime_Of_Order(database.resultSet.getString("TimeOfOrder"));
				previousorder.setDate(database.resultSet.getString("month_day_year"));
				previousorder.setTotal1(database.resultSet.getDouble("Price"));
				previousorder.setTable_number(database.resultSet.getString("Tablenumber"));
				
				
				for(int i=0;i<previousorder.getfoodsize(); i++)
				{
					//System.out.println(i);
					int k = i+1;
				
					String name = database.resultSet.getString("item" + k);
			
					if(name.equals("null"))
					{
						
						int j = 7;
						
						System.out.println();
					}
					else
					{
						previousorder.setFood_name(database.resultSet.getString("item" + k), i);
						previousorder.setamount(database.resultSet.getInt("item" + k + "amount"), i);
						previousorder.setNotes(database.resultSet.getString("notes" + k), i);
						previousorder.setFood_price(database.resultSet.getDouble("item" + k + "cost"), i);
						System.out.println(i);
						//System.out.println(previousorder.getamount(i) + previousorder.getFood_name(i) + previousorder.getf));
					}	
					
				}
				
				orders.add(previousorder);
				 }
			 }		 
			    database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
				//System.out.println("made it here2");
		
		for (int i = 0; i < orders.size() ; i++) 
		{
			 Button orderButton = new Button("Order #" + orders.get(o).getOrder_number());
			 orderButton.setFont(font33);
			 String ji = Integer.toString(o);
			 orderButton.setId(ji);
			 orderButton.setMinWidth(704);
			 orderButton.setMinHeight(87);
			 orderButton.setMaxWidth(704);
			 orderButton.setMaxHeight(87);
			 orderButton.setOnAction(new EventHandler<ActionEvent>() 
		 		{
				 	@Override
				 	public void handle(ActionEvent event) 
					{
				 		foodBarBox3.getChildren().clear();
				 		int of = Integer.parseInt(orderButton.getId());
				 		orderNumberk.setText(orders.get(of).getOrder_number());
				 		tablek.setText(orders.get(of).getTable_number());
				 		totalPriceText1.setText(orders.get(of).getTotal1());
				 		workerUsernamek.setText(orders.get(of).getWaitress());
				 		for(int i =0; i<orders.get(of).getfoodsize() ;i++)
				 		{
				 			String namei = orders.get(of).getFood_name(i);
				 			if(namei.equals("null"))
							{
								
				 				int j = 7;
								
								//System.out.println(i);
							
							}
							else
							{
				 			Font font29 = Font.font("Modern No. 20", 29);
				 			String amountStr = orders.get(of).getamountString(i);
				 			String priceStr = Double.toString(orders.get(of).getFood_price(i));		
				 			String lableStr = amountStr + "  " + orders.get(of).getFood_name(i) + "  " + priceStr ;
				 			String lableStr2 = orders.get(of).getnote(i);
							Label foodInfo = new Label(lableStr); //ADD TEXT HERE!!
							foodInfo.setMinWidth(651);
							foodInfo.setMinHeight(71);
							foodInfo.setFont(font29);
							foodInfo.setStyle("-fx-text-alignment: TOP_LEFT; ");
							
							Label foodInfo2 = new Label(lableStr2); //ADD TEXT HERE!!
							foodInfo2.setMinWidth(651);
							foodInfo2.setMinHeight(71);
							foodInfo2.setFont(font29);
							foodInfo2.setStyle("-fx-text-alignment: TOP_LEFT; ");
							
							
							foodBarBox3.getChildren().addAll(foodInfo, foodInfo2);
							}
				 		}
				 		//
				 	    currentbutton = of;
					}				 	
		 		});
			 
			 order.add(o,orderButton.getId());
			 orderList.getChildren().addAll(orderButton);
			 o++;
		}
		//System.out.println(o);
		//System.out.println(orders.size());
		 }
		 catch (IOException | SQLException e) 
		 {
			e.printStackTrace();
			System.out.println(e);
		}
	 }
	 
	 public void orderComplete(ActionEvent event) throws InterruptedException
	 {	 
		 int k = currentbutton;
		 int lastdatabaseid = 0;
		 try 
		 {
			 if(orders.size() == 0)
			 {
				 errorKO.setText("refresh again and hit a button");
				 currentbutton = 11000;
				 System.out.println(k);
			 }
			 else 
			 {				
			errorKO.setText("");
			
			database.connect_to_database();
			String ordernumber = orders.get(k).getOrder_number();
			String SQL = "UPDATE Orders " + "SET Complete = ? " + "WHERE OrderNumber = " + ordernumber;
			database.updateField = database.connection.prepareStatement(SQL);
			database.updateField.setString(1, "Complete");
			database.updateField.executeUpdate();	
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
			errorKO.setText("Success");
			System.out.println( orders.get(k).getOrder_number());
			 }
		} 
		 catch (IOException e) 
		 {
			    database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
		
			   e.printStackTrace();
		} 
		 catch (SQLException e) 
		 {
			    database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();		
			  e.printStackTrace();			
		}		 
	 }
	 
	 public void clear1(ActionEvent event) throws InterruptedException
	 {
		 	o=0;
		 	orders.clear();
			orderList.getChildren().clear();
			foodBarBox3.getChildren().clear();
			orderNumberk.setText("");
			tablek.setText("");
			workerUsernamek.setText("");
	 }	 
	 
	 
	 
	 
	 public void pulse1(ActionEvent event) 
	 {
		 
			/*
			 * for(int i=0; i<new_order.getfoodsize();i++) {
			 * System.out.println(new_order.getFood_name(i)); } int lastordernumber; int
			 * newordernumber; String lastorderstring ; String newordernumber1; id =
			 * Integer.parseInt(id_Number);
			 */

			try 
			{

				database.connect_to_database();
				database.setResultsetorder();

				while (database.resultSet.next())
				{
					lastorderstring = database.resultSet.getString("OrderNumber");
				}

				lastordernumber = Integer.parseInt(lastorderstring);
				newordernumber = lastordernumber + 1;
				newordernumber1 = String.valueOf(newordernumber);

				BufferedReader readeremp = new BufferedReader(new FileReader("employee_name.txt"));
				employee_name = readeremp.readLine();
				workerUsername.setText(employee_name);
				orderNumber.setText(newordernumber1);
			} 
			catch (Exception e) 
			{
				System.out.print(e);

			}
		}
	 
	 public void exportdata(ActionEvent event)
	 {
		 /*
		  // Initialize a Workbook object
			Workbook workbook = new Workbook();

// Obtaining the reference of the worksheet
			Worksheet worksheet = workbook.getWorksheets().get(0);

// Instantiating an ArrayList object
ArrayList<String> list = new ArrayList<String>();

// Add few names to the list as string values
			list.add("Laurence Chen");
			list.add("Roman Korchagin");
			list.add("Kyle Huang");
			list.add("Tommy Wang");

// Exporting the contents of ArrayList vertically at the first row and first column of the worksheet. 
			worksheet.getCells().importArrayList(list, 0, 0, true);

// Saving the Excel file
			workbook.save("C:\\Files\\Output.xlsx");
		  */
		 
		 
	 }
	 
	 
	 public void  refresh1(ActionEvent event)
	 {
		 
		 Font font33 = Font.font("Modern No. 20", 33);
		 try {
		
			database.connect_to_database();
			database.setResultsetorder();

			 while(database.resultSet.next())
			 {
				  
				 String paidStatus = database.resultSet.getString("Paid");
				 if(paidStatus.equals("unpaid"))
				 {
			
				Order previousorder = new Order();
				previousorder.setnullall();
				previousorder.setOrder_number(database.resultSet.getString("OrderNumber"));
				previousorder.setWaitress(database.resultSet.getString("WaitStaff"));
				previousorder.setTime_Of_Order(database.resultSet.getString("TimeOfOrder"));
				previousorder.setDate(database.resultSet.getString("month_day_year"));
				previousorder.setTotal1(database.resultSet.getDouble("Price"));
				previousorder.setTable_number(database.resultSet.getString("Tablenumber"));
				previousorder.setCustomername(database.resultSet.getString("Customername"));
				previousorder.setphonenumber(database.resultSet.getString("PhoneNumber"));
				for(int i=0;i<previousorder.getfoodsize(); i++)
				{
					//System.out.println(i);
					int k = i+1;
				
					String name = database.resultSet.getString("item" + k);
			
					if(name.equals("null"))
					{						
						int j = 7;						
						System.out.println();
					}
					else
					{
						previousorder.setFood_name(database.resultSet.getString("item" + k), i);
						previousorder.setamount(database.resultSet.getInt("item" + k + "amount"), i);
						previousorder.setNotes(database.resultSet.getString("notes" + k), i);
						previousorder.setFood_price(database.resultSet.getDouble("item" + k + "cost"), i);
					}						
				}				
				orderdone1.add(previousorder);
				 }
			 }		 
			    database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
				//ystem.out.println("made it here2");
		
		for (int i = 0; i <orderdone1.size() ; i++) 
		{
			 Button orderButton = new Button("Order #" + orderdone1.get(os).getOrder_number());
			 orderButton.setFont(font33);
			 String ji = Integer.toString(os);
			 orderButton.setId(ji);
			 orderButton.setMinWidth(704);
			 orderButton.setMinHeight(87);
			 orderButton.setMaxWidth(704);
			 orderButton.setMaxHeight(87);
			 orderButton.setOnAction(new EventHandler<ActionEvent>() 
		 		{
				 	@Override
				 	public void handle(ActionEvent event) 
					{
				 		//customers_name2
				 		//customers_number2
				 		//tableNumber
				 		//totalPriceText1
				 		//orderNumber1
				 		//workerUsername10
				 		
				 		foodBarBox18.getChildren().clear();
				 		int of = Integer.parseInt(orderButton.getId());
				 		System.out.println(of);
				 		System.out.println(orderdone1.get(of).getfoodsize());
				 		orderNumber1.setText(orderdone1.get(of).getOrder_number());
				 		tableNumber.setText(orderdone1.get(of).getTable_number());
				 		totalPriceText12.setText(orderdone1.get(of).getTotal1());
				 		workerUsername10.setText(orderdone1.get(of).getWaitress());
				 		customers_name2.setText(orderdone1.get(of).getCustomername());
				 		customers_number2.setText(orderdone1.get(of).getphonenumber());
				 
				 		for(int i =0; i<orderdone1.get(of).getfoodsize() ;i++)
				 		{
				 			String namei = orderdone1.get(of).getFood_name(i);
				 			if(namei.equals("null"))
							{
								
				 				int j = 7;
								
								//System.out.println(i);
							
							}
							else
							{
				 			Font font29 = Font.font("Modern No. 20", 29);
				 			String amountStr = orderdone1.get(of).getamountString(i);
				 			String priceStr = Double.toString(orderdone1.get(of).getFood_price(i));		
				 			String lableStr = amountStr + "  " + orderdone1.get(of).getFood_name(i) + "  " + priceStr ;
				 			String lableStr2 = orderdone1.get(of).getnote(i);
							Label foodInfo = new Label(lableStr); //ADD TEXT HERE!!
							foodInfo.setMinWidth(651);
							foodInfo.setMinHeight(71);
							foodInfo.setFont(font29);
							foodInfo.setStyle("-fx-text-alignment: TOP_LEFT; ");
							
							Label foodInfo2 = new Label(lableStr2); //ADD TEXT HERE!!
							foodInfo2.setMinWidth(651);
							foodInfo2.setMinHeight(71);
							foodInfo2.setFont(font29);
							foodInfo2.setStyle("-fx-text-alignment: TOP_LEFT; ");
							
							
							foodBarBox18.getChildren().addAll(foodInfo, foodInfo2);
							}
				 		}
				 		//
				 		pricetotalbutton = orderdone1.get(of).getTotal1();
					}				 	
		 		});
			 
			 order.add(o,orderButton.getId());
			 orderlistK.getChildren().addAll(orderButton);
			 os++;
		}
		//System.out.println(o);
		//System.out.println(orders.size());
		 }
		 catch (IOException | SQLException e) 
		 {
			e.printStackTrace();
			System.out.println(e);
		}
	 }
	 
	 
	 public void clear2(ActionEvent event) throws InterruptedException
	 {
		 	o=0;
		 	orderdone1.clear();
		 	orderlistK.getChildren().clear();
		 	//order.clear();
			//orderNumberk.setText("");
			//tablek.setText("");
			//workerUsernamek.setText("");
	 }	 
	 
	 public void edituser(ActionEvent event) throws IOException
	    {
		
		 String idnumber = employeeId_text_field.getText();
		 String wage = employeewage_text_field.getText();
		String password = employeepass_text_field.getText();
		String hours = employeehours_text_field.getText();
		// System.out.println(idnumber);		
	try {
		 database.connect_to_database();
		 database.setResultset();
		 int lastdatabaseid=0;
		 int newdatabaseid=0;
		 while (database.resultSet.next()) {
				Employee employee = new Employee();
				employee.setdatabaseid(database.resultSet.getInt("id"));
				employee.setEmployee_name(database.resultSet.getString("Name"));
				employee.setId_number(database.resultSet.getString("IdNumber"));
				employee.setHours(database.resultSet.getInt("Hours"));
				employee.setWage(database.resultSet.getDouble("Wage"));
				employee.set_Job_Type(database.resultSet.getString("JobType"));
				employee.Set_total_Pay();
				employee.setpassword(database.resultSet.getString("Password"));
				employees.add(employee);
				lastdatabaseid = employee.getdatabaseid();
			}
		 newdatabaseid = lastdatabaseid + 1;
		 //System.out.println(employees.get(3).getdatabaseid());
		 //System.out.println(employees.get(3).getId_number());
		 
		 if(idnumber.equals(""))
		 {			 
			 errorlabeledit.setText("please enter an id");
		 } 
		 
		 else if (checkdatabaseid(employees, idnumber))
		 {			 		
		        if(EmployedStatusRBE.isSelected())
		         {		
			 for(int i = 0;i<employees.size();i++)
			 {
				 if(employees.get(i).getId_number().equals(idnumber))
				 {				
					 
					 	String deletesql2  = "DELETE FROM Employee WHERE id = " + employees.get(i).getdatabaseid();
			            database.updateField = database.connection.prepareStatement(deletesql2);
			            database.updateField.executeUpdate();
					 	
					 	database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();						
						
					 errorlabeledit.setText("employee fired");
				 }
			 }
		        }
		         else 
		             {		
		        	 //update clause
		        	 Double wagedb = Double.parseDouble(wage);
		        	   Integer idnumberI = Integer.parseInt(idnumber);
		        	   Integer hoursI = Integer.parseInt(hours);
		        	   Double totalpay = wagedb * hoursI;
			             if (wage.equals("")) 
			             {
			            	 errorlabeledit.setText("Please enter a wage");
			 			 }
			            else if (idnumber.equals(""))
			            {
			            	errorlabeledit.setText("Please enter an ID");
			 			} 
			            else if (hours.equals("")) 
			            {
			             errorlabeledit.setText("Please enter hours");
			            }
			            else if (password.equals("")) 
			            {
			             errorlabeledit.setText("Please enter hours");
			            }
			            else if (!Cashier_rdbE.isSelected() && !Kitchen_Staff_rdbE.isSelected() && !Manager_rdbE.isSelected()
								&& !Wait_staff_rdbE.isSelected()) 
			            {
			            	  errorlabeledit.setText("please select a job type");
			            }
		        	  
		             
		          
		            else 
		            
		        	   {
		            	String jobType  = "";
		            	
		            	if (Manager_rdbE.isSelected())
		            	{
							jobType = "Manager";
					
						}

						else if (Wait_staff_rdbE.isSelected()) 
						{
							jobType = "WaitStaff";
						

						} 
						else if (Kitchen_Staff_rdbE.isSelected())
						{
							jobType = "KitchenStaff";
						
						}

						else if (Cashier_rdbE.isSelected()) 
						{
							jobType = "Cashier";
					
						} 
		           
				 
				
				 		String updatesql = "UPDATE Employee " + "SET Password = ?," + "Hours = ?, "  + "Wage = ?, " + "TotalPay = ?, " + "JobType = ? "+ "WHERE IdNumber = " + idnumber;
				 	    database.updateField = database.connection.prepareStatement(updatesql);
			            database.updateField.setString(1, password);
			            database.updateField.setInt(2, hoursI);
			            database.updateField.setDouble(3, wagedb);
			            database.updateField.setDouble(4, totalpay);
			            database.updateField.setString(5, jobType);
			            database.updateField.executeUpdate();
			            
		        	 errorlabeledit.setText("Update Success");
					 database.closeConnection();
	                 database.closeConnection();
					 database.closeresultSet();
					 database.closestatement();
					 database.closeupdateField();
		             }
		       }
		 }
		 	else
		 		{
		 			            
			    errorlabeledit.setText("id number not found");
			 	database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
		 		}
		 }
					  
		 catch(Exception e)
		 {
			 database.closeConnection();
			 database.closeresultSet();
			 database.closestatement();
			 database.closeupdateField();
			 errorlabeledit.setText("please enter the information in the right format and all the fields");
		 }
		
	  }
	 public void submit_clockin(ActionEvent event) throws InterruptedException
	 {
		 try {
			 LocalDate myDate = myDatePicker.getValue();
			 String myFormattedDate = myDate.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		     System.out.println(myFormattedDate);
			 database.connect_to_database();
			 database.setResultsetclockedin();
			 
				while (database.resultSet.next())
				{
				  Employee employee = new Employee();
				  employee.setEmployee_name(database.resultSet.getString("EmployeeName"));
				  employee.setClockedin(database.resultSet.getString("ClockInDate"));
				  employee.setClockout(database.resultSet.getString("IdNumber"));
				  employee.setId_number(database.resultSet.getString("IdNumber"));
				  employees.add(employee);
				}
			 for(int i=0;i<employees.size();i++)
			 {
				 if(employees.get(i).getClockedin().equals(myFormattedDate)) 
				{
					 
				}
			 }
				
			 database.closeConnection();
			 database.closeresultSet();
			 database.closestatement();
			 database.closeupdateField();
		 }
		 catch(Exception e)
		 {
			 System.out.print("error");
			 database.closeConnection();
			 database.closeresultSet();
			 database.closestatement();
			 database.closeupdateField();
		 }
		 
		   
	 }	 
}

 

