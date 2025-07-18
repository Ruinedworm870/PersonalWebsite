/**
 * William Smolinski
 * CISS 111
 * Program06 - Takes a number and outputs the prime factors of the number in order
 */

import java.util.ArrayList;
import java.util.Scanner;

public class SmolinskiW_Program06
{
    public static void main(String[] args)
    {
        //Declares a Scanner to detect user input
        Scanner keyboard = new Scanner(System.in);

        //Declares an ArrayList to hold all the factors
        ArrayList<Integer> factors = new ArrayList<Integer>();

        //Declares an int to hold the user input
        int num;

        //Declares an int to hold the number to initialize tracker to in the recursive method
        final int TRACKER = 3;

        //Declares a boolean to be used to determine if the program should loop or exit
        boolean done = false;

        //Loops until the user exits the program
        while(!done)
        {
            //Clears the ArrayList at the start of each loop and resets num
            factors.clear();
            num = 0;

            //Gets a positive number from the user
            while (num <= 1)
            {
                System.out.print("Enter a number greater than 1: ");

                //Try catch clause to tell the user they didn't enter a valid number
                try
                {
                    num = Integer.parseInt(keyboard.nextLine());
                }
                catch(Exception e)
                {
                    System.out.println("Not valid input! " + e.getMessage());
                }
            }

            //Calls the method to get the prime factors
            factors = calculateFactors(num, factors, TRACKER);

            //Displays the output to the user
            System.out.println("\nPrime factors of " + num + ": \n");

            for(int i = 0; i < factors.size(); i++)
            {
                System.out.println(factors.get(i));
            }

            //Asks the user if they want to exit or not
            System.out.print("\nWould you like to enter another number? (y or n) ");

            if(keyboard.nextLine().charAt(0) == 'n')
            {
                System.out.println("Thanks for using the program!");
                done = true;
            }
        }
    }

    /**
     * Recursive method that builds an ArrayList with all the prime factors
     * @param num Number to get the prime factors from
     * @param factors ArrayList to fill with prime factors
     * @param tracker Number that tracks what number to divide num by
     * @return Returns an ArrayList with all the prime factors
     */
    public static ArrayList<Integer> calculateFactors(int num, ArrayList<Integer> factors, int tracker)
    {
        //If the number is prime there are no prime factors
        if(isPrime(num))
        {
            //Adds the prime number to the ArrayList without a recursive call and will end the loop
            factors.add(num);
        }
        else if(num % 2 == 0) //Will go through here until the number is not even
        {
            //Divides by 2 and adds 2 to the ArrayList of prime factors
            num /= 2;

            factors.add(2);

            //Recursive call
            calculateFactors(num, factors, tracker);
        }
        else
        {
            //Checks to see if the tracked number (always odd) can divide evenly into the number
            if(num % tracker == 0)
            {
                //Divides by the tracker num and adds it to the ArrayList of prime factors
                num /= tracker;

                factors.add(tracker);
            }
            else
            {
                //Increments onto all odd numbers (All prime numbers except for 2 are odd)
                //(Although it will increment onto non-prime numbers like 9 it will never work dividing by 9 above
                // because the prime factors of 9, which are 3 and 3, would have already been added to the prime factor
                // list and taken out of num)
                tracker += 2;
            }

            //Recursive call
            calculateFactors(num, factors, tracker);
        }

        //If it fails all cases above it returns a reference to the ArrayList
        return factors;
    }

    /**
     * Method to determine if a number is prime
     * @param num Number to check if it is prime
     * @return Returns the result as a boolean
     */
    public static boolean isPrime(int num)
    {
        //If a number is even it is not prime except for 2, 1 is also not prime
        if((num % 2 == 0 && num != 2) || num == 1)
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
