/**
 * William Smolinski
 * 10/22/21
 * Ave Rainfall Assignment, determines the average rainfall over a period of years
 */

import java.util.Scanner;

public class WFS_AveRainfall
{
  public static void main(String[] args)
  {
    //Declares and initializes a Scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the variables to hold the total months, total rainfall, and average rainfall
    int totalMonths = 0;
    double totalRainfall = 0, averageRainfall = 0;
    
    //Declares and initializes years to 0 for the while loop
    int years = 0;
    
    //Asks the user for the number of years and makes sure the input is > 0
    do
    {
      System.out.print("How many years do you want to calculate the average for? ");
      years = keyboard.nextInt();
      
    }while(years <= 0);
    
    //Adds an extra empty line
    System.out.println();
    
    //Declares the String to hold the months name for output
    String monthName = "";
    
    //First loop to iterate per year
    for(int i = 1; i <= years; i++)
    {
      //Second loop to iterate per month
      for(int month = 1; month <= 12; month++)
      {
        //Switch to determine the months name
        switch(month)
        {
        case 1: //January
          monthName = "January";
          break;
          
        case 2: //February 
          monthName = "February";
          break;
          
        case 3: //March
          monthName = "March";
          break;
          
        case 4: //April
          monthName = "April";
          break;
          
        case 5: //May
          monthName = "May";
          break;
          
        case 6: //June
          monthName = "June";
          break;
          
        case 7: //July
          monthName = "July";
          break;
          
        case 8: //August
          monthName = "August";
          break;
          
        case 9: //September
          monthName = "September";
          break;
          
        case 10: //October
          monthName = "October";
          break;
          
        case 11: //November
          monthName = "November";
          break;
          
        case 12: //December
          monthName = "December";
          break;
      }
        
      //Declares input rainfall to be used to check if the rainfall entered is valid
      double rainfall = -1;
        
      //Gets the rainfall for the month from the user and repeats until a valid number is entered
      do
      {
        System.out.print("Enter the inches of rainfall for " + monthName + " of year " + i + ": ");
        rainfall = keyboard.nextDouble();
        
      }while(rainfall < 0);
      
      //Adds an extra empty line
      System.out.println();
      
      //Adds 1 to the total months variable
      totalMonths++;
      
      //Adds the valid rainfall amount to the total rainfall
      totalRainfall += rainfall;
    }
   }
    //Calculates the average rainfall rounded to 2 decimal places
    averageRainfall = Math.round((totalRainfall / totalMonths) * 100.0) / 100.0;
  
    //Ouputs the average rainfall
    System.out.println("The average rainfall for " + totalMonths + " months" + 
    " was " + averageRainfall + " inches, with a total rainfall of " + totalRainfall + " inches.");
  }
}