/**
 * William Smolinski
 * 10/22/21
 * Upper Case Converter Assignment, asks the user for two files one to read information
 * from and the other will be where the ouput goes and the output includes
 * the first file but all the letters are converted to upper case
 */

import java.util.Scanner;
import java.io.*;

public class WFS_UpperCaseConverter
{
  public static void main(String[] args)throws IOException
  {
    //Declares and initializes a Scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the file variable
    File file1;
    
    //Loops until a valid file name is entered
    do
    {
      //Asks for the first files name
      System.out.print("Enter the input files name: ");
      String firstFileName = keyboard.nextLine();
      
      //Gets the file with the file name and checks if it exists
      file1 = new File(firstFileName);
      
      //Checks to see if the file doesn't exist then it tells the user the file doesn't exist
      if(!file1.exists())
      {
        System.out.println("Invalid file name: " + firstFileName + "\nTry again");
      }
      
    }while(!file1.exists());
    
    //Declares the Scanner to read the file
    Scanner inputFile = new Scanner(file1);
    
    //Asks for the second files name
    System.out.print("Enter the output files name: ");
    String secondFileName = keyboard.nextLine();
    
    //Declares the PrintWriter for the output file
    PrintWriter outputFile = new PrintWriter(secondFileName);
    
    //Uses a while loop to iterate for each line of the input file
    while(inputFile.hasNext())
    {
      //Writes the line to the output file converted to all upper case letters
      outputFile.println(inputFile.nextLine().toUpperCase());
    }
    
    //Closes the files
    inputFile.close();
    outputFile.close();
    
    //Tells the user the program executed successfully
    System.out.println("The file has converted successfully");
  }
}