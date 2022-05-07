package mathop;

public class Factorial
{
    public int main(int number){
        int i,fact=1;
       //It is the number to calculate factorial
        for(i=1;i<=number;i++){
            fact=fact*i;
        }
        return fact;
    }
}
