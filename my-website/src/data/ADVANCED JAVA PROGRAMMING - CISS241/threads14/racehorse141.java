package threads14;

/* Bill Wohlleber
 * Exercise 14-1
 * This class will define a racehorse
 */
public class racehorse141 extends Thread
{
    private String name;
   
    public racehorse141(String n)
    {
        name = n;
    }

    public void run()  // override run() method from Thread, called by start()
    {
        int i;
        for (i = 1; i <= 100; i++)
            System.out.print(i + "." + name + " ");
        System.out.println(name + " done");
    }
}