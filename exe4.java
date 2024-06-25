import java.util.Scanner;
public class Exe4
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		boolean validInput = false;
		while (!validInput) 
		{
			try
			{
				String count = sc.next();
				int c = Integer.parseInt(count);
				
				for (int i =0;i<c;i++)
				{
		    		System.out.println(Fibonacci(i));
				}

				if (c < 0) 
				{
					System.out.println("Input Can't Be Negative,Try With Other Value.");
				}
				else
				{
					validInput = true;
				}
			}
			catch(NumberFormatException e)
			{
				System.out.println("Input is Not an Integer Try With An Integer Value:");
			}
		}
	}
	
	public static int Fibonacci(int num)
	{
	    if (num == 0)
	    {
	        return 0;
	    }
	    else if(num == 1)
	    {
	        return 1;
	    }
	    else
	    {
	        return Fibonacci(num-1)+Fibonacci(num-2);
	    }
	}
}
