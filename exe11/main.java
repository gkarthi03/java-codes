import java.util.Scanner;
import java.util.Vector;
import java.io.*;
import java.util.Collections;
import java.util.Hashtable;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main
{
    public static Scanner sc = new Scanner(System.in);
    public static Hashtable<String,Contact> contactData = new Hashtable<String,Contact>();

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
		            default:
		                writeInFile();
		                control = false;
		                break;
		        }
		    }
		}
		catch(FileNotFoundException e) {
		    e.printStackTrace();
		}
	}
	
	public static void loadData(String data)
	{
	    if(!data.isEmpty())
	    {
	        String[] tempData = data.split(",");
	        for(String i:tempData)
	        {
	            String[] maindata = i.split("_");
	            String name = maindata[0];
	            Long num1 = Long.parseLong(maindata[1]);
				
				if (!maindata[2].equals("###")) {
					System.out.println(maindata[2].toString());
					Long num2 = Long.parseLong(maindata[2]);
					Contact newContact = new Contact(num1,num2);
					contactData.put(name, newContact);
				}
				else
				{
					Contact newContact = new Contact(num1);
					contactData.put(name, newContact);
				}
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
			Contact newContact = new Contact(PhoneNumber);
	        contactData.put(Name,newContact);
	    }
	    else
	    {
	        System.out.println("Contact Already Present");
			if (contactData.get(Name).secondaryPhoneNumber == null) {
				System.out.println("Press 1 To Add As Secondary Number");
				if (sc.nextInt() == 1) {
					System.out.println("Enter Number:");
	        		Long PhoneNumber = sc.nextLong();
					Contact newContact = new Contact(contactData.get(Name).primaryPhoneNumber,PhoneNumber);
	        		contactData.put(Name,newContact);
				}
				
			}
	    }
	}
	
	public static void deleteContact()
	{
	    System.out.println("Enter Contact Name To Be Deleted:");
	    String Name_del = sc.next();

	    if(!contactData.containsKey(Name_del))
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
		if (contactData.containsKey(search_Name)) 
		{
			Long val = contactData.get(search_Name).primaryPhoneNumber;
			if (contactData.get(search_Name).secondaryPhoneNumber != null) 
			{
				Long val2 = contactData.get(search_Name).secondaryPhoneNumber;
				System.out.println("Name:"+search_Name+" "+"Primary Number:"+val+" Secondary Number:"+val2);
			}
			else
			{
				System.out.println("Name:"+search_Name+" "+"Number:"+val);
			}
		}
		else
		{
			System.out.println("Contact Not Found");
		}
	}
	
	public static void viewContact()
	{
	    if (!contactData.isEmpty())
	    {
			Vector<String> contactList = new Vector<String>();
			contactData.forEach((key,value)->contactList.add(key));
			Collections.sort(contactList);

			for(String i : contactList)
			{
				if (contactData.get(i).secondaryPhoneNumber == null) {
					System.out.println("Name:"+i+" "+"Number:"+contactData.get(i).primaryPhoneNumber);
				}
				else
				{
					System.out.println("Name:"+i+" Primary Number:"+contactData.get(i).primaryPhoneNumber+" Secondary Number:"+contactData.get(i).secondaryPhoneNumber);
				}
			}
	    }
	    else
	    {
	        System.out.println("Book is Empty");
	    }
	}
	
	public static void writeInFile()
	{
	    Path path = Paths.get("phoneBook.txt");
		StringBuffer data = new StringBuffer();
		contactData.forEach((key,value) -> data.append(key+"_"+contactData.get(key).primaryPhoneNumber+"_"+ 
		((contactData.get(key).secondaryPhoneNumber == null) ? "###" : contactData.get(key).secondaryPhoneNumber) +","));
	    
	    try {
	        Files.writeString(path, data);
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	}
}
