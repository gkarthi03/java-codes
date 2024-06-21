import java.util.Scanner;
import java.io.*;

import java.util.Hashtable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static Scanner sc = new Scanner(System.in);
    public static Hashtable<String,Long> contactData = new Hashtable<String,Long>();
    
	public static void main(String[] args) throws IOException {
	    Path path = Paths.get("phoneBook.txt");
	    
		try {
		    
		    String dataStored = Files.readString(path);
		    loadData(dataStored);
		    
		    boolean control = true;
		    while(control)
		    {
		        System.out.println("Choose 1.Add Contact 2.Delete Contact 3.List All 4.Search");
		        int option = sc.nextInt();
		        
		        switch(option)
		        {
		            case 1:
		                addContact();
		                break;
		            case 2:
		                deleteContact();
		                break;
		            case 3:
		                viewContact();
		                break;
		            case 4:
		                searchContact();
		                break;
		            case 5:
		                writeInFile();
		                control = false;
		                break;
		        }
		    }
		}
		catch(FileNotFoundException e) {
		    //
		}
	}
	
	public static void loadData(String data)
	{
	    if(!data.isEmpty())
	    {
	        data = data.replace('{',' ');
	        data = data.replace('}',' ');
	        data = data.trim();
	        String[] tempData = data.split(",");
	        for(String i:tempData)
	        {
	            String[] maindata = i.split("=");
	            String name = maindata[0];
	            name = name.trim();
	            Long num = Long.parseLong(maindata[1]);
	            contactData.put(name,num);
	        }
	    }
	}
	
	public static void addContact()
	{
	    System.out.println("Enter Name:");
	    String Name = sc.next();
	    if(!contactData.containsKey(Name))
	    {
	        System.out.println("Enter Number:");
	        Long PhoneNumber = sc.nextLong();
	    
	        contactData.put(Name,PhoneNumber);
	    }
	    else
	    {
	        System.out.println("Contact Already Present");
	    }
	}
	
	public static void deleteContact()
	{
	    System.out.println("Enter Contact Name To Be Deleted:");
	    String Name_del = sc.next();
	    Long val = contactData.get(Name_del);
	    if(val == null)
	    {
	        System.out.println("Contact Not Found");
	    }
	    else
	    {
	        contactData.remove(Name_del);
	    }
	}

	public static void searchContact()
	{
	    System.out.println("Enter Name To Be Searched:");
	    String search_Name = sc.next();
	    Long val = contactData.get(search_Name);
	    if(val == null)
	    {
	        System.out.println("Contact Not Found");
	    }
	    else
	    {
	        System.out.println("Name:"+search_Name+" "+"Number:"+val);
	    }
	}
	
	public static void viewContact()
	{
	    if (!contactData.isEmpty())
	    {
	        contactData.forEach(
	            (key,value) -> System.out.println("Name:"+key+" "+"Number:"+value));
	    }
	    else
	    {
	        System.out.println("Book is Empty");
	    }
	}
	
	public static void writeInFile()
	{
	    
	    Path path = Paths.get("phoneBook.txt");
	    String data = contactData.toString();
	   
	    try {
	        Files.writeString(path, data);
	    }
	    catch(Exception e)
	    {
	        //
	    }
	}
}
