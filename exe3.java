import java.util.Random;

public class exe3
{
    public static int min = 1000;
    public static int max = 0;
	public static void main(String[] args) {
	    Random rand = new Random();
		int[][][] a = new int[4][5][8];
		for (int i = 0;i<4 ;i++)
		{
		    for(int j=0;j<5;j++)
		    {
		        for(int k=0;k<8;k++)
		        {
		            a[i][j][k] = rand.nextInt(1000);
		            checkMin(a[i][j][k]);
		            checkMax(a[i][j][k]);
		            System.out.print(a[i][j][k] + " ");
		        }
		        System.out.println("");
		    }
		    System.out.println("");
		}
		
		System.out.println("Smallest Number : "+min);
		System.out.println("largest Number: "+max);
	}
	
	public static void checkMin(int checkNum)
	{
	    if (checkNum < min)
	    {
	        min = checkNum;
	    }
	}
	
	public static void checkMax(int checkNum)
	{
	    if(checkNum > max)
	    {
	        max = checkNum;
	    }
	}
}
