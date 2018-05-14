import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class TripInformation {
	Scanner UserScan;
	private String[] userArray=new String[200];
	private Formatter rf; 
	int length;
	
	
	
	public void readFile()
	{
		try 
		{
			UserScan = new Scanner(new File("Trips.txt"));
		}
		catch(Exception e5)
		{
			System.out.println("FILE NOT FOUND");
		}
	}
	
	public void userFiletoArray()
	{	
		length=0;
		while(UserScan.hasNext())
		{
			userArray[length]=UserScan.next();
			length++;
		}
	}
	
	public String[] showSuitableTrips(String f,String t,String g)
	{
		String sentArray[] = new String[40];
		int j=0;
		for(int i=0;i<length;i=i+8)
		{
			if(f.equals(userArray[i]) && t.equals(userArray[i+1]) && g.equals(userArray[i+2]))
			{
				sentArray[j]=userArray[i];
				j++;
				sentArray[j]=userArray[i+1];
				j++;
				sentArray[j]=userArray[i+2];
				j++;
				sentArray[j]=userArray[i+3];
				j++;
				sentArray[j]=userArray[i+4];
				j++;
				sentArray[j]=userArray[i+5];
				j++;
				sentArray[j]=userArray[i+6];
				j++;
				sentArray[j]=userArray[i+7];
				j++;
				
				

			}
		}
		return sentArray;
	}
	
	public String[] showSuitableTrips(String f,String t,String g,String r)
	{
		String sentArray[] = new String[20];
		int j=0;
		for(int i=0;i<length;i=i+8)
		{
			if(f.equals(userArray[i]) && t.equals(userArray[i+1]) && g.equals(userArray[i+2]) && r.equals(userArray[i+3]))
			{
				sentArray[j]=userArray[i];
				j++;
				sentArray[j]=userArray[i+1];
				j++;
				sentArray[j]=userArray[i+2];
				j++;
				sentArray[j]=userArray[i+3];
				j++;
				sentArray[j]=userArray[i+4];
				j++;
				sentArray[j]=userArray[i+5];
				j++;
				sentArray[j]=userArray[i+6];
				j++;
				sentArray[j]=userArray[i+7];
				j++;
				

			}
		}
		return sentArray;
	}
	
	
	public void saveConfirmedTrips(String f,String t,String g,String r,String k,String n,String reservedTickets)
	{

		try {
		PrintWriter writer = new PrintWriter("Trips.txt","UTF-8");
		
		for(int i=0;i<length;i=i+8)
		{
			if(f.equals(userArray[i]) && t.equals(userArray[i+1]) && g.equals(userArray[i+2]) && r.equals(userArray[i+3]) && k.equals(userArray[i+4]) && n.equals(userArray[i+5]))
			{
				int newNumberOfTickets=Integer.parseInt(n)-Integer.parseInt(reservedTickets);
				String newStringNumberOfTickets =	""+newNumberOfTickets;
				writer.println(userArray[i]+" "+userArray[i+1]+" "+userArray[i+2]+" "+userArray[i+3]+" "+userArray[i+4]+" "+newStringNumberOfTickets+" "+userArray[i+6]+" "+userArray[i+7]);
			}
			else
			{
				writer.println(userArray[i]+" "+userArray[i+1]+" "+userArray[i+2]+" "+userArray[i+3]+" "+userArray[i+4]+" "+userArray[i+5]+" "+userArray[i+6]+" "+userArray[i+7]);
			}
		}
		writer.close();
		}
		catch(Exception e9)
		{
			System.out.println("Can't open file");
		}
		
	}
	
	public void saveReservations(String name,String f,String t,String g,String r,String k,String reservedTickets)
	{

		try {
		PrintWriter writer = new PrintWriter(new FileOutputStream(new File("Reservations.txt"), true /* append = true */));
		
		for(int i=0;i<length;i=i+8)
		{
			if(f.equals(userArray[i]) && t.equals(userArray[i+1]) && g.equals(userArray[i+2]) && r.equals(userArray[i+3]) && k.equals(userArray[i+4]))
			{
				
				writer.println(name+" "+userArray[i]+" "+userArray[i+1]+" "+userArray[i+2]+" "+userArray[i+3]+" "+userArray[i+4]+" "+reservedTickets+" "+userArray[i+6]+" "+userArray[i+7]);
			}
			
		}
		writer.close();
		}
		catch(Exception e10)
		{
			System.out.println("Can't open file");
		}
		
	}
		
	
}
