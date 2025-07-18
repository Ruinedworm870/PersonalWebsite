/** 
 * William Smolinski
 * September 25th, 2021
 * Strings programming assignment, take some information about the user and display a short paragraph
 */

import java.util.Scanner;

public class WFS_Strings
{
  public static void main(String[] args)
  {
    // Declares and initialzes the Scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    // Gets the users city of birth and assigns it to a String
    System.out.println("Enter your city of birth: ");
    String cityOfBirth = keyboard.nextLine();
    
    // Gets the users favorite sport and assigns it to a String
    System.out.println("Enter your favorite sport: ");
    String favoriteSport = keyboard.nextLine();
    
    // Gets where the user would like to live and assigns it to a String
    System.out.println("Enter any place in the world you would like to live: ");
    String placeToLive = keyboard.nextLine();
    
    // Gets the users dream vacation and assigns it to a String
    System.out.println("Enter your dream vacation: ");
    String dreamVacation = keyboard.nextLine();
    
    // Displays the paragraph
    System.out.print("\nYou were born in " + cityOfBirth + 
                     " and you like the sport of " + favoriteSport + 
                     ". You would also like to live in " + placeToLive + 
                     " and your dream vacation is " + dreamVacation + "\n");
  }
}