/**
 * William Smolinski
 * 10/22/21
 * Loop Patterns assignment, makes various patterns using loops
 */

import java.util.Scanner;

public class WFS_LoopPatterns
{
  public static void main(String[] args)
  {
    //Declares and initializes the scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares and initializes the variable to hold which pattern to show
    int pattern = 0;
    
    do
    {
      //Asks the user what pattern they want to see
      System.out.print("What pattern do you want to see? (enter 1 - 5) ");
      pattern = keyboard.nextInt();
      
    }while(pattern < 1 || pattern > 5);
    
    //Adds an extra blank line
    System.out.println();
    
    //Displays each pattern depending on user input
    switch(pattern)
    {
      case 1: //Displays pattern 1
        
      for(int rows = 0; rows < 5; rows++)
      {
        for(int columns = 0; columns < 5; columns++)
        {
          if(rows % 2 == 0)
          {
            System.out.print("*A");
          }
          else
          {
            System.out.print("A*");
          }
        }
        System.out.println();
      }
        
        break;
        
      case 2: //Displays pattern 2
        
      for(int rows = 1; rows <= 10; rows++)
      {
        for(int columns = 1; columns <= rows; columns++)
        {
          System.out.print("A");
        }
        System.out.println();
      }
        
        break;
        
      case 3: //Displays pattern 3
        
      for(int rows = 10; rows > 0; rows--)
      {
        for(int columns = rows; columns > 0; columns--)
        {
          System.out.print("A");
        }
        System.out.println();
      }
        
        break;
        
      case 4: //Displays pattern 4
        
      for(int rows  = 10; rows > 0; rows--)
      {
        for(int blanks = 10 - rows; blanks > 0; blanks--)
        {
          System.out.print(" ");
        }
        
        for(int letters = rows; letters > 0; letters--)
        {
          System.out.print("A");
        }
        System.out.println();
      }
        
        break;
        
      case 5: //Displays pattern 5
        
      for(int rows  = 9; rows > 0; rows--)
      {
        for(int firstLetter = rows; firstLetter > 0; firstLetter--)
        {
          System.out.print("A");
        }
        
        for(int secondLetter = (9 - rows) + 1; secondLetter > 0; secondLetter--)
        {
          System.out.print("X");
        }
        System.out.println();
      }
        
        break;
    }
  }
}