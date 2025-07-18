/**
 * William Smolinski
 * CISS 111
 * Program01 - Simulates the rolling of a certain number of dice with a certain number of sides a certain number of
 * times specified from user input
 */

import java.util.Random;
import java.util.Scanner;

public class SmolinskiW_Program01
{
    public static void main(String[] args)
    {
        //Declares the scanner keyboard to collect user input
        Scanner keyboard = new Scanner(System.in);

        //Declares the Random object to create a random number
        Random rand = new Random();

        //Declares the array that will hold the sum of each set of rolls
        int[] sumDiceRolls;

        //Declares the variables to hold the information about how many sides, number of die, and how many rolls
        int numSides, numDie, numRolls;

        //Declares the canPlay boolean to handle quitting the game
        boolean canPlay = true;

        //Will loop the game until the user quits
        while(canPlay)
        {
            //Tells the user a positive number must be entered
            System.out.println("Please enter a positive number greater than 0 for each prompt");

            //Gets the user input about the dice
            System.out.print("Enter the number of sides: ");
            numSides = getInput(keyboard);

            System.out.print("Enter the number of die: ");
            numDie = getInput(keyboard);

            System.out.print("Enter the number of rolls: ");
            numRolls = getInput(keyboard);

            //Sets the size of the array
            sumDiceRolls = new int[numSides * numDie];

            //Runs the simulateGame method to handle the calculations and output for the game
            simulateGame(sumDiceRolls, numSides, numDie, numRolls, rand);

            //Asks the user if they want to play again
            System.out.print("Do you want to play again? (y = yes, n = no) ");
            if(keyboard.next().equals("n"))
            {
                System.out.println("Thanks for using the program");
                canPlay = false;
            }
            else
            {
                //Creates an empty line
                System.out.println();
            }
        }
    }

    /**
     * Gets the input from the user and makes sure it is greater than 0
     * @param kb scanner to get user input
     * @return returns the result as an int
     */
    public static int getInput(Scanner kb)
    {
        //Declares num to hold the user input
        int num;

        //Initial input
        num = kb.nextInt();

        //Will loop as long as num is less than or equal to 0
        while(num <= 0)
        {
            System.out.print("Not a valid number try again: ");
            num = kb.nextInt();
        }

        return num;
    }

    /**
     * Runs the calculations for the game and outputs the results, I added the average and the minimum
     * and maximum value rolled to the results
     * @param sumDiceRolls Array to hold the sum of each set of rolls
     * @param numSides Number of sides on each die
     * @param numDie Number of die
     * @param numRolls Number of rolls
     * @param rand Used to get a random number for each roll
     */
    public static void simulateGame(int[] sumDiceRolls, int numSides, int numDie, int numRolls, Random rand)
    {
        //Holds the sum for each set of rolls
        int sum = 0;

        //Holds the total for calculating the average
        int total = 0;

        //Holds the values of the minimum and maximum numbers rolled
        int minimum = 0, maximum = 0;

        //Number of rolls
        for(int i = 0; i < numRolls; i++)
        {
            //Number of die
            for(int j = 0; j < numDie; j++)
            {
                //Gets a random number based on the sides and adds it to sum
                sum += rand.nextInt(numSides) + 1;
            }

            //Adds the result to the array and resets the sum
            sumDiceRolls[sum - 1]++;
            sum = 0;
        }

        //Creates an empty line
        System.out.println();

        //Outputs the results to the user
        System.out.println("Game Results:");
        for(int i = 0; i < sumDiceRolls.length; i++)
        {
            if(sumDiceRolls[i] > 0)
            {
                //Updates total to calculate the average
                total += sumDiceRolls[i] * (i + 1);

                //Sets minimum and maximum numbers rolled
                if(minimum == 0)
                {
                    minimum = i + 1;
                }
                maximum = i + 1;

                //Handles if the output is plural or not
                if(sumDiceRolls[i] > 1)
                {
                    System.out.println("There were " + sumDiceRolls[i] + " sums of " + (i + 1));
                }
                else
                {
                    System.out.println("There was " + sumDiceRolls[i] + " sum of " + (i + 1));
                }
            }
        }

        //Creates an empty line
        System.out.println();

        //Outputs the average along with maximum and minimum values
        System.out.println("Absolute minimum sum possible: " + numDie);
        System.out.println("Actual minimum sum rolled: " + minimum);
        System.out.println();
        System.out.println("Absolute maximum sum possible: " + numDie * numSides);
        System.out.println("Actual maximum sum rolled: " + maximum);
        System.out.println();
        System.out.println("Average of absolute min and max sum (rounded down): " +
                (numDie + (numDie * numSides)) / 2);
        System.out.println("Average of sums rolled(rounded down): " + total / numRolls);

        //Creates an empty line
        System.out.println();
    }
}
