import java.util.*;
import java.text.*;
public class exe5
{
	public static void main(String[] args) {
	    Date today = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("E MMM dd HH:mm:ss zz yyyy");
	    String out = formatter.format(today);
	    System.out.print(out);
		
	}
}