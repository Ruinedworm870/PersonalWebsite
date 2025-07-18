/**
 * William Smolinski
 * 10/10/21
 * Test Scores programming assignment, asks the user for three test scores and returns the
 * average and letter grade
 */

import java.util.Scanner;

class WFS_TestScores
{
  public static void main(String[] args)
  {
    //Declares and initializes the scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Asks the user to enter 3 test scores
    System.out.println("Enter three test Scores:");
    
    System.out.print("1: ");
    int testScore1 = keyboard.nextInt();
    
    System.out.print("2: ");
    int testScore2 = keyboard.nextInt();
    
    System.out.print("3: ");
    int testScore3 = keyboard.nextInt();
    
    //Calculates the average rounded to a whole number
    int average = (int) Math.round((testScore1 + testScore2 + testScore3) / 3.0);
    
    //Declare the char to hold the letter grade
    char letterGrade;
    
    //Determines the letter grade for the average score
    if(average >= 90)
    {
      letterGrade = 'A';
    }
    else if(average >= 80)
    {
      letterGrade = 'B';
    }
    else if(average >= 70)
    {
      letterGrade = 'C';
    }
    else if(average >= 60)
    {
      letterGrade = 'D';
    }
    else
    {
      letterGrade = 'F';
    }
    
    //Displays the average and the letter grade
    System.out.println("Your average is: " + average);
    System.out.println("Your letter grade is: " + letterGrade);
  }
}