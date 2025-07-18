/**
 * William Smolinski
 * 11/19/21
 * Paper rock scissors assignment, plays a game of paper rock scissors between the user and the computer
 */

import java.util.Scanner;

public class WFS_PaperRockScissors
{
  public static void main(String[] args)
  {
    //Declares a scanner to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the GameHandler to handle the game
    WFS_GameHandler gameHandler = new WFS_GameHandler();
    
    //Calls the method to initiate the game
    gameOrder(keyboard, gameHandler);
  }
  
  /**
   * gameOrder is used to easily replay the game if it was a tie or if the user wants to go again
   * @param keyboard The scanner used to detect keyboard input from the user
   * @param gameHandler Reference to the object that handles the game
   */
  
  private static void gameOrder(Scanner keyboard, WFS_GameHandler gameHandler)
  {
    //Calls the method to start the game
    startGame(keyboard, gameHandler);
    
    //Calls the method to play the game
    playGame(keyboard, gameHandler);
  }
  
  /**
   * Starts the game by showing the rules and getting the users choice
   * @param keyboard The scanner used to detect keyboard input from the user
   * @param gameHandler Reference to the object that handles the game
   */
  
  private static void startGame(Scanner keyboard, WFS_GameHandler gameHandler)
  {
    //Displays the rules
    System.out.println("RULES: paper beats rock, rock beats scissors, scissors beats paper");
    
    //Creates a blank line
    System.out.println();
    
    //Shows the user the menu and puts the input into gameHandler if it is valid
    showMenu();
    int num = keyboard.nextInt();
    
    //Repeats until a valid option is entered
    while(num < 0 || num > 2)
    {
      System.out.println("Invalid option, try again: ");
      num = keyboard.nextInt();
    }
    
    //Creates a blank line after a valid option is chosen
    System.out.println();
    
    //Sets the users value in gameHandler
    gameHandler.setPlayerChoice(num);
  }
  
  /**
   * The method is used to call the methods in the gameHandler object and display the results
   * @param keyboard The scanner used to detect keyboard input from the user
   * @param gameHandler Reference to the object that handles the game
   */
  
  private static void playGame(Scanner keyboard, WFS_GameHandler gameHandler)
  {
    //Plays the game and determines what to do
    String winner = gameHandler.getWinner();
    
    if(winner.equals("Player"))
    {
      //Displays the player won
      System.out.println("You win the game!");
    }
    else if(winner.equals("Computer"))
    {
      //Displays the player lost
      System.out.println("You lost to the computer.");
    }
    else
    {
      //Displays it was a tie
      System.out.println("Game was a tie.");
    }
    
    //Displays what the user chose and what the computer chose
    System.out.println("You played: " + gameHandler.getPlayerChoice());
    System.out.println("The computer played: " + gameHandler.getComputerChoice());
    
    //Creates a blank line
    System.out.println();
    keyboard.nextLine();
    
    //Determines whether game has to be replayed or if the user can choose
    if(winner.equals("Tie"))
    {
      //Lets the user know tha game is restarting because of a tie
      System.out.println("Game was a tie, replaying game:");
      
      //Creates a blank line
      System.out.println();
      
      //Calls the method to restart the game
      gameOrder(keyboard, gameHandler);
    }
    else
    {
      //Asks the user if they want to replay the game
      System.out.println("Would you like to replay the game? (y = yes)");
      char answer = keyboard.nextLine().charAt(0);
      
      if(answer == 'y' || answer == 'Y')
      {
        //Lets the user know the game is restarting
        System.out.println("Replaying game:");
        
        //Creates a blank line
        System.out.println();
        
        gameOrder(keyboard, gameHandler);
      }
      else
      {
        //Thanks the user for playing
        System.out.println("Thanks for playing... Exiting Now");
      }
    }
  }
  
  /**
   * showMenu is used as a method to more neatly hold the menu
   */
  
  private static void showMenu()
  {
    //prints the menu
    System.out.print("MENU: \n" + 
                     "Enter the number to choose your option. \n" +
                     "0 --> Paper \n" + 
                     "1 --> Rock \n" + 
                     "2 --> Scissors \n" + 
                     "OPTION: ");
  }
}