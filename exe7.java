import java.io.*;
import java.util.Scanner;
public class exe7
{
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		String fileName = sc.nextLine();
		
		try {
		    FileInputStream inputFile = new FileInputStream(fileName+".txt");
		    int c;
		    int index = 1;
		    while((c=inputFile.read()) != -1)
		    {
		        if (index == 1)
		        {
		            System.out.print(index+".");
		            index++;
		        }
		        else if(c == 10)
		        {
                    System.out.print((char)c);
		            System.out.print(index+".");
		            index++;
		        }
		        else
		        {
		            System.out.print((char)c);   
		        }
		        
		    }
		    
		} catch(FileNotFoundException e) {
		    System.out.println("File Not Found");
		}
		
	}
}