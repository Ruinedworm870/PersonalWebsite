/**
 * William Smolinski
 * 11/8/21
 * isPrime assignment, determines if the number entered is prime
 */

import java.util.Scanner;

public class WFS_IsPrimeMethod
{
  public static void main(String[] args)
  {
    //Declares the scanner keyboard to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the num variable to hold the number that will be checked if it is prime
    int num = 0;
    
    //Asks the user for a number greater than 0
    do
    {
      System.out.print("Enter a number greater than 0: ");
      num = keyboard.nextInt();
    }while(num <= 0);
    
    //Creates a blank line
    System.out.println();
    
    //Displays to the user whether the number was prime or not
    if(isPrime(num))
    {
      System.out.println(num + " is prime.");
    }
    else
    {
      System.out.println(num + " is not prime.");
    }
  }
  
  /**
   * isPrime method dtermines whether a number is prime or not
   * @param num the number that is checked to see if it is prime
   * @return returns the result as a boolean
   */
  
  public static boolean isPrime(int num)
  { 
    //One is not a prime number
    if(num == 1)
    {
      return false;
    }
    
    //If a number is even it is not prime except for 2
    if(num % 2 == 0 && num != 2)
    {
      return false;
    }
    
    //Determines all odd numbers up to the square root of num and tests if num is evenly divisible by them
    for(int i = 3; i * i <= num; i += 2)
    {
      if(num % i == 0)
      {
        return false;
      }
    }
    
    return true;
  }
}