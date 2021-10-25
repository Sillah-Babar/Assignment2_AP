package utilities;
import java.util.*;
import java.io.File;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.*; 
public class FlightFiles {
	File myObj;
	public DatedFlights[] flightObject;
	public Passenger[] customers;
	int size;
	int dateCount;
    int passCount;
	//flights
	public FlightFiles()
	{
		//System.out.println("Stainless");
		flightObject=new DatedFlights[500];
		customers=new Passenger[500];
		for(int i=0 ; i<500 ; i++)
		{
			flightObject[i]=new DatedFlights();
		    customers[i]=new Passenger();
		}
        
		passCount=0;
		size=500;
		dateCount=0;
	}
	//creates files for a specific date, monthly or weekly basis
	public void createFiles(String date, int days)
	{

		String []	array= date.split("/");
		if(days==0)//creating a file for specific date
		{


			try {


				String Filename="";

				Filename+="Flights_";
				Filename+=array[0];
				Filename+="_";
				Filename+=array[1];
				Filename+="_";
				Filename+=array[2];
				Filename+=".csv";			
				System.out.println(Filename);

				myObj = new File(Filename);
				if (myObj.createNewFile()) {
					System.out.println("File created: " + myObj.getName());
					WriteHeads();
					try
					{
						if(dateCount==size-1)
							refillArray();	
						flightObject[dateCount].date.setDate(date);
						dateCount++;
					}
					catch(Exception e)
					{
						System.out.println("Array index out of bounds");
					}
				} else {
					System.out.println("File already exists.");
				}
			}
			catch (IOException e) 
			{
				System.out.println("An error occurred.");
				e.printStackTrace();
			}	

		}
		else
		{
			for(int i=0 ; i<days ; i++)
			{


				try {


					String Filename="";
					String SaveDate="";

					Filename+="Flights_";
					Filename+=array[0];
					SaveDate+=array[0];
					Filename+="_";
					SaveDate+="/";
					Filename+=array[1];
					SaveDate+=array[1];
					Filename+="_";
					SaveDate+="/";
					Filename+=array[2];
					SaveDate+=array[2];
					Filename+=".csv";			
					System.out.println(Filename);

					myObj = new File(Filename);
					if (myObj.createNewFile()) {
						System.out.println("File created: " + myObj.getName());
						WriteHeads();
						try
						{
							if(dateCount==size-1)
								refillArray();	
							flightObject[dateCount].date.setDate(SaveDate);
							System.out.println(flightObject[dateCount].date);
							dateCount++;
						}
						catch(Exception e)
						{
							System.out.println("Array index out of bounds");
						}

					} else {
						System.out.println("File already exists.");
					}
				}
				catch (IOException e) 
				{
					System.out.println("An error occurred.");
					e.printStackTrace();
				}	


				int day=Integer.parseInt(array[0]);
				int mon=Integer.parseInt(array[1]);
				int year=Integer.parseInt(array[2]);
				if(mon==1 || mon==3 || mon==5 || mon==7 || mon==8 || mon==10 || mon==12)
				{

					if(mon==12 && day+1==32)
					{
						year++;   
					}
					else if(day+1==32)
					{
						day=1;
						mon++;		
					}
					else
					{
						day++;
					}
				}
				else if(mon==2)
				{
					if(day+1==29)
					{
						day=1;
						mon++;		
					}
					else
					{
						day++;
					} 
				}
				else if(mon==2 || mon==4 || mon==6 || mon==9 || mon==11 )
				{
					if(day+1==32)
					{
						day=0;
						mon++;		
					}
					else
					{
						day++;
					}
				}
				array[0]=Integer.toString(day);
				array[1]=Integer.toString(mon);
				array[2]=Integer.toString(year);
			}

		}
	}
	public void DisplayFlights()
	{
		for(int i=0 ; i<dateCount ; i++)
		{
			flightObject[i].Display();
		}
	}
	public boolean EnterDate(String d)
	{
		for(int i=0 ; i<dateCount ; i++)
		{

			String date=flightObject[i].date.date;
			if(date.equals(d))
			{

				flightObject[i].TakeFlightDetails();

				return true;
			}
		}
		return false;
	}

