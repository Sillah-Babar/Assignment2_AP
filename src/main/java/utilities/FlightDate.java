package utilities;
import java.util.*;
import java.text.DateFormat;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
public class FlightDate {

	String date;
	

	public void setDate(String d)
	{
		date=d;	
	}
	public void setCurrent()
	{
		DateFormat df = new SimpleDateFormat("dd/MM/yy");
		Date dateobj = new Date();
		System.out.println(df.format(dateobj));
		date=df.format(dateobj);

	}
	public String getCurrentDate()
	{
		return date;
	}

	
	public void Display()
	{
		System.out.printf("date: %s",date);
		System.out.println();
		
	}

}
