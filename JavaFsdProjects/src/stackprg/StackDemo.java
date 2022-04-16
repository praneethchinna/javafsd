package stackprg;

import java.util.Stack;

public class StackDemo
{
    public static void main(String[] args) {
        Stack<String> s=new Stack<>();
        s.push("praneeth");
        s.push("nikhil");
        s.push("pushpa");
        s.push("ashok");
        System.out.println(s);
        s.pop();
        System.out.println(s);
        System.out.println(s.peek());

        s.push("chinna");
        System.out.println(s);
        System.out.println(s.peek());


                          }
}

