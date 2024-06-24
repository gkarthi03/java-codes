import java.util.*;
public class Exe13
{
    public static Queue<Integer> data = new LinkedList<Integer>();
	public static void main(String[] args) {
	    
	    Producer producer = new Producer();
	    producer.start();
	    
		Consumer consumer = new Consumer();
		consumer.start();
		
	}
}

class Producer extends Thread
{
    public void run()
    {
        Exe13 main = new Exe13();
        
        Random rand = new Random();
        int num = rand.nextInt(100);
        main.data.add(num);
        System.out.println("Enqueued Number is:"+ num);
        System.out.println("Queue Data:" + main.data);
    }
}

class Consumer extends Thread
{
    public void run()
    {
        try {
            Thread.sleep(500);
            
        } catch(Exception e) {
        }
        Exe13 main = new Exe13();
        int delNum = main.data.poll();
       
        if(checkPrime(delNum))
        {
             System.out.println("Deleted Number:"+delNum+" is a primeNumber");
        }
        else
        {
            System.out.println("Deleted Number:"+delNum+" is Not a primeNumber");
        }
        System.out.println("Queue After Deletion:"+main.data);
    }
    
    private boolean checkPrime(int num)
	{
	    boolean result = true;
	    
	    for(int i = 2; i<num;i++)
	    {
	        if(num%i ==0)
	        {
	            result = false;
	            break;
	        }
	    }
	    return result;
	}
}