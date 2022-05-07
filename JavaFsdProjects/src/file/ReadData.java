package file;

import java.io.*;

public class ReadData
{
    public static void main(String[] args) throws IOException {
        File f=new File("D:\\_temp_matlab_R2021b_win64\\readme.txt");
        FileReader fr=new FileReader(f);
        BufferedReader b=new BufferedReader(fr);

        String line=b.readLine();


        int i=fr.read();
        while (line!=null)
        {
            System.out.println(line);
            line=b.readLine();
        }
        fr.close();



    }
}
