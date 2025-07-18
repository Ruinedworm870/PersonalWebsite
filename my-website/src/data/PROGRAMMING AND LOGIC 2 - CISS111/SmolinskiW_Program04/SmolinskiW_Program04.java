/**
 * William Smolinski
 * CISS 111
 * Program04 - Calls methods from a class to perform various operations with a String
 */

import javax.swing.JOptionPane;

public class SmolinskiW_Program04
{
    public static void main(String[] args)
    {
        //Gets the String to perform the operations on from the user
        //Test String for recording:
        //There are 10 types of people in the world, those who understand binary and those who don’t
        String testString = JOptionPane.showInputDialog("Enter a String: ");

        //Creates the StringOperations object and sets the String in the Class
        StringOperations stringOps = new StringOperations(testString);

        //Outputs the result
        JOptionPane.showMessageDialog(null, "Vowel count: " + stringOps.getVowelCount());
        JOptionPane.showMessageDialog(null, "Consonant count: " + stringOps.getConsonantCount());
        JOptionPane.showMessageDialog(null, "Backwards: " + stringOps.backwards());
        JOptionPane.showMessageDialog(null, "White space: " + stringOps.getWhiteSpace());
        JOptionPane.showMessageDialog(null, "Digits: " + stringOps.getDigits());
    }
}
