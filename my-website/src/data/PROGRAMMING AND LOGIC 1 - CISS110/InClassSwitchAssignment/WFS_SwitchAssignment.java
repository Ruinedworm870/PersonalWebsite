/**
 * William Smolinski
 * 10/8/21
 * This will prompt the user with a menu to then choose an option of what
 * to do with the two numbers that they entered
 */

import java.util.Scanner;

public class WFS_SwitchAssignment
{
  public static void main(String[] args)
  {
    //Declares the char choice to hold the letter the user chose
    char choice;
    
    //Declares the string to hold the user input
    String input; 
    
    //Declares the doubles that will be the numbers used by the program
    double num1,
           num2,
           num3,
           finalNum = 0;

    //Declares the boolean to decide whether the final statement is needed or not
    boolean showFinalStatement = true;
    
    //Declares the scanner to get user input
    Scanner keyboard = new Scanner(System.in);
    
    //Prompts the user with the menu
    System.out.print("A -> Add three number \n" + 
                     "S -> Subtract two numbers \n" + 
                     "M -> Multiply three numbers \n" + 
                     "D -> Divide two numbers \n" + 
                     "O -> Modulus two numbers \n" + 
                     "E -> Exit \n");
    
    //Asks the user which option they want
    System.out.println("Which option do you want?");
    
    //Gets the users input
    input = keyboard.nextLine();
    
    //Turns the first letter of the string to a char
    choice = input.charAt(0);
    
    //Uses the switch to determine what to do with the user input
    switch (choice)
    {
      case 'A':
      case 'a':
        //Asks the users for the first two numbers
        System.out.println("Enter the first two numbers:");
        
        //Gets the first two nubers
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();
        
        //Asks the user to enter the third number
        System.out.println("Your choice needs a third number. Enter the third number:");
        
        //Gets the third number for addition
        num3 = keyboard.nextInt();
        
        //Performs the calculation
        finalNum = num1 + num2 + num3;
        break;
        
      case 'S':
      case 's':
        //Asks the users for the first two numbers
        System.out.println("Enter the first two numbers:");
        
        //Gets the first two nubers
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();
        
        //Performs the calculation
        finalNum = num1 - num2;
        break;
        
      case 'M':
      case 'm':
        //Asks the users for the first two numbers
        System.out.println("Enter the first two numbers:");
        
        //Gets the first two nubers
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();
        
        //Asks the user to enter the third number
        System.out.println("Your choice needs a third number. Enter the third number:");
        
        //Gets the third number for addition
        num3 = keyboard.nextInt();
        
        //Performs the calculation
        finalNum = num1 * num2 * num3;
        break;
      
      case 'D':
      case 'd':
        //Asks the users for the first two numbers
        System.out.println("Enter the first two numbers:");
        
        //Gets the first two nubers
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();
        
        //Tests to see if num2 is 0 so that it won't divide by 0
        if(num2 == 0)
        {
          System.out.println("Can't divide by 0");
        }
        else
        {
          //Performs the calculation
          finalNum = num1 / num2;
        }
        break;
        
      case 'O':
      case 'o':
        //Asks the users for the first two numbers
        System.out.println("Enter the first two numbers:");
        
        //Gets the first two nubers
        num1 = keyboard.nextInt();
        num2 = keyboard.nextInt();
        
        //Tests to see if num2 is 0 so that it won't perform modulus by 0
        if(num2 == 0)
        {
          System.out.println("Can't perform modulus by 0");
        }
        else
        {
          //Performs the calculation
          finalNum = num1 % num2;
        }
        
        break;
        
      case 'E':
      case 'e':
        //Thanks the user for using the program
        System.out.println("Thanks for using the program");
        
        //sets the boolean to false so that the final statement isn't displayed
        showFinalStatement = false;
        break;
        
      default:
        //Tells the user they entered an invalid option
        System.out.println("Invalid option");
        
        //sets the boolean to false so that the final statement isn't displayed
        showFinalStatement = false;
    }
    
    //Determines if the final statement is shown and then shows it
    if(showFinalStatement)
    {
      System.out.printf("Result: %.2f", finalNum);
    }
  }
}