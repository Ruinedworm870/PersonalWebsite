/**
 * Used to perform the operations of the magic 8 ball
 */

import java.util.Random;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class WFS_Magic8Ball
{
  //Fields
  private ArrayList<String> responses = new ArrayList<String>();
  
  /**
   * No-arg constructor that initializes the magic 8 ball to be ready to use
   */
  
  public WFS_Magic8Ball()throws IOException
  {
    InitializeResponseText();
  }
  
  /**
   * Method used to initialize the ArrayList with the phrases in the file
   */
  
  public void InitializeResponseText()throws IOException
  {
    //Declares and initializes the file that the responses are gathered from
    File inputFile = new File("8_ball_responses.txt");
    
    //Declares and initializes the scanner that accesses the inputFile
    Scanner inputFileScanner = new Scanner(inputFile);
    
    //Adds each line in the input file to the ArrayList
    while(inputFileScanner.hasNext())
    {
      responses.add(inputFileScanner.nextLine());
    }
    
    //Closes the file
    inputFileScanner.close();
  }
  
  /**
   * Method used to add a custom String that wasn't in the responses file
   * @param str String to be added to the responses ArrayList
   */
  
  public void setResponseText(String str)
  {
    responses.add(str);
  }
  
  /**
   * Method used to get the responses that the magic 8 ball can use
   * @return Returns the ArrayList holding the Strings of the phrases the magic 8 ball can use
   */
  
  public ArrayList<String> getResponses()
  {
    return responses;
  }
  
  /**
   * Method used to get a random response from the responses ArrayList
   * @return Returns the random response as a String
   */
  
  public String getRandomResponse()
  {
    //Declares the random variable to get a random number
    Random rand = new Random();
    
    return responses.get(rand.nextInt(responses.size()));
  }
}