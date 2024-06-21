import java.io.*;

public class exe1
{
	public static void main(String[] args) throws IOException{
	    
		try(DataInputStream data = new DataInputStream(new FileInputStream("file.txt"))){
		    String text = data.readLine();
		    
		    System.out.println(text);
		}
		catch(FileNotFoundException e)
		{
		    System.out.println("file not found");
		}
	}
}
