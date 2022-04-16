package exceptionHandling;

import java.io.FileNotFoundException;

public class RethrowEx
{
    public static void main(String[] args) {
//        String str=null;
//        try
//        {
//            System.out.println(str.length());
//        }
//        catch (ArithmeticException e)
//        {
//            System.out.println(e+" String is null");
//        }
//        catch (ArrayIndexOutOfBoundsException e)
//        {
//            System.out.println( e);
//
//        }
//        catch (ClassCastException e)
//        {
//            System.out.println(e);
//        }
//        finally {
//            System.out.println("null pointer Exception");
//        }
        print();

    }

    static void print()
{
   try
   {
       throw new ArithmeticException("Arithmatic Exception");


   }
   catch (ArithmeticException e)
   {
       System.out.println( e);
   }
}
}
