package com.crypto;

public class Print
{
    String name;
    int id;

    public static Print display()
    {
        return new Print();
    }

    @Override
    public String toString() {
        return "Print{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}

class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        Print p=Print.display();
        System.out.println(p);
    }
}