package threads14;

/**
 * William Smolinski
 * CISS 241
 * Exercise 14-1: Uses multithreading to show horses racing
 */

public class ex141 
{
	public static void main(String[] args)
	{
		//Creating the 4 horse objects
		racehorse141 horse1 = new racehorse141("One");
		racehorse141 horse2 = new racehorse141("Two");
		racehorse141 horse3 = new racehorse141("Three");
		racehorse141 horse4 = new racehorse141("Four");
		
		//Setting the priority
		horse1.setPriority((int)(Math.random() * 10) + 1);
		horse2.setPriority((int)(Math.random() * 10) + 1);
		horse3.setPriority((int)(Math.random() * 10) + 1);
		horse4.setPriority((int)(Math.random() * 10) + 1);
		
		//Starting the race
		horse1.start();
		horse2.start();
		horse3.start();
		horse4.start();
	}
}
