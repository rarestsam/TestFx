package application;
import java.util.ArrayList;

public class Order 
{
	private String order_number;
	private double total;
	private ArrayList<Double> food_price;
	private ArrayList<String> food_name;
	private String time_Of_Order;
	private String employee_Name;

	public String getOrder_number() 
	{
		return order_number;
	}

	public void setOrder_number(String order_number)
	{
		this.order_number = order_number;
	}

	public String getFood_name(int i) 
	{
		return food_name.get(i);
	}

	public void setFood_name(String food_name,int i)
	{
		this.food_name.set(i,food_name);
	}

	public double getTotal(int i) 
	{
		for(int k=0; k<i; k++)
		{
			total = total + food_price.get(i);
		}
		return total;
	}

	public double getFood_price(int i)
	{
		return food_price.get(i);
	}

	public void setFood_price(double food_price,int i)
	{
		this.food_price.set(i, food_price);
	}

	public String getTime_Of_Order() 
	{
		return time_Of_Order;
	}

	public void setTime_Of_Order(String time_Of_Order) 
	{
		this.time_Of_Order = time_Of_Order;
	}

	public String getEmployee_Name() 
	{
		return employee_Name;
	}

	public void setEmployee_Name(String employee_Name) 
	{
		this.employee_Name = employee_Name;
	}

}
