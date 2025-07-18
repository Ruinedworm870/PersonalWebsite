/* Bill Wohlleber
 * Exercise 18 - 3, 4, 5, 6
 * This class will define a movie
 */

package lists18;

public class movie18 implements Comparable
{
    private String name;
    private int year;
   
    public movie18(String n, int y)
    {
        name = n;
        year = y;
    }
   
    public String getname()
    {
        return name;
    }
    public int getyear()
    {
        return year;
    }
   
/* for sorting, movie18 objects have to have a way to compare */
    public int compareTo(Object o)
    {
        return name.compareTo(((movie18)o).name);
    }
}