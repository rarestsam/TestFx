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
	private int hours;
	private double totalPay;
	private int databaseid;
	
	
	public void setdatabaseid(int databaseid)
	{
		this.databaseid=databaseid;
	}
	
	public int getdatabaseid()
	{		
		return databaseid;
	}
	
	public void setWage(double wage)
	{
		 this.wage=wage;
	}
	
	public double getWage()
	{
		 return wage;
	}
	
	public void setHours(int hours)
	{
		 this.hours=hours;
	}
	
	public int getHours()
	{
		 return hours;
	}
	public double get_totalpay()
	{
		return totalPay;
	}
	public void Set_total_Pay()
	{		
		totalPay = wage*hours;
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

