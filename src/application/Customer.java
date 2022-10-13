package application;
public class Customer 
{
	private double money;
	private String customer_Name;
	private String phone_number;
	
	public void set_Money(double money_given) 
	{	
		money = money_given;
	}
	
	public double get_Money() 
	{
		return money;
	}
	
	public void set_Name(String name_given) 
	{	
		customer_Name = name_given;
	}
	
	public String get_Name() 
	{
		return customer_Name;
	}
	
	public void set_phone_number(String phone_number_given) 
	{	
		phone_number = phone_number_given;
	}
	
	public String get_phone_number() 
	{
		return phone_number;
	}
}
