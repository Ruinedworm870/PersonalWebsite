package rtti17;

/**
 * William Smolinski
 * CISS 241
 * Exercise 17-3: 
 * This program will let the user give a class name to find the
 * get and set Methods.  Test with:
 * java.util.Date
 * javax.swing.JLabel
 * java.lang.reflect.Method
 */

import java.lang.reflect.Method;

public class ex173b
{
    public static void main(String[] args)
    {
        String classname;
        Class x;

        for(int i = 0; i < args.length; i++)
        {
        	classname = args[i];
        	
        	try
            {
                x = Class.forName(classname);
                getm(x);
                System.out.println();
                setm(x);
                System.out.println();
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
    }

    public static void getm(Class cls)
    {
        int i;
        String methodname;
        Class rettype;
        Class[] paramtypes;
        Method[] ma;
        System.out.println("Listing get methods for " + cls);

        /* get all methods for the cls Class, loop through methods and
        print all methods that are get methods - start with get, is
        not a void return, and has no arguments
        */
        
        ma = cls.getMethods();
        for(i = 0; i < ma.length; i++)
        {
        	methodname = ma[i].getName();
        	rettype = ma[i].getReturnType();
        	paramtypes = ma[i].getParameterTypes();
        	
        	if(methodname.startsWith("get") && rettype != Void.TYPE && paramtypes.length == 0)
        	{
        		System.out.println(methodname + "()");
        	}
        }
    }

    public static void setm(Class cls)
    {
        int i;
        String methodname;
        Class rettype;
        Class[] paramtypes;
        Method[] ma;
        System.out.println("Listing set methods for " + cls);

        /* get all methods for the cls Class, loop through methods and
        print all methods that are set methods - start with set, is
        a void return, and has one argument
        */
        
        ma = cls.getMethods();
        for(i = 0; i < ma.length; i++)
        {
        	methodname = ma[i].getName();
        	rettype = ma[i].getReturnType();
        	paramtypes = ma[i].getParameterTypes();
        	
        	if(methodname.startsWith("set") && rettype == Void.TYPE && paramtypes.length == 1)
        	{
        		System.out.println(methodname + "(" + paramtypes[0] + ")");
        	}
        }
    }
}