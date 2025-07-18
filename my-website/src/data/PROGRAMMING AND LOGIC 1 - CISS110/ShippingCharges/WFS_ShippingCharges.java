/**
 * William Smolinski
 * 10/10/21
 * Shipping Charges programming assignment, asks the user for the weight of the package 
 * and miles driven with the package and returns the shipping charges
 */

import java.util.Scanner;

class WFS_ShippingCharges
{
  public static void main(String[] args)
  {
    //Declares and initializes the scanner to detect keyboard input
    Scanner keyboard = new Scanner(System.in);
    
    //Asks the user for the weight of the package
    System.out.println("How many pounds was the package?");
    double weightOfPackage = keyboard.nextDouble();
    
    //Asks the user how far they traveled with the package
    System.out.println("How many miles did you travel with the package?");
    double milesTraveled = keyboard.nextDouble();
    
    //Declares the variable to store the cost per 500 miles
    double costPer500Miles;
    
    //Determines the cost per 500 miles of the package
    if(weightOfPackage <= 2)
    {
      costPer500Miles = 1.10;
    }
    else if(weightOfPackage < 6)
    {
      costPer500Miles = 2.20;
    }
    else if(weightOfPackage < 10)
    {
      costPer500Miles = 3.70;
    }
    else
    {
      costPer500Miles = 3.80;
    }
    
    //Calculates the total cost
    double totalCost = Math.ceil(milesTraveled / 500) * costPer500Miles;
    
    //Displays the total cost
    System.out.printf("Your total cost for taking a " + weightOfPackage + 
                       " pound package " + milesTraveled + " miles is: $%.2f", totalCost);
  }
}