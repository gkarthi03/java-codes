import java.util.Scanner;
public class exe4
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    
		int count = sc.nextInt();
		for (int i =0;i<count ;i++)
		{
		    System.out.println(Fibonacci(i));
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