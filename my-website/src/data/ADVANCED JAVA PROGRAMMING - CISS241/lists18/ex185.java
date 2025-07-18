package lists18;

/**
 * William Smolinski
 * CISS 241
 * Exercise 18-5: Creates a TreeSet of movie objects and keeps them sorted in alphabetical order, and not allowing duplicate movies
 */

import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

public class ex185 
{
	public static void main(String[] args)
	{
		TreeSet<movie18> movies = new TreeSet<movie18>();
	
		int pick;
		
		Scanner sc = new Scanner(System.in);
        
		System.out.println("There are " + movies.size() + " movies in the TreeSet");
        System.out.println("Enter 1 to add movie to treeset");
        System.out.println("Enter 2 to see first movie on treeset");
        System.out.println("Enter 3 to watch first movie on treeset");
        System.out.println("Enter 4 to see last movie on treeset");
        System.out.println("Enter 5 to watch last movie on treeset");       
        System.out.println("Enter 6 to see treeset of movies");
        System.out.print("Enter pick (-1 to end):  ");
        
        pick = sc.nextInt();
        while (pick != -1)
        {
	        switch(pick)
	        {
	            case 1:
	            	//Add movie
	            	sc.nextLine();
	            	AddMovie(movies, sc);
	            	break;
	            	
	            case 2:
	            	//See next movie
	            	GetFirst(movies, false);
	            	break;
	
	            case 3:
	            	//See next movie and remove it
	            	GetFirst(movies, true);
	            	break;
	     
	            case 4:
	            	//See last movie
	            	GetLast(movies, false);
	            	break;
	            	
	            case 5:
	            	//See last movie and remove it
	            	GetLast(movies, true);
	            	break;
	            	
	            case 6:
	            	//See TreeSet of movies
	            	SeeTreeSet(movies);
	            	break;
	
	            default:
	                System.out.println("Try again");
	        }
	        
	        System.out.println("There are " + movies.size() + " movies in the TreeSet");
	        System.out.println("Enter 1 to add movie to treeset");
	        System.out.println("Enter 2 to see first movie on treeset");
	        System.out.println("Enter 3 to watch first movie on treeset");
	        System.out.println("Enter 4 to see last movie on treeset");
	        System.out.println("Enter 5 to watch last movie on treeset");       
	        System.out.println("Enter 6 to see treeset of movies");
	        System.out.print("Enter pick (-1 to end):  ");
	        pick = sc.nextInt();
        }
	}
	
	private static void AddMovie(TreeSet<movie18> movies, Scanner sc)
	{
		System.out.print("\nEnter the name of the movie: ");
    	String name = sc.nextLine();
    	System.out.print("Enter the year of the movie: ");
    	int year = sc.nextInt();
    	
    	if(movies.add(new movie18(name, year)))
    	{
    		System.out.println("Movie successfully added\n");
    	}
    	else 
    	{
    		System.out.println("Movie failed to add, it already exists in TreeSet\n");
		}
	}
	
	private static void GetFirst(TreeSet<movie18> movies, boolean remove)
	{
		movie18 movie;
		
		if(!movies.isEmpty())
		{
			if(remove)
			{
				movie = movies.pollFirst();
				System.out.println("\nWatched first movie:\nName: " + movie.getname() + "\nYear: " + movie.getyear() + "\nMovie successfully removed\n");
			}
			else 
			{
				movie = movies.first();
				System.out.println("\nFirst movie:\nName: " + movie.getname() + "\nYear: " + movie.getyear() + "\n");
			}
		}
		else 
		{
			System.out.println("\nThere are no movies in the TreeSet\n");
		}
	}
	
	private static void GetLast(TreeSet<movie18> movies, boolean remove)
	{
		movie18 movie;
		
		if(!movies.isEmpty())
		{
			if(remove)
			{
				movie = movies.pollLast();
				System.out.println("\nWatched last movie:\nName: " + movie.getname() + "\nYear: " + movie.getyear() + "\nMovie successfully removed\n");
			}
			else 
			{
				movie = movies.last();
				System.out.println("\nLast movie:\nName: " + movie.getname() + "\nYear: " + movie.getyear() + "\n");
			}
		}
		else 
		{
			System.out.println("\nThere are no movies in the TreeSet\n");
		}
	}
	
	private static void SeeTreeSet(TreeSet<movie18> movies)
	{	
		Iterator<movie18> iterator = movies.iterator();
		System.out.println("\nMovies in TreeSet:\n");
		int num = 1;
		movie18 movie;
		
		while(iterator.hasNext())
		{
			movie = iterator.next();
			System.out.print(num + ". Movie Name: " + movie.getname() + ", Year: " + movie.getyear() + "\n");
			num++;
		}
		
		System.out.println();
	}
}
