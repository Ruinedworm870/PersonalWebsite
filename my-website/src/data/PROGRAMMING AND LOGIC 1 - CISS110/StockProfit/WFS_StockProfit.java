/**
 * William Smolinski
 * 11/8/21
 * Stock Profit assignment, takes in information about a stock and returns the profit or loss
 */

import java.util.Scanner;

public class WFS_StockProfit
{
  public static void main(String[] args)
  {
    //Declares the scanner keyboard to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the variable to hold the user input and profit
    double shares, purchasePrice, purchaseCommission, salePrice, saleCommission, profit;
    
    //Asks the user for the total shares purchased
    System.out.print("What are the total number of shares purchased? ");
    shares = keyboard.nextDouble();
    
    //Asks the user for the purchase price of the shares
    System.out.print("What was the purchase price of the shares? ");
    purchasePrice = keyboard.nextDouble();
    
    //Asks the user for the purchase commission
    System.out.print("What was the purchase commission paid? ");
    purchaseCommission = keyboard.nextDouble();
    
    //Asks the user for the sale price of the shares
    System.out.print("What was the sale price of the shares? ");
    salePrice = keyboard.nextDouble();
    
    //Asks the user for the sale commission
    System.out.print("What was the sale commission paid? ");
    saleCommission = keyboard.nextDouble();
    
    //Calls the CalculateProfit method
    profit = calculateProfit(shares, purchasePrice, purchaseCommission, salePrice, saleCommission);
    
    //Creates a blank line
    System.out.println();
    
    //Determines whether the sale was a profit or a loss and outputs to the user
    if(profit > 0)
    {
      //Sale was profit
      System.out.printf("You profited $%.2f from the sale.", profit);
    }
    else if(profit < 0)
    {
      //Sale was at a loss
      
      //Converts profit to a positive number for output
      profit *= -1;
      
      System.out.printf("You sold at a loss of $%.2f", profit);
    }
    else
    {
      //You didn't profit or lose any money
      System.out.println("You didn't profit or lose and money.");
    }
  }
  
  /**
   * calculateProfit method takes in the information neccessary to calculate a profit or loss on a stock
   * @param shares number of shares
   * @param purchasePrice purchase price per share
   * @param purchaseCommission purchase commission paid
   * @param salePrice sale price per share
   * @param saleCommission sale commission paid
   * @return returns the profit or loss as a double
   */
  
  public static double calculateProfit(double shares, double purchasePrice, double purchaseCommission, 
                                       double salePrice, double saleCommission)
  {
    //returns the profit or loss
    return ((shares * salePrice) - saleCommission) - ((shares * purchasePrice) + purchaseCommission);
  }
}