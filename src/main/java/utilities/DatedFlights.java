package utilities;
//this class is composed of flights that happen to be on a specific date
public class DatedFlights {
public FlightDate date;
public Flight [] flights;
int size=500;
int flightCount=0;
public DatedFlights()
 {
	 size=500;
	 date=new FlightDate();
	 date.date="";
	 flights=new Flight[500];
	 for(int i=0 ; i<500 ; i++)
	 {
		 flights[i]=new Flight(); 
	 }
 }
 public void TakeFlightDetails()
 {
	 
	 try
	 {
		 if( flightCount == size-1 )
			 refillFlights();
		 else
		 {
			 
	      flights[flightCount].InputDetails(flightCount);
	      FlightFiles.WriteToFile(flights[flightCount],date.date);
	      flightCount++;
		 }
	 }
	 catch(Exception e)
	 {
		 System.out.println("Array index out of bound");
	 }
	 
 }
 public void Display()
 {
	 System.out.println("=======================================================");
	 System.out.printf("Date: %s %n",date.date);
	 System.out.printf("Flight Count: %d %n",flightCount);
	 System.out.println("=======================================================");
    for(int i=0 ; i<flightCount ; i++)
    {
    	this.flights[i].display();
    }
 }
 public void bubbleSort() 
 {    
	 Flight temp;
      for(int i=0; i <flightCount ; i++)
      {  
              for(int j=1; j < (flightCount-i); j++)
              {  
                       if(this.flights[j-1].fare > this.flights[j].fare)
                       {  
                              //swap elements  
                              temp = this.flights[j-1];  
                              this.flights[j-1] = this.flights[j];  
                              this.flights[j] = temp;  
                      }  
                       
              }  
      }  

 }  
 public void refillFlights()
 {
	 
 }
}
