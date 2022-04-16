package exceptionHandling;

public class YoungerAgeException extends RuntimeException{
    YoungerAgeException(String msg)
    {
        super(msg);
    }
    public void Print(String msgs)
    {
        System.out.println(msgs);
    }
}
