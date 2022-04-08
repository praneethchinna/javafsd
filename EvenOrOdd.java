import java.util.Scanner;

public class EvenOrOdd
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter a number");

        int i= scan.nextInt();
        if(i%2==0)
            System.out.print("it is even number");
        else
            System.out.print("it is odd number");

    }
}
