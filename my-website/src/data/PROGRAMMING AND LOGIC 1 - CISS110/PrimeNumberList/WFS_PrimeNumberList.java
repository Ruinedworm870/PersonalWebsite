/**
 * William Smolinski
 * 11/8/21
 * Prime Number List assignment, determines all prime numbers from 1 - 100 and outputs to a file
 */

import java.io.*;

public class WFS_PrimeNumberList
{
  public static void main(String[] args)throws IOException
  {
    //Declares the PrintWriter for the output file
    PrintWriter outputFile = new PrintWriter("PrimeNumbers.txt");
    
    //Calls the isPrime method for all numbers up to 100 and prints the prime numbers in the output file
    for(int i = 1; i <= 100; i++)
    {
      if(isPrime(i))
      {
        outputFile.println(i);
      }
    }
    
    //Closes the output file
    outputFile.close();
    
    //Lets the user know the program executed successfully
    System.out.println("Prime numbers printed successfully");
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