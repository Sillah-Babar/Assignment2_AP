package utilities;
import java.util.Scanner;
public class Passenger 
{
	String Name;
	String TicketCode;
	String Email_ID;
	String CardNo;
	String CardPin;
    int SeatNo;	
	Flight obj;
	String Date;
 public Passenger()
 {
	 Name="";
	 TicketCode="";
	 Email_ID="";
	 CardNo="";
	 CardPin="";
 }
 public boolean deleteTicket()
{
	 boolean TicketReturn=false;
	 FlightDate currentDate=new FlightDate();
	 currentDate.setCurrent();
	 String currDate=currentDate.getCurrentDate();
	 String[] array=currDate.split("/");
	 String[] array2=Date.split("/");
	 
	 if(Integer.parseInt(array[0])>Integer.parseInt(array2[0]) && Integer.parseInt(array[1])==Integer.parseInt(array2[1]) && Integer.parseInt(array[2])==Integer.parseInt(array2[2]) )//if the current day is greater than the flight day then the flight has passed and cannot be cancelled 
	 {
		 return TicketReturn;
	 
	 }
	 else if(Integer.parseInt(array[1])>Integer.parseInt(array2[1]) && Integer.parseInt(array[2])==Integer.parseInt(array2[2]))
	 {
		 return TicketReturn; 
	 }
	 else
	 {
		 Scanner input=new Scanner(System.in);
		 System.out.println("==================Refunding 50 percent of the money========================");
	    	System.out.println("Enter your Card Number");
	    	String cardn=input.next();
	    	System.out.println("Enter your Card Pin");
	    	String cardp=input.next();
	    	System.out.println("==================Your Money has been refunded and the Ticket Cancelled========================");
	        TicketCode="-1";
	        TicketReturn=true;
	        return TicketReturn;
	 }
}
 public void PrintEticket()
 {
	 if(!TicketCode.equals("-1"))
	 {
	System.out.println("================================================="); 
	System.out.printf("Name: %s %n",Name);
	System.out.printf("Code: %s %n ",TicketCode);
	System.out.printf("Seat Number: %d %n ",SeatNo);
    System.out.println();
    System.out.println();
	System.out.printf("Date: %s %n ",Date);
	System.out.printf("Time: %s %n ",obj.Time.time);
	System.out.printf("Destination: %s %n ",obj.destination);
	System.out.printf("Boarding Time: %s %n ",obj.boardingTime.time);
	System.out.printf("plane: %s %n ",obj.airplane);
	System.out.printf("fare: %s %n ",obj.fare);
	System.out.println();
	System.out.println();
	System.out.println("================================================="); 
	 } 
 }
}
