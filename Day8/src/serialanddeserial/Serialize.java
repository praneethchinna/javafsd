package serialanddeserial;

import java.io.*;

public class Serialize
{
    int id;
    String name;
    public Serialize(int id,String name)

    {this.id=id;
        this.name=name;

    }
    public static void main(String[] args)  {
//        Serialize s=new Serialize(23,"praneeth");

//        FileOutputStream fos=new FileOutputStream("D:\\GIT\\hello.txt");
//        ObjectOutputStream oos=new ObjectOutputStream(fos);
//        oos.writeObject(s);
//        oos.close();
        Serialize s=null;



           try {
               FileInputStream fis;
               fis = new FileInputStream("D:\\GIT\\hello.txt");
               ObjectInputStream ois=new ObjectInputStream(fis);
               Serialize data=(Serialize)ois.readObject();
               System.out.println(data.id);
               ois.close();
           }
           catch ( FileNotFoundException e)
           {
               System.out.println(e);
           } catch (IOException e) {
               e.printStackTrace();
           } catch (ClassNotFoundException e) {
               e.printStackTrace();
           }


    }
}
