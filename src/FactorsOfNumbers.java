import java.util.Scanner;

public class FactorsOfNumbers
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter a number");

        int n= scan.nextInt();
        for (int i=1;i<=n;i++)
        {
            if (n%i==0)
            {
                System.out.print(i);
                if (i!=n)
                {
                    System.out.print(" ,");
                }
            }



        }
    }
}
