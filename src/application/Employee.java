package application;


public class Employee 
{
	private String employee_name;
	private String id_number;
	//private String clocked_in;
	//private String clocked_out;
	private String total_hours;
	private String jobType;
	private double wage;
	private double hours;
	private double totalPay;
	
	public void setWage(double wage)
	{
		 this.wage=wage;
	}
	
	public void setHours(double hours)
	{
		 this.hours=hours;
	}
	public double get_totalpay()
	{
		totalPay = wage*hours;
		return totalPay;
	}
	
	public void set_Job_Type(String jobType)
	{
		this.jobType=jobType;
	}
	
	public String getjobType()
	{
		return jobType;
	}
	
	public String getEmployee_name()
	{
		return employee_name;
	}
	
	public void setEmployee_name(String employee_name) 
	{
		this.employee_name = employee_name;
	}
	
	public String getId_number()
	{
		return id_number;
	}
	
	public void setId_number(String id_number)
	{
		this.id_number = id_number;
	}
	
	//public String getClocked_in() 
	//{
	//	return clocked_in;
	//}
	
//	public void setClocked_in(String clocked_in) 
	//{
	//	this.clocked_in = clocked_in;
	//}
	
	//public String getClocked_out() 
	//{
	//	return clocked_out;
	//}
	
	//public void setClocked_out(String clocked_out) 
	//{
	//	this.clocked_out = clocked_out;
	//}
	public String getTotal_hours()
	{
		return total_hours;
	}
	
	public void setTotal_hours(String total_hours) 
	{
		this.total_hours = total_hours;
	}
	
}

