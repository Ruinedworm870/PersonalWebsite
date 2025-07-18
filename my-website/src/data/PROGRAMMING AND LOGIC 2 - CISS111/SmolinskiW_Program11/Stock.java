/**
 * Class to hold information about a stock
 */

public class Stock
{
    //Fields
    private String symbol;
    private double price;

    /**
     * Constructor to set information about a stock
     * @param symbol String for the symbol of the stock
     * @param price double for the price of the stock
     */
    Stock(String symbol, double price)
    {
        setSymbol(symbol);
        setPrice(price);
    }

    //Setter methods

    /**
     * Setter method to set the price of the stock
     * @param price Price of the stock as a double
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     * Setter method to se the symbol of the stock
     * @param symbol Symbol of the stock as a String
     */
    public void setSymbol(String symbol)
    {
        //Converts the symbol to uppercase and the assigns it
        this.symbol = symbol.toUpperCase();
    }

    //Getter methods

    /**
     * Getter method to get the symbol of the stock
     * @return Returns the symbol as a String
     */
    public String getSymbol()
    {
        return this.symbol;
    }

    /**
     * Getter method to get the price of the stock
     * @return Returns the price as a double
     */
    public double getPrice()
    {
        return  this.price;
    }

    //Instance methods

    /**
     * Method to get information printed out about the stock
     * @return Returns a String containing the information
     */
    public String toString()
    {
        return "Symbol: " + getSymbol() + ", Price: " + getPrice();
    }

}
