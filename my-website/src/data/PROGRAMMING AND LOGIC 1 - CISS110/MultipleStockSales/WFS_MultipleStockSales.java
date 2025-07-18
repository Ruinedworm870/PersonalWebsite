/**
 * William Smolinski
 * 11/8/21
 * Multiple Stock Sales assignment, takes in information about multiple stocks and displays the total profit or losses
 */

import java.util.Scanner;

public class WFS_MultipleStockSales
{
  public static void main(String[] args)
  {
    //Declares the scanner keyboard to detect user input
    Scanner keyboard = new Scanner(System.in);
    
    //Declares the variable to hold the user input and profit
    double shares = 0, purchasePrice = 0, purchaseCommission = 0, salePrice = 0, saleCommission = 0, profit = 0;
    
    //Asks the user the number of stocks they sold
    System.out.print("How many stocks did you sell? ");
    int stocksSold = keyboard.nextInt();
    
    //Creates a blank line
    System.out.println();
    
    for(int i = 1; i <= stocksSold; i++)
    {
      //Prints the stock the program is calculating
      System.out.println("Stock " + i + ":");
      
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
      
      //Creates a blank line
      System.out.println();
      
      //Calls the CalculateProfit method and adds the result to profit
      profit += calculateProfit(shares, purchasePrice, purchaseCommission, salePrice, saleCommission);
    }
    
    //Determines whether the sale was a profit or a loss and outputs to the user
    if(profit > 0)
    {
      //Sale was profit
      System.out.printf("You profited $%.2f from the sale of %d stocks.", profit, stocksSold);
    }
    else if(profit < 0)
    {
      //Sale was at a loss
      
      //Converts profit to a positive number for output
      profit *= -1;
      
      System.out.printf("You sold %d stocks at a loss of $%.2f", stocksSold, profit);
    }
    else
    {
      //You didn't profit or lose any money
      System.out.println("You didn't profit or lose and money from selling " + stocksSold  + " stocks.");
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