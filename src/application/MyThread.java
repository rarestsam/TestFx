package application;

import java.util.Calendar;
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
import javafx.scene.control.Label;



public class MyThread extends Thread 
{
	String time;
	Calendar calendar;
	SimpleDateFormat timeFormat;	
	
	@Override
	 public void run()
	 {
		
		for(int i=0;i<100;i++)
		{
			
			System.out.println(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	 }
	 
	 public void run(Label timeText)
	 {
		
		 while(true) {		
			//timeText= new Label();
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeText.setText(time);
			  try {
			   Thread.sleep(1000);
			  } catch (InterruptedException e) {
			   e.printStackTrace();
			  }
}
	 }
	 public void gettime(Label timeText)
	 {
		
		 	
			timeText= new Label();
			time = timeFormat.format(Calendar.getInstance().getTime());
			timeText.setText(time);
			
}
	 }


