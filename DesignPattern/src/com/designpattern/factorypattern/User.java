package com.designpattern.factorypattern;

public class User
{
    public static void main(String[] args) {
        Factory f=new Factory();
       MobilePhone mobilePhone= f.getCall("Nokia Phone");
       mobilePhone.callUser();
    }
}
