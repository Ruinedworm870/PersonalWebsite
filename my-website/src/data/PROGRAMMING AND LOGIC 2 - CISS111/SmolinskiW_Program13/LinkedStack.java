/**
 * A stack that uses a linked list to keep track of the different symbols
 */

public class LinkedStack
{
    //Fields
    private CharNode top = null;

    //Instance methods

    /**
     * Method to determine whether the stack is empty or not
     * @return Returns the result as a boolean
     */
    public boolean empty()
    {
        return top == null;
    }

    /**
     * Method to remove the top of the stack
     */
    public void pop()
    {
        if(empty())
        {
            throw new IllegalStateException("The stack is empty");
        }
        else
        {
            top = top.next;
        }
    }

    /**
     * Method to add to the stack
     * @param symbol Symbol to be added to the stack
     */
    public void push(char symbol)
    {
        top = new CharNode(symbol, top);
    }

    /**
     * Method to return the top of the stack
     * @return Returns the result as a char
     */
    public char peek()
    {
        if(empty())
        {
            throw new IllegalStateException("The stack is empty");
        }
        else
        {
            return top.symbol;
        }
    }
}
