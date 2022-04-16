package exceptionHandling;

public class Test
{
    public static void main(String[] args)  {

      try {
          if (16 < 18) {
              throw new YoungerAgeException("not eligible");
          } else {
              System.out.println("eligible");
          }
      }
      catch (YoungerAgeException e)
      {
          e.printStackTrace();
          System.out.println(e);
      }

    }
}
