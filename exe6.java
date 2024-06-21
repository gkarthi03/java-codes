import java.util.Scanner;
import java.io.*;

public class exe6
{
	public static void main(String[] args) throws IOException
	{
	    Scanner sc = new Scanner(System.in);
	    String fileName = sc.nextLine();
	   
		try
		{
		    FileInputStream readFile = new FileInputStream(fileName+".txt");
		    FileOutputStream duplicateFile = new FileOutputStream("Outputfile.txt");
		    int c;
		    while((c = readFile.read()) != -1)
		    {
		        //System.out.println(c);
		        duplicateFile.write(c);
		    }
	    }
	    catch(FileNotFoundException e)
	    {
	        System.out.println("file not found");
	    }
	}
}