	public void refillArray()//used to increment the array when size of flights exceeds 100 for a specific date
	{

	}
	public void WriteHeads()
	{
		for(int i=0 ; i<size ; i++)
		{
			if(flightObject[i].date.date!="")
			{
				try
				{
					String date=flightObject[i].date.date;
					String[] array= date.split("/");
					String Filename="";
					Filename+="Flights_";
					Filename+=array[0];
					Filename+="_";
					Filename+=array[1];
					Filename+="_";
					Filename+=array[2];
					Filename+=".csv";			
					String str = "Flight_No,Time,classType,destination,plane,total_passengers,boardingTime,CityStays,seatsAvailable,fare\n";
					BufferedWriter writer = new BufferedWriter(new FileWriter(Filename));

					writer.write(str);
					writer.close();
					myObj = new File(Filename);				
				}
				catch(Exception e)
				{
					System.out.println("There has been an exception while writing into file");
				}
			}
		}
	}
	public static void WriteToFile(Flight obj, String d)
	{
		try
		{

			String[] array= d.split("/");
			String Filename="";
			Filename+="Flights_";
			Filename+=array[0];
			Filename+="_";
			Filename+=array[1];
			Filename+="_";
			Filename+=array[2];
			Filename+=".csv";	
			File file = new File(Filename);
			FileWriter fr = new FileWriter(file, true);
			BufferedWriter br = new BufferedWriter(fr);

			br.append(String.valueOf(obj.flightNo));
			br.append(",");
			br.append(obj.Time.time);
			br.append(",");
			br.append(obj.classType);
			br.append(",");
			br.append(obj.destination);
			br.append(",");
			br.append(String.valueOf(obj.totalPassengers));
			br.append(",");
			br.append(obj.boardingTime.time);
			br.append(",");
			br.append(obj.cityStays);
			br.append(",");
			br.append(String.valueOf(obj.seatsAvailable));
			br.append(",");
			br.append(String.valueOf(obj.fare));
			br.append("\n");


			br.close();
			fr.close();
		}
		catch (Exception e)
		{
			System.out.println("File did not open for data to be written");
		}
	}

