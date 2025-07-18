/**
 * Game class used to store and handle all information about a game
 */

import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class Game
{
    //Fields
    private int lowerLimit; //Holds the lowest guess possible
    private int upperLimit; //Holds the highest guess possible
    private int currentGuess; //Holds the current guess
    private ArrayList<String> allGuesses; //Holds the total guesses and values guessed
    private static int totalGuesses;

    /**
     * Constructor to set default values
     */
    public Game()
    {
        //Sets the lower and upper limit to their default for the game
        lowerLimit = 1;
        upperLimit = 100;

        //Initializes the allGuesses ArrayList
        allGuesses = new ArrayList<String>();
    }

    //Setter methods

    /**
     * Modifies the lowerLimit field
     * @param lowerLimit Value of the lower limit
     */
    public void setLowerLimit(int lowerLimit)
    {
        this.lowerLimit = lowerLimit;
    }

    /**
     * Modifies the upperLimit field
     * @param upperLimit Value of the upper limit
     */
    public void setUpperLimit(int upperLimit)
    {
        this.upperLimit = upperLimit;
    }

    /**
     * Sets the currentGuess field and adds the current guess to the allGuesses ArrayList
     * @param currentGuess Value of the current guess
     */
    public void setCurrentGuess(int currentGuess)
    {
        this.currentGuess = currentGuess;

        //Adds the current guess to the ArrayList of all guesses for the game
        allGuesses.add(Integer.toString(currentGuess));
        totalGuesses += 1;
    }

    //Getter methods

    /**
     * Gets the lowerLimit field
     * @return Returns the field as an int
     */
    public int getLowerLimit()
    {
        return lowerLimit;
    }

    /**
     * Gets the upperLimit field
     * @return Returns the field as an int
     */
    public int getUpperLimit()
    {
        return upperLimit;
    }

    /**
     * Gets the currentGuess field
     * @return Returns the field as an int
     */
    public int getCurrentGuess()
    {
        return currentGuess;
    }

    /**
     * Uses the allGuesses ArrayList to return the guess at the index requested
     * @return Returns the value as an array of ints
     */
    public String[] getAllGuesses()
    {
        //Array to hold the values
        String[] allGuesses = new String[this.allGuesses.size()];

        for(int i = 0; i < allGuesses.length; i++)
        {
            allGuesses[i] = this.allGuesses.get(i);
        }

        return  allGuesses;
    }

    /**
     * Gets the total guesses across all instances of the game
     * @return Returns the result as an int
     */
    public static int getTotalGuesses()
    {
        return totalGuesses;
    }

    //Instance methods

    /**
     * Handles the playing of each individual game
     * @param rand Random object to get a random number
     * @param name Name to be used in output
     */
    public void playGame(Random rand, String name)
    {
        //Declares response to hold user input
        char response = ' ';

        while (response != 'c')
        {
            //Guesses a random number in the range
            setCurrentGuess(rand.nextInt(getLowerLimit(), getUpperLimit() + 1)); //Adds 1 because the max value is exclusive

            //Holds the user input
            response = userResponse(getCurrentGuess(), name, getAllGuesses().length);

            //Handles changing upper and lower limits
            if(response == 'l')
            {
                //Takes one away because it doesn't include the value just guessed
                setUpperLimit(getCurrentGuess() - 1);
            }
            else if (response == 'h')
            {
                //Adds one because it doesn't include the value just guessed
                setLowerLimit(getCurrentGuess() + 1);
            }
        }
    }

    /**
     * Gets either higher or lower from the user and checks if it is possible that the response is true
     * @param guess The value of the current guess
     * @param name The name of the user
     * @param guessNum The guess number
     * @return Returns what the user entered as a char
     */
    private char userResponse(int guess, String name, int guessNum)
    {
        //Declares character to hold user input
        char character = ' ';

        //If the user enters an invalid response it will loop
        //Ex. Enters lower when lowerLimit is guessed
        while(true)
        {
            while (character != 'l' && character != 'h' && character != 'c')
            {
                //String to hold the user input to be tested if it is valid
                String input = JOptionPane.showInputDialog("Guess Number: " + guessNum + "\n" +
                        "Program guessed: " + guess + "\n" +
                        name + ", is your number Higher (H), Lower (L), or is the guess Correct (C)?");

                //Assigns character to the lowercase of the first letter entered
                character = input.toLowerCase().charAt(0);
            }

            //If lowerLimit or upperLimit is guessed and the user enters lower or higher respectively, it is invalid
            if((guess == getLowerLimit() && character == 'l') ||
                    (guess == getUpperLimit() && character == 'h'))
            {
                JOptionPane.showMessageDialog(null, "Not a possible response. Try again.");

                //Resets character so that the second while loop can loop again
                character = ' ';
            }
            else
            {
                //Input is valid and returns character
                return character;
            }
        }


    }
}
