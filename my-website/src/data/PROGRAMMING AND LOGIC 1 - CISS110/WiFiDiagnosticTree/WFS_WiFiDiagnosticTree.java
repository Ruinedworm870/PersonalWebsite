/**
 * William Smolinski
 * 10/10/21
 * Wi-Fi Diagnostic Tree programming assignment, leads the user through the steps
 * of fixing a bad Wi-Fi connection
 */

import java.util.Scanner;

class WFS_WiFiDiagnosticTree
{
  public static void main(String[] args)
  {
    //Declares and initializes the scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Declare the String to hold the user input
    String userInput;
    
    //Lets the user know how to respond
    System.out.println("\nEnter yes or no for all questions \n");
    
    //Prompts the user with the first question
    System.out.println("Reboot the computer and try to connect \n");
    
    //Asks the user if that fixed the problem
    System.out.print("Did that fix the problem? ");
    userInput = keyboard.nextLine();
    
    //Determines whether the user entered yes or no
    if(userInput.equals("no") || userInput.equals("No"))
    {
      //Asks the next question
      System.out.println("\nReboot the router and try to connect \n");
      
      //Asks if that fixed the problem
      System.out.print("Did that fix the problem? ");
      userInput = keyboard.nextLine();
      
      //Determines whether the user entered yes or no
      if(userInput.equals("no") || userInput.equals("No"))
      {
        //Asks the next question
        System.out.println("\nMake sure the cables between the router and modem are plugged" + 
                           " in firmly \n");
        
        //Asks if that fixed the problem
        System.out.print("Did that fix the problem? ");
        userInput = keyboard.nextLine();
                           
        //Determines whether the user entered yes or no
        if(userInput.equals("no") || userInput.equals("No"))
        {
          //Asks the next question
          System.out.println("\nMove the router to a new location and try to connect \n");
        
          //Asks if that fixed the problem
          System.out.print("Did that fix the problem? ");
          userInput = keyboard.nextLine();
          
          //Determines whether the user entered yes or no
          if(userInput.equals("no") || userInput.equals("No"))
          {
            //Displays the final message
            System.out.println("\nGet a new router");
          }
          else
          {
            //Displays the exiting message
            System.out.println("\nProblem solved, exiting the program");
          }
        }
        else
        {
          //Displays the exiting message
          System.out.println("\nProblem solved, exiting the program");
        }
      }
      else
      {
        //Displays the exiting message
        System.out.println("\nProblem solved, exiting the program");
      }
    }
    else
    {
      //Displays the exiting message
      System.out.println("\nProblem solved, exiting the program");
    }
  }
}