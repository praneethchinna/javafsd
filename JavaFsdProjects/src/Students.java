import java.util.Calendar;

public class Students
{
    int number;
    String studentName;
    Students(int number, String studentName)
    {
        this.number=number;
        this.studentName=studentName;
    }
    public static void main(String[] args) {
        System.out.println("Hello, World!");


        Students[] s;
        s = new Students[5];

        s[0]=new Students(1234,"praneeth");
        s[1]=new Students(7676,"thamnna");
        s[2]=new Students(6566,"bannu");

        s[3]=new Students(5454,"nikhil");
        s[4]=new Students(4545,"chinna");


        for(int i=0;i<s.length; i++)
        {
            System.out.println(s[i].number);
        }

        Calendar calendar=Calendar.getInstance();


        System.out.println(calendar.get(Calendar.MINUTE));
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH));





    }
}
