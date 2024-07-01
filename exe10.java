import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Vector;
public class Exe10
{
    
	public static void main(String[] args) 
	{
	    Scanner sc = new Scanner(System.in);
	    
	    Vector<String> dataQueue = new Vector<String>(); 
	    boolean run = true;
	    while(run)
	    {
	        System.out.println("Choose 1.enqueue 2.dequeue 3.list");
	        int option = sc.nextInt();
	        switch(option)
	        {
	            case 1:
					System.out.println("Enter the Element to be added:");
					dataQueue.add(sc.next());
					System.out.println("Queue: "+dataQueue);
	                break;
	           case 2:
	                dataQueue.remove(dataQueue.getFirst());
					System.out.println("Queue: "+dataQueue);
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
