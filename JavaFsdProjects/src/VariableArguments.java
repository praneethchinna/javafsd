public class VariableArguments
{
    public static void main(String[] args) {
        display();
        display("welcome ","to ","simplilearn ");//three arguments
        display(" An ","example ","program ","varargs ");//four arguments
    }

    static void display(String...values)
{

    System.out.println("display method invoked");
    for (String s:values)
    {
        System.out.print(s);
    }
}
}
