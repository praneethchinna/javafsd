package com.designpattern.factorypattern;

public class Factory
{
    public MobilePhone getCall(String msg)
    {
        if (msg == null || msg.isEmpty())
            return null;

        switch (msg)
        {
            case "Samsung Phone":
                return new SamsungPhone();
            case "Nokia Phone":
                return new NokiaPhone();
        }


        return null;
    }
}
