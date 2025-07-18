/**
 * William Smolinski
 * CISS 111
 * Program05 - Gets all the words and the number of times they appear in a text file
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SmolinskiW_Program05
{
    public static void main(String[] args)
    {
        //Declares a Scanner to get input from the user
        Scanner keyboard = new Scanner(System.in);

        //Declares the ArrayList to hold the word objects
        ArrayList<Word> words = new ArrayList<Word>();

        //Boolean to hold whether to continue or not to get multiple files in the output
        boolean canContinue = true;

        //Declares the Scanner to handle reading the file
        Scanner inputFile;

        //Declares the PrintWriter to write the output to a file
        PrintWriter outputFile;

        //Added this so that you can get the words from as many files as you want in the output file totalled together
        while(canContinue)
        {
            inputFile = getValidInputFileName(keyboard);

            handleWords(words, inputFile);

            inputFile.close();

            //Lets the user know the operation completed successfully
            System.out.println("Operation completed successfully");

            //Asks the user if they want to add another file to the output
            System.out.print("\nWould you like to get another file in the output? (y or n) ");
            if(!keyboard.nextLine().equals("y"))
            {
                canContinue = false;
            }
        }

        //Assigning the PrintWriter for output
        outputFile = getValidOutputFile(keyboard);

        //Creates the contents of the file
        for(int i = 0; i < words.size(); i++)
        {
            outputFile.println(words.get(i).getWord() + ": " + words.get(i).getNum());
        }
        outputFile.close();

        //Tells the user the operation was successful, and thanks them for using the program
        System.out.println("Operation Successful! Thanks for using the program!");

    }

    /**
     * Method to get a valid file name as input. It's not needed in the instructions, although
     * I added this so that the program can be tested with other text files and to show
     * that the try catch clauses work
     * @param keyboard Scanner to get user input
     * @return Returns a reference to a Scanner to read a file
     */
    public static Scanner getValidInputFileName(Scanner keyboard)
    {
        //Declares a File to read from a file
        File file;

        //String to hold the file name from user input
        String fileName;

        //Will loop until a valid input is received and returned
        while(true)
        {
            //Asks the user for the file name
            System.out.print("Enter the file name: ");
            fileName = keyboard.nextLine();

            try
            {
                file = new File(fileName);

                //Creates a new Scanner and returns the reference
                return new Scanner(file);
            }
            catch(IOException e)
            {
                //File does not exist
                System.out.println("NOT A VALID FILE NAME: " + e.getMessage());
            }
        }
    }


    public static PrintWriter getValidOutputFile(Scanner keyboard)
    {
        //Will loop until a valid input is received and returned
        while(true)
        {
            //Asks the user how where they want the output
            System.out.print("What file do you want your output in? ");

            try
            {
                return new PrintWriter(keyboard.nextLine());
            }
            catch (Exception e)
            {
                System.out.println("OUTPUT ERROR: " + e.getMessage());
            }
        }
    }

    /**
     * Method to handle getting each individual word in the file and calling the method to add it to the ArrayList
     * @param words ArrayList that holds the Word objects
     * @param inputFile Scanner that gets input from a file
     */
    public static void handleWords(ArrayList<Word> words, Scanner inputFile)
    {
        //String to hold the current line in the file
        String line;

        //Will loop for the number of lines in th file
        while(inputFile.hasNext())
        {
            line = inputFile.nextLine();

            //Converts it to uppercase because it is case-insensitive
            line = line.toUpperCase();

            //String Array to hold each individual word in a line (separated by white space)
            //This also splits hyphenated words because in the instructions it says to ignore hyphens
            //although hyphenated words could be considered one word
            String[] lineSplit = line.split(" |-");

            //Checks the word to remove punctuation and numbers for each String in lineSplit
            for(int i = 0; i < lineSplit.length; i++)
            {
                //String that gets only valid characters concatenated onto it and passed to be added as a word
                String word = "";

                //If the String isn't blank (Present at the start of Lose yourself to dance.txt -> there is an extra space)
                if(!lineSplit[i].equals(""))
                {
                    //Loops for each character in the String
                    for(int j = 0; j < lineSplit[i].length(); j++)
                    {
                        //If it is a letter or apostrophe it will be added to the word
                        if(Character.isLetter(lineSplit[i].charAt(j)) ||
                                lineSplit[i].charAt(j) == '\'')
                        {
                            word += lineSplit[i].charAt(j);
                        }
                    }

                    //If nothing was added to the word String it won't be added to the ArrayList
                    if(!word.equals(""))
                    {
                        //Calls the method to handle adding the word to the ArrayList
                        addWord(word, words);
                    }
                }
            }
        }
    }

    /**
     * Method to search the ArrayList to see if the word already exists or adding it at the end
     * @param word Word to add or search in the ArrayList for
     * @param words ArrayList of the Word objects
     */
    public static void addWord(String word, ArrayList<Word> words)
    {
        //Boolean to hold whether the word was found in the ArrayList or not
        boolean found = false;

        //int to hold the current index in the ArrayList that the program is at
        int count = 0;

        //Will loop until the word is found in the ArrayList, or it loops to be larger than the ArrayList size
        while(!found && count < words.size())
        {
            //If the word is that same as the one in the ArrayList it adds one to the total
            if(words.get(count).getWord().equals(word))
            {
                words.get(count).addOne();
                found = true;
            }
            else
            {
                count++;
            }
        }

        //If the word wasn't found in the ArrayList it adds it
        if(!found)
        {
            words.add(new Word(word));
        }
    }
}
