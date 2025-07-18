/**
 * William Smolinski
 * 10/22/21
 * Dice Game Assignment, plays a dice game with the user against the computer
 */

import java.util.Random;
import java.util.Scanner; //Added this for the tiebreaker and to do each roll

public class WFS_DiceGame
{
  public static void main(String[] args)
  {
    /*
     * Added this to determine if the user wants to do a tiebreaker if the total wins at the end
     * are the same for the computer and the user. Also I use it to have the user hit enter
     * before each roll.
     * Declares and initializes a Scanner to detect keyboard input
     */
    Scanner keyboard = new Scanner(System.in);
    
    //Creates the Random object to generate random numbers
    Random rand = new Random();
    
    //Declares the variables to hold the values needed
    int computerRoll = 0, 
      userRoll = 0,
      computerWins = 0,
      userWins = 0, 
      totalTies = 0;
    
    //Creates the for-loop to repeat the dice rolling 10 times
    for(int i = 1; i <= 10; i++)
    {
      //Creates a blank line
      System.out.println();
      
      //Has the user press enter to roll
      System.out.println("Press enter to roll");
      keyboard.nextLine();
      
      //Rolls for the computer
      computerRoll = rand.nextInt(6) + 1;
      
      //Rolls for the user
      userRoll = rand.nextInt(6) + 1;
      
      //Tests to see who won or if it was a tie
      if(userRoll > computerRoll)
      {
        //The user won
        
        //Displays that the user won
        System.out.println("Round " + i + " won! You rolled a " + userRoll + 
                           " and the computer rolled a " + computerRoll + ".");
        
        //Adds 1 to user wins
        userWins++;
      }
      else if(userRoll == computerRoll)
      {
        //The user and computer tied
        
        //Displays that it was a tie
        System.out.println("Round " + i + " tied. You rolled a " + userRoll + 
                           " and the computer rolled a " + computerRoll + ".");
        
        //Adds 1 to total ties
        totalTies++;
      }
      else
      {
        //The computer won
        
        //Displays the the computer won
        System.out.println("Round " + i + " lost. You rolled a " + userRoll + 
                           " and the computer rolled a " + computerRoll + ".");
        
        //Adds 1 to computer wins
        computerWins++;
      }
    }
    
    //Adds and extra blank line
    System.out.println();
    
    //Determines who the grand winner was
    if(userWins > computerWins)
    {
      //User is the grand winner
      
      //Displays that the user is the grand winner
      System.out.println("You are the grand winner! You won " + userWins + " times, " + 
                         "the computer won " + computerWins + " times " + 
                         "and you tied the computer " + totalTies + " times.");
    }
    else if(userWins == computerWins)
    {
      //The user and the computer tied
      
      //Tells the user they tied and asks for a tiebreaker
      System.out.print("You tied with the computer. You both had " + userWins + " wins and " + 
                         totalTies + " ties. Would you like to do a tiebreaker?" + 
                         " (y for yes, n for no) ");
      String tiebreaker = keyboard.nextLine();
      
      if(tiebreaker.equalsIgnoreCase("y"))
      {
        while(userWins == computerWins)
        {
          //Creates a blank line
          System.out.println();
          
          //Has the user press enter before the next roll
          System.out.println("Press enter to roll");
          keyboard.nextLine();
          
          //Rolls for the computer
          computerRoll = rand.nextInt(6) + 1;
          
          //Rolls for the user
          userRoll = rand.nextInt(6) + 1;
          
          //Tests to see who won or if it was a tie
          if(userRoll > computerRoll)
          {
            //The user won
            
            //Displays that the user won
            System.out.println("Round " + (userWins + computerWins + totalTies + 1) + 
                               " won! You rolled a " + userRoll + 
                               " and the computer rolled a " + computerRoll + ".");
            
            //Adds 1 to user wins
            userWins++;
          }
          else if(userRoll == computerRoll)
          {
            //The user and computer tied
            
            //Displays that it was a tie
            System.out.println("Round " + (userWins + computerWins + totalTies + 1) + 
                               " tied. You rolled a " + userRoll + 
                               " and the computer rolled a " + computerRoll + ".");
            
            //Adds 1 to total ties
            totalTies++;
          }
          else
          {
            //The computer won
            
            //Displays the the computer won
            System.out.println("Round " + (userWins + computerWins + totalTies + 1) + 
                               " lost. You rolled a " + userRoll + 
                               " and the computer rolled a " + computerRoll + ".");
            
            //Adds 1 to computer wins
            computerWins++;
          }
        }
        
        //Creates a blank line
        System.out.println();
        
        //Tests to see who won after the tiebreaker
        if(userWins > computerWins)
        {
          //The user is the grand winner
          
          //Displays that the user is the grand winner
          System.out.println("You are the grand winner! You won in the tiebreaker with " + userWins + 
                             " wins, " + "the computer won " + computerWins + " times " + 
                             "and you tied the computer " + totalTies + " times.");
        }
        else
        {
          //The computer is the grand winner
          
          //Displays that the computer is the grand winner
          System.out.println("The computer is the grand winner. You lost in the tiebreaker with " + 
                             userWins + " wins, " + "the computer won " + computerWins + " times " + 
                             "and you tied the computer " + totalTies + " times.");
        }
        
      }
    }
    else
    {
      //The computer is the grand winner
      
      //Displays that the computer is the grand winner
      System.out.println("The computer is the grand winner. You won " + userWins + " times, " + 
                         "the computer won " + computerWins + " times " + 
                         "and you tied the computer " + totalTies + " times.");
    }
  }
}