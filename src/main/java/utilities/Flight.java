package utilities;
import java.util.Scanner;
import java.util.IllegalFormatConversionException;
public class Flight {
	int flightNo;
	FlightTime Time;
	String classType; //economy or business class
	String destination;
	String airplane;
	int totalPassengers;
	FlightTime boardingTime;
	String cityStays;
	int [] Seats;
	int seatNo;
	public int seatsAvailable;
	double fare;
	public Flight()
	{
		Seats=null;
		boardingTime=new FlightTime();
		Time=new FlightTime();
		flightNo=0;
		classType=null;
		destination=null;
		airplane="";
		totalPassengers=0;
		cityStays="";
		seatsAvailable=0;
		fare=0;
		seatNo=0;
	}
	public int GenerateSeat()
	{
		int s=-1;
		if(seatNo< totalPassengers)
		{
		Seats[seatNo]=1;
		seatNo++;
		s=seatNo;
		}
		else
		{
			System.out.println("Seats are not available");
		}
		return s;
	}
	public void InputDetails(int fl)
	{
		flightNo=fl;
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the type of class this flight gives e.g economy , business");
		classType=input.next();
		System.out.println("Enter the Destination");
		destination=input.next();
		System.out.println("Enter the airplane");
		airplane=input.next();
		System.out.println("Enter the total passengers");
		totalPassengers=input.nextInt();
		System.out.println("Enter the stopovers in the format 5hr in mexico, 4hr in thailand, 3 hr in dubai");
		input.nextLine();
		cityStays=input.nextLine();
		System.out.println("Enter the fare of the ride");
		fare=input.nextDouble();
		System.out.println("Enter the time of flight in the format hr:min ");
		Time.time=input.next();
		System.out.println("Enter the boarding time of flight hr:min ");
	   boardingTime.time=input.next();
		
        seatsAvailable=totalPassengers;	
		Seats=new int[totalPassengers];
		
	}
	public void setFlight(int fl, String type, String des, String air, int tp, String stays , int sa, double f,String br,String t)
	{
		flightNo=0;
		classType=type;
		destination=des;
		airplane=air;
		totalPassengers=tp;
		cityStays=stays;
		seatsAvailable=sa;
		fare=f;
		Time.time=t;
		boardingTime.time=br;
	}

	public void display()
	{
		try
		{
		if(flightNo != -1)
		{
		System.out.printf("Flight Number %d %n",flightNo);
		System.out.printf("Class Type %s %n",classType);
		System.out.printf("Destination: %s %n",destination);
		System.out.printf("Air plane:  %s %n",airplane);
		System.out.printf("Total passengers %d %n",totalPassengers);
		System.out.printf("City Stays: %s %n",cityStays);
		System.out.printf("Seats Available:  %d %n",seatsAvailable);
		System.out.printf("Fare %.2f %n",fare);
		System.out.printf("time %s %n",Time.time);
		System.out.printf("Boarding Time %s %n",boardingTime.time);
		System.out.println();
		System.out.println();
		}
		}
		catch(IllegalFormatConversionException e)
		{
		System.out.println("Illegal fromatting using printf");	
		}
		}
}