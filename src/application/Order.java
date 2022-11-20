package application;
import java.sql.Date;
import java.util.ArrayList;

public class Order 
{
	private String order_number;
	private String table_number;
	private ArrayList<String> notes = new ArrayList<String>();
	private String date;
	private double total;
	private ArrayList<Double> food_price = new ArrayList<Double>();
	private ArrayList<String> food_name = new ArrayList<String>();
	private String time_Of_Order;
	private String employee_Name;
	private String complete;
	private String orderdone;
	private String paid;
	private ArrayList<Integer> amount = new ArrayList<Integer>();
	
	private String food_namet;
	private Integer quantityT;
	private Double priceT;
	private String notesT;
	
	
	public String getFood_namet() {
		return food_namet;
	}

	public void setFood_namet(String food_namet) {
		this.food_namet = food_namet;
	}

	public Integer getQuantityT() {
		return quantityT;
	}

	public void setQuantityT(Integer quantityT) {
		this.quantityT = quantityT;
	}

	public Double getPriceT() {
		return priceT;
	}

	public void setPriceT(Double priceT) {
		this.priceT = priceT;
	}

	public String getNotesT() {
		return notesT;
	}

	public void setNotesT(String notesT) {
		this.notesT = notesT;
	}


	
	public String getComplete() {
		return complete;
	}

	public void setComplete(String complete) {
		this.complete = complete;
	}

	public String getOrderdone() {
		return orderdone;
	}

	public void setOrderdone(String orderdone) {
		this.orderdone = orderdone;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	
	
	public String getnote(int i) 
	{
		return notes.get(i);
	}
	
	public void setNotes(String note,int i)
	{
		notes.add(i,note);
	}
	
	public String getDate() 
	
	{
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getTable_number() 
	{
		return table_number;
	}

	public void setTable_number(String table_number) 
	{
		this.table_number = table_number;
	}


	public int getfoodsize() 
	{
		int size;
		size=food_name.size();
		return size;
	}
	
	
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

	public double getFood_price(int i)
	{
		return food_price.get(i);
	}

	public void setFood_price(Double food_pricel,int i)
	{
		food_price.add(i, food_pricel);
	}
	
	public void setFood_name(String food_namel,int i)
	{
		food_name.add(i,food_namel);
	}

	public double getTotal() 
	{
		/*
		for(int k=0; k<i; k++)
		{
			total = total + food_price.get(i);
		}
		return total;
		*/
		double total1 = 0;
		for(int i=0; i<food_price.size();i++)
		{		
			total1=total1+food_price.get(i);
		}
		total = total1;
		return total;
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
