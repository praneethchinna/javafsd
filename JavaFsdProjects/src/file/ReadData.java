package file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadData
{
    public static void main(String[] args) throws IOException {
        File f=new File("D:\\_temp_matlab_R2021b_win64\\readme.txt");
        FileReader fr=new FileReader(f);

        int i=fr.read();
        while (i!=-1)
        {
            System.out.print((char)i);
             i=fr.read();
        }
        fr.close();



    }
}
