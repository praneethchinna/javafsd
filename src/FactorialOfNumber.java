import java.util.Scanner;

public class FactorialOfNumber
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter a number");

        int n= scan.nextInt();

        int fact=1;
        for (int i=1;i<=n;i++)
        {
            fact*=i;
        }
        System.out.print(fact);


    }
}
