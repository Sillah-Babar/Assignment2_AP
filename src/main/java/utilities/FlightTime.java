package utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlightTime {
	String time;

	public void setTime(String t)
	{
		time=t;	
	}
	public void setCurrent()
	{
		
		Date dateobj = new Date();
	
		DateFormat dfn = new SimpleDateFormat("HH:mm");
		System.out.println(dfn.format(dateobj));
		time=dfn.format(dateobj);


	}
	public String getCurrentTime()
	{

		return time;

	}
	public void Display()
	{
		
		System.out.printf("time: %s",time);
		System.out.println();
	}

}
