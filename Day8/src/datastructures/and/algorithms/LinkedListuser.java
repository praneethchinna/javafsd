package datastructures.and.algorithms;

public class LinkedListuser
{
    public class Node
    {
        int data;
        Node next;
        Node(int data)
        {
            this.data=data;
        }

    }
    Node head;

    public void main(String[] args)
    {
              Node first=new Node(33);

        head=first;

        System.out.println(head.next);


    }

}
