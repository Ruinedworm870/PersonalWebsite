/**
 * William Smolinski
 * 12/6/21
 * Name Search Assignment, Searches through many popular names and lets the user know if the name entered was among the most popular
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class WFS_NameSearch
{
  public static void main(String[] args)throws IOException
  {
    //Declares the Scanner to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the ArrayLists
    ArrayList<String> boyNames = new ArrayList<String>();
    ArrayList<String> girlNames = new ArrayList<String>();
    
    //Calls the create Arrays method
    createArrays(boyNames, girlNames);
    
    //Asks the user to enter a name
    System.out.print("Enter a name you want to search for: ");
    String name = keyboard.nextLine();
    
    //Creates a blank line
    System.out.println();
    
    //Determines whether the name was in the ArrayLists and lets the user know the result
    if(searchForName(boyNames, girlNames, name))
    {
      //Name was in the list
      System.out.println(name + " was in the list");
    }
    else
    {
      //Name was not in the list
      System.out.println(name + " was not in the list");
    }
    
    //Thanks the user for using the program
    System.out.println("\nThanks for using the program, Exiting now...");
  }
  
  /**
   * Method used to access the files and assign the names to the arrayLists
   * @param boys ArrayList to hold boys names
   * @param girls ArrayList to hold girl names
   */
  
  private static void createArrays(ArrayList<String> boys, ArrayList<String> girls)throws IOException
  {
    //Creates the Strings to hold the file names so they can be easily changed
    String boysFileName = "BoyNames.txt";
    String girlsFileName = "GirlNames.txt";
    
    //Sets up the files to be read from
    File boysFile = new File(boysFileName);
    File girlsFile = new File(girlsFileName);
    
    Scanner boysFileInput = new Scanner(boysFile);
    Scanner girlsFileInput = new Scanner(girlsFile);
    
    //Assigns the Strings the the ArrayLists
    while(boysFileInput.hasNext())
    {
      boys.add(boysFileInput.nextLine());
    }
    
    while(girlsFileInput.hasNext())
    {
      girls.add(girlsFileInput.nextLine());
    }
    
    //Closes the files
    boysFileInput.close();
    girlsFileInput.close();
  }
  
  /**
   * Method used to search for the name the user enetered
   * @param boys ArrayList that has the boys names
   * @param girls ArrayList that has the girls names
   * @param name The name the user entered for the program to search for
   * @return Returns true or false depending on if the name is in the lists or not
   */
  
  private static boolean searchForName(ArrayList<String> boys, ArrayList<String> girls, String name)
  {
    for(int i = 0; i < boys.size(); i++)
    {
      if(boys.get(i).equals(name))
      {
        return true;
      }
    }
    
    for(int j = 0; j < girls.size(); j++)
    {
      if(girls.get(j).equals(name))
      {
        return true;
      }
    }
    
    return false;
  }
}