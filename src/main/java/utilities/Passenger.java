package utilities;

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

 public void PrintEticket()
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
