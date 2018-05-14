import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Formatter;
import java.util.Scanner;

public class CancelReservationInformation {
	Scanner UserScan;
	private String[] userArray=new String[1000];
	private Formatter rf; 
	private int length;
	int fix;
	
	public void readFile()
	{
		try 
		{
			UserScan = new Scanner(new File("Reservations.txt"));
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
	
	public String[] showTripsForCancelation(String nameOfClient)
	{
		String sentArray[] = new String[40];
		int j=0;
		for(int i=0;i<length;i=i+9)
		{
			if(nameOfClient.equals(userArray[i]))
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
				sentArray[j]=userArray[i+8];
				j++;
				

			}
		}
		return sentArray;
	}
	
	public void deleteCancelledTrip(String name,String f,String t,String g,String r,String k,String n)
	{

		try {
		PrintWriter writer = new PrintWriter("Reservations.txt","UTF-8");
		
		for(int i=0;i<length;i=i+9)
		{
			//if((!name.equals(userArray[i])) && (!f.equals(userArray[i+1])) && (!t.equals(userArray[i+2])) &&(!g.equals(userArray[i+3])) && (!r.equals(userArray[i+4])) && (!k.equals(userArray[i+5])) && (!n.equals(userArray[i+6])))
//			if((!name.equals(userArray[i])) &&(!r.equals(userArray[i+4])) && (!k.equals(userArray[i+5])))
//			{
//				writer.println(userArray[i]+" "+userArray[i+1]+" "+userArray[i+2]+" "+userArray[i+3]+" "+userArray[i+4]+" "+userArray[i+5]+" "+userArray[i+6]);
//			}
			if((name.equals(userArray[i])) && (f.equals(userArray[i+1])) && (t.equals(userArray[i+2])) &&(g.equals(userArray[i+3])) && (r.equals(userArray[i+4])) && (k.equals(userArray[i+5])) && (n.equals(userArray[i+6])))
			{
				int fix=i;
				saveConfirmedTrips(fix);
			}
			else
			{
				writer.println(userArray[i]+" "+userArray[i+1]+" "+userArray[i+2]+" "+userArray[i+3]+" "+userArray[i+4]+" "+userArray[i+5]+" "+userArray[i+6]+" "+userArray[i+7]+" "+userArray[i+8]);

			}
		}
		writer.close();
		}
		catch(Exception e9)
		{
			System.out.println("Can't open file");
		}
		
	}
	
	public void saveConfirmedTrips(int f)
	{

		try {	
		PrintWriter appendWriter = new PrintWriter(new FileOutputStream(new File("Trips.txt"), true /* append = true */));
		appendWriter.println(userArray[f+1]+" "+userArray[f+2]+" "+userArray[f+3]+" "+userArray[f+4]+" "+userArray[f+5]+" "+userArray[f+6]+" "+userArray[f+7]+" "+userArray[f+8]);
		appendWriter.close();
		}
		catch(Exception e9)
		{
			System.out.println("Can't open file");
		}
		
	}

}
