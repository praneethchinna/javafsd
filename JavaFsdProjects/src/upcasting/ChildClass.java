package upcasting;

public class ChildClass  extends ParentClass
{
    @Override
    public void run()
    {
        System.out.println("iam in child class");
    }



    public void walk()
    {
        System.out.println("iam in child class wallk method");
    }

    public static void main(String[] args) {
        ParentClass p=new ChildClass();
        p.jogging();
        p.run();
        ChildClass c=(ChildClass) p;
        c.run();
        c.walk();

        LambdaFun l=(int a) ->a;
        System.out.println(l.show(33));



    }


}
