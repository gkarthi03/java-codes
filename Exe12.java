public class Exe12
{
	public static void main(String[] args) {
	    
	    printPrime prime = new printPrime();
	    
	    prime.start();
	    System.out.println("First 100 Prime Numbers:");
		
	}
}

class printPrime extends Thread
{
    public void run()
    {
        for (int i = 1;i<=100 ;i++)
		{
		    if (checkPrime(i) && i != 1)
		    {
                System.out.println(i);
                try{
		            Thread.sleep(1000);
		        } 
		        catch(Exception e) {}
		    }
		}
    }
		
    private boolean checkPrime(int num)
	{
	        boolean result = true;
	    
	        for(int i = 2; i<num;i++)
	        {
	            if(num%i ==0)
	            {
	                if(num != i)
	                {
	                    result = false;
	                    break;
	                }
	            }
	        }
	    
	        return result;
	}
}
