
import java.io.File;
import java.util.Scanner;

public class AccountInformation implements AccountInformationInterface{
	Scanner UserScan;
	private String[] userArray=new String[50];
	
	
	public void readFile()
	{
		try 
		{
			UserScan = new Scanner(new File("User.txt"));
		}
		catch(Exception e)
		{
			System.out.println("FILE NOT FOUND");
		}
	}
	
	public void userFiletoArray()
	{	
		int i=0;
		while(UserScan.hasNext())
		{
			userArray[i]=UserScan.next();
			i++;
		}
	}
	
	public int checkUsername(String un)
	{
		int check=0;
		for(int i=0;i<userArray.length;i=i+2)
		{
			if(un.equals(userArray[i]) || un.equals("admin"))
			{
				check=1;
			}
		}
		return check;
		
	}
	
	public int checkLogin(String un,String pw)
	{
		int check=0,i;
		for(i=0;i<userArray.length;i=i+2)
		{
			if(un.equals(userArray[i]) && pw.equals(userArray[i+1]))
			{
				check=1;
				break;
			}
		}
		if(un.equals("admin") && pw.equals("adminpw"))
		{
			check=2;
		}
		if(un.equals("driver") && pw.equals("driverpw") || un.equals("driver1") && pw.equals("driver1pw") && pw.equals("driver1pw") || un.equals("driver2") && pw.equals("driver2pw") || un.equals("driver4") && pw.equals("driver4pw"))
		{
			check=3;
		}
		
		
			
		return check;
		
	}
}
