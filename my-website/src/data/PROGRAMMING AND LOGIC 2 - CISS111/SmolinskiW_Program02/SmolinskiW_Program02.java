/**
 * William Smolinski
 * CISS 111
 * Program02 - Plays a guessing game between the user and the program
 */

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Random;

public class SmolinskiW_Program02
{
    public static void main(String[] args)
    {
        //ArrayList to hold all the games
        ArrayList<Game> games = new ArrayList<Game>();

        //Creates the random class to be used in each game
        Random rand = new Random();

        //Holds the users name
        String name;

        //Holds the total number of games to be played
        int totalGames;

        //Asks the user for their name
        name = JOptionPane.showInputDialog("What is your name?");

        //Asks the user for the number of games to play
        totalGames = getInput(Integer.parseInt(JOptionPane.showInputDialog(name + ", enter the number of games to be played: ")));

        //Creates and plays each game for the amount of games to be played
        for(int i = 0; i < totalGames; i++)
        {
            games.add(new Game());
            games.get(i).playGame(rand, name);
        }

        //Shows information at the end of the games
        showOutput(name, games, Game.getTotalGuesses());
    }

    /**
     * Gets the input from the user and ensures it is within the valid range
     * @param num Initial value entered by the user
     * @return Returns the valid user input
     */
    public static int getInput(int num)
    {
        //While the number is less than 1 it will loop
        while(num < 1)
        {
            num = Integer.parseInt(JOptionPane.showInputDialog("Enter a number greater than 0: "));
        }

        return  num;
    }

    /**
     * Used for keeping main method neat and prints the data at the end of the games
     * @param name Name of the user
     * @param games The ArrayList holding all the game objects
     * @param totalGuesses Total guesses across all games
     */
    public static void showOutput(String name, ArrayList<Game> games, int totalGuesses)
    {
        //Prints the total number of guesses and asks if the user would like more info and stores it in a String
        String outputOption = JOptionPane.showInputDialog(name + ", the total number of guesses across all games (" + games.size() + ") was: " + totalGuesses + "\n" +
                "Would you like more info? Enter A to list all guesses, or enter a number for the guesses in that game only (N to quit).");

        //Holds the formatted output do display in the dialog box
        String output = "";

        //To print out all guesses in order
        if(outputOption.toLowerCase().charAt(0) == 'a')
        {
            //Loops through each allGuesses array in each game
            for(int i = 0; i < games.size(); i++)
            {
                for(int j = 0; j < games.get(i).getAllGuesses().length; j++)
                {
                    output += (j + 1) + ": " + games.get(i).getAllGuesses()[j] + "\n";
                }

                //Displays the guesses in each game, one game at a time
                JOptionPane.showMessageDialog(null, "Game " + (i + 1) + ": \n" + output);

                //Resets the output String
                output = "";
            }

            //Thanks the user for using the program
            JOptionPane.showMessageDialog(null, "Thanks " + name + " for using the program!");
        }
        else if(outputOption.toLowerCase().charAt(0) == 'n') //Properly quitting the program
        {
            JOptionPane.showMessageDialog(null, "Thanks " + name + " for using the program!");
        }
        else if(Integer.parseInt(outputOption) > 0) //To get a specific games guesses
        {
            //Holds the index of the game to be output
            int gameIndex = Integer.parseInt(outputOption) - 1;

            //Determines if the user wants to keep getting data for new games
            Boolean moreGames = true;

            //Checks to make sure gameIndex is valid
            if(gameIndex < 0 || gameIndex >= games.size())
            {
                moreGames = false;
            }

            //Loops until the user is done
            while(moreGames)
            {
                for(int i = 0; i < games.get(gameIndex).getAllGuesses().length; i++)
                {
                    output += (i + 1) + ": " + games.get(gameIndex).getAllGuesses()[i] + "\n";
                }

                //Shows the user the output and asks if they want to continue
                String moreGamesInput = JOptionPane.showInputDialog("Game " + (gameIndex + 1) + ": \n" + output + "\n" +
                        name + ", would you like to continue? Enter a game number or -1 to quit, total games: " + games.size());

                //Converts the String to an int
                int numEntered = Integer.parseInt(moreGamesInput);

                //If it is a valid number of a game
                if(numEntered > 0 && numEntered <= games.size())
                {
                    gameIndex = numEntered - 1;

                    //Resets output
                    output = "";
                }
                else //Exits the program
                {
                    moreGames = false;
                }
            }

            //Thanks the user for using the program
            JOptionPane.showMessageDialog(null, "Thanks " + name + " for using the program!");
        }
    }
}
