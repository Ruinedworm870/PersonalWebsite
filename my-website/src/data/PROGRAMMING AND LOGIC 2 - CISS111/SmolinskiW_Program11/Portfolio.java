import java.util.SortedMap;
import java.util.TreeMap;

/**
 * Handles keeping track of stock in a portfolio
 */

public class Portfolio
{
    //Fields
    private SortedMap<String, Stock> stock = new TreeMap<>();

    //Instance methods

    /**
     * Method to add a stock to the sorted map
     * @param stock Stock object to be added to the portfolio
     */
    public void AddStock(Stock stock)
    {
        this.stock.put(stock.getSymbol(), stock);
    }

    /**
     * Method to iterate through the map by the symbol and returns all the symbols as a String
     * @return Returns the result as a String
     */
    public String getAllSymbols()
    {
        String output = "";

        //Iterates through the map by the stock symbols (Keys)
        for(String s : this.stock.keySet())
        {
            output += "-> " + s + "\n";
        }

        return output;
    }

    /**
     * Method to get information about a stock in the portfolio using its symbol
     * @param symbol String of the stocks symbol that you want to retrieve the information of
     * @return Returns the stock information as a String (The stocks toString method)
     */
    public String getStockInfo(String symbol)
    {
        //Used to make sure that the stock symbol exists
        try
        {
            return this.stock.get(symbol.toUpperCase()).toString();
        }
        catch(Exception e)
        {
            return "Not a valid stock symbol!";
        }
    }
}
