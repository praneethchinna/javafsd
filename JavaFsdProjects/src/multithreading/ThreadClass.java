package multithreading;

public class ThreadClass extends Thread{
    @Override
    public void run() {
        System.out.println("Active Threads name= "+Thread.currentThread().getName());
        System.out.println("ACtive Thread priority= "+Thread.currentThread().getPriority());
    }

    public static void main(String[] args) {
        ThreadClass tc=new ThreadClass();
        ThreadClass tc1=new ThreadClass();
       tc.setPriority(Thread.MIN_PRIORITY);
       tc1.setPriority(Thread.MAX_PRIORITY);
       tc.start();
       tc1.start();
    }
}
