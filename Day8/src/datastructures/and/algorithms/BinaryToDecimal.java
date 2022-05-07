package datastructures.and.algorithms;

public class BinaryToDecimal
{
    public int binToDecimal1(String binary)
    {
       int  base=1;
       int result=0;
       for (int i=1;i<=binary.length();i++)
       {
           if (binary.charAt(binary.length()-i)=='1')
               result+=base;

           base*=2;
       }
       return result;

    }

    public int binToDecimal2(String binary)
    {
        int result=0;
        for (int i=1;i<=binary.length();i++)
        {
            if(binary.charAt(binary.length()-i) == '1')
                result +=Math.pow(2,i-1);
        }
        return result;
    }

    public static void main(String[] args) {
        BinaryToDecimal btod=new BinaryToDecimal();
        long i= btod.binToDecimal1("101101101001");
        System.out.println(i);

        long k=System.nanoTime();
        System.out.println(k);
        double d=Double.MAX_VALUE;
        System.out.println(d);
    }
}
