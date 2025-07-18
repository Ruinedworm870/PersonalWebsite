/**
 * William Smolinski
 * 10/29/21
 * This will prompt the user with a menu to then choose an option of what
 * to do with the two numbers that they entered
 */

import java.util.Scanner;

public class WFS_SwitchWithMethods
{
  public static void main(String[] args)
  {
    //Declares the scanner to get user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the finalNum variable to hold the final number
    double finalNum = 0;
    
    //Declares the doubles to hold the two numbers from user input
    double num1 = 0, num2 = 0;
    
    //Declares the repeat boolean to determine when the program should stop repeating
    boolean repeat = true;
    
    //Declares the char to hold the option chosen by the user
    char optionChosen;
    
    do
    {
      //Gets the char to determine what option the user chose
      optionChosen = DisplayMenu(keyboard);
      
      //Uses the switch to determine what to do with the user input
      switch (optionChosen)
      {
        case 'A':
        case 'a':
          //Gets the two numbers and performs the calculation
          finalNum = AddTwo(GetNum(keyboard), GetNum(keyboard));
          break;
          
        case 'S':
        case 's':
          //Gets the two numbers and performs the calculation
          finalNum = SubtractTwo(GetNum(keyboard), GetNum(keyboard));
          break;
          
        case 'M':
        case 'm':
          //Gets the two numbers and performs the calculation
          finalNum = MultiplyTwo(GetNum(keyboard), GetNum(keyboard));
          break;
          
        case 'D':
        case 'd':
          //Gets the two numbers 
          num1 = GetNum(keyboard);
          num2 = GetNum(keyboard);
          
          //Repeats until the user enters a number other than 0 for num2
          while(num2 == 0)
          {
            System.out.println("Can't divide by 0");
            num2 = GetNum(keyboard);
          }
          
          finalNum = DivideTwo(num1, num2);
          break;
          
        case 'O':
        case 'o':
          //Gets the two numbers 
          num1 = GetNum(keyboard);
          num2 = GetNum(keyboard);
          
          //Repeats until the user enters a number other than 0 for num2
          while(num2 == 0)
          {
            System.out.println("Can't divide by 0");
            num2 = GetNum(keyboard);
          }
          
          finalNum = ModulusTwo(num1, num2);
          break;
          
        case 'E':
        case 'e':
          //Thanks the user for using the program
          System.out.println("Thanks for using the program");
          
          //sets repeat to false so the program stops running
          repeat = false;
          break;
          
        default:
          //Tells the user they entered an invalid option
          System.out.println("Invalid option");
      }
      
      //Only displays the results of the calculation if there was a calculation
      if(repeat)
      {
        System.out.printf("Result: %.2f", finalNum);
        //Creates empty lines before the program repeats
        System.out.println();
        System.out.println();
        
        keyboard.nextLine();
      }
      
    }while(repeat);
  }
  
  /**
   * Shows the user the menu and has the user choose a menu option
   * @param uses the scanner keyboard to get user input
   * @return returns a char to do the performed task of the option
   */
  
  public static char DisplayMenu(Scanner keyboard)
  {
    //Prompts the user with the menu
    System.out.print("A -> Add two number \n" + 
                     "S -> Subtract two numbers \n" + 
                     "M -> Multiply two numbers \n" + 
                     "D -> Divide two numbers \n" + 
                     "O -> Modulus two numbers \n" + 
                     "E -> Exit \n");
    
    //Asks the user which option they want
    System.out.println("Which option do you want?");
    
    //Gets the users input and returns it
    return keyboard.nextLine().charAt(0);
  }
  
  /**
   * Asks the user to enter a number
   * @param uses the scanner keyboard to get user input
   * @return returns a the number as a double
   */
  
  public static double GetNum(Scanner keyboard)
  {
    //Tells the user to enter a number
    System.out.println("Enter a number: ");
    
    return keyboard.nextDouble();
  }
  
  /**
   * Does the calculation for adding the two numbers and returns the result
   * @param num1 number 1
   * @param num2 number 2
   * @return returns the result of the calculation as a double
   */
  
  public static double AddTwo(double num1, double num2)
  {
    return num1 + num2;
  }
  
  /**
   * Does the calculation for subtracting the two numbers and returns the result
   * @param num1 number 1
   * @param num2 number 2
   * @return returns the result of the calculation as a double
   */
  
  public static double SubtractTwo(double num1, double num2)
  {
    return num1 - num2;
  }
  
  /**
   * Does the calculation for multiplying the two numbers and returns the result
   * @param num1 number 1
   * @param num2 number 2
   * @return returns the result of the calculation as a double
   */
  
  public static double MultiplyTwo(double num1, double num2)
  {
    return num1 * num2;
  }
  
  /**
   * Does the calculation for dividing the two numbers and returns the result
   * @param num1 number 1
   * @param num2 number 2
   * @return returns the result of the calculation as a double
   */
  
  public static double DivideTwo(double num1, double num2)
  {
    return num1 / num2;
  }
  
  /**
   * Does the calculation for performing modulus on the two numbers and returns the result
   * @param num1 number 1
   * @param num2 number 2
   * @return returns the result of the calculation as a double
   */
  
  public static double ModulusTwo(double num1, double num2)
  {
    return num1 % num2;
  }
}