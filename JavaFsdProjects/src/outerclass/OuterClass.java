package outerclass;

public class OuterClass
{
    static int a=23;
    public static class InnerClass
    {
        public static void main(String[] args) {
            try {
                System.out.println(a/0);
            }
            catch (Exception e)
            {
                System.out.println(e);
                throw e;
            }
//            finally {
//                System.out.println("zero");
//            }
        }
    }
}
