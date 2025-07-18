/**
 * William Smolinski
 * CISS 111
 * Program00, takes a number and outputs whether the number is prime and if it was even or odd
 */

import  java.util.Scanner;

public class SmolinskiW_Program00
{
    public static void main(String[] args)
    {
        //Declares the scanner keyboard to detect user input
        Scanner keyboard = new Scanner(System.in);

        //Declares the num variable to hold the user input
        int num;

        //Loop to keep repeating until 0 is entered to exit the program
        do
        {
            //Prompts the user to enter a number on a loop until a suitable number is entered
            do
            {
                System.out.print("Enter a number greater than 0 or enter 0 to exit: ");
                num = keyboard.nextInt();
            }while (num < 0);

            //Determines if the program will continue based upon the users input
            if(num != 0)
            {
                //Displays the message with the information for the user
                System.out.print("The number " + num);

                if(isEven(num))
                {
                    //2 is the only even number that is prime
                    if(num == 2)
                    {
                        System.out.print(" is prime, is even, is not odd");
                    }
                    else
                    {
                        System.out.print(" is not prime, is even, is not odd");
                    }
                }
                else if(isPrime(num))
                {
                    System.out.print(" is prime, is not even, is odd");
                }
                else
                {
                    System.out.print(" is not prime, is not even, is odd");
                }
            }
            else
            {
                //Displays a message thanking the user for using the program
                System.out.println("Thanks for using the program");
            }

            //creates two blank lines so that the output looks cleaner
            System.out.println();
            System.out.println();
        }while (num != 0);
    }

    /**
     * isEven method determines whether a number is even or not
     * @param num number to be checked if it is even or not
     * @return returns the result as a boolean
     */
    public static boolean isEven(int num)
    {
        //returns true or false if the number is even or not
        return  num % 2 == 0;
    }

    /**
     * isOdd method determines whether a number is odd or not, not really needed in this program as isEven will
     * be false if isOdd would be true
     * @param num number to be checked if it is odd or not
     * @return returns the result as a boolean
     */
    public static boolean isOdd(int num)
    {
        //returns true or false if the number is odd or not
        return  !(num % 2 == 0);
    }

    /**
     * isPrime method determines whether a number is prime or not
     * @param num number to be checker if it is prime or not
     * @return returns the result as a boolean
     */
    public static boolean isPrime(int num)
    {
        //If the number is even or is 1 it isn't prime unless it is 2
        if((isEven(num) && num != 2) || num == 1)
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

        return  true;
    }
}
