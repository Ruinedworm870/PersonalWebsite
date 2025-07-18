package recursion19;

/**
 * William Smolinski
 * CISS 241
 * ex191a: Uses recursion to find the gcd of two integers
 */
  
 import java.util.Scanner;
 
public class ex191a
{
	 
     public static void main(String[] args)
     {
		 int x, y, g;
		 Scanner sc = new Scanner(System.in);
		 System.out.print("Enter 2 integers:  ");
		 x = sc.nextInt();
		 y = sc.nextInt();
		 g = gcd(x, y);
		 System.out.println("GCD of " + x + " and " + y + " = " + g);
     }
  
     public static int gcd(int num1, int num2)
     {    	 
    	 //Base case
    	 if(num2 == 0)
    	 {
    		 return num1;
    	 }
    	 
    	 return gcd(num2, num1 % num2);
     }
}