package stackprg;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueDemo
{
    public static void main(String[] args) {
        PriorityQueue<String> q=new PriorityQueue<>();
        q.add("praneeth");
        q.add("nikhil");
        q.add("pushpa");
        q.add("ashok");
        System.out.println(q);
        q.poll();
        System.out.println(q);
        System.out.println(q.remove());
        System.out.println(q);

        q.add("bannu");
        System.out.println(q);
        q.remove();
        System.out.println(q);
        q.offer("chinna");

        System.out.println(q.peek());
    }
}
