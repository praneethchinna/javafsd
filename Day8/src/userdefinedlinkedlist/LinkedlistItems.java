package userdefinedlinkedlist;

import sun.awt.image.ImageWatched;

import java.util.LinkedList;

public class LinkedlistItems
{
    public static void main(String[] args) {
        LinkedList<Integer> ll=new LinkedList<Integer>();

        ll.add(12);
        ll.add(23);
        ll.add(45);
        ll.add(67);
        ll.add(33);
        ll.add(77);
        ll.add(44);

        System.out.println(ll.get(5));
        ll.add(5,9394);
        ll.addFirst(3444);
        System.out.println(ll.get(5));
        System.out.println(ll.get(0));
    }
}
