package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
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
	String employee_name;
	String order_number;
	String table_number_text;
	private int fb = 1;
	 private int on = 1;
	 private int o=0;
	private double ph = 200.0;
	private double tp = 0.0;
	private String time;
	private SimpleDateFormat timeFormat;
	Calendar calendar;
	ArrayList<Employee> employees = new ArrayList<Employee>();
	Database database = new Database();
	ArrayList<Order> orders = new ArrayList<Order>();
	ArrayList<Order> orderdone1 = new ArrayList<Order>();
	Order new_order = new Order();
	int iterator = 0;
	int lastordernumber;
	int newordernumber;
	String lastorderstring;
	String newordernumber1;
	String[] itemnumbers2 = new String[100];
	String[] notes2 = new String[100];
	int neworderid;
	ArrayList<String> order = new ArrayList<String>();
	boolean checkdelete = false;
	int currentbutton = 110000;
	
	// setEditable(false) use this function for setting text in a textfield and not
	// being played with
	
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
	private Label workerUsername;

	@FXML
	private Label orderNumber;

	@FXML
	private Label checktable;

	// BufferedWriter writer2 = new BufferedWriter(new
	// FileWriter("order_number.txt"));

	public void loginreroute(ActionEvent event) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("employee_name.txt"));

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
				employee.Set_total_Pay();
				employees.add(employee);
			}
			/*
			 * int size = employees.size(); System.out.print(size); for(int i=0;i<=size;i++
			 * ) { System.out.println(i); }
			 */
			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i).getId_number().equals(text)) {
					if (employees.get(i).getjobType().equals("Manager")) {
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
					if (employees.get(i).getjobType().equals("WaitStaff")) {
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
						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();
					}

					if (employees.get(i).getjobType().equals("KitchenStaff")) {
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
					}
				}
			}

		} catch (SQLException e) {
			login_Label.setText("Failed to connect to database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		} catch (Exception e) {
			System.out.print(e);
			login_Label.setText("Incorrect Id number or not found in database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		}
	}

	public void switchToManager(ActionEvent event) throws IOException {

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

	public Boolean verify_Nametext(String txt) {
		try {
			int s = Integer.parseInt(txt);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean checkdatabaseid(ArrayList<Employee> employees, String id_Number) {
		boolean checkid = false;
		for (int i = 0; i < employees.size(); i++) {
			if (employees.get(i).getId_number().equals(id_Number)) {
				checkid = true;
				break;
			}
		}
		return checkid;
	}

	public void switchToCreate_New_User(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("New_User.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}

	public void switchToSceneWaitstaff(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);

	}

	public void switchToLogin(ActionEvent event) throws IOException {
		root = FXMLLoader.load(getClass().getResource("Login_Screen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}

	public void switchToKitchenstaff(ActionEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("Kitchen.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		stage.setFullScreen(true);
	}

	public void addFoodBar(ActionEvent event) {
		// new_order.setEmployee_Name("jack");
		// new_order.setOrder_number("13");

		try {
			
			Font font21 = Font.font("Modern No. 20", 21);
			Font font29 = Font.font("Modern No. 20", 29);

			Pane foodbar = new AnchorPane();
			Label foodText = new Label(null);
			Label priceText = new Label(null);

			foodbar.setStyle("-fx-background-color: #ffffff; ");
			foodbar.setMinWidth(683);
			foodbar.setMinHeight(68);
			AnchorPane.setTopAnchor(foodbar, ph);
			// foodbar.setPadding(new Insets(0,0,0,0));
			foodbar.setId("foodbar" + fb);

			Spinner<Integer> spinner = new Spinner<>(1, 1000, 1);
			spinner.setMaxWidth(100);
			spinner.setMinHeight(49);
			spinner.relocate(40.0, 10.0);
			spinner.setId("spinner" + fb);

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
						deleteButton.getParent().setVisible(false);
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
					if (noteButton.isArmed() == true) {
						try {
							notesWindow(event);
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			});
			
			
			
			if (pizzaButton.isArmed() == true) {
				foodText.setText("Pizza");
				priceText.setText("24.23");
				new_order.setFood_name("pizza", iterator);
				new_order.setFood_price(24.23, iterator);
			} else if (burgerButton.isArmed() == true) {
				foodText.setText("Burger");
				priceText.setText("8.42");
				new_order.setFood_name("burger", iterator);
				new_order.setFood_price(8.42, iterator);
			} else if (icecreamButton.isArmed() == true) {
				foodText.setText("Ice Cream Scoop");
				priceText.setText("3.50");
				new_order.setFood_name("Ice Cream Scoop", iterator);
				new_order.setFood_price(3.50, iterator);
			} else if (friesButton.isArmed() == true) {
				foodText.setText("Fries");
				priceText.setText("3.02");
				new_order.setFood_name("Fries", iterator);
				new_order.setFood_price(3.02, iterator);
			} else if (sodaButton.isArmed() == true) {
				foodText.setText("Soda");
				priceText.setText("4.30");
				new_order.setFood_name("Soda", iterator);
				new_order.setFood_price(4.30, iterator);
				// new_order.(4.30, iterator);
			} else if (waterButton.isArmed() == true) {
				foodText.setText("Water Bottle");
				priceText.setText("2.54");
				new_order.setFood_name("Water Bottle", iterator);
				new_order.setFood_price(2.54, iterator);
			}
		
			foodbar.getChildren().addAll(spinner, foodText, dollarSign, priceText, deleteButton, noteButton);

			foodBarBox.getChildren().addAll(foodbar);

			ph += 100.0;
			fb++;

			Double totalPriceDub;
			String text = priceText.getText();
			totalPriceDub = Double.parseDouble(text);

			tp = tp + totalPriceDub;

			String totalPriceStr = Double.toString(tp);
			totalPriceText.setText(totalPriceStr);
			iterator++;

		} catch (Exception e) {
			System.out.print(e);
		}
	}

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
		} catch (Exception e) {
			System.out.print(e);

		}
	}
	public void clear(ActionEvent event) throws IOException {
		foodBarBox.getChildren().clear();
		table_number.setText("");
		totalPriceText.setText("0.00");
		tp=0.0;
	}
	public void complete(ActionEvent event) {
		/*
		 * for(int i=0; i<new_order.getfoodsize();i++) {
		 * System.out.println(new_order.getFood_name(i)); }
		 */

		try {
			SimpleDateFormat timeFormat;
			SimpleDateFormat dayFormat;
			SimpleDateFormat dateFormat;
			String time;
			String date;

			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			time = timeFormat.format(Calendar.getInstance().getTime());
			date = dateFormat.format(Calendar.getInstance().getTime());
			// System.out.println(time);
			// System.out.println(date);

			String incomplete = "complete";
			String orderdone = "undone";
			String orderpaid = "unpaid";
			String tableNumber = table_number.getText();
			if (tableNumber.equals("")) {
				checktable.setText("Enter Table Number");

			} else {
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
				new_order.setNotes("extra", 0);
				new_order.setComplete(incomplete);
				new_order.setPaid(orderpaid);
				new_order.setOrderdone(orderdone);
				// System.out.print(new_order.getTotal());

				String insertSQL = "INSERT INTO Orders (ID,OrderNumber, WaitStaff,TimeofOrder, month_day_year, Price, Complete, orderdone, Paid, Tablenumber, item1, itemamount1, notes1, itemcost1, item2, itemamount2, notes2, itemcost2) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
				database.updateField = database.connection.prepareStatement(insertSQL);
				database.updateField.setInt(1, 2);
				database.updateField.setString(2, new_order.getOrder_number());
				database.updateField.setString(3, new_order.getEmployee_Name());
				database.updateField.setString(4, new_order.getTime_Of_Order());
				database.updateField.setString(5, new_order.getDate());
				database.updateField.setDouble(6, new_order.getTotal());
				database.updateField.setString(7, new_order.getComplete());
				database.updateField.setString(8, new_order.getOrder_number());
				database.updateField.setString(9, new_order.getPaid());
				database.updateField.setString(10, new_order.getTable_number());

				database.updateField.setString(11, new_order.getFood_name(0));
				database.updateField.setInt(12, 1);
				database.updateField.setString(13, new_order.getnote(0));
				database.updateField.setDouble(14, new_order.getFood_price(0));

				database.updateField.setString(15, new_order.getFood_name(1));
				database.updateField.setInt(16, 1);
				database.updateField.setString(17, new_order.getnote(0));
				database.updateField.setDouble(18, new_order.getFood_price(1));

				database.updateField.executeUpdate();
				database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
				checktable.setText("Success");
				
				clear(event);
				readeremp.close();
			}
		} catch (Exception e) {
			checktable.setText("Enter table# in the right format");
			System.out.print(e);
		}
	}

	public void notesWindow(ActionEvent event) throws IOException {

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
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if (closeButton.isArmed() == true) {

					String cardNumStr = cardNum.getText();
					String expDateMStr = expDateM.getText();
					String expDateYStr = expDateY.getText();
					String secCodeStr = secCode.getText();
					// int cardNumInt = 0;
					// int expDateMInt = 0;
					// int expDateYInt = 0;
					// int secCodeInt = 0;
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
					else if (cardNumStr == "1234567890123456" && expDateMStr == "10" && expDateYStr == "24"
							&& secCodeStr == "123") {
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

	public void cardErrorWindow(ActionEvent event, String errorString) throws IOException {

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

	public void totalPrice(ActionEvent event) throws IOException 
	{
		String totalPriceStr = Double.toString(tp);
		totalPriceText.setText(totalPriceStr);

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
	
	public void clockin(ActionEvent event) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("employee_name.txt"));

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
				employee.Set_total_Pay();
				employees.add(employee);
			}

			for (int i = 0; i < employees.size(); i++) {
				if (employees.get(i).getId_number().equals(text)) {
					if (employees.get(i).getjobType().equals("Manager")) {

						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();

						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
						int id = 0;
						database.connect_to_database1();
						database.setResultsetclockedin();
						while (database.rs2.next()) {
							id = database.rs2.getInt("ID");
						}
						int newid = id + 1;

						String insertSQL = "INSERT INTO Clocked (ID,employeename,month_day_year,clockin) VALUES (?,?,?,?)";
						database.updateField1 = database.connection1.prepareStatement(insertSQL);
						database.updateField1.setInt(1, newid);
						database.updateField1.setString(2, employee_name);
						database.updateField1.setString(3, date);
						database.updateField1.setString(4, time);
						database.updateField1.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						database.closeConnection1();
						database.closers2();
						database.closestatement1();
						database.closeupdateField1();

						Parent root = FXMLLoader.load(getClass().getResource("Manager_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
					}
					if (employees.get(i).getjobType().equals("WaitStaff")) {

						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();

						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
						int id = 0;
						database.connect_to_database1();
						database.setResultsetclockedin();
						while (database.rs2.next()) {
							id = database.rs2.getInt("ID");

						}

						int newid = id + 1;
						String insertSQL = "INSERT INTO Clocked (ID,employeename,month_day_year,clockin) VALUES (?,?,?,?)";
						database.updateField1 = database.connection1.prepareStatement(insertSQL);
						database.updateField1.setInt(1, newid);
						database.updateField1.setString(2, employee_name);
						database.updateField1.setString(3, date);
						database.updateField1.setString(4, time);
						database.updateField1.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						database.closeConnection1();
						database.closers2();
						database.closestatement1();
						database.closeupdateField1();

						Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
						employee_name = employees.get(i).getEmployee_name();

					}

					if (employees.get(i).getjobType().equals("KitchenStaff")) {
						employee_name = employees.get(i).getEmployee_name();
						writer.write(employee_name);
						writer.close();

						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
						int id = 0;
						database.connect_to_database1();
						database.setResultsetclockedin();
						while (database.rs2.next()) {
							id = database.rs2.getInt("ID");

						}

						int newid = id + 1;
						String insertSQL = "INSERT INTO Clocked (ID,employeename,month_day_year,clockin) VALUES (?,?,?,?)";
						database.updateField1 = database.connection1.prepareStatement(insertSQL);
						database.updateField1.setInt(1, newid);
						database.updateField1.setString(2, employee_name);
						database.updateField1.setString(3, date);
						database.updateField1.setString(4, time);
						database.updateField1.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						database.closeConnection1();
						database.closers2();
						database.closestatement1();
						database.closeupdateField1();

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

						SimpleDateFormat timeFormat;
						SimpleDateFormat dateFormat;
						String time;
						String date;

						timeFormat = new SimpleDateFormat("hh:mm:ss a");
						dateFormat = new SimpleDateFormat("MM/dd/yyyy");
						time = timeFormat.format(Calendar.getInstance().getTime());
						date = dateFormat.format(Calendar.getInstance().getTime());
						int id = 0;
						database.connect_to_database1();
						database.setResultsetclockedin();
						while (database.rs2.next()) {
							id = database.rs2.getInt("ID");

						}
						int newid = id + 1;

						String insertSQL = "INSERT INTO Clocked (ID,employeename,month_day_year,clockin) VALUES (?,?,?,?)";
						database.updateField1 = database.connection1.prepareStatement(insertSQL);
						database.updateField1.setInt(1, newid);
						database.updateField1.setString(2, employee_name);
						database.updateField1.setString(3, date);
						database.updateField1.setString(4, time);
						database.updateField1.executeUpdate();

						database.closeConnection();
						database.closeresultSet();
						database.closestatement();
						database.closeupdateField();

						database.closeConnection1();
						database.closers2();
						database.closestatement1();
						database.closeupdateField1();

						Parent root = FXMLLoader.load(getClass().getResource("Waitstaff_Screen.fxml"));
						stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
						scene = new Scene(root);
						stage.setScene(scene);
						stage.show();
						stage.setFullScreen(true);
					}
				}
			}

		} catch (SQLException e) {
			System.out.print(e);
			login_Label.setText("Failed to connect to database");
			database.closeConnection();
			database.closeresultSet();
			database.closestatement();
			database.closeupdateField();
		} catch (Exception e) {
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
			SimpleDateFormat timeFormat;
			SimpleDateFormat dateFormat;
			String time;
			String date;
			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			dateFormat = new SimpleDateFormat("MM/dd/yyyy");
			time = timeFormat.format(Calendar.getInstance().getTime());
			date = dateFormat.format(Calendar.getInstance().getTime());
			database.connect_to_database();
			database.setResultsetclockedout();
			int id = 0;
			while (database.resultSet.next())
			{
			  id = database. resultSet.getInt("ID");
			}
			int newid = id + 1;
	
			String SQL = "INSERT INTO clockout1 (ID, clockout, employeename, month_day_year) VALUES (?,?,?,?)";
			database.updateField = database.connection.prepareStatement(SQL);
			database.updateField.setInt(1, newid);
			database.updateField.setString(2, time);
			database.updateField.setString(3, employee_name);
			database.updateField.setString(4, date);
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
		
		 Font font33 = Font.font("Modern No. 20", 33);
		 try {
			 int lastdatabaseid;
			database.connect_to_database();
			database.setResultsetorderkitchen();
			 while(database.resultSet.next())
			 {
				Order previousorder = new Order();
				previousorder.setOrder_number(database.resultSet.getString("OrderNumber"));
				previousorder.setWaitress(database.resultSet.getString("WaitStaff"));
				previousorder.setTime_Of_Order(database.resultSet.getString("TimeOfOrder"));
				previousorder.setDate(database.resultSet.getString("month_day_year"));
				previousorder.setTotal1(database.resultSet.getDouble("Price"));
				previousorder.setTable_number(database.resultSet.getString("Tablenumber"));
				
				previousorder.setFood_name(database.resultSet.getString("item1"), 0);
				previousorder.setFood_price(database.resultSet.getDouble("itemcost1"), 0);
				previousorder.setamount(database.resultSet.getInt("itemamount1"), 0);
				previousorder.setNotes(database.resultSet.getString("notes1"), 0);
				
				previousorder.setFood_name(database.resultSet.getString("item2"), 1);
				previousorder.setFood_price(database.resultSet.getDouble("itemcost2"), 1);
				previousorder.setamount(database.resultSet.getInt("itemamount2"), 1);
				previousorder.setNotes(database.resultSet.getString("notes2"), 1);
				
				orders.add(previousorder);
				lastdatabaseid = database.resultSet.getInt(1);
			 }		 
			    database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
		
		// ArrayList.clear() vs ArrayList.removeAll().		 
		//ArrayList<Order> orders = new ArrayList<Order>();
		 //orders.
		 //Order order = new
		 //priceText11 first amount tag
		 // orderNumberk ordernumber kitchen
		//tablek table number k
		// foodText1 		
		//totalPriceText1	
		//workerUsernamek	
		//priceText12 amount	
		//foodText2		
				
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
				 		int of = Integer.parseInt(orderButton.getId());
				 		orderNumberk.setText(orders.get(of).getOrder_number());
				 		tablek.setText(orders.get(of).getTable_number());
				 		totalPriceText1.setText(orders.get(of).getTotal1());
				 		workerUsernamek.setText(orders.get(of).getWaitress());
				 		//for(int i =0; i<2;i++)
				 		//{
				 		notesText1.setText(orders.get(of).getnote(0));
				 		foodText1.setText(orders.get(of).getFood_name(0));
				 		priceText11.setText(orders.get(of).getamountString(0));
				 		//}
				 		priceText12.setText(orders.get(of).getamountString(1));
				 		foodText2.setText(orders.get(of).getFood_name(1));
				 		notesText2.setText(orders.get(of).getnote(1));
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
		 // table name  done
		 //order.get(of)
		    int fn = 9;
			int am = 10;	
			int n = 11;	
		 System.out.println(currentbutton);
		 
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
				 
			SimpleDateFormat timeFormat;				
			String time;			
			timeFormat = new SimpleDateFormat("hh:mm:ss a");
			time = timeFormat.format(Calendar.getInstance().getTime());
				
			errorKO.setText("");
			database.connect_to_database();
			database.setResultset10();
			while(database.resultSet.next())
			{
				lastdatabaseid = database.resultSet.getInt(1);
			}
			
			int newdatabaseid;
			newdatabaseid = lastdatabaseid + 1;
			String SQL = "INSERT INTO Orderdone (ID, OrderNumber, Tablenumber, Waitstaff,TimeofOrder,timeofcomplete,month_day_year,Price,item1,itemamount1,notes1,item2,itemamount2,notes2 ) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			database.updateField = database.connection.prepareStatement(SQL);
			database.updateField.setInt(1,newdatabaseid);
			database.updateField.setString(2, orders.get(k).getOrder_number());
			database.updateField.setString(3, orders.get(k).getTable_number());
			database.updateField.setString(4, orders.get(k).getWaitress());
			database.updateField.setString(5, orders.get(k).getTime_Of_Order());
			database.updateField.setString(6, time);
			database.updateField.setString(7, orders.get(k).getDate());
			database.updateField.setDouble(8, orders.get(k).getTotal2());
			for(int i = 0; i<2; i++)
			{			
			database.updateField.setString(fn, orders.get(k).getFood_name(i));
			database.updateField.setString(am, orders.get(k).getamountString(i));
			database.updateField.setString(n, orders.get(k).getnote(i));
			fn = fn + 3;
			am = am + 3;
			n = n + 3;
			}
			//database.updateField.setString(12, orders.get(k).getFood_name(1));
			//database.updateField.setString(13, orders.get(k).getamountString(1));
			//database.updateField.setString(14, orders.get(k).getnote(1));
			
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
			 int lastdatabaseid;
			database.connect_to_database();
			database.setResultsetorderdone();
			
			 while(database.resultSet.next())
			 {
				Order previousorder = new Order();
				previousorder.setOrder_number(database.resultSet.getString("OrderNumber"));
				previousorder.setWaitress(database.resultSet.getString("WaitStaff"));
				previousorder.setTime_Of_Order(database.resultSet.getString("TimeOfOrder"));
				previousorder.setDate(database.resultSet.getString("month_day_year"));
				previousorder.setTotal1(database.resultSet.getDouble("Price"));
				previousorder.setTable_number(database.resultSet.getString("Tablenumber"));
				
				previousorder.setFood_name(database.resultSet.getString("item1"), 0);
				//previousorder.setFood_price(database.resultSet.getDouble("itemcost1"), 0);
				previousorder.setamount(database.resultSet.getInt("itemamount1"), 0);
				previousorder.setNotes(database.resultSet.getString("notes1"), 0);
				
				previousorder.setFood_name(database.resultSet.getString("item2"), 1);
				//previousorder.setFood_price(database.resultSet.getDouble("itemcost2"), 1);
				previousorder.setamount(database.resultSet.getInt("itemamount2"), 1);
				previousorder.setNotes(database.resultSet.getString("notes2"), 1);
				
				orderdone1.add(previousorder);
				lastdatabaseid = database.resultSet.getInt(1);
			 }		 
			 
			    database.closeConnection();
				database.closeresultSet();
				database.closestatement();
				database.closeupdateField();
		
		// ArrayList.clear() vs ArrayList.removeAll().		 
		//ArrayList<Order> orders = new ArrayList<Order>();
		 //orders.
		 //Order order = new
		 //priceText11 first amount tag
		 // orderNumberk ordernumber kitchen
		//tablek table number k
		// foodText1 		
		//totalPriceText1	
		//workerUsername10	
		//priceText12 amount	
		//foodText2	
				
				
		for (int i = 0; i < orderdone1.size() ; i++) 
		{
			 Button orderButton = new Button("Order #" + orderdone1.get(o).getOrder_number());
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
				 		/*
				 		int of = Integer.parseInt(orderButton.getId());
				 		orderNumberk.setText(orderdone1.get(of).getOrder_number());
				 		tablek.setText(orderdone1.get(of).getTable_number());
				 		totalPriceText1.setText(orderdone1.get(of).getTotal1());
				 		workerUsername10.setTextorderdone1.get(of).getWaitress());
				 		//for(int i =0; i<2;i++)
				 		//{
				 		notesText1.setText(orderdone1.get(of).getnote(0));
				 		foodText1.setText(orderdone1.get(of).getFood_name(0));
				 		priceText11.setText(orderdone1.get(of).getamountString(0));
				 		//}
				 		priceText12.setText(orderdone1.get(of).getamountString(1));
				 		foodText2.setText(orderdone1.get(of).getFood_name(1));
				 		notesText2.setText(orderdone1.get(of).getnote(1));
				 	    currentbutton = of;
				 	    */
				 		System.out.println("it worked");
					}
		 
				});
			
			 order.add(o,orderButton.getId());
			 orderlistK.getChildren().addAll(orderButton);
			 o++;
		}
		System.out.println(o);
		System.out.println(orders.size());

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
	 
	 
	 public void clear2(ActionEvent event) throws InterruptedException
	 {
		 	o=0;
		 	orderdone1.clear();
		 	orderlistK.getChildren().clear();
		 	order.clear();
			//orderNumberk.setText("");
			//tablek.setText("");
			//workerUsernamek.setText("");
	 }	 
	 
	 
}
