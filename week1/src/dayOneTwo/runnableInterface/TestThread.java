package dayOneTwo.runnableInterface;

class RunnableDemo implements Runnable {
    String name;
    public RunnableDemo(String name) {
        this.name = name;
        System.out.println("Thread Name : " + name + ", " + "State : New");
    }

    public void run() {
        System.out.println("Thread Name : " + name + ", " + "State : Running");
        for(int i = 4; i > 0; i--) {
            System.out.println("Thread: " + name + ", " + i);
        }
        System.out.println("Thread Name : " + name + ", " + "State : Dead");
    }
}

public class TestThread {
    public static void main(String[] args) {
        RunnableDemo r1 = new RunnableDemo("Thread-1|");
        RunnableDemo r2 = new RunnableDemo("Thread-2|");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        System.out.println("t1 : " + t1.getName());
        t1.start();
        System.out.println("t2 : " + t2.getName());
        t2.start();
    }
}
