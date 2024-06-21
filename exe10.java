import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class exe10
{
    
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    
	    Queue<String> dataQueue = new LinkedList<String>();
	    boolean run = true;
	    while(run)
	    {
	        System.out.println("Choose 1.enqueue 2.dequeue 3.list");
	        int option = sc.nextInt();
	        switch(option)
	        {
	            case 1:
	                System.out.println("Enter Element To Add:");
	                String Element = sc.next();
	                dataQueue.add(Element);
	                break;
	           case 2:
	                String del_Element = dataQueue.remove();
	                break;
	           case 3:
	                for (String i:dataQueue)
	                {
	                    System.out.println(i);
	                }
	                break;
	           case 4:
	               run = false;
	               break;
	           default:
	               return;
	               
	        }
	    }
	    
	}
}