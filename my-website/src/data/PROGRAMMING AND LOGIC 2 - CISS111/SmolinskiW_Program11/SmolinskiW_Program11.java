import java.util.Scanner;

/**
 * William Smolinski
 * CISS 111
 * Program 11- Creates a portfolio of stock using symbols and the value of the stock
 */

public class SmolinskiW_Program11
{
    public static void main(String[] args)
    {
        //Creates a portfolio
        Portfolio portfolio = new Portfolio();

        //Declares a scanner to detect user input
        Scanner keyboard = new Scanner(System.in);

        boolean keepGoing = true;

        //Loops until the user is done with the program
        while(keepGoing)
        {
            System.out.print("\n1. Add Stock \n" +
                    "2. Get all stock symbols\n" +
                    "3. Get stock info\n" +
                    "4. Exit\n" +
                    "Enter selection: ");
            int choice = 0;

            //Used to check user input to make sure it is valid
            try
            {
                choice = Integer.parseInt(keyboard.next());
            }
            catch(Exception e)
            {
                //No need for output here as it will be handled in the switch
            }

            //Handles the user input
            switch(choice)
            {
                case 1:
                    handleNewStock(portfolio, keyboard);
                    break;

                case 2:
                    System.out.println("\n" + portfolio.getAllSymbols());
                    break;

                case 3:
                    System.out.print("\nEnter the stock symbol: ");
                    System.out.println("\n" + portfolio.getStockInfo(keyboard.next()));
                    break;

                case 4:
                    System.out.println("\nThanks for using the program!");
                    keepGoing = false;
                    break;

                default:
                    System.out.println("\nNot valid input");
            }
        }
    }

    /**
     * Handles adding new stock to the portfolio
     * @param portfolio Portfolio object to add the stock to
     * @param keyboard Scanner to detect user input
     */
    public static void handleNewStock(Portfolio portfolio, Scanner keyboard)
    {
        System.out.print("\nEnter the stock symbol: ");
        String symbol = keyboard.next();

        boolean validNumber = false;
        double price = 0.0;

        //Used to make sure a number was entered for the price
        while(!validNumber)
        {
            System.out.print("Enter the stock price: ");

            try
            {
                price = Double.parseDouble(keyboard.next());
                validNumber = true;
            }
            catch (Exception e)
            {
                System.out.println("Not a valid price");
            }
        }

        //Creates a new stock and adds it to the portfolio
        portfolio.AddStock(new Stock(symbol, price));
    }
}
