package com.crypto;

import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;

public class hash
{
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String str="praneeth";
        byte[] a= str.getBytes();

        String hashValue="";
        try {
            MessageDigest messageDigest=MessageDigest.getInstance("SHA-256");
            messageDigest.update(a);
            byte[] digestBytes=messageDigest.digest();
            hashValue= DatatypeConverter.printHexBinary(digestBytes).toLowerCase();

        }
        catch (Exception e)
        {

        }
        System.out.println(hashValue);



    }
}
