package application;

import java.util.Calendar;
import java.io.IOException;
import java.text.SimpleDateFormat;
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
import javafx.scene.control.Label;



public class MyThread extends Thread 
{
	String time;
	Calendar calendar;
	SimpleDateFormat timeFormat;	
	Label timeText;
	
	public MyThread(Label timeText)
	{
		this.timeText=timeText;
		
	}
	
	@Override
	 public void run()
	 {
		 timeFormat = new SimpleDateFormat("hh:mm:ss a");
		 for(int i=0; i<=5;i++) 
			{
		 
		    time = timeFormat.format(Calendar.getInstance().getTime());				
			timeText.setText(time);
			System.out.println(timeText.getText());
			}
}
	
}
