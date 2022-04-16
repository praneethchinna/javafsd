package genericexamples;

public class Genriceg {
    public static void main(String[] args) {
        Test<Integer> jobj=new Test<Integer>(15);
        System.out.println(jobj.getObject());
    }
}
