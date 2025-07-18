/** 
 * William Smolinski
 * September 25th, 2021
 * Recipe programming assignment, takes the original quantities in a recipe and outputs the
 * quantities of each ingrediant based on user input on how many dozen cookies they want
 */

import javax.swing.JOptionPane;

public class WFS_Recipe
{
  public static void main(String[] args)
  { 
    // Declares and initializes the ingredients with the original quantities
    double powderedSugar = 1.5;
    double margarine = 1.0;
    double vanilla = 1.0;
    double almondExtract = 0.5;
    double egg = 1.0;
    double flour = 2.5;
    double bakingSoda = 1.0;
    double tartar = 1.0;
    
    // Declares and initializes the number of dozens of cookies are made when the original
    // quantities are used
    double originalDozensProduced = 4.0;

    // Asks the user the amount in dozens of cookies they want
    String dozensWantedString = JOptionPane.showInputDialog(null, 
                                                            "How many dozens of cookies do you want?");
    
    // Converts the String into an int
    int dozensWanted = Integer.parseInt(dozensWantedString);
    
    // Modifies the ingredients amount based on user input
    powderedSugar *= dozensWanted / originalDozensProduced;
    margarine *= dozensWanted /originalDozensProduced;
    vanilla *= dozensWanted / originalDozensProduced;
    almondExtract *= dozensWanted / originalDozensProduced;
    egg *= dozensWanted / originalDozensProduced;
    flour *= dozensWanted / originalDozensProduced;
    bakingSoda *= dozensWanted / originalDozensProduced;
    tartar *= dozensWanted / originalDozensProduced;
    
    // Displays the modified quantities
    JOptionPane.showMessageDialog(null, "Dozens wanted: " + dozensWanted + "\n" +
                                  "Ingrediants: \n"+
                                  "Powdered sugar: " + powderedSugar + " cups \n" +
                                  "Butter or margarine: " + margarine + " cups \n" + 
                                  "Vanilla: " + vanilla + " teaspoons \n" + 
                                  "Almond extract: " + almondExtract + " teaspoons \n" + 
                                  "Eggs: " + egg + "\n" + 
                                  "Flour: " + flour + " cups \n" + 
                                  "Baking soda: " + bakingSoda + " teaspoons \n" + 
                                  "Cream of tartar: " + tartar + " teaspoons");
    
    System.exit(0);
  }
}