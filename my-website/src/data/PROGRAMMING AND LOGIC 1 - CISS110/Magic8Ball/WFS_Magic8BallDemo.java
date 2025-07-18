/**
 * William Smolinski
 * 12/6/21
 * Magic 8 Ball assignment, simulates a magic 8 ball
 */

import java.util.Scanner;
import java.io.*;

public class WFS_Magic8BallDemo
{
  public static void main(String[] args)throws IOException
  {
    //Declares and initializes a Scanner to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the magic8Ball object
    WFS_Magic8Ball magic8Ball = new WFS_Magic8Ball();
    
    askQuestion(keyboard, magic8Ball);
  }
  
  /**
   * Method used to ask the user a question
   * @param keyboard Reference to the Scanner keyboard object
   * @param magic8Ball Reference to the magic 8 ball object
   */
  
  private static void askQuestion(Scanner keyboard, WFS_Magic8Ball magic8Ball)
  {
    do
    {
      //Asks the user to enter a yes or no question
      System.out.println("Ask a yes or no question: ");
      keyboard.nextLine();
      
      //Creates a blank line
      System.out.println();
      
      //Displays a random response
      System.out.println(magic8Ball.getRandomResponse());
      
    }while(keepAsking(keyboard));
  }
  
  /**
   * Method used to determine if the user wants to keep using the program
   * @param keyboard Reference to the Scanner keyboard object
   * @return Returns whether or not the user wants to continue as a boolean
   */
  
  private static boolean keepAsking(Scanner keyboard)
  {
    //Creates a blank line
    System.out.println();
    
    //Asks the user if they want to continue
    System.out.print("Do you want to continue? (y = yes) ");
    char answer = keyboard.nextLine().charAt(0);
    
    //Creates a blank line
    System.out.println();
    
    if(answer == 'y' || answer == 'Y')
    {
      //The user wants to continue using the program
      return true;
    }
    else
    {
      //Thanks the user for using the program
      System.out.println("Thanks for using the Program, Exiting now...");
      
      return false;
    }
  }
}