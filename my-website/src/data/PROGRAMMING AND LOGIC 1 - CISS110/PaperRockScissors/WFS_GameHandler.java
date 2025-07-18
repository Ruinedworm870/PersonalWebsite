/**
 * Game Handler class handles the operations in the game paper rock scissors
 */

import java.util.Random;

public class WFS_GameHandler
{
  //Declares the ints to hold the choice the player and computer chose to easily calculate the winner
  /*
   * 0 = paper
   * 1 = rock
   * 2 = scissors
   */
  private int player;
  private int computer;
  
  //Declares Random to get a random choice for the computer
  private Random rand = new Random();
  
  /**
   * setPlayerChoice method sets the players choice to the player field in the class
   * @param choice The choice that is assigned to the player field
   */
  
  public void setPlayerChoice(int choice)
  {
    player = choice;
  }
  
  /**
   * setComputerChoice method sets the field computer to a random number from 0 - 2.
   * Method is private because it doesn't need to be accesed by the rest of the program, only needs
   * to be used when determining the winner
   */ 
  
  private void setComputerChoice()
  {
    //Gets a random number from 0 - 2
    computer = rand.nextInt(3);
  }
  
  /**
   * getPlayerChoice method is used to determine the name of the users choice
   * @return Returns the choice as a String
   */
  
  public String getPlayerChoice()
  {
    //Determines the name of the choice the player made
    switch(player)
    {
      case 0:
        return "Paper";
        
      case 1:
        return "Rock";
        
      case 2:
        return "Scissors";
        
      default:
        return "";
    }
  }
  
  /**
   * getComputerChoice method is used to set the computers choice to a string 
   * @return Returns the choice as a String
   */
  
  public String getComputerChoice()
  {
    //Determines the name of the choice the computer made
    switch(computer)
    {
      case 0:
        return "Paper";
      
      case 1:
        return "Rock";
        
      case 2:
        return "Scissors";
        
      default:
        return "";
    }
  }
  
  /**
   * getWinner method figures out who is the winner
   * @return Returns the winner text as a string
   */
  
  public String getWinner()
  {
    //Calls the method to set computer to a random number, so that the program doesn't have to
    setComputerChoice();
    
    if(player == computer - 1 || player == computer + 2)
    {
      //Player wins
      return "Player";
    }
    else if(player == computer)
    {
      //A tie
      return "Tie";
    }
    else
    {
      //Computer wins
      return "Computer";
    }
  }
}