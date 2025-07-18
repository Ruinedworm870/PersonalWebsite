/**
 * William Smolinski
 * CISS 111
 * Program 13 - Checks a Java source code file for proper nesting of (), {}, []
 */

import java.io.*;
import java.util.Scanner;

public class SmolinskiW_Program13
{
    public static void main(String[] args)
    {
        //Declaring a Scanner to get user input
        Scanner keyboard = new Scanner(System.in);

        //Declaring the stack to keep track of curly brackets (Separate because they aren't line based)
        LinkedStack mainStack = new LinkedStack();

        //Declaring the stack to keep track of proper parenthesis and brackets in a line (Ending with ;)
        LinkedStack lineStack = new LinkedStack();

        boolean canContinue = false;
        Scanner inputFile = null;

        //Asks the user for a file to check
        while(!canContinue)
        {
            //Try-catch to make sure the file is valid
            try
            {
                System.out.print("Enter the file name to test: ");

                File file = new File(keyboard.next());
                inputFile = new Scanner(file);

                canContinue = true;
            }
            catch (Exception e)
            {
                System.out.println("Not a valid file!");
            }
        }

        String line = "";
        int lineNum = 0;
        boolean fileIsCorrect = true;
        boolean checkForCurlyBracket = false;

        //Keeps track of what type of break the program is in (comment or literal)
        int typeOfBreak = 0;

        //Loops for each line in the file or until an error is detected
        while(inputFile.hasNext() && fileIsCorrect)
        {
            //If the last line was a line comment it resets the typeOfBreak because it no longer exists on a new line
            if(typeOfBreak == 1)
            {
                typeOfBreak = 0;
            }

            line = inputFile.nextLine();
            lineNum += 1;

            //Loops through each character in the line
            for(int i = 0; i < line.length(); i++)
            {
                if(typeOfBreak == 0)
                {
                    //Not in a comment or literal

                    char current = line.charAt(i);

                    if(current == '(' || current == '{' || current == '[')
                    {
                        //If the character is an opening symbol it adds it to the stack

                        if(current == '{')
                        {
                            //At the start of a new curly bracket it would mean the parenthesis in the method
                            //header and those aren't followed by a semicolon so this would mark the end of line
                            if(!lineStack.empty())
                            {
                                fileIsCorrect = false;
                            }
                            else
                            {
                                //Curly bracket
                                mainStack.push(current);
                            }
                        }
                        else
                        {
                            //Line specific symbols
                            lineStack.push(current);
                        }
                    }
                    else if(current == ')' || current == '}' || current == ']')
                    {
                        //If the character is a closing symbol it checks if the top of the stack is the correct
                        //opening symbol and removes it, or it ends the program

                        //CurlyBracket is separate
                        if(current == '}')
                        {
                            if(!mainStack.empty())
                            {
                                mainStack.pop();
                            }
                            else
                            {
                                fileIsCorrect = false;
                            }
                        }
                        else
                        {
                            //Checks for proper pairing of opening and closing symbols
                            if(!lineStack.empty() && ((lineStack.peek() == '(' && current == ')') ||
                                    (lineStack.peek() == '[' && current == ']')))
                            {
                                lineStack.pop();
                            }
                            else
                            {
                                fileIsCorrect = false;
                            }
                        }
                    }
                    else if(current == ';')
                    {
                        //Flags that it is the end of the line

                        if(!lineStack.empty())
                        {
                            //If the symbols on the line don't pair and there are leftovers it marks it as incorrect
                            fileIsCorrect = false;
                        }
                    }
                    else
                    {
                        //Checks if it is the start of a comment or literal

                        if(i != 0)
                        {
                            char last = line.charAt(i - 1);

                            typeOfBreak = getTypeOfBreak(last, current);
                        }
                    }
                }
                else
                {
                    //In a comment or literal (checks for the end of the comment)

                    if(i != 0)
                    {
                        char current = line.charAt(i);
                        char last = line.charAt(i - 1);

                        //Checks to see if the break is ended
                        if(resolveTypeOfBreak(last, current, typeOfBreak))
                        {
                            //Resets typeOfBreak
                            typeOfBreak = 0;
                        }
                    }
                }
            }

            //If a curly bracket is not detected the file fails
            if(checkForCurlyBracket && typeOfBreak == 0)
            {
                //Makes sure the line is not empty
                if(line.trim().length() > 0)
                {
                    if(!line.trim().startsWith("{"))
                    {
                        fileIsCorrect = false;
                    }
                    else
                    {
                        checkForCurlyBracket = false;
                    }
                }
            }

            //If a line ends with a ) without a ; the next line should start with an open curly bracket
            if(line.trim().endsWith(")") && typeOfBreak == 0) //Only checks when not in comment
            {
                checkForCurlyBracket = true;
            }
        }

        //Displays the proper message at the end
        if(fileIsCorrect && mainStack.empty())
        {
            System.out.println("The file has proper nesting of (), {}, []");
        }
        else
        {
            System.out.println("Fail detected by line: " + lineNum);
            System.out.println("The file does NOT have proper nesting of (), {}, []");
        }

        //Closes the file
        inputFile.close();
    }

    /**
     * Method to determine if the line has entered a commented section or literal
     * @param last The last char in the line
     * @param current The current char in the line
     * @return Returns the type of break as an int to be used to determine when that type of break ends
     */
    private static int getTypeOfBreak(char last, char current)
    {
        if(last == '/' && current == '/')
        {
            //In a single line comment
            return 1;
        }
        else if(last == '/' && current == '*')
        {
            //In a multiple line comment
            return 2;
        }
        else if(current == '"' && last != '\\')
        {
            //In a literal
            return 3;
        }
        else if(current == '\'' && last != '\\')
        {
            //In a char
            return 4;
        }
        else
        {
            return 0;
        }
    }

    /**
     * Method to determine if the type of break can be resolved or not
     * @param last Last char in the line
     * @param current current char in the line
     * @param type Type of break that was detected
     * @return Returns a boolean for whether the break is resolved or not
     */
    private static boolean resolveTypeOfBreak(char last, char current, int type)
    {
        switch(type)
        {
            case 2:
                return (last == '*' && current == '/');

            case 3:
                return (current == '"' && last != '\\');

            case 4:
                return (current == '\'' && last != '\\');
        }

        return false;
    }
}
