import java.util.Scanner;

public class DiamondPattern
{
    private static Scanner sc;
    public static void main(String[] args) {
         sc = new Scanner(System.in);

        int i, j, k;

        System.out.print("Enter Diamond Pattern Rows = ");
        int rows = sc.nextInt();

        System.out.println("Printing Diamond Star Pattern");
        i = 1 ;
        while(i <= rows )
        {
            j = 1 ;
            while( j <= rows - i  )
            {
                System.out.print(" ");
                j++;
            }
            k = 1 ;
            while ( k <= i * 2 - 1 )
            {
                System.out.print("*");
                k++;
            }
            System.out.println();
            i++;
        }
        i = rows - 1 ;
        while( i > 0 )
        {
            j = 1 ;
            while ( j <= rows - i )
            {
                System.out.print(" ");
                j++;
            }
            k = 1 ;
            while( k <= i * 2 - 1 )
            {
                System.out.print("*");
                k++;
            }
            System.out.println();
            i--;
        }
    }
}
