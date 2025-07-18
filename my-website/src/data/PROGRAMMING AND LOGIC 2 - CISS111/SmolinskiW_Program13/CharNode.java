/**
 * char node to store a char in a linked list
 */

public class CharNode
{
    //Fields
    public char symbol;
    public CharNode next;

    /**
     * Constructor
     * @param symbol The symbol to keep track of
     * @param next The next node
     */
    CharNode(char symbol, CharNode next)
    {
        this.symbol = symbol;
        this.next = next;
    }
}
