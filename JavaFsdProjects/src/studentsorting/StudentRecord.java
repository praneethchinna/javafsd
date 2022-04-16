package studentsorting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class StudentRecord
{
    public static void main(String[] args) {
        List<Learner> l=new ArrayList<Learner>();

        l.add(new Learner(1234,"praneeth","India"));
        l.add(new Learner(2345,"Nikhile ","srilanka"));
        l.add(new Learner(3456,"pushpa","pak"));
        l.add(new Learner(4567,"ashok","uk"));
        l.add(new Learner(5677,"moni","us"));

        for (Object v: l) {
            System.out.println(v);

        }
        System.out.println("-----------------------");
        Collections.sort(l);
        for (Object v: l) {
            System.out.println(v);

        }

    }
}
