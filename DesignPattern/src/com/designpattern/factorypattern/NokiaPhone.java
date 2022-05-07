package com.designpattern.factorypattern;

public class NokiaPhone implements MobilePhone
{
    @Override
    public void callUser()
    {
        System.out.println("calling from NokiaPhone");
    }

}
