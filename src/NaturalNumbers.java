import java.util.Scanner;

public class NaturalNumbers
{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("enter a number");

        int n= scan.nextInt();
        int sum=0;
        for (int i=1;i<=n;i++)
            sum+=i;
        System.out.print("sum on n natural number is "+sum);
    }
}
