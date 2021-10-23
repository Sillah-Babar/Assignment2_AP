import java.util.Scanner;
import utilities.FlightDate;
import utilities.Admin;
import utilities.Flight;
import utilities.FlightFiles;
import utilities.DriverClass;
public class Main {
	public static void main(String args[])
	{
		DriverClass object=new DriverClass();

		int get=93;
		while(get!=0)
		{
			System.out.println("1.Admin interface");
			System.out.println("2.Passenger Login");
			System.out.println("3.Display all flights");
			System.out.println("4.Display all flights by date");
			System.out.println("5.Display all flights by date and increasing fare");
			System.out.println("6.BuyTicket");
			Scanner input=new Scanner(System.in);
			get=input.nextInt();
			if(get==1)
			{
				int choice=8;
				while(choice!=0)
				{
					System.out.println("1.Set Flights");
					System.out.println("2.Enter Flights Data");
					System.out.println("3.Display all Flights Data");
					System.out.println("4.Cancel a Flight");
					System.out.println("0.Exit");
					choice=input.nextInt();
					if(choice==1)
					{
						object.manager.setFlights(object.Files);
					}
					else if(choice==2)
					{
						object.manager.EnterFlights(object.Files); 
					}
					else if(choice==3)
					{
						object.Files.DisplayFlights();     		 
					}
					else if(choice==4)
					{
						object.manager.cancelFlight(object.Files);
					}
				}
			}
			else if(get==2)
			{
				int choice=8;
				while(choice!=0)
				{
					System.out.println("1.Print Eticket");
					System.out.println("0.Exit");
					choice=input.nextInt();
					if(choice==1)
					{
						object.Files.PrintTicket();
					}
					
				}
				
			}
			else if(get==3)
			{
				object.Files.DisplayFlights();    	
			}
			else if(get==4)
			{
				object.Files.DisplayFlightsByDates();	
			}
			else if(get==5)
			{
				object.Files.DisplayFlightsByDatesAndFare();
			}
			else if(get==6)
			{
				object.Files.BuyTicket();
			}
		}
	}
}
