/**
 * Class to hold the information about a word
 */

public class Word
{
    //fields
    private String word;
    private int num;

    /**
     * Constructor
     * @param word String to set the word to
     */
    Word(String word)
    {
        setWord(word);
        setNum(1);
    }

    //setter methods

    /**
     * Setter method to set the word field
     * @param word String to set word to
     */
    public void setWord(String word)
    {
        this.word = word;
    }

    /**
     * Setter method to set the num field
     * @param num int to set num to
     */
    public void setNum(int num)
    {
        this.num = num;
    }

    //getter methods

    /**
     * Getter method to get the word field
     * @return Returns word as a String
     */
    public String getWord()
    {
        return this.word;
    }

    /**
     * Getter method to get the num field
     * @return Returns num as an int
     */
    public int getNum()
    {
        return this.num;
    }

    //Instance methods

    /**
     * Used to increment the num field by 1
     */
    public void addOne()
    {
        setNum(getNum() + 1);
    }
}
