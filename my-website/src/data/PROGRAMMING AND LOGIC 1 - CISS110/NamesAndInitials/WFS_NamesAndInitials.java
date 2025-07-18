/** 
 * William Smolinski
 * September 25th, 2021
 * Names and Initials programming assignment, takes a full name and displays the initials
 */

public class WFS_NamesAndInitials
{
  public static void main(String[] args)
  {
    // Declares and initializes first, middle and last name variables
    String firstName = "William";
    String middleName = "Frank";
    String lastName = "Smolinski";
    
    // Declares and initializes the variables that store the initials
    char firstInitial = firstName.charAt(0);
    char middleInitial = middleName.charAt(0);
    char lastInitial = lastName.charAt(0);
    
    // Displays the information
    System.out.println("The output takes the full name: " + 
                       firstName + " " + middleName + " " + lastName + 
                       ", then displays the initials: " + 
                       firstInitial + middleInitial + lastInitial);
  }
}