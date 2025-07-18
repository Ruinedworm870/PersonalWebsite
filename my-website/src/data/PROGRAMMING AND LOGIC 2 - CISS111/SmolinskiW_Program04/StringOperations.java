/**
 * Class to hold the methods that will be used with the String
 */

public class StringOperations
{
    //Fields
    private String string;

    /**
     * Constructor to get the String
     * @param string String to set string to
     */
    StringOperations(String string)
    {
        setString(string);
    }

    //Setters

    /**
     * Setter method for the string field
     * @param string String to set the string to
     */
    public void setString(String string)
    {
        this.string = string;
    }

    //Getters

    /**
     * Getter method for the string field
     * @return Returns the string as a String
     */
    public String getString()
    {
        return this.string;
    }

    //Instance methods

    /**
     * Method to get the number of vowels in a String
     * @return Returns the result as an int
     */
    public int getVowelCount()
    {
        //Creates a local variable of string and makes it lowercase, so it is easier to work with
        String string = getString().toLowerCase();

        //Number to hold the number of vowels
        int num = 0;

        //Loops for the length of the String
        for(int i = 0; i < string.length(); i++)
        {
            switch(string.charAt(i))
            {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    num += 1;
                    break;
            }
        }

        return num;
    }

    /**
     * Method to get the number of consonants in a String
     * @return Returns the result as an int
     */
    public int getConsonantCount()
    {
        //Number to hold the total number of letters in the string
        int num = 0;

        //Loops for the length of the String
        for(int i = 0; i < getString().length(); i++)
        {
            if(Character.isLetter(getString().charAt(i)))
            {
                num += 1;
            }
        }

        //If a letter is a vowel it isn't a consonant, so it subtracts the total vowels from total letters
        return num - getVowelCount();
    }

    /**
     * Methods to reverse the order of a String
     * @return Returns a new String that is reversed
     */
    public String backwards()
    {
        //Declares string to be used to hold the reversed original String
        String string = "";

        //Loops backwards for the length of the original String
        for(int i = getString().length() - 1; i >= 0; i--)
        {
            string += getString().charAt(i);
        }

        return string;
    }

    /**
     * Method to get the number of white space characters
     * @return Returns the result as an int
     */
    public int getWhiteSpace()
    {
        //Number to hold the number of white space characters
        int num = 0;

        //Loops for the length of the String
        for(int i = 0; i < getString().length(); i++)
        {
            if(Character.isSpaceChar(getString().charAt(i)))
            {
                num += 1;
            }
        }

        return num;
    }

    /**
     * Method to get the number of digits in a String
     * @return Returns the result as an int
     */
    public int getDigits()
    {
        //Number to hold the number of digits
        int num = 0;

        //Loops for the length of the String
        for(int i = 0; i < getString().length(); i++)
        {
            if(Character.isDigit(getString().charAt(i)))
            {
                num += 1;
            }
        }

        return num;
    }
}
