package studentsorting;

public class Learner implements Comparable<Learner>
{
    int rollno;
    String courseName;
    String location;

    public Learner(int rollno, String courseName, String location) {
        this.rollno = rollno;
        this.courseName = courseName;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Learner{" +
                "rollno=" + rollno +
                ", courseName='" + courseName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    @Override
    public int compareTo(Learner o) {
        return this.courseName.toLowerCase().compareTo(o.courseName.toLowerCase());
    }
}
