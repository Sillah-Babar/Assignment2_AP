package utilities;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Admin {
String UserName;
String passcode;

    public Admin()
    {
    	UserName="";
    	passcode="";
    }
	public Admin(String u, String p)
	{
	UserName=u;
	passcode=p;
	}
	public void setFlights(FlightFiles obj)
	{
		int choice=0;
		FlightDate dateobj=new FlightDate();
		dateobj.setCurrent();
		String date=dateobj.getCurrentDate();
		
		System.out.println("1.Set weekly flights from this date onwards");
		System.out.println("2.Set monthly flights from this date onwards");
		System.out.println("3.Set Flight on specific date");
        Scanner input=new Scanner(System.in);		
		choice=input.nextInt();
		if(choice==1)
		{
	      obj.createFiles(date,7);		
			
		}else if(choice==2)
		{
		 obj.createFiles(date,30);	
		}
		else if(choice==3)
		{
			
		try {	
				 String [] array= date.split("/");
				 int d,m,y;
				 int day,mon,year;
				 day= Integer.parseInt(array[0]);
				 mon= Integer.parseInt(array[1]);
				 year= Integer.parseInt(array[2]);
				
				 System.out.println("Enter the day");
				 d=input.nextInt();
				 while(d<0 || d>31)
				 {
					 System.out.println("Wrong input for day");
					 d=input.nextInt(); 
				 }
		
				 System.out.println("Enter the month");
				 System.out.println("1.January");
				 System.out.println("2.February");
				 System.out.println("3.March");
				 System.out.println("4.April");
				 System.out.println("5.May");
				 System.out.println("6.June");
				 System.out.println("7.July");
				 System.out.println("8.August");
				 System.out.println("9.September");
				 System.out.println("10.October");
				 System.out.println("11.November");
				 System.out.println("12.December");
				 m=input.nextInt();
				 while(m<0 && m>12)
				 {
					 System.out.println("Wrong inout for month");
					 m=input.nextInt(); 
				 }
				 y=year;
				 if((d<day && m==mon) || (d<=day && m<mon))
				 {
					 System.out.println("The date given has already passed");
				 }
				 else
				 {
					 String dd="";
				 dd=Integer.toString(d);
				 dd+="/";
				 dd+=Integer.toString(m);
				 dd+="/";
				 dd+=Integer.toString(year);
				// System.out.println(dd);
				 obj.createFiles(dd, 0);
				 
				 }
		 }
		 catch(Exception e)
		 {
		 System.out.println("Array out of bound exception ewr");	
		 }
		}
	}
	//used to enter flight details
	public void EnterFlights(FlightFiles obj)
	{
		String date;
	  Scanner input=new Scanner(System.in);
	  System.out.println("Enter the date for the flight for which you want to enter data. Enter the date in the format 23/23/21");
	  date=input.next();
	  boolean check=false;
	  while(check==false)
	  {
	    check=obj.EnterDate(date);
	    if(check==false)
	     {
	       System.out.println("You entered the wrong date. Enter again");
		   date=input.next();
	     }
	  }
	}
public void cancelFlight(FlightFiles obj) 
{
	Scanner input= new Scanner(System.in);
 String date;
 System.out.println("Enter the date on which you want to cancel the flight in the format 23/34/21");
 date=input.next();
 int FlightNo;
 System.out.println("Enter the flight Number of the flight you want to cancel");
 FlightNo=input.nextInt();
 obj.cancelflight(obj,date,FlightNo);
}
}