	public void cancelflight(FlightFiles obj,String d, int fno)
	{
		boolean flag=false;
		for(int i=0 ; i<dateCount ; i++)
		{
			if(obj.flightObject[i].date.date.equals(d))
			{
				for(int j=0 ; j<obj.flightObject[i].flightCount ; j++)
				{
					if(obj.flightObject[i].flights[j].flightNo==fno)
					{
						obj.flightObject[i].flights[j].flightNo=-1;//ensure that the flight has been deleted 
						flag=true;
						RemoveFromFile(obj.flightObject[i],fno);

					}
				}
			}

		}
		if(!flag)
		{
			System.out.println("No such flight has been found , either the flight no or date is wrong");
		}
		else
		{
			System.out.println("flight has been deleted"); 
		}
	}
    public void DisplayFlightsByDates()
    {
    	boolean check=false;
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter the date for the flights you want to see in the format 22/23/23");
    	String d=input.next();
    	for(int i=0 ; i<dateCount ; i++)
		{
			if(flightObject[i].date.date.equals(d))
			{
				flightObject[i].Display();	
		        check=true;
			}
			
		}
    	if(check==false)
    	{
    		System.out.println("No such date was found");
    	}
    		
    }
    public void DisplayFlightsByDatesAndFare()
    {
    	boolean check=false;
    	Scanner input=new Scanner(System.in);
    	System.out.println("Enter the date for the flights you want to see in the format 22/23/23");
    	String d=input.next();
    	
    	for(int i=0 ; i<dateCount ; i++)
		{
			if(flightObject[i].date.date.equals(d))
			{
				flightObject[i].bubbleSort();
				flightObject[i].Display();	
		        check=true;
			}
			
		}
    	if(check==false)
    	{
    		System.out.println("No such date was found");
    	}
    		
    }
    public void BuyTicket()
    {
    	boolean check=false;
    	Scanner input=new Scanner(System.in);
    	String date,flightNo;
    	System.out.println("Enter the date you want the flight on");
    	date=input.next();
    	System.out.println("Enter the Flight No");
    	flightNo=input.next();
    	
    	for(int i=0 ; i<dateCount ; i++)
    	{
    		if(flightObject[i].date.date.equals(date))
    		{
    			for(int j=0 ; j<flightObject[i].flightCount ; j++)
    			{
    				String s=String.valueOf(flightObject[i].flights[j].flightNo);
                   if(s.equals(flightNo))
                   {
                	   
                	   System.out.println(".....Generating an available Seat Token");
                	   int se=flightObject[i].flights[j].GenerateSeat(); 
                	   if(se==-1)
                	   {
                		   System.out.println("... Ticket cannot be assigned ...");
                	   }
                	   else
                	   {
                		   check=true;   
                		   customers[passCount].SeatNo=se;
                		   System.out.println("Enter Name");
                		   customers[passCount].Name=input.next();
                		   System.out.println("Email ID");
                		   customers[passCount].Email_ID=input.next();
                		   System.out.println("Enter Card No");
                		   customers[passCount].CardNo=input.next();
                		   System.out.println("Enter Card Pin");
                		   customers[passCount].CardPin=input.next();
                		   System.out.println("..........Generating Token Number..........");
                		   customers[passCount].TicketCode=String.valueOf(passCount);
                		  customers[passCount].obj=flightObject[i].flights[j];
                		  customers[passCount].Date=date;
                		   System.out.println("............Your Tikect Token Number is....................");
                		   System.out.println(String.valueOf(passCount));
                		   passCount++;
                	   }
                   }
    			}
    		}
    	}
    	
    }
    public void PrintTicket()
    {
    	Scanner input=new Scanner(System.in);
    	
    	System.out.println("Enter your Name");
    	String n=input.next();
    	System.out.println("Enter your Ticket");
    	String ticket=input.next();
    	
    	for(int i=0 ; i<passCount ; i++)
    	{
    		if(customers[i].Name.equals(n) && customers[i].TicketCode.equals(ticket))
    		{
    			customers[i].PrintEticket();	
    		}
    	}
    }
    public void cancelTicket()
	{
	Scanner input=new Scanner(System.in);
    	
    	System.out.println("Enter your Name");
    	String n=input.next();
    	System.out.println("Enter your Ticket Token");
    	String ticket=input.next();
    	boolean Ticketreturn=false;
    	int position=0;
    	for(int i=0 ; i<passCount ; i++)
    	{
    		if(customers[i].Name.equals(n) && customers[i].TicketCode.equals(ticket))
    		{
    		 Ticketreturn	 =customers[i].deleteTicket();
    		 position=i;
    			i=passCount;
    		}
    	}
    	if(Ticketreturn==false)
    	{
    		System.out.println("Your ticket cannot be cancelled as the date of flight has already passed");
    	}
    	else 
    	{
    		for(int i=0 ; i<dateCount ; i++)
    		{
    			if(flightObject[i].date.date.equals(customers[position].Date))
    			{
    				for(int j=0 ; j<flightObject[i].flightCount ; j++)
    				{
    					if(flightObject[i].flights[j].flightNo==customers[position].obj.flightNo)
    					{
    						flightObject[i].flights[j].seatsAvailable++;	
    						flightObject[i].flights[j].seatNo--;	
    					}
    				}
 
    			}
    			
    		}
    	}
    	
    	
    	
    	
	}
	public void RemoveFromFile(DatedFlights fl,int fno)
	{
/*		
		String[] array= fl.date.date.split("/");
		String Filename="";
		Filename+="Flights_";
		Filename+=array[0];
		Filename+="_";
		Filename+=array[1];
		Filename+="_";
		Filename+=array[2];
		Filename+=".csv";	
		try
		{
			File file = new File(Filename);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			BufferedWriter writer = new BufferedWriter(new FileWriter("dummy.csv"));
			String contentLine = br.readLine();
			int count=0;
			while (contentLine != null) 
			{
				System.out.println(contentLine);
				System.out.printf("fno %d: ",fno);
				String [] arr=contentLine.split(",");
				if(arr[0].equals(String.valueOf(fno)))
				{

				}
				else
				{
					System.out.println("yeah");
				
					writer.append(contentLine);
					
					count++;
				}
				contentLine = br.readLine();
			}


			fr.close();
		    writer.close();
			br.close();
		
			File file2=new File("dummy.csv");
			file= new File (Filename);
			if (file.delete()) { 
				System.out.println("Deleted the file: " + myObj.getName());
			} else {
				System.out.println("Failed to delete the file.");
			} 
			file=new File(Filename);
			if (file.createNewFile()) {
				System.out.println("File created: " + file.getName());
				FileWriter fr2=new FileWriter(file);
				fr=new FileReader(file2);
				br=new BufferedReader(fr);
				BufferedWriter br2=new BufferedWriter(fr2);
				System.out.println("Reading from the dummy file");

				contentLine = br.readLine();
				while (contentLine != null) 
				{

					System.out.println(contentLine);
					br2.append(contentLine);
					contentLine = br.readLine();
				}
				fr2.close();
				br2.close();
				br.close();
				fr.close();
				if (file2.delete()) { 
					System.out.println("Deleted the file: " + myObj.getName());
				} else {
					System.out.println("Failed to delete the file.");
				}
					   
			}

		}
		catch(Exception e)
		{
			System.out.println("cant open files");
		}		

	
*/	
 }
}